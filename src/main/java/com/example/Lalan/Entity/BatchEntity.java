package com.example.Lalan.Entity;

import com.example.Lalan.Util.CategoryBox;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "batch_Reg")
public class BatchEntity {

    @Id
    private String  batchID_regBch;
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jobID_bch")
    private String jobIDBch;
    private Integer bch_id;
    private Integer count_regBch;
    private String batchName_regBch;
    private String userID_regBch;
    private String productCategory;
    private String product_id;
}
