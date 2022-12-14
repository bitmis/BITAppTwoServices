package com.example.BITAppTwoServices.HDIT.LateralApplicationNo_HDIT;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lateral_application_no_hdit")
public class LateralApplicationNo_HDIT {


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
