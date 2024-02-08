package com.example.Lalan.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import org.springframework.web.multipart.MultipartFile;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "line_reg")
public class LineRegistrationEntity {
    @Id
    @Column(name = "line_id")
    private String lineId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "line_db_id")
    private int lineDbId;
    @Column(name = "line_name")
    private String lineName;
    @Column(length = 500)
    private String description;
    @Lob
    private String image;
    @Column(name = "start_time")
    private String startTime;
    @Column(name = "end_time")
    private String endTime;
    @Column(name = "userid_line")
    private String useridLine;
    @Transient
    private MultipartFile imageFile;
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
}
