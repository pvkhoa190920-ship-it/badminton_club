package com.badminton.badminton_club.controller;

import com.badminton.badminton_club.dto.LoginRequestDTO;
import com.badminton.badminton_club.entity.User;
import com.badminton.badminton_club.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequestDTO request) {
        Optional<User> userOpt = userRepository.findById(request.getUserId());
        Map<String, String> response = new HashMap<>();

        if (userOpt.isPresent() && passwordEncoder.matches(request.getPassword(), userOpt.get().getPassword())) {
            response.put("message", "Đăng nhập thành công!");
            // Không trả về redirectUrl nữa, tách bạch hoàn toàn BE và FE
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Sai tên đăng nhập hoặc mật khẩu!");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
}