package com.example.BITAppOneServices.DIT.LateralApplicationNo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface LateralApplicationNoRepository extends JpaRepository<LateralApplicationNo,Integer> {

    @Query("select l from LateralApplicationNo l where l.bit_registration_no = ?1")
    LateralApplicationNo fetchLateralApplicationStatus(String bit_registration_no);

    @Query("select l from LateralApplicationNo l where l.bit_registration_no = ?1")
    LateralApplicationNo findByRegNo(String bit_registration_no);

    @Transactional
    @Modifying
    @Query("update LateralApplicationNo l set l.application_no = ?1 where l.year = ?2 and l.bit_registration_no = ?3")
    int updateCorrectApplicationNo(String application_no, String year, String bit_registration_no);

}
