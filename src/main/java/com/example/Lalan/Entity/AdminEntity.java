package com.example.Lalan.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// import org.apache.tomcat.jni.Time;
// import org.hibernate.type.TimeType;
// import org.springframework.format.annotation.DateTimeFormat;

// import java.sql.Date;
import java.sql.Time;
import java.util.Date;
// import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "admin_control")

public class AdminEntity {


    private  String adminid_ad;
    
    @Id
    private  int admin_id;
    private  String batchid_ad;

    private String product_lineid_ad;
    private  String userid_ad;
    private  String job_id_ad;

    private Date production_start_datetime;
    private Date production_end_datetime;
   
    private Time batch_start_time;
    private Time batch_end_time;

    private Date predicted_date;

    private int production_order;



}
