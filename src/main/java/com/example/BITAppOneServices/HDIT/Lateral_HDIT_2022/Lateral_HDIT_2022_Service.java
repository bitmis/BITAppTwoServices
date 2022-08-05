package com.example.BITAppOneServices.HDIT.Lateral_HDIT_2022;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Lateral_HDIT_2022_Service {

    @Autowired
    private Lateral_HDIT_2022_Repository repository;

    public Lateral_HDIT_2022 getHDIT2022Data(String registration_no, String id_no){

        return repository.findByRegNoandNIC(registration_no,id_no);

    }
}
