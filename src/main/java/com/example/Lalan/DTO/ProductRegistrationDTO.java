package com.example.Lalan.DTO;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductRegistrationDTO {

    private String productId;
    private String productName;
    private String description;
    private String image;
    @JsonIgnore
    private MultipartFile imageFile;
    private String dateAndTime;
    private String userID_pro;
}
