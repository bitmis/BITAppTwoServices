package com.example.BITAppOneServices.Lateral_DIT_2022;

import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping(value = "/api")
@RestController
public class Lateral_DIT_2022_Controller {

    private final Lateral_DIT_2022_Service lateral_DIT_2022_Service;

    public Lateral_DIT_2022_Controller(Lateral_DIT_2022_Service lateral_DIT_2022_Service) {
        this.lateral_DIT_2022_Service = lateral_DIT_2022_Service;
    }

    @GetMapping("/get_dit_regno_nic/{reg_no}/{id_no}")
    public Lateral_DIT_2022 getRegistrationNoandNIC(@PathVariable("reg_no") String reg_no, @PathVariable("id_no") String id_no){

        return this.lateral_DIT_2022_Service.getDIT2022Data( reg_no ,id_no);


    }





}
