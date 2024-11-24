package com.diseno.demo.service;

import com.diseno.demo.dto.request.FileDTO;
import com.diseno.demo.entity.Requirement;
import com.diseno.demo.exception.TicketException;
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
import java.util.Objects;
import java.util.UUID;

@Service
//todo pensar bien como hacer userFile
public class FileService {

    private static final String directoryPath = System.getenv("DIRECTORY_PATH");
    private final FileRepository fileRepository;
    private final File directory = new File(directoryPath);
    private final RequirementService requirementService;


    public FileService(FileRepository fileRepository, RequirementService requirementService) {
        if (!directory.exists()) {
            directory.mkdirs();
        }
        this.fileRepository = fileRepository;
        this.requirementService = requirementService;
    }

    @SneakyThrows
    public void createFile(MultipartFile file, Long requirementId) {
        if (file.isEmpty()) {
            throw new RuntimeException("File is empty");
        }

        String safeFileName = this.getSafeFileName(file);
        String uniqueFileName = UUID.randomUUID().toString() + "_" + safeFileName;
        String filePath = directory + uniqueFileName;

        this.saveFileToDatabase(file, filePath, requirementId);
        file.transferTo(new File(filePath));
    }

    private void saveFileToDatabase(MultipartFile file, String filePath, Long requirementId) {
        com.diseno.demo.entity.File fileEntity = new com.diseno.demo.entity.File(file.getOriginalFilename(), filePath);

        switch (file.getContentType()){
            case "application/pdf":
                fileEntity.setType(com.diseno.demo.entity.FileType.PDF);
                break;
            case "application/vnd.openxmlformats-officedocument.wordprocessingml.document":
                fileEntity.setType(com.diseno.demo.entity.FileType.WORD);
                break;
            case "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet":
                fileEntity.setType(com.diseno.demo.entity.FileType.EXCEL);
            break;
            default:
                throw new TicketException("File type not supported", "INVALID_FILE_TYPE");
        }

        fileEntity.setRequirement(requirementService.getRequirementById(requirementId));
        fileRepository.save(fileEntity);
    }

    private String getSafeFileName(MultipartFile file) {
        if (file.getOriginalFilename() == null) {
            throw new RuntimeException("File name is null");
        }
        return file.getOriginalFilename().replaceAll("[^a-zA-Z0-9.]", "_");
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
