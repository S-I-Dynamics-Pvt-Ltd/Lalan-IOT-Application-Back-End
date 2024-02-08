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
    private String material_name;
    private String planned_ratio;
    private Float planned_value;
    private Float actual_value;
    private Integer admin_id; 
}
