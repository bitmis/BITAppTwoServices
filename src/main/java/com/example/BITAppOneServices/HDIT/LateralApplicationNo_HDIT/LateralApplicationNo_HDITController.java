package com.example.BITAppOneServices.HDIT.LateralApplicationNo_HDIT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping(value = "/api")
@RestController
public class LateralApplicationNo_HDITController {

    @Autowired
    private LateralApplicationNo_HDITService lateralApplicationNo_HDITService;


    // Save operation
    @GetMapping("/save_hdit_lateral_application_number/{registration_no}/{year}")
    public void saveApplicationNumber(@PathVariable("registration_no") String registration_no , @PathVariable("year") String year)
    {
        lateralApplicationNo_HDITService.saveTempApplicationNo(registration_no , year);

    }

    @GetMapping("/get_hdit_application_status/{registration_no}")
    public LateralApplicationNo_HDIT fetchApplicationStatus(@PathVariable("registration_no") String registration_no)
    {
        System.out.println("get applications");
        return lateralApplicationNo_HDITService.fetchApplicationStatus(registration_no);
    }
}
