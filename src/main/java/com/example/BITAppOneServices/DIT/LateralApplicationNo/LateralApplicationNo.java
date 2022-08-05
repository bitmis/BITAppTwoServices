package com.example.BITAppOneServices.DIT.LateralApplicationNo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lateral_application_no")
public class LateralApplicationNo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,length = 50)
    private String application_no;

    @Column(nullable = false ,length = 50)
    private String bit_registration_no;

    @Column(nullable = false ,length = 50)
    private String year;

    @Column(nullable = false ,length = 50)
    private String application_status;
}
