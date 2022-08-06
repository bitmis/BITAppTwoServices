package com.example.BITAppOneServices.DIT.LateralApplicationNo;

public interface LateralApplicationNoService {

    LateralApplicationNo fetchApplicationStatus(String bit_registration_no);

    int saveTempApplicationNo(String bit_registration_no , String year);
}
