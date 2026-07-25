package com.badminton.badminton_club.controller;

import com.badminton.badminton_club.dto.DmTypeRequestDTO;
import com.badminton.badminton_club.dto.DmTypeResponseDTO;
import com.badminton.badminton_club.service.DmTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/types")
public class DmTypeController {

    @Autowired
    private DmTypeService dmTypeService;

    // Lấy toàn bộ danh hiệu trả về dưới dạng Response DTO
    @GetMapping
    public List<DmTypeResponseDTO> getAllTypes() {
        return dmTypeService.getAllTypes();
    }

    // Thêm danh hiệu mới (Nhận vào Request DTO)
    @PostMapping
    public ResponseEntity<DmTypeResponseDTO> createType(@RequestBody DmTypeRequestDTO requestDTO) {
        return ResponseEntity.ok(dmTypeService.saveType(requestDTO));
    }

    // Cập nhật danh hiệu
    @PutMapping("/{id}")
    public ResponseEntity<DmTypeResponseDTO> updateType(@PathVariable String id, @RequestBody DmTypeRequestDTO requestDTO) {
        DmTypeResponseDTO responseDTO = dmTypeService.updateType(id, requestDTO);
        if (responseDTO != null) {
            return ResponseEntity.ok(responseDTO);
        }
        return ResponseEntity.notFound().build();
    }

    // Xóa danh hiệu
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteType(@PathVariable String id) {
        dmTypeService.deleteType(id);
        return ResponseEntity.ok().build();
    }
}