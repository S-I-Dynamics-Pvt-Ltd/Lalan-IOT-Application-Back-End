package com.example.Lalan.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.util.List;

import org.apache.tomcat.jni.Time;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WastageDTO {
    private  Integer admin_id;
    private  Integer system_wastage;

    private Integer actual_wastage;
}
