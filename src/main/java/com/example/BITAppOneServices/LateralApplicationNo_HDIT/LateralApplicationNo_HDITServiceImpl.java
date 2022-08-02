package com.example.BITAppOneServices.LateralApplicationNo_HDIT;

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
    public void saveTempApplicationNo(String registration_no, String year) {

        LateralApplicationNo_HDIT lateralApplicationNo = new LateralApplicationNo_HDIT();
        lateralApplicationNo.setApplication_no("xxx");
        lateralApplicationNo.setBit_registration_no(registration_no);
        lateralApplicationNo.setYear(year);
        lateralApplicationNo.setApplication_status("pending");

        LateralApplicationNo_HDIT exists_L = lateralApplicationNo_HDITRepository.findByRegNo(registration_no);
        System.out.println(exists_L+"  *** check if exists");
        if (exists_L == null) {
            lateralApplicationNo_HDITRepository.save(lateralApplicationNo);
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
