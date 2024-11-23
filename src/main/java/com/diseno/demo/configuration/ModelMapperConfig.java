package com.diseno.demo.configuration;

import com.diseno.demo.dto.RequirementDTO;
import com.diseno.demo.entity.Requirement;
import org.modelmapper.*;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);

        TypeMap<RequirementDTO, Requirement> requirementDTORequirementTypeMap = modelMapper.createTypeMap(RequirementDTO.class, Requirement.class);
        requirementDTORequirementTypeMap.addMappings(mapper -> {
            mapper.skip(Requirement::setId);
            mapper.skip(Requirement::setId);
            mapper.map(src -> src.getAssigneeId() != null? src.getAssigneeId() : null, Requirement::setAssignee);
            mapper.map(src -> src.getRequirementsIds() != null && !src.getRequirementsIds().isEmpty() ?
                            src.getRequirementsIds() :
                            null,
                    Requirement::setRequirements);
        });

        return modelMapper;
    }
}
