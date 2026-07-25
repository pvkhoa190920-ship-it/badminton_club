package com.badminton.badminton_club.service;

import com.badminton.badminton_club.dto.UserRequestDTO;
import com.badminton.badminton_club.entity.User;
import com.badminton.badminton_club.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.time.LocalDateTime;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void createUser(UserRequestDTO requestDTO) {
        // 1. Kiểm tra User ID đã tồn tại chưa
        if (userRepository.existsById(requestDTO.getUserId())) {
            throw new RuntimeException("Tên đăng nhập đã tồn tại!");
        }

        // 2. Tạo entity User mới
        User newUser = new User();
        newUser.setUserId(requestDTO.getUserId());
        newUser.setMemberId(requestDTO.getMemberId());

        // ĐIỂM CỐT LÕI: Phải băm (hash) mật khẩu trước khi lưu!
        newUser.setPassword(passwordEncoder.encode(requestDTO.getPassword()));

        // 3. Lưu xuống Database
        userRepository.save(newUser);
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void changePassword(String userId, String newPassword) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy tài khoản!"));

        // Băm mật khẩu mới và lưu lại
        existingUser.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(existingUser);
    }
}