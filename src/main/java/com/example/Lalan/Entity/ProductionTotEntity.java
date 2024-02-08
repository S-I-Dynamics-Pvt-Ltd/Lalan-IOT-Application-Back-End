package com.example.Lalan.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "production_tot_details")
public class ProductionTotEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tot_id")
    private Integer totId;
    @Column(name = "admin_id")
    private Integer adminId;
    private Integer tot_weight;
    private Integer tot_length;
    private Integer tot_rolls;
    private Integer tot_system_wastage;
    private Integer tot_actual_wastage;
}
