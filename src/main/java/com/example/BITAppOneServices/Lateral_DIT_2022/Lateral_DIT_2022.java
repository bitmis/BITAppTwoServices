package com.example.BITAppOneServices.Lateral_DIT_2022;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Lateral_DIT_2022")

public class Lateral_DIT_2022 {

    @Id
    private String registration_no;
    private String id_no;
    private String year = "2";

}
