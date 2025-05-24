package com.insurance.insurance_Form.Services;

import com.insurance.insurance_Form.Entity.InsuranceForm;
import com.insurance.insurance_Form.Repository.InsuranceDataRepo;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserService {

    private final InsuranceDataRepo insuranceDataRepo;

    @Autowired
    public UserService(InsuranceDataRepo insuranceDataRepo) {
        this.insuranceDataRepo = insuranceDataRepo;
    }

//    @Autowired
//    private InsuranceDataRepo insuranceRepository;


    private static String getCellValue(Row row, int index) {
        Cell cell = row.getCell(index);
        return cell == null ? "" : cell.toString().trim();
    }

    private static Integer getIntegerCellValue(Row row, int index) {
        Cell cell = row.getCell(index);
        if (cell == null) {
            return null;
        }

        switch (cell.getCellType()) {
            case NUMERIC:
                return (int) cell.getNumericCellValue();
            case STRING:
                try {
                    return Integer.parseInt(cell.getStringCellValue().trim());
                } catch (NumberFormatException e) {
                    return null; // Or throw exception if you want to enforce strict parsing
                }
            default:
                return null;
        }
    }


    private static LocalDate getDateCell(Row row, int index) {
        try {
            Cell cell = row.getCell(index);
            if (cell != null && DateUtil.isCellDateFormatted(cell)) {
                Date date = cell.getDateCellValue();
                // Convert java.util.Date to java.time.LocalDate
                LocalDate localDate = date.toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate();


                return localDate;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    private static Boolean getBooleanCell(Row row, int index) {
        String val = getCellValue(row, index).toLowerCase();
        return val.equals("yes") || val.equals("true");

    }

    private static Double getDoubleCell(Row row, int index) {
        try {
            return row.getCell(index).getNumericCellValue();
        } catch (Exception e) {
            return null;
        }
    }





    // Export all insurance user data to Excel
    public ByteArrayInputStream exportUsersToExcel() throws IOException {
        List<InsuranceForm> users = insuranceDataRepo.findAll();

        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Insurance Users");

            // Header row
            Row header = sheet.createRow(0);
            int headerCol = 0;
            header.createCell(headerCol++).setCellValue("ID");
            header.createCell(headerCol++).setCellValue("Insurance ID");


            //policy details

            header.createCell(headerCol++).setCellValue("policy-Identification-Number");
            header.createCell(headerCol++).setCellValue("action");
            header.createCell(headerCol++).setCellValue("action-effective-date");

            // Personal Details

            header.createCell(headerCol++).setCellValue("First Name");
            header.createCell(headerCol++).setCellValue("Middle Name");
            header.createCell(headerCol++).setCellValue("Last Name");
            header.createCell(headerCol++).setCellValue("Gender");
            header.createCell(headerCol++).setCellValue("Title");
            header.createCell(headerCol++).setCellValue("Date of Birth");
            header.createCell(headerCol++).setCellValue("Age");
            header.createCell(headerCol++).setCellValue("Date of Marriage");
            header.createCell(headerCol++).setCellValue("Nationality");
            header.createCell(headerCol++).setCellValue("Occupation");
            header.createCell(headerCol++).setCellValue("BMI");
            header.createCell(headerCol++).setCellValue("Weight");
            header.createCell(headerCol++).setCellValue("Height");

            // Contact Details Headers
            header.createCell(headerCol++).setCellValue("Mobile Number");
            header.createCell(headerCol++).setCellValue("Alternate Number");
            header.createCell(headerCol++).setCellValue("Emergency Contact Number");
            header.createCell(headerCol++).setCellValue("STD Code");
            header.createCell(headerCol++).setCellValue("Email");
            header.createCell(headerCol++).setCellValue("Mobile Same As WhatsApp");

//  Address Details - Header
            header.createCell(headerCol++).setCellValue("Address Line 1");
            header.createCell(headerCol++).setCellValue("Address Line 2");
            header.createCell(headerCol++).setCellValue("Address Line 3");
            header.createCell(headerCol++).setCellValue("Pin Code");
            header.createCell(headerCol++).setCellValue("International Address");
            header.createCell(headerCol++).setCellValue("International Contact");
            header.createCell(headerCol++).setCellValue("Mailing Same As Primary Address");

// Identification Numbers - Header
            header.createCell(headerCol++).setCellValue("Aadhar Card No");
            header.createCell(headerCol++).setCellValue("PAN Card No");
            header.createCell(headerCol++).setCellValue("Passport");
            header.createCell(headerCol++).setCellValue("Voter ID Card");
            header.createCell(headerCol++).setCellValue("Driving License");
            header.createCell(headerCol++).setCellValue("CKYC Number");


//  Other Flags - Header
            header.createCell(headerCol++).setCellValue("Priority Customer");
            header.createCell(headerCol++).setCellValue("Sensitive Customer");
            header.createCell(headerCol++).setCellValue("Policy Holder Also Member");
            header.createCell(headerCol++).setCellValue("Politically Exposed Person");
            header.createCell(headerCol++).setCellValue("Form 60");
            header.createCell(headerCol++).setCellValue("Priority Customer Remarks");
            header.createCell(headerCol++).setCellValue("Educational Qualification");

//Insurance Plan Details - Header
            header.createCell(headerCol++).setCellValue("Annual Gross Income");
            header.createCell(headerCol++).setCellValue("Applicable Sum Insured");
            header.createCell(headerCol++).setCellValue("Relationship");
            header.createCell(headerCol++).setCellValue("Member Code");

// Nominee Details - Header
            header.createCell(headerCol++).setCellValue("Nominee Name");
            header.createCell(headerCol++).setCellValue("Nominee DOB");
            header.createCell(headerCol++).setCellValue("Nominee Age");
            header.createCell(headerCol++).setCellValue("Nominee Relationship With Proposer");
            header.createCell(headerCol++).setCellValue("Nominee Gender");
            header.createCell(headerCol++).setCellValue("Nominee Contact Number");
            header.createCell(headerCol++).setCellValue("Nominee Address");

//  Appointee Details - Header
            header.createCell(headerCol++).setCellValue("Appointee Name");
            header.createCell(headerCol++).setCellValue("Appointee Relationship With Nominee");
            header.createCell(headerCol++).setCellValue("Nominee Percentage");

// Bank Details - Header
            header.createCell(headerCol++).setCellValue("Account Holder Name");
            header.createCell(headerCol++).setCellValue("Account Number");
            header.createCell(headerCol++).setCellValue("IFSC Code");
            header.createCell(headerCol++).setCellValue("MICR Code");
            header.createCell(headerCol++).setCellValue("Bank Name");
            header.createCell(headerCol++).setCellValue("Bank Branch");
            header.createCell(headerCol++).setCellValue("Account Type");


            // Filling data rows
            int rowIdx = 1;
            for (InsuranceForm user : users) {
                Row row = sheet.createRow(rowIdx++);
                int col = 0;
                row.createCell(col++).setCellValue(user.getId());
                row.createCell(col++).setCellValue(user.getInsuranceId());


                // Policy Details Values
                row.createCell(col++).setCellValue(user.getPolicyIdentificationNumber());
                row.createCell(col++).setCellValue(user.getAction());
                row.createCell(col++).setCellValue(user.getActionEffectiveDate());


                // Personal Details Values
                row.createCell(col++).setCellValue(user.getFirstName());
                row.createCell(col++).setCellValue(user.getMiddleName());
                row.createCell(col++).setCellValue(user.getLastName());
                row.createCell(col++).setCellValue(user.getGender());
                row.createCell(col++).setCellValue(user.getTitle());
                row.createCell(col++).setCellValue(user.getDateOfBirth());
                row.createCell(col++).setCellValue(user.getAge());
                row.createCell(col++).setCellValue(user.getDateOfMarriage());
                row.createCell(col++).setCellValue(user.getNationality());
                row.createCell(col++).setCellValue(user.getOccupation());
                row.createCell(col++).setCellValue(user.getBmi());
                row.createCell(col++).setCellValue(user.getWeight());
                row.createCell(col++).setCellValue(user.getHeight());


                // Contact Details Values
                row.createCell(col++).setCellValue(user.getMobileNumber());
                row.createCell(col++).setCellValue(user.getAlternateNumber());
                row.createCell(col++).setCellValue(user.getEmergencyContactNumber());
                row.createCell(col++).setCellValue(user.getStdCode());
                row.createCell(col++).setCellValue(user.getEmail());
                //row.createCell(col++).setCellValue(user.getMobileSameAsWhatsapp());
                Boolean isWhatsapp = user.getMobileSameAsWhatsapp();
               // System.out.println("efhj"+isWhatsapp);
               // row.createCell(col++).setCellValue(isWhatsapp != null ? (isWhatsapp ? "Yes" : "No") : "N/A");
                row.createCell(col++).setCellValue(isWhatsapp != null ? isWhatsapp : false);




//  Address Details - Row
                row.createCell(col++).setCellValue(user.getAddressLine1());
                row.createCell(col++).setCellValue(user.getAddressLine2());
                row.createCell(col++).setCellValue(user.getAddressLine3());
                row.createCell(col++).setCellValue(user.getPinCode());
                row.createCell(col++).setCellValue(user.getInternationalAddress());
                row.createCell(col++).setCellValue(user.getInternationalContact());
                //row.createCell(col++).setCellValue(user.getMailingSameAsPrimaryAddress());
                Boolean isMailingprimaryAddress = user.getMobileSameAsWhatsapp();
               // row.createCell(col++).setCellValue(isMailingprimaryAddress != null ? (isMailingprimaryAddress ? "Yes" : "No") : "N/A");
                row.createCell(col++).setCellValue(isMailingprimaryAddress != null ? isMailingprimaryAddress : false);

// Identification Numbers - Row
                row.createCell(col++).setCellValue(user.getAadharCardNo());
                row.createCell(col++).setCellValue(user.getPanCardNo());
                row.createCell(col++).setCellValue(user.getPassport());
                row.createCell(col++).setCellValue(user.getVoterIdCard());
                row.createCell(col++).setCellValue(user.getDrivingLicense());
                row.createCell(col++).setCellValue(user.getCkycNumber());

//  Other Flags - Row

//                row.createCell(col++).setCellValue(user.getPriorityCustomer());
//                row.createCell(col++).setCellValue(user.getSensitiveCustomer());
//                row.createCell(col++).setCellValue(user.getPolicyHolderAlsoMember());
//                row.createCell(col++).setCellValue(user.getPoliticallyExposedPerson());
//                row.createCell(col++).setCellValue(user.getForm60());

                Boolean isPriority = user.getPriorityCustomer();
               // System.out.println("gedgedgfegdeg"+isPriority);
                row.createCell(col++).setCellValue(isPriority != null ? isPriority : false);

                Boolean isSensitive = user.getSensitiveCustomer();
                row.createCell(col++).setCellValue(isSensitive != null ? isSensitive : false);

                Boolean isPolicyHolder = user.getPolicyHolderAlsoMember();
                row.createCell(col++).setCellValue(isPolicyHolder != null ? isPolicyHolder : false);

                Boolean isPEP = user.getPoliticallyExposedPerson();
                row.createCell(col++).setCellValue(isPEP != null ? isPEP : false);

                Boolean isForm60 = user.getForm60();
                row.createCell(col++).setCellValue(isForm60 != null ? isForm60 : false);

                row.createCell(col++).setCellValue(user.getPriorityCustomerRemarks());
                row.createCell(col++).setCellValue(user.getEducationalQualification());

                //Insurance Plan Details - Row
                row.createCell(col++).setCellValue(user.getAnnualGrossIncome());
                row.createCell(col++).setCellValue(user.getApplicableSumInsured());
                row.createCell(col++).setCellValue(user.getRelationship());
                row.createCell(col++).setCellValue(user.getMemberCode());

// Nominee Details - Row
                row.createCell(col++).setCellValue(user.getNomineeName());
                row.createCell(col++).setCellValue(user.getNomineeDateOfBirth());
//                row.createCell(col++).setCellValue(user.getNomineeAge());
                Integer nomineeAge = user.getNomineeAge();
                row.createCell(col++).setCellValue(nomineeAge != null ? nomineeAge : 0);

                row.createCell(col++).setCellValue(user.getNomineeRelationshipWithProposer());
                row.createCell(col++).setCellValue(user.getNomineeGender());
                row.createCell(col++).setCellValue(user.getNomineeContactNumber());
                row.createCell(col++).setCellValue(user.getAddressOfNominee());

//  Appointee Details - Row
                row.createCell(col++).setCellValue(user.getAppointeeName());
                row.createCell(col++).setCellValue(user.getRelationshipOfAppointeeWithNominee());
                row.createCell(col++).setCellValue(user.getNomineePercentage());

// Bank Details - Row
                row.createCell(col++).setCellValue(user.getAccountHolderName());
                row.createCell(col++).setCellValue(user.getAccountNumber());
                row.createCell(col++).setCellValue(user.getIfscCode());
                row.createCell(col++).setCellValue(user.getMicrCode());
                row.createCell(col++).setCellValue(user.getBankName());
                row.createCell(col++).setCellValue(user.getBankBranch());
                row.createCell(col++).setCellValue(user.getAccountType());


            }

            // Convert workbook to ByteArrayInputStream
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (Exception e) {
            throw new IOException("Problem in exporting data to Excel", e);
        }
    }

//    // Export a single insurance user by Insurance ID
//    public ByteArrayInputStream exportUserToExcel(String id) throws IOException {
//        InsuranceForm user = insuranceDataRepo.findByInsuranceId(id)
//                .orElseThrow(() -> new RuntimeException("User not found with Insurance ID: " + id));
//
//        try (Workbook workbook = new XSSFWorkbook()) {
//            Sheet sheet = workbook.createSheet("User");
//            Row header = sheet.createRow(0);
//            Row row = sheet.createRow(1);
//
//            // (Reuse same column structure as above)
//            // You can refactor the header + row logic into a helper if needed to avoid duplication
//
//            // TODO: Optionally extract headers and row population into helper methods for reusability
//
//            // Write workbook to stream
//            ByteArrayOutputStream out = new ByteArrayOutputStream();
//            workbook.write(out);
//            return new ByteArrayInputStream(out.toByteArray());
//        } catch (Exception e) {
//            throw new IOException("Problem in exporting single user data", e);
//        }
//    }

    // Export a single insurance user by Insurance ID
    public ByteArrayInputStream exportUserToExcel(String id) throws IOException {
        InsuranceForm user = insuranceDataRepo.findByInsuranceId(id)
                .orElseThrow(() -> new RuntimeException("User not found with Insurance ID: " + id));

        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("User");
            Row header = sheet.createRow(0);

            String[] headers = {
                    "ID", "First Name", "Last Name", "Insurance ID", "Email", "Phone",
                    "Occupation", "Date of Birth", "BMI", "Gender", "Address", "City", "State", "Pincode",
                    "Aadhaar Number", "PAN Number", "Policy Type", "Policy Term", "Sum Assured", "Premium Amount",
                    "Nominee Name", "Nominee Relation", "Appointee Name", "Bank Name", "Account Number", "IFSC Code"
            };

            for (int i = 0; i < headers.length; i++) {
                header.createCell(i).setCellValue(headers[i]);
            }

            Row row = sheet.createRow(1);
            row.createCell(0).setCellValue(user.getId());
            row.createCell(1).setCellValue(user.getFirstName());
            row.createCell(2).setCellValue(user.getLastName());
            row.createCell(3).setCellValue(user.getInsuranceId());
            row.createCell(4).setCellValue(user.getEmail());
            row.createCell(5).setCellValue(user.getMobileNumber());
            row.createCell(6).setCellValue(user.getOccupation());
            row.createCell(7).setCellValue(user.getDateOfBirth());
            row.createCell(8).setCellValue(user.getBmi());
            row.createCell(9).setCellValue(user.getGender());
            row.createCell(10).setCellValue(user.getAddressLine1());
            row.createCell(11).setCellValue(user.getAddressLine2());
            row.createCell(12).setCellValue(user.getAddressLine3());
            row.createCell(13).setCellValue(user.getPinCode());
            row.createCell(14).setCellValue(user.getAadharCardNo());
            row.createCell(15).setCellValue(user.getPanCardNo());
            row.createCell(16).setCellValue(user.getPolicyIdentificationNumber());
            row.createCell(17).setCellValue(user.getPriorityCustomerRemarks());
            row.createCell(18).setCellValue(user.getApplicableSumInsured());
            row.createCell(19).setCellValue(user.getAccountHolderName());
            row.createCell(20).setCellValue(user.getNomineeName());
            row.createCell(21).setCellValue(user.getNomineeRelationshipWithProposer());
            row.createCell(22).setCellValue(user.getAppointeeName());
            row.createCell(23).setCellValue(user.getBankName());
            row.createCell(24).setCellValue(user.getAccountNumber());
            row.createCell(25).setCellValue(user.getIfscCode());

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (Exception e) {
            throw new IOException("Problem in exporting single user data", e);
        }
    }


    //upload by file

    @Transactional
    public boolean bulkUploadFromExcel(MultipartFile file) throws Exception {
        if (file.isEmpty() || !file.getOriginalFilename().endsWith(".xlsx")) {
            return false;
        }

        try (Workbook workbook = new XSSFWorkbook(file.getInputStream())) {
            Sheet sheet = workbook.getSheetAt(0);
            List<InsuranceForm> forms = new ArrayList<>();

            for (int i = 1; i < sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) continue;

                InsuranceForm form = new InsuranceForm();

                // Policy details
                form.setPolicyIdentificationNumber(getCellValue(row, 1));
                form.setAction(getCellValue(row, 2));
               // form.setActionEffectiveDate(getDateCell(row, 3));
                LocalDate effectiveDate = getDateCell(row, 3);
                if (effectiveDate == null) {
                    throw new IllegalArgumentException("actionEffectiveDate is required at row: " + i);
                }
                form.setActionEffectiveDate(effectiveDate);




                // Personal Details
                form.setFirstName(getCellValue(row, 4));
                form.setMiddleName(getCellValue(row, 5));
                form.setLastName(getCellValue(row, 6));
                form.setGender(getCellValue(row, 7));
                form.setTitle(getCellValue(row, 8));
                form.setDateOfBirth(getDateCell(row, 9));
                form.setAge(getIntegerCellValue(row, 10));
                form.setDateOfMarriage(getDateCell(row, 11));
                form.setNationality(getCellValue(row, 12));
                form.setOccupation(getCellValue(row, 13));
                form.setBmi(getDoubleCell(row, 14));
                form.setWeight(getDoubleCell(row, 15));
                form.setHeight(getDoubleCell(row, 16));

                // Contact Details (adjusted index here)
                form.setMobileNumber(getCellValue(row, 17));
                form.setAlternateNumber(getCellValue(row, 18));
                form.setEmergencyContactNumber(getCellValue(row, 19));
                form.setStdCode(getCellValue(row, 20));
                form.setEmail(getCellValue(row, 21));
                form.setMobileSameAsWhatsapp(getBooleanCell(row, 22));

                // Address details
                form.setAddressLine1(getCellValue(row, 23));
                form.setAddressLine2(getCellValue(row, 24));
                form.setAddressLine3(getCellValue(row, 25));
                form.setPinCode(getCellValue(row, 26));
                form.setInternationalAddress(getCellValue(row, 27));
                form.setInternationalContact(getCellValue(row, 28));
                form.setMailingSameAsPrimaryAddress(getBooleanCell(row, 29));

                // Identification numbers
                form.setAadharCardNo(getCellValue(row, 30));
                form.setPanCardNo(getCellValue(row, 31));
                form.setPassport(getCellValue(row, 32));
                form.setVoterIdCard(getCellValue(row, 33));
                form.setDrivingLicense(getCellValue(row, 34));
                form.setCkycNumber(getCellValue(row, 35));

                // Other flags
                form.setPriorityCustomer(getBooleanCell(row, 36));
                form.setSensitiveCustomer(getBooleanCell(row, 37));
                form.setPolicyHolderAlsoMember(getBooleanCell(row, 38));
                form.setPoliticallyExposedPerson(getBooleanCell(row, 39));
                form.setForm60(getBooleanCell(row, 40));
                form.setPriorityCustomerRemarks(getCellValue(row, 41));
                form.setEducationalQualification(getCellValue(row, 42));

                // Insurance plan details
                form.setAnnualGrossIncome(getCellValue(row, 43));
                form.setApplicableSumInsured(getCellValue(row, 44));
                form.setRelationship(getCellValue(row, 45));
                form.setMemberCode(getCellValue(row, 46));

                // Nominee details
                form.setNomineeName(getCellValue(row, 47));
                form.setNomineeDateOfBirth(getDateCell(row, 48));
                form.setNomineeAge(getIntegerCellValue(row, 49));
                form.setNomineeRelationshipWithProposer(getCellValue(row, 50));
                form.setNomineeGender(getCellValue(row, 51));
                form.setNomineeContactNumber(getCellValue(row, 52));
                form.setAddressOfNominee(getCellValue(row, 53));

                // Appointee details
                form.setAppointeeName(getCellValue(row, 54));
                form.setRelationshipOfAppointeeWithNominee(getCellValue(row, 55));
                form.setNomineePercentage(getCellValue(row, 56));

                // Bank details
                form.setAccountHolderName(getCellValue(row, 57));
                form.setAccountNumber(getCellValue(row, 58));
                form.setIfscCode(getCellValue(row, 59));
                form.setMicrCode(getCellValue(row, 60));
                form.setBankName(getCellValue(row, 61));
                form.setBankBranch(getCellValue(row, 62));
                form.setAccountType(getCellValue(row, 63));

                // Finally, add to list
                //forms.add(form);
                InsuranceForm saveD = insuranceDataRepo.save(form);
                System.out.println(456);
                String userid = ((saveD.getPolicyIdentificationNumber().length() >= 4)
                        ? saveD.getPolicyIdentificationNumber().substring(0, 4)
                        : saveD.getPolicyIdentificationNumber()) + saveD.getId();
                saveD.setInsuranceId(userid);
                insuranceDataRepo.save(saveD);


            }


            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }





}
