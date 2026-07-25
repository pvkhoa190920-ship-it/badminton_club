package com.badminton.badminton_club.service;

import com.badminton.badminton_club.dto.DmTypeRequestDTO;
import com.badminton.badminton_club.dto.DmTypeResponseDTO;
import com.badminton.badminton_club.entity.DmType;
import com.badminton.badminton_club.repository.DmTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DmTypeService {

    @Autowired
    private DmTypeRepository dmTypeRepository;

    // Hàm phụ trợ: Chuyển từ Entity sang Response DTO
    private DmTypeResponseDTO mapToResponseDTO(DmType entity) {
        DmTypeResponseDTO dto = new DmTypeResponseDTO();
        dto.setTypeId(entity.getTypeId());
        dto.setMemberId(entity.getMemberId());
        dto.setLinkImg(entity.getLinkImg());
        return dto;
    }

    public List<DmTypeResponseDTO> getAllTypes() {
        return dmTypeRepository.findAll().stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    public DmTypeResponseDTO saveType(DmTypeRequestDTO requestDTO) {
        DmType entity = new DmType();
        // Lấy dữ liệu từ DTO đắp vào Entity
        entity.setTypeId(requestDTO.getTypeId());
        entity.setMemberId(requestDTO.getMemberId());
        entity.setLinkImg(requestDTO.getLinkImg());

        DmType savedEntity = dmTypeRepository.save(entity);
        return mapToResponseDTO(savedEntity);
    }

    public DmTypeResponseDTO updateType(String typeId, DmTypeRequestDTO requestDTO) {
        DmType existing = dmTypeRepository.findById(typeId).orElse(null);
        if (existing != null) {
            existing.setMemberId(requestDTO.getMemberId());
            existing.setLinkImg(requestDTO.getLinkImg());

            DmType updatedEntity = dmTypeRepository.save(existing);
            return mapToResponseDTO(updatedEntity);
        }
        return null;
    }

    public void deleteType(String typeId) {
        dmTypeRepository.deleteById(typeId);
    }
}