package com.example.BITAppOneServices.LateralApplicantsPersonlInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class LateralApplicantsPersonlInfoServiceImpl implements LateralApplicantsPersonlInfoService {


    @Autowired
    private LateralApplicantsPersonlInfoRepository lateralApplicantsPersonlInfoRepository;

    // Save operation
    @Override
    public LateralApplicantsPersonlInfo saveLateralApplicantsInfo(LateralApplicantsPersonlInfo lateralApplicantsPersonlInfo) {
        return lateralApplicantsPersonlInfoRepository.save(lateralApplicantsPersonlInfo);
    }


    // Read operation
    @Override
    public LateralApplicantsPersonlInfo fetchLateralApplicantsPersonlInfo(String application_no) {
        return lateralApplicantsPersonlInfoRepository.findByApplicationNo(application_no);
    }

    //Get Operations
    @Override
    public List<LateralApplicantsPersonlInfo> fetchLateralApplicantsPersonlInfoList() {
        return lateralApplicantsPersonlInfoRepository.findAll();
    }

    @Override
    public String fetchLateralApplicationStatus(String application_no) {
        return lateralApplicantsPersonlInfoRepository.fetchLateralApplicationStatus(application_no);
    }


    // Update operation
    @Override
    public LateralApplicantsPersonlInfo
    updateLateralApplicantsPersonlInfo(LateralApplicantsPersonlInfo lateralApplicantsPersonlInfo,
                                       String application_no) {
        LateralApplicantsPersonlInfo db_info
                = lateralApplicantsPersonlInfoRepository.findById(application_no).get();

        if (Objects.nonNull(lateralApplicantsPersonlInfo.getFull_name())
                && !"".equalsIgnoreCase(
                lateralApplicantsPersonlInfo.getFull_name())) {
            db_info.setFull_name(
                    lateralApplicantsPersonlInfo.getFull_name());
        }


        return lateralApplicantsPersonlInfoRepository.save(db_info);
    }

    @Override
    public int updateLateralApplicantsPersonalInfo(LateralApplicantsPersonlInfo lateralApplicantsPersonlInfo) {

        String full_name = lateralApplicantsPersonlInfo.getFull_name();
        String full_name_sinhala = lateralApplicantsPersonlInfo.getFull_name_sinhala();
        String full_name_tamil = lateralApplicantsPersonlInfo.getFull_name_tamil();
        String name_marking = lateralApplicantsPersonlInfo.getName_marking();
        String initials = lateralApplicantsPersonlInfo.getInitials();
        String title = lateralApplicantsPersonlInfo.getTitle();
        String gender = lateralApplicantsPersonlInfo.getGender();
        String id_type = lateralApplicantsPersonlInfo.getId_type();
        String id_no = lateralApplicantsPersonlInfo.getId_no();
        String dob = lateralApplicantsPersonlInfo.getDob();
        String email = lateralApplicantsPersonlInfo.getEmail();
        String citizenship = lateralApplicantsPersonlInfo.getCitizenship();
        String nationality = lateralApplicantsPersonlInfo.getNationality();

        String application_no = lateralApplicantsPersonlInfo.getApplication_no();

        return lateralApplicantsPersonlInfoRepository.updatePersonalInfoNew(
                full_name,
                full_name_sinhala,
                full_name_tamil,
                name_marking,
                initials,
                title,
                gender,
                id_type,
                id_no,
                dob,
                email,
                citizenship,
                nationality ,
                application_no);
    }


    @Override
    public int updateLateralApplicantsContactInfo(LateralApplicantsPersonlInfo lateralApplicantsPersonlInfo) {


        String phone = lateralApplicantsPersonlInfo.getPhone();
        String mobile = lateralApplicantsPersonlInfo.getMobile();
        String address1 = lateralApplicantsPersonlInfo.getAddress1();
        String address2 = lateralApplicantsPersonlInfo.getAddress2();
        String address3 = lateralApplicantsPersonlInfo.getAddress3();
        String district = lateralApplicantsPersonlInfo.getDistrict();
        String country = lateralApplicantsPersonlInfo.getCountry();

        String application_no = lateralApplicantsPersonlInfo.getApplication_no();

        return lateralApplicantsPersonlInfoRepository.updateContactInfoNew(phone, mobile, address1, address2, address3, district, country, application_no);
    }

    @Override
    public int updateLateralApplicantsEducationInfo(LateralApplicantsPersonlInfo lateralApplicantsPersonlInfo) {

        String qualification_type = lateralApplicantsPersonlInfo.getQualification_type();
        String qualification_pending = lateralApplicantsPersonlInfo.getQualification_pending();
        String need_different_req = lateralApplicantsPersonlInfo.getNeed_different_req();
        String al_year = lateralApplicantsPersonlInfo.getAl_year();
        String al_index_no = lateralApplicantsPersonlInfo.getAl_index_no();
        String al_type = lateralApplicantsPersonlInfo.getAl_type();

        String al_subject1 = lateralApplicantsPersonlInfo.getAl_subject1();
        String al_result1 = lateralApplicantsPersonlInfo.getAl_result1();

        String al_subject2 = lateralApplicantsPersonlInfo.getAl_subject2();
        String al_result2 = lateralApplicantsPersonlInfo.getAl_result2();

        String al_subject3 = lateralApplicantsPersonlInfo.getAl_subject3();
        String al_result3 = lateralApplicantsPersonlInfo.getAl_result3();

        String al_subject4 = lateralApplicantsPersonlInfo.getAl_subject4();
        String al_result4 = lateralApplicantsPersonlInfo.getAl_result4();

        String ol_year1 = lateralApplicantsPersonlInfo.getOl_year1();
        String ol_subject1 = lateralApplicantsPersonlInfo.getOl_subject1();
        String ol_result1 = lateralApplicantsPersonlInfo.getOl_result1();

        String ol_year2 = lateralApplicantsPersonlInfo.getOl_year2();
        String ol_subject2 = lateralApplicantsPersonlInfo.getOl_subject2();
        String ol_result2 = lateralApplicantsPersonlInfo.getOl_result2();

        String fit_registration_no = lateralApplicantsPersonlInfo.getFit_registration_no();

        String application_no = lateralApplicantsPersonlInfo.getApplication_no();


        return lateralApplicantsPersonlInfoRepository.updateEducationInfoNew(
                qualification_type, qualification_pending, need_different_req, al_year, al_index_no, al_type,
                al_subject1, al_result1, al_subject2, al_result2, al_subject3, al_result3, al_subject4,
                al_result4, ol_year1, ol_subject1, ol_result1, ol_year2, ol_subject2, ol_result2,fit_registration_no,
                application_no);
    }


    @Override
    public int updateLateralApplicantsPaymentInfo(LateralApplicantsPersonlInfo lateralApplicantsPersonlInfo) {


        String type = lateralApplicantsPersonlInfo.getType();
        String payment_category = lateralApplicantsPersonlInfo.getPayment_category();
        String payment_type = lateralApplicantsPersonlInfo.getPayment_type();
        String amount = lateralApplicantsPersonlInfo.getAmount();
        String over_payment = lateralApplicantsPersonlInfo.getOver_payment();
        String surcharge = lateralApplicantsPersonlInfo.getSurcharge();
        String bank = lateralApplicantsPersonlInfo.getBank();
        String bank_branch = lateralApplicantsPersonlInfo.getBank_branch();
        String paid_date = lateralApplicantsPersonlInfo.getPaid_date();
        String invoice_no = lateralApplicantsPersonlInfo.getInvoice_no();

        String application_no = lateralApplicantsPersonlInfo.getApplication_no();

        return this.lateralApplicantsPersonlInfoRepository.updatePaymentInfoNew(type, payment_category, payment_type, amount, over_payment, surcharge, bank,
                bank_branch, paid_date, invoice_no, application_no);


    }


    // Delete operation
    @Override
    public void deleteLateralApplicantsPersonlInfoById(String application_no) {
        lateralApplicantsPersonlInfoRepository.deleteById(application_no);
    }




}
