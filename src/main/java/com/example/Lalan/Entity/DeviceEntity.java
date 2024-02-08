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
@Table(name = "device_Reg")
public class DeviceEntity {

    @Id
    private String  deviceID_dvcReg;
    private String  deviceName_dvcReg;
    private String  parameterType_dvcReg;
    private String deviceGPSLocation;
    private String deviceIpAddress;
    private String description;
    private String parameter_id;
    private int min_value;
    private int max_value;
    private String measuring_unit;
    private int is_it_starter_value;
    private int completed_prod_count;
    private String alarm_alert_type;
    private String message;
    private String user_id_para;



}
