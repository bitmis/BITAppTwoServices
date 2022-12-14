package com.example.BITAppTwoServices.DIT.Lateral_DIT_2022;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Lateral_DIT_2022_Service {

    @Autowired
    private Lateral_DIT_2022_Repository repository;

    public Lateral_DIT_2022 getDIT2022Data(String registration_no, String id_no){

        return repository.findByRegNoandNIC(registration_no,id_no);

    }
}
