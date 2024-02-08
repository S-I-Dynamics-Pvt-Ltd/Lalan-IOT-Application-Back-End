package com.example.Lalan.Entity;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "machine_reg")

public class MachineRegistrationEntity {

    @Id
    private String machineId;

    @Column(length = 500)
    private String machineDescription;
    private String machineName;
    private String machineImage;
    private String dateTime;


}
