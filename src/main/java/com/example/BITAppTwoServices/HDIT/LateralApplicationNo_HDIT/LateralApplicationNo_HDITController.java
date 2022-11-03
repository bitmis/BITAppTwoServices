package com.example.BITAppTwoServices.HDIT.LateralApplicationNo_HDIT;

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
    public int saveApplicationNumber(@PathVariable("registration_no") String registration_no , @PathVariable("year") String year)
    {
        return lateralApplicationNo_HDITService.saveTempHDITApplicationNo(registration_no , year);

    }

    @GetMapping("/get_hdit_application_status/{registration_no}")
    public LateralApplicationNo_HDIT fetchApplicationStatus(@PathVariable("registration_no") String registration_no)
    {
        System.out.println("get applications");
        return lateralApplicationNo_HDITService.fetchApplicationStatus(registration_no);
    }

    //update HDIT application status
    @PutMapping("/update_hdit_application_status/{application_no}/{application_status}")
    public int updateHDITApplicationStatus( @PathVariable("application_no") String application_no ,@PathVariable("application_status") String application_status)
    {
        return lateralApplicationNo_HDITService.updateHDITApplicationStatus( application_status,application_no);
    }


}
