package com.example.BITAppOneServices.LateralApplicationNo;

public interface LateralApplicationNoService {

    LateralApplicationNo fetchApplicationStatus(String bit_registration_no);

    void saveTempApplicationNo(String bit_registration_no , String year);
}
