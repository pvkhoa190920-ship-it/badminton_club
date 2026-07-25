package com.badminton.badminton_club.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "r81user") // Tên bảng trong DB
@Data
public class User {
    @Id
    @Column(name = "user_id") // Tên cột trong DB
    private String userId;

    @Column(name = "password")
    private String password;

    @Column(name = "create_log")
    private LocalDateTime createLog;

    @Column(name = "member_id") // Sửa từ tvien_id thành member_id
    private String memberId;
}