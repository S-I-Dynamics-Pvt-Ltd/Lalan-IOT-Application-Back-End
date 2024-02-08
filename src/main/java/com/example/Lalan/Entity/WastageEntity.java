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
@Table(name = "wastage")
public class WastageEntity {
    @Id
    private  Integer admin_id;
    private  Integer system_wastage;

    private Integer actual_wastage;
}
