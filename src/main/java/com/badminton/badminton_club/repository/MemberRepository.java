package com.badminton.badminton_club.repository;

import com.badminton.badminton_club.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {

    // Lấy danh sách thế hệ (bỏ qua những dòng null hoặc rỗng)
    @Query("SELECT DISTINCT m.theHeTVien FROM Member m WHERE m.theHeTVien IS NOT NULL AND m.theHeTVien != '' ORDER BY m.theHeTVien")
    List<String> findDistinctTheHe();

    // Hàm lấy danh sách thành viên theo một thế hệ cụ thể
    List<Member> findByTheHeTVien(String theHeTVien);
}