package com.example.BITAppTwoServices.DIT.LateralApplicationNo;

public interface LateralApplicationNoService {

    LateralApplicationNo fetchApplicationStatus(String bit_registration_no);

    int saveTempApplicationNo(String bit_registration_no , String year);

    int updateDITApplicationStatus(String application_status, String application_no);
}
