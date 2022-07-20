package com.example.BITAppOneServices.Lateral_HDIT_2022;

import com.example.BITAppOneServices.Lateral_DIT_2022.Lateral_DIT_2022;
import com.example.BITAppOneServices.Lateral_DIT_2022.Lateral_DIT_2022_Repository;
import org.springframework.beans.factory.annotation.Autowired;

public class Lateral_HDIT_2022_Service {

    @Autowired
    private Lateral_HDIT_2022_Repository repository;

    public Lateral_HDIT_2022 getHDIT2022Data(String registration_no, String id_no){

        return repository.findByRegNoandNIC(registration_no,id_no);

    }
}
