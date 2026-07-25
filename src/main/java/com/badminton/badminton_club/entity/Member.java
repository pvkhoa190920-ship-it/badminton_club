package com.badminton.badminton_club.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "r81member") // <-- THÊM DÒNG NÀY ĐỂ ÉP ĐÚNG TÊN BẢNG
@Data
public class Member {
    @Id
    @Column(name = "Member_ID", length = 50) // Sửa từ tvien_id
    private String memberId;

    @Column(name = "Member_Name", length = 255) // Sửa từ tvien_name
    private String memberName;

    @Column(name = "Ngay_Sinh")
    private LocalDate ngaySinh;

    @Column(name = "Link_Anh_The", length = 500)
    private String linkAnhThe;

    @Column(name = "Link_Anh_Cnhan", length = 500)
    private String linkAnhCnhan;

    @Column(name = "The_He_TVien", length = 50)
    private String theHeTVien;

    @Column(name = "Is_HoiTruong")
    private Boolean isHoiTruong;

    @Column(name = "Is_DuongNhiem")
    private Boolean isDuongNhiem;

    @Column(name = "nhiem_ki", length = 50)
    private String nhiemki;
}