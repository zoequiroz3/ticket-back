package com.diseno.demo.service;

import com.diseno.demo.dto.GetRequirementDTO;
import com.diseno.demo.dto.RequirementDTO;
import com.diseno.demo.entity.Requirement;
import com.diseno.demo.entity.Type;
import com.diseno.demo.repository.RequirementRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Service
public class RequirementService {

    private final RequirementRepository requirementRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;
    private final UserService userService;
    private final TypeService typeService;

    public void createRequirement(RequirementDTO requirementDTO) {
        Requirement requirement = modelMapper.map(requirementDTO, Requirement.class);
        requirement.setCode(this.generateCode(requirementDTO.getTypeId()));
        requirementRepository.save(requirement);
    }

    public ResponseEntity<List<GetRequirementDTO>> getAllRequirements() {
        List<Requirement> requirements = requirementRepository.findAll();


        List<GetRequirementDTO> requirementDTOS = requirements.stream()
                .map(this::convertRequirementToGetDTO)
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(requirementDTOS);
    }

    public ResponseEntity<GetRequirementDTO> getRequirementDTOById(Long id) {
        Requirement requirement = requirementRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Requirement with id " + id + " not found"));

        GetRequirementDTO requirementDTO = convertRequirementToGetDTO(requirement);

        return ResponseEntity.status(HttpStatus.OK).body(requirementDTO);

    }



    public void updateRequirement(Long id, RequirementDTO requirementDTO) {
    //    requirementRepository.update(id, requirementDTO);
    }

    private String generateCode(Long typeId) {
        Type type = typeService.getTypeById(typeId);
        return  type.getCode() + "-" + LocalDate.now().getYear() + "-" + String.format("%010d", requirementRepository.count() + 1);
    }

    private GetRequirementDTO convertRequirementToGetDTO(Requirement requirement) {
        GetRequirementDTO requirementDTO = modelMapper.map(requirement, GetRequirementDTO.class);
        requirementDTO.setCategoryId(requirement.getCategory().getId());
        requirementDTO.setCreatorId(requirement.getCreator().getId());
        requirementDTO.setDate(requirement.getCreatedAt().toLocalDate());
        requirementDTO.setTime(requirement.getCreatedAt().toLocalTime());
        if (requirement.getAssignee() != null) {
            requirementDTO.setAssigneeId(requirement.getAssignee().getId());
        }
        return requirementDTO;
    }
}
