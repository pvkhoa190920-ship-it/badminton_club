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
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // BỘ NHỚ LƯU TOKEN: Lưu trữ danh sách ai đang đăng nhập (Chìa khóa bảo mật)
    public static final Map<String, String> TOKEN_STORE = new ConcurrentHashMap<>();

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequestDTO request) {
        Optional<User> userOpt = userRepository.findById(request.getUserId());
        Map<String, String> response = new HashMap<>();

        if (userOpt.isPresent() && passwordEncoder.matches(request.getPassword(), userOpt.get().getPassword())) {
            // Tạo một Token ngẫu nhiên (Ví dụ: 550e8400-e29b-41d4-a716-446655440000)
            String token = UUID.randomUUID().toString();

            // Lưu token vào Server để đối chiếu sau này
            TOKEN_STORE.put(token, userOpt.get().getUserId());

            response.put("message", "Đăng nhập thành công!");
            response.put("token", token); // Trả Token về cho Client
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Sai tên đăng nhập hoặc mật khẩu!");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

    // API để Client kiểm tra xem Token có còn hợp lệ hay là đồ giả (F12)
    @GetMapping("/me")
    public ResponseEntity<?> checkToken(@RequestHeader(value = "Authorization", required = false) String authHeader) {
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            if (TOKEN_STORE.containsKey(token)) {
                return ResponseEntity.ok().build();
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}