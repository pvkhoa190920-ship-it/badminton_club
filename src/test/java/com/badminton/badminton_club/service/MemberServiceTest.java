package com.badminton.badminton_club.service;

import com.badminton.badminton_club.dto.MemberRequestDTO;
import com.badminton.badminton_club.dto.MemberResponseDTO;
import com.badminton.badminton_club.entity.Member;
import com.badminton.badminton_club.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MemberServiceTest {

    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberService memberService;

    @Test
    void testCreateMember() {
        MemberRequestDTO request = new MemberRequestDTO();
        request.setMemberId("TV01");
        request.setMemberName("Phan Vinh Khoa");

        Member member = new Member();
        member.setMemberId("TV01");

        when(memberRepository.save(any(Member.class))).thenReturn(member);

        MemberResponseDTO response = memberService.createMember(request);

        assertNotNull(response);
        assertEquals("TV01", response.getMemberId());
    }
}