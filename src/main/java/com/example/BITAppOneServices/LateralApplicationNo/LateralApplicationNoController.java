package com.example.BITAppOneServices.LateralApplicationNo;


import com.example.BITAppOneServices.LateralApplicantsPersonlInfo.LateralApplicantsPersonlInfo;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@CrossOrigin
@RequestMapping(value = "/api")
@RestController
public class LateralApplicationNoController {


    @Autowired
    private LateralApplicationNoService lateralApplicationNoService;


    // Save operation
    @GetMapping("/save_lateral_application_number/{registration_no}/{year}")
    public void saveApplicationNumber( @PathVariable("registration_no") String registration_no ,@PathVariable("year") String year)
    {
         lateralApplicationNoService.saveTempApplicationNo(registration_no , year);

    }

    @GetMapping("/get_application_status/{registration_no}")
    public LateralApplicationNo fetchApplicationStatus( @PathVariable("registration_no") String registration_no)
    {
        System.out.println("get applications");
        return lateralApplicationNoService.fetchApplicationStatus(registration_no);
    }



}
