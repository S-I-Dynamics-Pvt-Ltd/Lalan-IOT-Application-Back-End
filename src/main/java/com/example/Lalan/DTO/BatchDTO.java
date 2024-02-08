package com.example.Lalan.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class BatchDTO {
    private String batchID_regBch;
    private String batchName_regBch;
    private String jobIDBch;
    private Integer count_regBch;
    private Integer bch_id;
    private String productCategory;
    private String product_id;
}
