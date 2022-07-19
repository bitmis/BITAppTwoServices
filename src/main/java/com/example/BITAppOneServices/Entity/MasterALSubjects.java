package com.example.BITAppOneServices.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "master_al_subjects")

public class MasterALSubjects {

    @Id
    @GeneratedValue
    private int id;
    private String al_subject;
}
