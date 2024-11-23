package com.diseno.demo.service;

import com.diseno.demo.entity.Type;
import com.diseno.demo.repository.TypeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TypeService {

    private final TypeRepository typeRepository;

    public Type getTypeById(Long typeId) {
        return typeRepository.findById(typeId)
                .orElseThrow(() -> new EntityNotFoundException("Type with id " + typeId + " not found"));
    }
}
