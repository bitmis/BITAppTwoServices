package com.example.BITAppOneServices.HDIT.LateralApplicationNo_HDIT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LateralApplicationNo_HDITServiceImpl implements LateralApplicationNo_HDITService {

    @Autowired
    private LateralApplicationNo_HDITRepository lateralApplicationNo_HDITRepository;


    @Override
    public LateralApplicationNo_HDIT fetchApplicationStatus(String registration_no) {
        return lateralApplicationNo_HDITRepository.fetchLateralApplicationStatus(registration_no);
    }

    @Override
    public void saveTempHDITApplicationNo(String registration_no, String year) {

        LateralApplicationNo_HDIT HDIT_lateralApplicationNo = new LateralApplicationNo_HDIT();
        HDIT_lateralApplicationNo.setApplication_no("yyy");
        HDIT_lateralApplicationNo.setBit_registration_no(registration_no);
        HDIT_lateralApplicationNo.setYear(year);
        HDIT_lateralApplicationNo.setApplication_status("pending");

        LateralApplicationNo_HDIT exists_HDIT = lateralApplicationNo_HDITRepository.findByRegNo(registration_no);
        System.out.println(exists_HDIT+"  *** check if exists");
        if (exists_HDIT == null) {
            lateralApplicationNo_HDITRepository.save(HDIT_lateralApplicationNo);
        }

        LateralApplicationNo_HDIT tempEntity = lateralApplicationNo_HDITRepository.findByRegNo(registration_no);
        System.out.println(tempEntity.getId());

        int id = tempEntity.getId();
        String formatted = String.format("%06d", id);
        //21Y2M000047
        //22Y2M000004
        String correct_application_no = "22Y" + year + "N" + formatted;

        lateralApplicationNo_HDITRepository.updateCorrectApplicationNo(correct_application_no, year, registration_no);


    }

}
