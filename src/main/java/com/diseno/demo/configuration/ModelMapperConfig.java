package com.diseno.demo.configuration;

import com.diseno.demo.dto.response.GetCategoryDTO;
import com.diseno.demo.dto.response.GetCommentDTO;
import com.diseno.demo.dto.response.GetRequirementDTO;
import com.diseno.demo.dto.request.RequirementDTO;
import com.diseno.demo.dto.response.GetTypeDTO;
import com.diseno.demo.entity.Category;
import com.diseno.demo.entity.Comment;
import com.diseno.demo.entity.Requirement;
import com.diseno.demo.entity.Type;
import com.diseno.demo.entity.user.User;
import org.modelmapper.*;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Collectors;

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

        TypeMap<Requirement, GetRequirementDTO> requirementGetRequirementDTOTypeMap =
                modelMapper.createTypeMap(Requirement.class, GetRequirementDTO.class);
        requirementGetRequirementDTOTypeMap.addMappings(mapper -> {

            mapper.map(src -> src.getRequirements() != null && !src.getRequirements().isEmpty() ?
                        src.getRequirements().stream().map(Requirement::getId).collect(Collectors.toSet()) :
                        null,
                 GetRequirementDTO::setRequirementsIds);


            /*
            mapper.map(src -> src.getCategory() != null ? src.getCategory().getId() : null, GetRequirementDTO::setCategoryId);
            mapper.map(src -> src.getCreator() != null ? src.getCreator().getId() : null, GetRequirementDTO::setCreatorId);
            mapper.map(src -> src.getAssignee() != null ? src.getAssignee().getId() : null, GetRequirementDTO::setAssigneeId);

             */
        });

        TypeMap<Comment, GetCommentDTO> commentGetCommentDTOTypeMap = modelMapper.createTypeMap(Comment.class, GetCommentDTO.class);
        commentGetCommentDTOTypeMap.addMappings(mapper -> {
            mapper.using(ctx -> {
                Requirement requirement = (Requirement) ctx.getSource();
                return requirement != null ? requirement.getId() : null;
            }).map(Comment::getRequirement, GetCommentDTO::setRequirementId);
            mapper.using(ctx -> {
                User user = (User) ctx.getSource();
                return user != null ? user.getId() : null;
            }).map(Comment::getUser, GetCommentDTO::setUserId);
        });

        /*TypeMap<Category, GetCategoryDTO> categoryGetCategoryDTOTypeMap = modelMapper.createTypeMap(Category.class, GetCategoryDTO.class);
        categoryGetCategoryDTOTypeMap.addMappings(mapper -> {
            mapper.map(src -> src.getType() != null ? modelMapper.map(src.getType(), GetTypeDTO.class): null, GetCategoryDTO::setType);
        });
*/
        return modelMapper;
    }
}
