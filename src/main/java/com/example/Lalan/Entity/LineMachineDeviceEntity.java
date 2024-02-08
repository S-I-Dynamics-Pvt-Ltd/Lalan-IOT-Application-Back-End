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
@Table(name = "line_machine_device")
public class LineMachineDeviceEntity {
   
    private String  lineId;
    
    //@Column(name = "machine_id")
    private String  machine_id;
    @Id
    private String  device_id;
}