package com.example.BITAppOneServices.LateralApplicantsPersonlInfo;

import java.util.HashMap;
import java.util.List;

public interface LateralApplicantsPersonlInfoService {


    // Save operation
    LateralApplicantsPersonlInfo saveLateralApplicantsPersonlInfo(LateralApplicantsPersonlInfo lateralApplicantsPersonlInfo);

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
