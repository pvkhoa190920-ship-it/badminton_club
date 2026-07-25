package com.badminton.badminton_club.service;

import com.badminton.badminton_club.dto.MemberRequestDTO;
import com.badminton.badminton_club.dto.MemberResponseDTO;
import com.badminton.badminton_club.entity.Member;
import com.badminton.badminton_club.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    // Chức năng Lấy danh sách
    public List<MemberResponseDTO> getAllMembers() {
        return memberRepository.findAll().stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    // Chức năng Thêm mới
    public MemberResponseDTO createMember(MemberRequestDTO requestDTO) {
        // Chuyển DTO thành Entity
        Member member = new Member();
        member.setMemberId(requestDTO.getMemberId());
        member.setMemberName(requestDTO.getMemberName());
        member.setNgaySinh(requestDTO.getNgaySinh());
        member.setLinkAnhThe(requestDTO.getLinkAnhThe());
         member.setLinkAnhCnhan(requestDTO.getLinkAnhCnhan()); // Mở comment nếu bạn đã thêm vào DTO
        member.setTheHeTVien(requestDTO.getTheHeTVien());
        member.setIsDuongNhiem(requestDTO.getIsDuongNhiem());
        member.setIsHoiTruong(requestDTO.getIsHoiTruong());
        member.setNhiemki(requestDTO.getNhiemki());
        // Lưu xuống DB
        Member savedMember = memberRepository.save(member);

        // Trả về DTO
        return convertToResponseDTO(savedMember);
    }

    // Hàm phụ trợ convert Entity -> DTO
    private MemberResponseDTO convertToResponseDTO(Member member) {
        MemberResponseDTO dto = new MemberResponseDTO();
        dto.setMemberId(member.getMemberId());
        dto.setMemberName(member.getMemberName());
        dto.setNgaySinh(member.getNgaySinh());
        dto.setLinkAnhThe(member.getLinkAnhThe());
        dto.setLinkAnhCnhan(member.getLinkAnhCnhan()); // Mở comment nếu bạn đã thêm vào DTO
        dto.setTheHeTVien(member.getTheHeTVien());
        dto.setIsDuongNhiem(member.getIsDuongNhiem());
        dto.setIsHoiTruong(member.getIsHoiTruong());
        dto.setNhiemki(member.getNhiemki());
        return dto;
    }

    // Chức năng Cập nhật (Sửa)
    public MemberResponseDTO updateMember(String id, MemberRequestDTO requestDTO) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy thành viên với ID: " + id));

        // Cập nhật các trường (không cập nhật ID)
        member.setMemberName(requestDTO.getMemberName());
        member.setNgaySinh(requestDTO.getNgaySinh());
        member.setLinkAnhThe(requestDTO.getLinkAnhThe());
        member.setLinkAnhCnhan(requestDTO.getLinkAnhCnhan()); // Mở comment nếu đã thêm vào DTO
        member.setTheHeTVien(requestDTO.getTheHeTVien());
        member.setIsDuongNhiem(requestDTO.getIsDuongNhiem());
        member.setIsHoiTruong(requestDTO.getIsHoiTruong());
        member.setNhiemki(requestDTO.getNhiemki());

        Member updatedMember = memberRepository.save(member);
        return convertToResponseDTO(updatedMember);
    }

    // Chức năng Xóa
    public void deleteMember(String id) {
        memberRepository.deleteById(id);
    }
}