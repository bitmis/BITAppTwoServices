package com.example.BITAppOneServices.DIT.LateralApplicationNo;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RequestMapping(value = "/api")
@RestController
public class LateralApplicationNoController {


    @Autowired
    private LateralApplicationNoService lateralApplicationNoService;


    // Save operation
    @GetMapping("/save_dit_lateral_application_number/{registration_no}/{year}")
    public int saveApplicationNumber( @PathVariable("registration_no") String registration_no ,@PathVariable("year") String year)
    {
         return lateralApplicationNoService.saveTempApplicationNo(registration_no , year);

    }

    @GetMapping("/get_dit_application_status/{registration_no}")
    public LateralApplicationNo fetchApplicationStatus( @PathVariable("registration_no") String registration_no)
    {
        System.out.println("get applications");
        return lateralApplicationNoService.fetchApplicationStatus(registration_no);
    }



}
