package com.insurance.insurance_Form.model;


import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDate;





public class Requestmodel {


    // Policy details
    private String policyIdentificationNumber;
    private String action;
    private LocalDate actionEffectiveDate;

    // Personal details
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private String title;
    private LocalDate dateOfBirth;
    private Integer age;
    private LocalDate dateOfMarriage;
    private String nationality;
    private String occupation;
    private Double bmi;
    private Double weight;
    private Double height;

    // Contact details
    private String mobileNumber;
    private String alternateNumber;
    private String emergencyContactNumber;
    private String stdCode;
    private String email;
    private Boolean isMobileSameAsWhatsapp;

    // Address details
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String pinCode;
    private String internationalAddress;
    private String internationalContact;
    private Boolean isMailingSameAsPrimaryAddress;

    // Identification numbers
    private String aadharCardNo;
    private String panCardNo;
    private String passport;
    private String voterIdCard;
    private String drivingLicense;
    private String ckycNumber;

    // Other flags
    private Boolean priorityCustomer;
    private Boolean sensitiveCustomer;
    private Boolean isPolicyHolderAlsoMember;
    private Boolean politicallyExposedPerson;
    private Boolean form60;
    private String priorityCustomerRemarks;
    private String educationalQualification;

    // Insurance plan details
    private String annualGrossIncome;
    private String applicableSumInsured;
    private String relationship;
    private String memberCode;

    // Nominee details
    private String nomineeName;
    private LocalDate nomineeDateOfBirth;
    private Integer nomineeAge;
    private String nomineeRelationshipWithProposer;
    private String nomineeGender;
    private String nomineeContactNumber;
    private String addressOfNominee;

    // Appointee details
    private String appointeeName;
    private String relationshipOfAppointeeWithNominee;
    private String nomineePercentage;

    // Bank details
    private String accountHolderName;
    private String accountNumber;
    private String ifscCode;
    private String micrCode;
    private String bankName;
    private String bankBranch;
    private String accountType;

   public Requestmodel() {
    }



    public  Requestmodel(
            String policyIdentificationNumber,
            String action,
            LocalDate actionEffectiveDate,
            String firstName,
            String middleName,
            String lastName,
            String gender,
            String title,
            LocalDate dateOfBirth,
            Integer age,
            LocalDate dateOfMarriage,
            String nationality,
            String occupation,
            Double bmi,
            Double weight,
            Double height,
            String mobileNumber,
            String alternateNumber,
            String emergencyContactNumber,
            String stdCode,
            String email,
            Boolean isMobileSameAsWhatsapp,
            String addressLine1,
            String addressLine2,
            String addressLine3,
            String pinCode,
            String internationalAddress,
            String internationalContact,
            Boolean isMailingSameAsPrimaryAddress,
            String aadharCardNo,
            String panCardNo,
            String passport,
            String voterIdCard,
            String drivingLicense,
            String ckycNumber,


            Boolean priorityCustomer,
            Boolean sensitiveCustomer,
            Boolean isPolicyHolderAlsoMember,
            Boolean politicallyExposedPerson,
            Boolean form60,
            String priorityCustomerRemarks,
            String educationalQualification,


            String annualGrossIncome,
            String applicableSumInsured,
            String relationship,
            String memberCode,
            String nomineeName,
            LocalDate nomineeDateOfBirth,
            Integer nomineeAge,
            String nomineeRelationshipWithProposer,
            String nomineeGender,
            String nomineeContactNumber,
            String addressOfNominee,
            String appointeeName,
            String relationshipOfAppointeeWithNominee,
            String nomineePercentage,
            String accountHolderName,
            String accountNumber,
            String ifscCode,
            String micrCode,
            String bankName,
            String bankBranch,
            String accountType
    ) {
        this.policyIdentificationNumber = policyIdentificationNumber;
        this.action = action;
        this.actionEffectiveDate = actionEffectiveDate;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.gender = gender;
        this.title = title;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.dateOfMarriage = dateOfMarriage;
        this.nationality = nationality;
        this.occupation = occupation;
        this.bmi = bmi;
        this.weight = weight;
        this.height = height;
        this.mobileNumber = mobileNumber;
        this.alternateNumber = alternateNumber;
        this.emergencyContactNumber = emergencyContactNumber;
        this.stdCode = stdCode;
        this.email = email;
        this.isMobileSameAsWhatsapp = isMobileSameAsWhatsapp;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.addressLine3 = addressLine3;
        this.pinCode = pinCode;
        this.internationalAddress = internationalAddress;
        this.internationalContact = internationalContact;
        this.isMailingSameAsPrimaryAddress = isMailingSameAsPrimaryAddress;
        this.aadharCardNo = aadharCardNo;
        this.panCardNo = panCardNo;
        this.passport = passport;
        this.voterIdCard = voterIdCard;
        this.drivingLicense = drivingLicense;
        this.ckycNumber = ckycNumber;

        this.priorityCustomer = priorityCustomer;
        this.sensitiveCustomer = sensitiveCustomer;
        this.isPolicyHolderAlsoMember = isPolicyHolderAlsoMember;
        this.politicallyExposedPerson = politicallyExposedPerson;
        this.form60 = form60;
        this.priorityCustomerRemarks = priorityCustomerRemarks;
        this.educationalQualification = educationalQualification;

        this.annualGrossIncome = annualGrossIncome;
        this.applicableSumInsured = applicableSumInsured;
        this.relationship = relationship;
        this.memberCode = memberCode;

        this.nomineeName = nomineeName;
        this.nomineeDateOfBirth = nomineeDateOfBirth;
        this.nomineeAge = nomineeAge;
        this.nomineeRelationshipWithProposer = nomineeRelationshipWithProposer;
        this.nomineeGender = nomineeGender;
        this.nomineeContactNumber = nomineeContactNumber;
        this.addressOfNominee = addressOfNominee;
        this.appointeeName = appointeeName;
        this.relationshipOfAppointeeWithNominee = relationshipOfAppointeeWithNominee;
        this.nomineePercentage = nomineePercentage;
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.ifscCode = ifscCode;
        this.micrCode = micrCode;
        this.bankName = bankName;
        this.bankBranch = bankBranch;
        this.accountType = accountType;
    }


    public String getPolicyIdentificationNumber() {
        return policyIdentificationNumber;
    }

    public void setPolicyIdentificationNumber(String policyIdentificationNumber) {
        this.policyIdentificationNumber = policyIdentificationNumber;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public LocalDate getActionEffectiveDate() {
        return actionEffectiveDate;
    }

    public void setActionEffectiveDate(LocalDate actionEffectiveDate) {
        this.actionEffectiveDate = actionEffectiveDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDateOfMarriage() {
        return dateOfMarriage;
    }

    public void setDateOfMarriage(LocalDate dateOfMarriage) {
        this.dateOfMarriage = dateOfMarriage;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Double getBmi() {
        return bmi;
    }

    public void setBmi(Double bmi) {
        this.bmi = bmi;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAlternateNumber() {
        return alternateNumber;
    }

    public void setAlternateNumber(String alternateNumber) {
        this.alternateNumber = alternateNumber;
    }

    public String getEmergencyContactNumber() {
        return emergencyContactNumber;
    }

    public void setEmergencyContactNumber(String emergencyContactNumber) {
        this.emergencyContactNumber = emergencyContactNumber;
    }

    public String getStdCode() {
        return stdCode;
    }

    public void setStdCode(String stdCode) {
        this.stdCode = stdCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getMobileSameAsWhatsapp() {
        return isMobileSameAsWhatsapp;
    }

    public void setMobileSameAsWhatsapp(Boolean mobileSameAsWhatsapp) {
        isMobileSameAsWhatsapp = mobileSameAsWhatsapp;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getInternationalAddress() {
        return internationalAddress;
    }

    public void setInternationalAddress(String internationalAddress) {
        this.internationalAddress = internationalAddress;
    }

    public String getInternationalContact() {
        return internationalContact;
    }

    public void setInternationalContact(String internationalContact) {
        this.internationalContact = internationalContact;
    }

    public Boolean getMailingSameAsPrimaryAddress() {
        return isMailingSameAsPrimaryAddress;
    }

    public void setMailingSameAsPrimaryAddress(Boolean mailingSameAsPrimaryAddress) {
        isMailingSameAsPrimaryAddress = mailingSameAsPrimaryAddress;
    }

    public String getAadharCardNo() {
        return aadharCardNo;
    }

    public void setAadharCardNo(String aadharCardNo) {
        this.aadharCardNo = aadharCardNo;
    }

    public String getPanCardNo() {
        return panCardNo;
    }

    public void setPanCardNo(String panCardNo) {
        this.panCardNo = panCardNo;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getVoterIdCard() {
        return voterIdCard;
    }

    public void setVoterIdCard(String voterIdCard) {
        this.voterIdCard = voterIdCard;
    }

    public String getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense;
    }


    public String getCkycNumber() {
        return ckycNumber;
    }

    public void setCkycNumber(String ckycNumber) {
        this.ckycNumber = ckycNumber;
    }


    public Boolean getPriorityCustomer() {
        return priorityCustomer;
    }

    public void setPriorityCustomer(Boolean priorityCustomer) {
        this.priorityCustomer = priorityCustomer;
    }

    public Boolean getSensitiveCustomer() {
        return sensitiveCustomer;
    }

    public void setSensitiveCustomer(Boolean sensitiveCustomer) {
        this.sensitiveCustomer = sensitiveCustomer;
    }

    public Boolean getPolicyHolderAlsoMember() {
        return isPolicyHolderAlsoMember;
    }

    public void setPolicyHolderAlsoMember(Boolean policyHolderAlsoMember) {
        isPolicyHolderAlsoMember = policyHolderAlsoMember;
    }

    public Boolean getPoliticallyExposedPerson() {
        return politicallyExposedPerson;
    }

    public void setPoliticallyExposedPerson(Boolean politicallyExposedPerson) {
        this.politicallyExposedPerson = politicallyExposedPerson;
    }

    public Boolean getForm60() {
        return form60;
    }

    public void setForm60(Boolean form60) {
        this.form60 = form60;
    }

    public String getPriorityCustomerRemarks() {
        return priorityCustomerRemarks;
    }

    public void setPriorityCustomerRemarks(String priorityCustomerRemarks) {
        this.priorityCustomerRemarks = priorityCustomerRemarks;
    }

    public String getEducationalQualification() {
        return educationalQualification;
    }

    public void setEducationalQualification(String educationalQualification) {
        this.educationalQualification = educationalQualification;
    }

    public String getAnnualGrossIncome() {
        return annualGrossIncome;
    }

    public void setAnnualGrossIncome(String annualGrossIncome) {
        this.annualGrossIncome = annualGrossIncome;
    }

    public String getApplicableSumInsured() {
        return applicableSumInsured;
    }

    public void setApplicableSumInsured(String applicableSumInsured) {
        this.applicableSumInsured = applicableSumInsured;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public String getNomineeName() {
        return nomineeName;
    }

    public void setNomineeName(String nomineeName) {
        this.nomineeName = nomineeName;
    }

    public LocalDate getNomineeDateOfBirth() {
        return nomineeDateOfBirth;
    }

    public void setNomineeDateOfBirth(LocalDate nomineeDateOfBirth) {
        this.nomineeDateOfBirth = nomineeDateOfBirth;
    }

    public Integer getNomineeAge() {
        return nomineeAge;
    }

    public void setNomineeAge(Integer nomineeAge) {
        this.nomineeAge = nomineeAge;
    }

    public String getNomineeRelationshipWithProposer() {
        return nomineeRelationshipWithProposer;
    }

    public void setNomineeRelationshipWithProposer(String nomineeRelationshipWithProposer) {
        this.nomineeRelationshipWithProposer = nomineeRelationshipWithProposer;
    }

    public String getNomineeGender() {
        return nomineeGender;
    }

    public void setNomineeGender(String nomineeGender) {
        this.nomineeGender = nomineeGender;
    }

    public String getNomineeContactNumber() {
        return nomineeContactNumber;
    }

    public void setNomineeContactNumber(String nomineeContactNumber) {
        this.nomineeContactNumber = nomineeContactNumber;
    }

    public String getAddressOfNominee() {
        return addressOfNominee;
    }

    public void setAddressOfNominee(String addressOfNominee) {
        this.addressOfNominee = addressOfNominee;
    }

    public String getAppointeeName() {
        return appointeeName;
    }

    public void setAppointeeName(String appointeeName) {
        this.appointeeName = appointeeName;
    }

    public String getRelationshipOfAppointeeWithNominee() {
        return relationshipOfAppointeeWithNominee;
    }

    public void setRelationshipOfAppointeeWithNominee(String relationshipOfAppointeeWithNominee) {
        this.relationshipOfAppointeeWithNominee = relationshipOfAppointeeWithNominee;
    }

    public String getNomineePercentage() {
        return nomineePercentage;
    }

    public void setNomineePercentage(String nomineePercentage) {
        this.nomineePercentage = nomineePercentage;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getMicrCode() {
        return micrCode;
    }

    public void setMicrCode(String micrCode) {
        this.micrCode = micrCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
