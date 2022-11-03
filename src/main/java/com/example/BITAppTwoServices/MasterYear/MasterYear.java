package com.example.BITAppTwoServices.MasterYear;

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
@Table(name = "master_year")

public class MasterYear {

    @Id
    @GeneratedValue
    private int id;
    private String year;
}
