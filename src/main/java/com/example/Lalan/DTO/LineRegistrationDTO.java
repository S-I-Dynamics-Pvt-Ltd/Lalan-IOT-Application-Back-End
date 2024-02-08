package com.example.Lalan.DTO;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LineRegistrationDTO {

    private String lineId;
    private int lineDbId;
    private String lineName;
    private String description;
    private String image;
    private String startTime;
    private String endTime;
    private String useridLine;
    @JsonIgnore
    private MultipartFile imageFile;
}
