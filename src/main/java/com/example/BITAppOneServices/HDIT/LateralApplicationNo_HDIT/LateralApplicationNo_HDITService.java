package com.example.BITAppOneServices.HDIT.LateralApplicationNo_HDIT;

public interface LateralApplicationNo_HDITService {

    LateralApplicationNo_HDIT fetchApplicationStatus(String bit_registration_no);

    void saveTempApplicationNo(String bit_registration_no , String year);
}
