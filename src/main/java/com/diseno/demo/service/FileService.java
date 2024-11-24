package com.diseno.demo.service;

import com.diseno.demo.dto.request.FileDTO;
import com.diseno.demo.entity.Requirement;
import com.diseno.demo.repository.FileRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Service
//todo pensar bien como hacer userFile
public class FileService {

    private static final String directoryPath = System.getenv("DIRECTORY_PATH");
    private final FileRepository fileRepository;
    private final File directory = new File(directoryPath);


    public FileService(FileRepository fileRepository) {
        if (!directory.exists()) {
            directory.mkdir();
        }
        this.fileRepository = fileRepository;
    }

    @SneakyThrows
    public void createFile(MultipartFile file) {
        if (file.isEmpty()) {
            throw new RuntimeException("File is empty");
        }

        String filePath = directory + file.getOriginalFilename();
        file.transferTo(new File(filePath));
    }
/*

    private final FileRepository fileRepository;
    private final ModelMapper modelMapper;

    public void createFile(FileDTO fileDTO) {
        //todo configurar el modelMapper
        File file = modelMapper.map(fileDTO, File.class);
        fileRepository.save(file);
    }

    public ResponseEntity<GetFileDTO> getFileDTOById(Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(this.getFileById(id), GetFileDTO.class));
    }

    public ResponseEntity<List<GetFileDTO>> getAllFiles() {
        List<File> files = fileRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(files.stream().map(file -> modelMapper.map(file, GetFileDTO.class)).toList());
    }

    public void updateFile(Long id, FileDTO fileDTO) {
        File fileToUpdate = getFileById(id);

        if (fileDTO.getName() != null){
            fileToUpdate.setName(fileDTO.getName());
        }
        if (fileDTO.getExtension() != null){
            fileToUpdate.setExtension(fileDTO.getExtension());
        }
        if (fileDTO.getSize() != null){
            fileToUpdate.setSize(fileDTO.getSize());
        }
        if (fileDTO.getRequirementId() != null){
            Requirement requirement = requirementService.getRequirementById(fileDTO.getRequirementId());
            fileToUpdate.setRequirement(requirement);
        }

        fileRepository.save(fileToUpdate);
    }

    private File getFileById(Long id) {
        return fileRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("File with id " + id + " not found"));
    }
*/

}
