package com.diseno.demo.controller;

import com.diseno.demo.dto.request.TypeDTO;
import com.diseno.demo.dto.response.GetTypeDTO;
import com.diseno.demo.service.TypeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/types")
public class TypeController {
    private final TypeService typeService;

    @PostMapping
    public void createType(@RequestBody TypeDTO typeDTO) {
        typeService.createType(typeDTO);
    }

    @GetMapping
    public ResponseEntity<List<GetTypeDTO>> getAllTypes() {
        return typeService.getAllTypes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetTypeDTO> getTypeDTOById(@PathVariable Long id) {
        return typeService.getTypeDTOById(id);
    }

    @PatchMapping("/{id}")
    public void updateType(@PathVariable Long id, @RequestBody TypeDTO typeDTO) {
        typeService.updateType(id, typeDTO);
    }
}
