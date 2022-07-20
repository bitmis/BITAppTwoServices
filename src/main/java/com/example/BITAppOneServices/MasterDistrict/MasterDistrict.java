package com.example.BITAppOneServices.MasterDistrict;


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
@Table(name = "master_district")

public class MasterDistrict {

    @Id
    @GeneratedValue
    private int id;
    private String district;
}
