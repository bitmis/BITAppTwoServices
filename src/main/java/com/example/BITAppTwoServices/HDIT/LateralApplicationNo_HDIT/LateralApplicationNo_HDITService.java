package com.example.BITAppTwoServices.HDIT.LateralApplicationNo_HDIT;

public interface LateralApplicationNo_HDITService {

    LateralApplicationNo_HDIT fetchApplicationStatus(String bit_registration_no);

    int saveTempHDITApplicationNo(String bit_registration_no , String year);

    int updateHDITApplicationStatus(String application_status, String application_no);
}
