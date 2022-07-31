package com.example.BITAppOneServices.LateralApplicantsPersonlInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping(value = "/api")
@RestController
public class LateralApplicantsPersonlInfoController {

    @Autowired
    private LateralApplicantsPersonlInfoService lateralApplicantsPersonlInfoService;

    // Save operation
    @PostMapping("/save_lateral_applicant_info")
    public LateralApplicantsPersonlInfo saveLateralApplicantInfo(
            @RequestBody LateralApplicantsPersonlInfo lateralApplicantsPersonlInfo)
    {
        return lateralApplicantsPersonlInfoService.saveLateralApplicantsInfo(lateralApplicantsPersonlInfo);
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



     // -------------------------------- Update operations  -------------------------------------------------------

    @PutMapping("/update_lateral_applicant_info/{application_no}")
    public LateralApplicantsPersonlInfo
    updateLateralApplicantsPersonlInfo(@RequestBody LateralApplicantsPersonlInfo lateralApplicantsPersonlInfo,
                     @PathVariable("application_no") String application_no)
    {
        return lateralApplicantsPersonlInfoService.updateLateralApplicantsPersonlInfo(
                lateralApplicantsPersonlInfo, application_no);
    }

    //update personal info
    @PutMapping("/update_lateral_applicant_personal_info")
    public int updateLateralApplicantPersonalInfo(
            @RequestBody LateralApplicantsPersonlInfo lateralApplicantsPersonlInfo)
    {
        return lateralApplicantsPersonlInfoService.updateLateralApplicantsPersonalInfo(lateralApplicantsPersonlInfo);
    }

    //update contact info
    @PutMapping("/update_lateral_applicant_contact_info")
    public int updateLateralApplicantContactInfo(
            @RequestBody LateralApplicantsPersonlInfo lateralApplicantsPersonlInfo)
    {
        return lateralApplicantsPersonlInfoService.updateLateralApplicantsContactInfo(lateralApplicantsPersonlInfo);
    }

    //update education info
    @PutMapping("/update_lateral_applicant_education_info")
    public int updateLateralApplicantEducationInfo(
            @RequestBody LateralApplicantsPersonlInfo lateralApplicantsPersonlInfo)
    {
        return lateralApplicantsPersonlInfoService.updateLateralApplicantsEducationInfo(lateralApplicantsPersonlInfo);
    }

    //update payment info
    @PutMapping("/update_lateral_applicant_payment_info")
    public int updateLateralApplicantPaymentInfo(
            @RequestBody LateralApplicantsPersonlInfo lateralApplicantsPersonlInfo)
    {
        return lateralApplicantsPersonlInfoService.updateLateralApplicantsPaymentInfo(lateralApplicantsPersonlInfo);
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
