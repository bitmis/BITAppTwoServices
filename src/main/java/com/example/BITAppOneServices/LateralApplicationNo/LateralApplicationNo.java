package com.example.BITAppOneServices.LateralApplicationNo;

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

    @Column(nullable = false)
    private int application_no;

    @Column(nullable = false)
    private String bit_registration_no;
}
