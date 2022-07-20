package com.example.BITAppOneServices.MasterTitle;

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
@Table(name = "master_title")

public class MasterTitle {

    @Id
    @GeneratedValue
    private int id;
    private String title;
}
