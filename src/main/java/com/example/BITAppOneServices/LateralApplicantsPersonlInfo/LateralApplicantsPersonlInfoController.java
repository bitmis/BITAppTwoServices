package com.example.BITAppOneServices.LateralApplicantsPersonlInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class LateralApplicantsPersonlInfoController {

    @Autowired
    private LateralApplicantsPersonlInfoService lateralApplicantsPersonlInfoService;

    // Save operation
    @PostMapping("/save_lateral_applicant_info")
    public LateralApplicantsPersonlInfo saveLateralApplicantInfo(
            @RequestBody LateralApplicantsPersonlInfo lateralApplicantsPersonlInfo)
    {
        return lateralApplicantsPersonlInfoService.saveLateralApplicantsPersonlInfo(lateralApplicantsPersonlInfo);
    }

    // Read operation
    @GetMapping("/get_lateral_applicant_info/{application_no}")
    public LateralApplicantsPersonlInfo fetchLateralApplicantsPersonalInfo( @PathVariable("application_no") String application_no )
    {
        System.out.println("get one application");
        return lateralApplicantsPersonlInfoService.fetchLateralApplicantsPersonlInfo(application_no);
    }

    @GetMapping("/get_lateral_applicant_info_list")
    public List<LateralApplicantsPersonlInfo> fetchLateralApplicantsPersonalInfoList()
    {
        System.out.println("get all applications");
        return lateralApplicantsPersonlInfoService.fetchLateralApplicantsPersonlInfoList();
    }

    @GetMapping("/get_lateral_application_status/{application_no}")
    public String fetchLateralApplicationStatus( @PathVariable("application_no") String application_no)
    {
        System.out.println("get  application status");
        return lateralApplicantsPersonlInfoService.fetchLateralApplicationStatus(application_no);
    }



    // Update operation
    @PutMapping("/update_lateral_applicant_info/{application_no}")
    public LateralApplicantsPersonlInfo
    updateLateralApplicantsPersonlInfo(@RequestBody LateralApplicantsPersonlInfo lateralApplicantsPersonlInfo,
                     @PathVariable("application_no") String application_no)
    {
        return lateralApplicantsPersonlInfoService.updateLateralApplicantsPersonlInfo(
                lateralApplicantsPersonlInfo, application_no);
    }

    // Delete operation
    @DeleteMapping("/deleteLateralApplicantsPersonlInfoById/{application_no}")
    public String deleteLateralApplicantsPersonlInfoById(@PathVariable("application_no")
                                               String application_no)
    {
        lateralApplicantsPersonlInfoService.deleteLateralApplicantsPersonlInfoById(application_no);
        return "Deleted Successfully";
    }
}
