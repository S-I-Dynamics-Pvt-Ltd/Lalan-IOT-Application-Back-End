package com.example.Lalan.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "customer_reg")
public class CustomerRegistrationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cus_id;
    private String customer_name;
    private String customer_NIC;
    private String customer_contact_number;
    private String customer_email;
    private String contact_person;
    private String user_id;
}
