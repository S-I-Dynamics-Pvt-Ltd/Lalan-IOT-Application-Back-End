package com.example.Lalan.Services;

import com.example.Lalan.DTO.LineRegistrationDTO;
import com.example.Lalan.Entity.LineRegistrationEntity;
import com.example.Lalan.Repos.LineRegistrationRepo;
import com.example.Lalan.Util.VarList;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap;
import org.hibernate.mapping.Value;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional

public class LineRegistrationService {

    @Autowired
    private LineRegistrationRepo lineRegistrationRepo;
    @Autowired
    private ModelMapper modelMapper;
    @org.springframework.beans.factory.annotation.Value("${line.path}")
    private String uploadPath;

    // ----------------------------------------------------------------------------------------------
    // Save Line Details
    public String saveLine(LineRegistrationDTO lineRegistrationDTO) {
        try {
            if (lineRegistrationRepo.existsById(lineRegistrationDTO.getLineId())) {
                return VarList.RSP_DUPLICATED;
            } else {
                if (lineRegistrationDTO.getImageFile() != null) {
                    String imagePath = saveImage(lineRegistrationDTO.getImageFile());
                    lineRegistrationDTO.setImage(imagePath);
                }
                lineRegistrationRepo.save(modelMapper.map(lineRegistrationDTO, LineRegistrationEntity.class));
                return VarList.RSP_SUCCESS;
            }
        } catch (Exception e) {
            return VarList.RSP_ERROR;
        }
    }

    private String saveImage(MultipartFile imageFile) throws IOException {
        if (imageFile != null && !imageFile.isEmpty()) {
            String fileName = StringUtils.cleanPath(Objects.requireNonNull(imageFile.getOriginalFilename()));
            String fileExtension = StringUtils.getFilenameExtension(fileName);
            String newFileName = UUID.randomUUID().toString() + "." + fileExtension;

            Path uploadDir = Paths.get(uploadPath);
            if (!Files.exists(uploadDir)) {
                Files.createDirectories(uploadDir);
            }

            Path filePath = uploadDir.resolve(newFileName);
            Files.copy(imageFile.getInputStream(), filePath);

            return newFileName;
        }
        return null;
    }

    // ----------------------------------------------------------------------------------------------------
    // update line details...
    public String updateRegisteredLine(LineRegistrationDTO lineRegistrationDTO) {
        try {
            Optional<LineRegistrationEntity> optionalLine = lineRegistrationRepo
                    .findById(lineRegistrationDTO.getLineId());
            if (optionalLine.isPresent()) {
                LineRegistrationEntity existingLine = optionalLine.get();
                if (lineRegistrationDTO.getImageFile() != null) {
                    deleteImageFile(existingLine.getImage());
                    String imagePath = saveImage(lineRegistrationDTO.getImageFile());
                    existingLine.setImage(imagePath);
                }
                existingLine.setLineId(lineRegistrationDTO.getLineId());
                existingLine.setLineDbId(lineRegistrationDTO.getLineDbId());
                existingLine.setLineName(lineRegistrationDTO.getLineName());
                existingLine.setDescription(lineRegistrationDTO.getDescription());
                existingLine.setStartTime(lineRegistrationDTO.getStartTime());
                existingLine.setEndTime(lineRegistrationDTO.getEndTime());
                existingLine.setUseridLine(lineRegistrationDTO.getUseridLine());
                lineRegistrationRepo.save(existingLine);
                return VarList.RSP_SUCCESS;

            } else {
                return VarList.RSP_NO_DATA_FOUND;
            }
        } catch (Exception e) {
            return VarList.RSP_ERROR;
        }
    }

    private void deleteImageFile(String fileName) {
        if (fileName != null && !fileName.isEmpty()) {
            try {
                Path filePath = Paths.get(uploadPath).resolve(fileName);
                Resource resource = new UrlResource(filePath.toUri());
                if (resource.exists()) {
                    Files.deleteIfExists(filePath);
                } else {
                    System.out.println("File not found: " + fileName);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // ----------------------------------------------------------------------------------------------------
    // Display registered line details...
    public List<LineRegistrationDTO> getAllLines() {
        List<LineRegistrationEntity> lineList = lineRegistrationRepo.findAll();
        return modelMapper.map(lineList, new TypeToken<ArrayList<LineRegistrationDTO>>() {
        }.getType());
    }

    // -----------------------------------------------------------------------------------------------------
    // Search line details using lineId...
    public LineRegistrationDTO searchRegisteredLine(String lineId) {
        if (lineRegistrationRepo.existsById(lineId)) {
            LineRegistrationEntity lineRegistrationEntity = lineRegistrationRepo.findById(lineId).orElse(null);
            return modelMapper.map(lineRegistrationEntity, LineRegistrationDTO.class);
        } else {
            return null;
        }
    }

    // --------------------------------------------------------------------------------------------------
    // Delete registered customer...
    public String deleteRegisteredLine(String lineId) {
        try {
            Optional<LineRegistrationEntity> optionalLine = lineRegistrationRepo.findById(lineId);

            if (optionalLine.isPresent()) {
                LineRegistrationEntity line = optionalLine.get();
                deleteImageFile(line.getImage());
                lineRegistrationRepo.deleteById(lineId);
                return VarList.RSP_SUCCESS;
            } else {
                return VarList.RSP_NO_DATA_FOUND;
            }
        } catch (Exception e) {
            return VarList.RSP_ERROR;
        }
    }

    // get sumation of product count
    public List<Map<ActiveObjectMap.Key, Value>> getAllLineAndId() {
        return lineRegistrationRepo.getAllLineAndId();
    }
}
