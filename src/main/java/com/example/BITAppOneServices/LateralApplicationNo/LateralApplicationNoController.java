package com.example.BITAppOneServices.LateralApplicationNo;


import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class LateralApplicationNoController {


    @Autowired
    private LateralApplicationNoService lateralApplicationNoService;

    @GetMapping("/get_application_status/{registration_no}")
    public String fetchApplicationStatus( @PathVariable("registration_no") String registration_no)
    {
        System.out.println("get applications");
        return lateralApplicationNoService.fetchApplicationStatus(registration_no);
    }
}
