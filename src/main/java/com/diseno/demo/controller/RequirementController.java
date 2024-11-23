package com.diseno.demo.controller;

import com.diseno.demo.dto.GetRequirementDTO;
import com.diseno.demo.dto.RequirementDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.diseno.demo.service.RequirementService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/requirements")
public class RequirementController {

    private final RequirementService requirementService;

    @PostMapping
    public void createRequirement(@RequestBody RequirementDTO requirementDTO) {
        requirementService.createRequirement(requirementDTO);
    }

    @GetMapping
    public ResponseEntity<List<GetRequirementDTO>> getAllRequirements() {
        return requirementService.getAllRequirements();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetRequirementDTO> getRequirementById(@PathVariable Long id) {
        return requirementService.getRequirementDTOById(id);
    }

    @PatchMapping("/{id}")
    public void updateRequirement(@PathVariable Long id, @RequestBody RequirementDTO requirementDTO) {
        requirementService.updateRequirement(id, requirementDTO);
    }

}
