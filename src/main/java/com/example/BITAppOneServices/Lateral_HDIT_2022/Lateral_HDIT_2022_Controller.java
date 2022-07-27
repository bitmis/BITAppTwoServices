package com.example.BITAppOneServices.Lateral_HDIT_2022;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Lateral_HDIT_2022_Controller {


    private final Lateral_HDIT_2022_Service lateral_HDIT_2022_Service;

    public Lateral_HDIT_2022_Controller(Lateral_HDIT_2022_Service lateral_HDIT_2022_Service) {
        this.lateral_HDIT_2022_Service = lateral_HDIT_2022_Service;
    }

    @GetMapping("/get_hdit_regno_nic")
    @ResponseBody
    public Lateral_HDIT_2022 getRegistrationNoandNIC(@RequestParam("reg_no") String reg_no, @RequestParam("id_no") String id_no) {

        return this.lateral_HDIT_2022_Service.getHDIT2022Data(reg_no, id_no);


    }
}
