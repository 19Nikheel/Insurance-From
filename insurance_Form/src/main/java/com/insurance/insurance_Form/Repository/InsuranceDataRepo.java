package com.insurance.insurance_Form.Repository;

import com.insurance.insurance_Form.Entity.InsuranceForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface InsuranceDataRepo extends JpaRepository<InsuranceForm,Long> {

    Optional<InsuranceForm> findByInsuranceId(String h);
}
