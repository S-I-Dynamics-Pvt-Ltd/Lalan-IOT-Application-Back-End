package com.example.Lalan.Entity;
import javax.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "product_Reg")
public class ProductRegistrationEntity {
    @Id
    @Column(name = "product_id")
    private String productId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pro_db_id")
    private int proDbId;
    @Column(name = "product_name")
    private String productName;
    @NotNull
    @Column(length = 500)
    private String description;
    @Lob
    private String image;
    private String dateAndTime;
    private String userID_pro;
    @Transient
    private MultipartFile imageFile;
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
}
