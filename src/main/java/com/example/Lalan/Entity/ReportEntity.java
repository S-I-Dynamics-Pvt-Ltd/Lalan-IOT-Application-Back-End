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

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Primary key
    
    private  String MonthYear;
    private  int Production_Hours;

}
