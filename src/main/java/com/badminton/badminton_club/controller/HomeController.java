package com.badminton.badminton_club.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Khi người dùng gõ http://localhost:8080/ thì nó sẽ nhảy vào hàm này
    @GetMapping("/")
    public String home() {
        // Chữ "index" này tương ứng với tên file index.html mà chúng ta chuẩn bị tạo
        return "index";
    }
}