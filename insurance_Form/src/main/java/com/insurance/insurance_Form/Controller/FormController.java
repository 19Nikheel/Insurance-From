package com.insurance.insurance_Form.Controller;

import com.insurance.insurance_Form.Entity.InsuranceForm;
import com.insurance.insurance_Form.Repository.InsuranceDataRepo;
import com.insurance.insurance_Form.Services.UserService;
import com.insurance.insurance_Form.model.Requestmodel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class FormController {

    private InsuranceDataRepo insuranceDataRepo;

    private UserService excelExportService;

    @Autowired
    public FormController(InsuranceDataRepo insuranceDataRepo, UserService excelExportService) {
        this.insuranceDataRepo = insuranceDataRepo;
        this.excelExportService = excelExportService;
    }

    @Transactional
    @PostMapping("/post")
    public ResponseEntity<String> generateUserId(@RequestBody Requestmodel Rm) {
        String userid;
        try {

            InsuranceForm insuranceForm = new InsuranceForm();

            // policy details
            insuranceForm.setPolicyIdentificationNumber(Rm.getPolicyIdentificationNumber());
            insuranceForm.setAction(Rm.getAction());
            insuranceForm.setActionEffectiveDate(Rm.getActionEffectiveDate());

            System.out.println(Rm);
            System.out.println(insuranceForm);

            // Personal Details
            insuranceForm.setFirstName(Rm.getFirstName());
            insuranceForm.setMiddleName(Rm.getMiddleName());
            insuranceForm.setLastName(Rm.getLastName());
            insuranceForm.setGender(Rm.getGender());
            insuranceForm.setTitle(Rm.getTitle());
            insuranceForm.setDateOfBirth(Rm.getDateOfBirth());
            insuranceForm.setAge(Rm.getAge());
            insuranceForm.setDateOfMarriage(Rm.getDateOfMarriage());
            insuranceForm.setNationality(Rm.getNationality());
            insuranceForm.setOccupation(Rm.getOccupation());
            insuranceForm.setBmi(Rm.getBmi());
            insuranceForm.setWeight(Rm.getWeight());
            insuranceForm.setHeight(Rm.getHeight());

            // Contact details
            insuranceForm.setMobileNumber(Rm.getMobileNumber());
            insuranceForm.setAlternateNumber(Rm.getAlternateNumber());
            insuranceForm.setEmergencyContactNumber(Rm.getEmergencyContactNumber());
            insuranceForm.setStdCode(Rm.getStdCode());
            insuranceForm.setEmail(Rm.getEmail());
            insuranceForm.setMobileSameAsWhatsapp(Rm.getMobileSameAsWhatsapp());

            // Address details
            insuranceForm.setAddressLine1(Rm.getAddressLine1());
            insuranceForm.setAddressLine2(Rm.getAddressLine2());
            insuranceForm.setAddressLine3(Rm.getAddressLine3());
            insuranceForm.setPinCode(Rm.getPinCode());
            insuranceForm.setInternationalAddress(Rm.getInternationalAddress());
            insuranceForm.setInternationalContact(Rm.getInternationalContact());
            insuranceForm.setMailingSameAsPrimaryAddress(Rm.getMailingSameAsPrimaryAddress());

            // Identification numbers
            insuranceForm.setAadharCardNo(Rm.getAadharCardNo());
            insuranceForm.setPanCardNo(Rm.getPanCardNo());
            insuranceForm.setPassport(Rm.getPassport());
            insuranceForm.setVoterIdCard(Rm.getVoterIdCard());
            insuranceForm.setDrivingLicense(Rm.getDrivingLicense());
            insuranceForm.setCkycNumber(Rm.getCkycNumber());

            // Other flags
            insuranceForm.setPriorityCustomer(Rm.getPriorityCustomer());
            insuranceForm.setSensitiveCustomer(Rm.getSensitiveCustomer());
            insuranceForm.setPolicyHolderAlsoMember(Rm.getPolicyHolderAlsoMember());
            insuranceForm.setPoliticallyExposedPerson(Rm.getPoliticallyExposedPerson());
            insuranceForm.setForm60(Rm.getForm60());
            insuranceForm.setPriorityCustomerRemarks(Rm.getPriorityCustomerRemarks());
            insuranceForm.setEducationalQualification(Rm.getEducationalQualification());

            // Insurance plan details
            insuranceForm.setAnnualGrossIncome(Rm.getAnnualGrossIncome());
            insuranceForm.setApplicableSumInsured(Rm.getApplicableSumInsured());
            insuranceForm.setRelationship(Rm.getRelationship());
            insuranceForm.setMemberCode(Rm.getMemberCode());

            // Nominee details
            insuranceForm.setNomineeName(Rm.getNomineeName());
            insuranceForm.setNomineeDateOfBirth(Rm.getNomineeDateOfBirth());
            insuranceForm.setNomineeAge(Rm.getNomineeAge());
            insuranceForm.setNomineeRelationshipWithProposer(Rm.getNomineeRelationshipWithProposer());
            insuranceForm.setNomineeGender(Rm.getNomineeGender());
            insuranceForm.setNomineeContactNumber(Rm.getNomineeContactNumber());
            insuranceForm.setAddressOfNominee(Rm.getAddressOfNominee());

            // Appointee details
            insuranceForm.setAppointeeName(Rm.getAppointeeName());
            insuranceForm.setRelationshipOfAppointeeWithNominee(Rm.getRelationshipOfAppointeeWithNominee());
            insuranceForm.setNomineePercentage(Rm.getNomineePercentage());

            // Bank details
            insuranceForm.setAccountHolderName(Rm.getAccountHolderName());
            insuranceForm.setAccountNumber(Rm.getAccountNumber());
            insuranceForm.setIfscCode(Rm.getIfscCode());
            insuranceForm.setMicrCode(Rm.getMicrCode());
            insuranceForm.setBankName(Rm.getBankName());
            insuranceForm.setBankBranch(Rm.getBankBranch());
            insuranceForm.setAccountType(Rm.getAccountType());

            System.out.println(456);
            InsuranceForm saveD = insuranceDataRepo.save(insuranceForm);
            System.out.println(456);
            userid = ((Rm.getPolicyIdentificationNumber().length() >= 4)
                    ? Rm.getPolicyIdentificationNumber().substring(0, 4)
                    : Rm.getPolicyIdentificationNumber()) + saveD.getId();
            insuranceForm.setInsuranceId(userid);
            insuranceDataRepo.save(saveD);

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error in creating File");
        }

        return ResponseEntity.ok().body(userid);

    }

    @GetMapping("/download")
    public ResponseEntity<InputStreamResource> downloadExcel() throws IOException {
        ByteArrayInputStream in = excelExportService.exportUsersToExcel();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=users.xlsx");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(
                        MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                .body(new InputStreamResource(in));
    }

    @GetMapping("/loadbyid/{id}")
    public ResponseEntity<InputStreamResource> downloaduserExcel(@PathVariable("id") String id) throws IOException {
        ByteArrayInputStream in = excelExportService.exportUserToExcel(id);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=users.xlsx");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(
                        MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                .body(new InputStreamResource(in));
    }


    @PostMapping("/bulk-upload")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("No file selected");
        }

        String filename = file.getOriginalFilename();
        // Process file: file.getInputStream(), file.getBytes(), etc.
        boolean b=false;
        try {
            b = excelExportService.bulkUploadFromExcel(file);
        }catch (Exception e){
            System.out.println(e);

        }
        if(b){
            return ResponseEntity.ok("File uploaded: " + filename);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something wrong");
    }




}
