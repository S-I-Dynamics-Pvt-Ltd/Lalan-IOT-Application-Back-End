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
public class DeviceDTO {

    
    private String  deviceID_dvcReg;
    private int dvc_id;
    private String  deviceName_dvcReg;
    private String  parameterType_dvcReg;
    private String line_dvc_reg;
    private String deviceGPSLocation;
    private String deviceIpAddress;
    private String description;
    private String parameter_id;
    private String measuring_unit;
    private String is_it_starter_value;
    private int completed_prod_count;
    private String alarm_alert_type;
    private String message;
    private String user_id_para;

}
