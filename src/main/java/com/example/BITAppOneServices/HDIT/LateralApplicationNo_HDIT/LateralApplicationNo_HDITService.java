package com.example.BITAppOneServices.HDIT.LateralApplicationNo_HDIT;

public interface LateralApplicationNo_HDITService {

    LateralApplicationNo_HDIT fetchApplicationStatus(String bit_registration_no);

    LateralApplicationNo_HDIT saveTempHDITApplicationNo(String bit_registration_no , String year);
}
