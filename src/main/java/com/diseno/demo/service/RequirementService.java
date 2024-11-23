package com.diseno.demo.service;

import com.diseno.demo.dto.RequirementDTO;
import com.diseno.demo.entity.Requirement;
import com.diseno.demo.entity.Type;
import com.diseno.demo.repository.RequirementRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;

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


/*
    public List<GetRequirementDTO> getAllRequirements() {
        return requirementRepository.findAll();
    }

    public GetRequirementDTO getRequirementDTOById(Long id) {
        return requirementRepository.findById(id);
    }

    public void updateRequirement(Long id, RequirementDTO requirementDTO) {
        requirementRepository.update(id, requirementDTO);
    }


 */
    private String generateCode(Long typeId) {
        Type type = typeService.getTypeById(typeId);

        return  type.getCode() + "-" + LocalDate.now().getYear() + "-" + String.format("%010d", requirementRepository.count() + 1);
    }
}
