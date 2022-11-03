package com.example.BITAppTwoServices.MasterGrades;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "master_grades")

public class MasterGrades {

    @Id
    @GeneratedValue
    private int id;
    private String grade;
}
