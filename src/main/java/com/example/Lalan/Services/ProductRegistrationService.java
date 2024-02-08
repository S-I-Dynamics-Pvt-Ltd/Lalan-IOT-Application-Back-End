package com.example.Lalan.Services;
import com.example.Lalan.DTO.ProductRegistrationDTO;
import com.example.Lalan.Entity.ProductRegistrationEntity;
import com.example.Lalan.Repos.ProductRegistrationRepo;
import com.example.Lalan.Util.VarList;
import com.sun.corba.se.impl.oa.poa.ActiveObjectMap;
import java.util.Optional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Objects;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

@Service
@Transactional
public class ProductRegistrationService {
    @Autowired
    private ProductRegistrationRepo productRegistrationRepo;
    @Autowired
    private ModelMapper modelMapper;

    @org.springframework.beans.factory.annotation.Value("${upload.path}")
    private String uploadPath;

    // ----------------------------------------------------------------------------------------------
    // Save product Details
    public String saveProduct(ProductRegistrationDTO productRegistrationDTO) {
        try {
            if (productRegistrationRepo.existsById(productRegistrationDTO.getProductId())) {
                return VarList.RSP_DUPLICATED;
            } else {
                if (productRegistrationDTO.getImageFile() != null) {
                    String imagePath = saveImage(productRegistrationDTO.getImageFile());
                    productRegistrationDTO.setImage(imagePath);
                }
                productRegistrationRepo.save(modelMapper.map(productRegistrationDTO,
                ProductRegistrationEntity.class));

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

            // return uploadPath + newFileName;

            return newFileName;
        }
        return null;
    }

    public String updateRegisteredProduct(ProductRegistrationDTO productRegistrationDTO) {
        try {
            Optional<ProductRegistrationEntity> optionalProduct = productRegistrationRepo.findById(productRegistrationDTO.getProductId());
            if (optionalProduct.isPresent()) {
                ProductRegistrationEntity existingProduct = optionalProduct.get();
                if (productRegistrationDTO.getImageFile() != null) {
                    deleteImageFile(existingProduct.getImage());
                    String imagePath = saveImage(productRegistrationDTO.getImageFile());
                    existingProduct.setImage(imagePath);
                }
                existingProduct.setProductName(productRegistrationDTO.getProductName());
                existingProduct.setDescription(productRegistrationDTO.getDescription());
                existingProduct.setDateAndTime(productRegistrationDTO.getDateAndTime());
                existingProduct.setUserID_pro(productRegistrationDTO.getUserID_pro());
                productRegistrationRepo.save(existingProduct);
                return VarList.RSP_SUCCESS;
            } else {
                return VarList.RSP_NO_DATA_FOUND;
            }
        } catch (Exception e) {
            return VarList.RSP_ERROR;
        }
    }

    // ----------------------------------------------------------------------------------------------------
    // Display registered product details...
    public List<ProductRegistrationDTO> getAllProducts() {
        List<ProductRegistrationEntity> productList = productRegistrationRepo.findAll();
        return modelMapper.map(productList, new TypeToken<ArrayList<ProductRegistrationDTO>>() {
        }.getType());
    }

    // -----------------------------------------------------------------------------------------------------
    // Search product details using productId...
    public ProductRegistrationDTO searchRegisteredProduct(String productId) {
        if (productRegistrationRepo.existsById(productId)) {
            ProductRegistrationEntity productRegistrationEntity = productRegistrationRepo.findById(productId)
                    .orElse(null);
            return modelMapper.map(productRegistrationEntity, ProductRegistrationDTO.class);
        } else {
            return null;
        }
    }

    // --------------------------------------------------------------------------------------------------
    // Delete registered product using producr id...
    public String deleteRegisteredProduct(String productId) {
        try {
            Optional<ProductRegistrationEntity> optionalProduct = productRegistrationRepo.findById(productId);
            if (optionalProduct.isPresent()) {
                ProductRegistrationEntity product = optionalProduct.get();
                deleteImageFile(product.getImage());
                productRegistrationRepo.deleteById(productId);
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

    // get sumation of product count
    public List<Map<ActiveObjectMap.Key, org.hibernate.mapping.Value>> getAllProductsNameAndIds() {
        return productRegistrationRepo.getAllProductsNameAndIds();
    }
}
