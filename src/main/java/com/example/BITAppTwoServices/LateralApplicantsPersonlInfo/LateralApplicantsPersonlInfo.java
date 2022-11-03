package com.example.BITAppTwoServices.LateralApplicantsPersonlInfo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lateral_applicants_personal_info")

public class LateralApplicantsPersonlInfo {

    public String getApplication_no() {
        return application_no;
    }

    public String getYear() {
        return year;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getFull_name_sinhala() {
        return full_name_sinhala;
    }

    public String getFull_name_tamil() {
        return full_name_tamil;
    }

    public String getName_marking() {
        return name_marking;
    }

    public String getInitials() {
        return initials;
    }

    public String getTitle() {
        return title;
    }

    public String getGender() {
        return gender;
    }

    public String getId_type() {
        return id_type;
    }

    public String getId_no() {
        return id_no;
    }

    public String getDob() {
        return dob;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public String getNationality() {
        return nationality;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getMobile() {
        return mobile;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getAddress3() {
        return address3;
    }

    public String getDistrict() {
        return district;
    }

    public String getCountry() {
        return country;
    }

    public String getQualification_type() {
        return qualification_type;
    }

    public String getQualification_pending() {
        return qualification_pending;
    }

    public String getNeed_different_req() {
        return need_different_req;
    }

    public String getAl_year() {
        return al_year;
    }

    public String getAl_index_no() {
        return al_index_no;
    }

    public String getAl_type() {
        return al_type;
    }

    public String getAl_subject1() {
        return al_subject1;
    }

    public String getAl_result1() {
        return al_result1;
    }

    public String getAl_subject2() {
        return al_subject2;
    }

    public String getAl_result2() {
        return al_result2;
    }

    public String getAl_subject3() {
        return al_subject3;
    }

    public String getAl_result3() {
        return al_result3;
    }

    public String getAl_subject4() {
        return al_subject4;
    }

    public String getAl_result4() {
        return al_result4;
    }

    public String getOl_year1() {
        return ol_year1;
    }

    public String getOl_subject1() {
        return ol_subject1;
    }

    public String getOl_result1() {
        return ol_result1;
    }

    public String getOl_year2() {
        return ol_year2;
    }

    public String getOl_subject2() {
        return ol_subject2;
    }

    public String getOl_result2() {
        return ol_result2;
    }

    public String getType() {
        return type;
    }

    public String getPayment_category() {
        return payment_category;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public String getAmount() {
        return amount;
    }

    public String getOver_payment() {
        return over_payment;
    }

    public String getSurcharge() {
        return surcharge;
    }

    public String getBank() {
        return bank;
    }

    public String getBank_branch() {
        return bank_branch;
    }

    public String getPaid_date() {
        return paid_date;
    }

    public String getInvoice_no() {
        return invoice_no;
    }

    public String getFit_registration_no() {
        return fit_registration_no;
    }

    public String getBit_registration_no() {
        return bit_registration_no;
    }

    public String getDisabilities() {
        return disabilities;
    }

    public String getApplication_status() {
        return application_status;
    }

    public String getApply_bit_year() {
        return apply_bit_year;
    }

    public String getOl_index1() {
        return ol_index1;
    }

    public String getOl_index2() {
        return ol_index2;
    }


    public String getFit_year() {
        return fit_year;
    }

    @Id
    @Column(length = 20)
    private String application_no;
    @Column(length = 10)
    private String year;
    @Column(length = 150)
    private String full_name;
    @Column(length = 150)
    private String full_name_sinhala;
    @Column(length = 150)
    private String full_name_tamil;
    @Column(length = 50)
    private String name_marking;
    @Column(length = 20)
    private String initials;
    @Column(length = 20)
    private String title;
    @Column(length = 20)
    private String gender;
    @Column(length = 20)
    private String id_type;
    @Column(length = 20)
    private String id_no;
    @Column(length = 20)
    private String dob;
    @Column(length = 20)
    private String citizenship;
    @Column(length = 20)
    private String nationality;

    private String email;
    private String phone;
    private String mobile;
    private String address1;
    private String address2;
    private String address3;
    private String district;
    private String country;


    private String qualification_type;
    private String qualification_pending;
    private String need_different_req;
    private String al_year;
    private String al_index_no;
    private String al_type;
    private String al_subject1;
    private String al_result1;
    private String al_subject2;
    private String al_result2;
    private String al_subject3;
    private String al_result3;
    private String al_subject4;
    private String al_result4;

    private String ol_year1;
    private String ol_subject1;
    private String ol_result1;
    private String ol_index1;

    private String ol_year2;
    private String ol_subject2;
    private String ol_result2;
    private String ol_index2;

    private String type;
    private String payment_category;
    private String payment_type;
    private String amount;
    private String over_payment;
    private String surcharge;
    private String bank;
    private String bank_branch;
    private String paid_date;
    private String invoice_no;

    private String fit_registration_no;
    private String fit_year;
    private String bit_registration_no;
    private String disabilities;

    private String application_status;
    private String apply_bit_year;


}
