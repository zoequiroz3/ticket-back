package com.diseno.demo.service;

import com.diseno.demo.dto.request.TypeDTO;
import com.diseno.demo.dto.request.UpdateTypeDTO;
import com.diseno.demo.dto.response.GetTypeDTO;
import com.diseno.demo.dto.response.UpdateCategoryDTO;
import com.diseno.demo.entity.Type;
import com.diseno.demo.repository.TypeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TypeService {

    private final TypeRepository typeRepository;
    private final ModelMapper modelMapper;

    public void createType(TypeDTO typeDTO) {
        Type type = modelMapper.map(typeDTO, Type.class);
        typeRepository.save(type);
    }

    public ResponseEntity<GetTypeDTO> getTypeDTOById(Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(this.getTypeById(id), GetTypeDTO.class));
    }

    public ResponseEntity<List<GetTypeDTO>> getAllTypes() {
        List<Type> types = typeRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(types.stream().map(type -> modelMapper.map(type, GetTypeDTO.class)).toList());
    }

    public void updateType(Long id, TypeDTO typeDTO) {
        Type typeToUpdate = getTypeById(id);

        if (typeDTO.getDescription() != null){
            typeToUpdate.setDescription(typeDTO.getDescription());
        }
        if (typeDTO.getCode() != null){
            typeToUpdate.setCode(typeDTO.getCode());
        }

        typeRepository.save(typeToUpdate);
    }

    public Type getTypeById(Long typeId) {
        return typeRepository.findById(typeId)
                .orElseThrow(() -> new EntityNotFoundException("Type with id " + typeId + " not found"));
    }
}
