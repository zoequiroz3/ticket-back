package com.diseno.demo.dto.request;

import com.diseno.demo.entity.FileType;
import lombok.Data;

@Data
public class FileDTO {
    private String name;
    private FileType type;
    private Long requirementId;
}
