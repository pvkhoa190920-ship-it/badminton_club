package com.badminton.badminton_club.controller;

import com.badminton.badminton_club.dto.UserRequestDTO;
import com.badminton.badminton_club.entity.User;
import com.badminton.badminton_club.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserRequestDTO requestDTO) {
        try {
            userService.createUser(requestDTO);
            return ResponseEntity.ok("Tạo tài khoản " + requestDTO.getUserId() + " thành công cho thành viên " + requestDTO.getMemberId() + "!");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    // Thêm 2 API này vào bên trong class UserController
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PutMapping("/{userId}/password")
    public ResponseEntity<String> changePassword(@PathVariable String userId, @RequestBody UserRequestDTO requestDTO) {
        try {
            userService.changePassword(userId, requestDTO.getPassword());
            return ResponseEntity.ok("Cập nhật mật khẩu mới thành công!");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}