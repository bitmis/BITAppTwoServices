package com.example.BITAppOneServices.LateralApplicantsPersonlInfo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface LateralApplicantsPersonlInfoRepository extends JpaRepository<LateralApplicantsPersonlInfo, String> {


    @Query("select l.application_status from LateralApplicantsPersonlInfo l where l.application_no = ?1")
    String fetchLateralApplicationStatus(String application_no);

    @Transactional
    @Modifying
    @Query("update LateralApplicantsPersonlInfo l set l.full_name = ?1, l.full_name_sinhala = ?2, l.full_name_tamil = ?3, l.name_marking = ?4, l.initials = ?5, l.title = ?6, l.gender = ?7, l.id_type = ?8, l.id_no = ?9, l.dob = ?10, l.email = ?11 , l.citizenship = ?12 , l.nationality = ?13" +
            "where l.application_no = ?14")
    int updatePersonalInfoNew(String full_name,
                              String full_name_sinhala,
                              String full_name_tamil,
                              String name_marking,
                              String initials,
                              String title,
                              String gender,
                              String id_type,
                              String id_no,
                              String dob,
                              String email,
                              String citizenship,
                              String nationality,
                              String application_no);

    @Transactional
    @Modifying
    @Query("update LateralApplicantsPersonlInfo l set l.phone = ?1, l.mobile = ?2, l.address1 = ?3, l.address2 = ?4, l.address3 = ?5, l.district = ?6, l.country = ?7 " +
            "where l.application_no = ?8")
    int updateContactInfoNew(String phone, String mobile, String address1, String address2, String address3, String district, String country, String application_no);

    @Transactional
    @Modifying
    @Query("update LateralApplicantsPersonlInfo l set l.qualification_type = ?1, l.qualification_pending = ?2, l.need_different_req = ?3, l.al_year = ?4, l.al_index_no = ?5, l.al_type = ?6, l.al_subject1 = ?7, l.al_result1 = ?8, l.al_subject2 = ?9, l.al_result2 = ?10, l.al_subject3 = ?11, l.al_result3 = ?12, l.al_subject4 = ?13, l.al_result4 = ?14, l.ol_year1 = ?15, l.ol_subject1 = ?16, l.ol_result1 = ?17, l.ol_year2 = ?18, l.ol_subject2 = ?19, l.ol_result2 = ?20 " +
            "where l.application_no = ?21")
    int updateEducationInfoNew(String qualification_type, String qualification_pending, String need_different_req, String al_year, String al_index_no, String al_type, String al_subject1, String al_result1, String al_subject2, String al_result2, String al_subject3, String al_result3, String al_subject4, String al_result4, String ol_year1, String ol_subject1, String ol_result1, String ol_year2, String ol_subject2, String ol_result2, String application_no);

    @Query("select l from LateralApplicantsPersonlInfo l where l.application_no = ?1")
    LateralApplicantsPersonlInfo findByApplicationNo(String application_no);

    @Transactional
    @Modifying
    @Query("update LateralApplicantsPersonlInfo l set l.type = ?1, l.payment_category = ?2, l.payment_type = ?3, l.amount = ?4, l.over_payment = ?5, l.surcharge = ?6, l.bank = ?7, l.bank_branch = ?8, l.paid_date = ?9, l.invoice_no = ?10 " +
            "where l.application_no = ?11")
    int updatePaymentInfoNew(String type, String payment_category, String payment_type, String amount, String over_payment, String surcharge, String bank, String bank_branch, String paid_date, String invoice_no, String application_no);


}
