package com.example.BITAppOneServices.LateralApplicantsPersonlInfo;

import java.util.List;

public interface LateralApplicantsPersonlInfoService {


    // Save operation
    LateralApplicantsPersonlInfo saveLateralApplicantsInfo(LateralApplicantsPersonlInfo lateralApplicantsPersonlInfo);

    int saveLateralApplicantsPersonalInfo(LateralApplicantsPersonlInfo lateralApplicantsPersonlInfo);

    int saveLateralApplicantsContactInfo(LateralApplicantsPersonlInfo lateralApplicantsPersonlInfo);

    int saveLateralApplicantsEducationInfo(LateralApplicantsPersonlInfo lateralApplicantsPersonlInfo);


    // Read operation
    LateralApplicantsPersonlInfo fetchLateralApplicantsPersonlInfo(String application_no);

    List<LateralApplicantsPersonlInfo>fetchLateralApplicantsPersonlInfoList();

    String fetchLateralApplicationStatus(String application_no);

    // Update operation
    LateralApplicantsPersonlInfo updateLateralApplicantsPersonlInfo(LateralApplicantsPersonlInfo personalInfo,
                                String application_no);

    // Delete operation
    void deleteLateralApplicantsPersonlInfoById(String application_no);
}
