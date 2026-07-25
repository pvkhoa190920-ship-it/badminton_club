package com.badminton.badminton_club.controller;

import com.badminton.badminton_club.dto.MemberRequestDTO;
import com.badminton.badminton_club.dto.MemberResponseDTO;
import com.badminton.badminton_club.entity.Member;
import com.badminton.badminton_club.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.badminton.badminton_club.service.MemberService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    // THÊM ĐOẠN NÀY ĐỂ INJECT REPOSITORY
    @Autowired
    private MemberRepository memberRepository;

    @GetMapping
    public List<MemberResponseDTO> getAllMembers() {
        return memberService.getAllMembers();
    }

    @PostMapping
    public MemberResponseDTO createMember(@RequestBody MemberRequestDTO requestDTO) {
        return memberService.createMember(requestDTO);
    }

    @PutMapping("/{id}")
    public MemberResponseDTO updateMember(@PathVariable String id, @RequestBody MemberRequestDTO requestDTO) {
        return memberService.updateMember(id, requestDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable String id) {
        memberService.deleteMember(id);
    }

    @GetMapping("/generations")
    public ResponseEntity<List<String>> getDistinctGenerations() {
        // Bây giờ biến memberRepository đã được khai báo, sẽ không còn báo lỗi đỏ nữa
        List<String> generations = memberRepository.findDistinctTheHe();
        return ResponseEntity.ok(generations);
    }
}