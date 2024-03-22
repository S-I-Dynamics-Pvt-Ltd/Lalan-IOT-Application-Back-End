package com.example.Lalan.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "product_type_temps")

public class ProductTypeTempsEntity {
    @Id
    private int  product_type_temps_id;
    private String deviceid_dvc_reg;
    private int product_type;
    private int min_value;
    private int max_value;
}
