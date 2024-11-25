package com.diseno.demo.service;

import org.springframework.stereotype.Service;

@Service
public class FileService {
/*

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

    public ResponseEntity<Resource> getFilesByRequirementId(Long requirementId) {
        //todo validar que el requerimiento tenga archivos adjuntos

        List<String> filePaths = (fileRepository.findFileByRequirementId(requirementId)).stream().map(com.diseno.demo.entity.File::getPath).toList();

        if (filePaths.isEmpty()) {
            throw new EntityNotFoundException("No files found for requirement with id: " + requirementId);
        }

        for (String filePath : filePaths) {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new EntityNotFoundException("File not found");
            }
        }
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
*/

}
