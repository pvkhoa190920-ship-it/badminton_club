package com.badminton.badminton_club.dto;

import lombok.Data;

@Data
public class UserRequestDTO {
    private String userId;
    private String password;
    private String memberId;
}