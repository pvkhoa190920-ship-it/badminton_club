package com.badminton.badminton_club.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data; // Bổ sung import Lombok

@Entity
@Table(name = "r81dmtype")
@Data // Tự động sinh Getters, Setters giống hệt Member
public class DmType {

    @Id
    @Column(name = "type_id", length = 50)
    private String typeId;

    @Column(name = "member_id", length = 50)
    private String memberId;

    @Column(name = "link_img", length = 500)
    private String linkImg;
}