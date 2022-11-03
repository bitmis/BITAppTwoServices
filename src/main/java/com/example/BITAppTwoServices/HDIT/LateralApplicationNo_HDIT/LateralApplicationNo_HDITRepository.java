package com.example.BITAppTwoServices.HDIT.LateralApplicationNo_HDIT;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface LateralApplicationNo_HDITRepository extends JpaRepository<LateralApplicationNo_HDIT,Integer> {
    @Transactional
    @Modifying
    @Query("update LateralApplicationNo_HDIT l set l.application_status = ?1 where l.application_no = ?2")
    int updateHDITApplicationStatus(String application_status, String application_no);

    @Query("select l from LateralApplicationNo_HDIT l where l.bit_registration_no = ?1")
    LateralApplicationNo_HDIT fetchLateralApplicationStatus(String bit_registration_no);

    @Query("select l from LateralApplicationNo_HDIT l where l.bit_registration_no = ?1")
    LateralApplicationNo_HDIT findByRegNo(String bit_registration_no);

    @Transactional
    @Modifying
    @Query("update LateralApplicationNo_HDIT l set l.application_no = ?1 where l.year = ?2 and l.bit_registration_no = ?3")
    int updateCorrectApplicationNo(String application_no, String year, String bit_registration_no);
}
