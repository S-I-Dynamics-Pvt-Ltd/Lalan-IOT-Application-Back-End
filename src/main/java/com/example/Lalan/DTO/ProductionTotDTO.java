package com.example.Lalan.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductionTotDTO {
    private  Integer tot_id;
    private  Integer adminId;
    private Integer tot_weight;
    private  Integer tot_length;
    private  Integer tot_rolls;
    private Integer tot_system_wastage;
    private Integer tot_actual_wastage;
}
