package com.badminton.badminton_club.repository;

import com.badminton.badminton_club.entity.DmType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DmTypeRepository extends JpaRepository<DmType, String> {
    // Kế thừa sẵn các hàm findAll, save, deleteById từ JpaRepository
}