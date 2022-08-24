package com.example.BITAppOneServices.LateralApplicantsPersonlInfo;

import java.util.List;

public interface LateralApplicantsPersonlInfoService {


    // Save operation
    LateralApplicantsPersonlInfo saveLateralApplicantsInfo(LateralApplicantsPersonlInfo lateralApplicantsPersonlInfo);



    // Read operation
    LateralApplicantsPersonlInfo fetchLateralApplicantsPersonlInfo(String application_no);

    List<LateralApplicantsPersonlInfo>fetchLateralApplicantsPersonlInfoList();

    String fetchLateralApplicationStatus(String application_no);

    // Update operation
    LateralApplicantsPersonlInfo updateLateralApplicantsPersonlInfo(LateralApplicantsPersonlInfo personalInfo,
                                String application_no);

    int updateLateralApplicantsPersonalInfo(LateralApplicantsPersonlInfo lateralApplicantsPersonlInfo);

    int updateLateralApplicantsContactInfo(LateralApplicantsPersonlInfo lateralApplicantsPersonlInfo);

    int updateLateralApplicantsEducationInfo(LateralApplicantsPersonlInfo lateralApplicantsPersonlInfo);

    int updateLateralApplicantStatusOne(String application_no);

    int updateLateralApplicantStatusTwo(String application_no);

    int updateLateralApplicantsPaymentInfo(LateralApplicantsPersonlInfo lateralApplicantsPersonlInfo);



    // Delete operation
    void deleteLateralApplicantsPersonlInfoById(String application_no);




}
