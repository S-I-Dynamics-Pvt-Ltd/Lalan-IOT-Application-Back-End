package com.example.Lalan.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MaterialDTO {
    private Integer material_id;
    private Integer admin_id;
    private Float planned_value;
    private Float actual_value;
    private Float m1_ratio;
    private Float m2_ratio;
    private Float m3_ratio;
    private Float m4_ratio;
    private Float m5_ratio;
    private Float m6_ratio;
    private Float m7_ratio;
}
