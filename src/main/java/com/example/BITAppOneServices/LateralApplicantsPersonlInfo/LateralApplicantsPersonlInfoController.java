package com.example.BITAppOneServices.LateralApplicantsPersonlInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class LateralApplicantsPersonlInfoController {

    @Autowired
    private LateralApplicantsPersonlInfoService lateralApplicantsPersonlInfoService;

    // Save operation
    @PostMapping("/save_lateral_student_info")
    public LateralApplicantsPersonlInfo saveLateralStudentInfo(
            @RequestBody LateralApplicantsPersonlInfo lateralApplicantsPersonlInfo)
    {
        return lateralApplicantsPersonlInfoService.saveLateralApplicantsPersonlInfo(lateralApplicantsPersonlInfo);
    }

    // Read operation
    @GetMapping("/get_lateral_student_info/{application_no}")
    public LateralApplicantsPersonlInfo fetchLateralApplicantsPersonlInfo( @PathVariable("application_no") String application_no )
    {
        System.out.println("Heree");
        return lateralApplicantsPersonlInfoService.fetchLateralApplicantsPersonlInfo(application_no);
    }

    // Update operation
    @PutMapping("/update_lateral_student_info/{application_no}")
    public LateralApplicantsPersonlInfo
    updateLateralApplicantsPersonlInfo(@RequestBody LateralApplicantsPersonlInfo lateralApplicantsPersonlInfo,
                     @PathVariable("application_no") String application_no)
    {
        return lateralApplicantsPersonlInfoService.updateLateralApplicantsPersonlInfo(
                lateralApplicantsPersonlInfo, application_no);
    }

    // Delete operation
    @DeleteMapping("/departments/{application_no}")
    public String deleteLateralApplicantsPersonlInfoById(@PathVariable("application_no")
                                               String application_no)
    {
        lateralApplicantsPersonlInfoService.deleteLateralApplicantsPersonlInfoById(application_no);
        return "Deleted Successfully";
    }
}
