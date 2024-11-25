package com.diseno.demo.controller;

import com.diseno.demo.service.FileService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@RestController
@RequestMapping("/api/files")
public class FileController {
/*

    private final FileService fileService;

    @PostMapping("/{requirementId}")
    public void createFile(@RequestParam("file") MultipartFile file, @PathVariable Long requirementId) {
        fileService.createFile(file, requirementId);
    }
*/

}
