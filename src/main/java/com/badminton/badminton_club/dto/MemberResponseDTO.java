package com.badminton.badminton_club.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class MemberResponseDTO {
    private String memberId;
    private String memberName;
    private String theHeTVien;
    private LocalDate ngaySinh;
    private String linkAnhThe;
    private String linkAnhCnhan;
    private Boolean isHoiTruong;
    private Boolean isDuongNhiem;
    private String nhiemki;

}
