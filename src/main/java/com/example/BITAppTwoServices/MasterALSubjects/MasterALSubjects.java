package com.example.BITAppTwoServices.MasterALSubjects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "master_al_subjects")

public class MasterALSubjects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String al_subject;
}
