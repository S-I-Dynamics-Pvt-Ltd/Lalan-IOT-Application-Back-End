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
public class ProductTypeTempsDTO {
    private int  product_type_temps_id;
    private String deviceid_dvc_reg;
    private int product_type;
    private int min_value;
    private int max_value;
}
