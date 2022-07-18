package com.example.BITAppOneServices.Controller;

import com.example.BITAppOneServices.Entity.Lateral_DIT_2022;
import com.example.BITAppOneServices.Service.Lateral_DIT_2022_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Lateral_DIT_2022_Controller {

    private final Lateral_DIT_2022_Service lateral_DIT_2022_Service;

    public Lateral_DIT_2022_Controller(Lateral_DIT_2022_Service lateral_DIT_2022_Service) {
        this.lateral_DIT_2022_Service = lateral_DIT_2022_Service;
    }

    @GetMapping("/get_regno_nic")
    public Lateral_DIT_2022 getRegistrationNoandNIC(@RequestParam("reg_no") String reg_no , @RequestParam("id_no") String id_no){

        return this.lateral_DIT_2022_Service.getDIT2022Data( reg_no ,id_no);


    }





}
