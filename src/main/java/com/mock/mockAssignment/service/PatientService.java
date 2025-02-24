package com.mock.mockAssignment.service;

import com.mock.mockAssignment.dto.request.PatientRequest;
import com.mock.mockAssignment.dto.response.PatientResponse;
import com.mock.mockAssignment.models.Patient;
import com.mock.mockAssignment.repository.AbstractBaseRepositoryImpl;
import com.mock.mockAssignment.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//@Service
//@Transactional
//public class PatientService extends AbstractBaseRepositoryImpl<Patient, Integer>
//        implements IPatientService{
//    private PatientRepository patientRepository;
//
//    public PatientService(PatientRepository patientRepository) {
//        super(patientRepository);
//    }
//    // other specialized methods from the MyDomainService interface
//
//}

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;

    public String addPatient(PatientRequest patientRequest) {

        // need to change to patient class
        Patient patient = new Patient();
        patient.setName(patientRequest.getName());
        patient.setAadharNo(patientRequest.getAadharNo());

        Patient savedPatient = patientRepository.save(patient);
        return "Successfully added with id " + savedPatient.getId();
    }

    public PatientResponse getPatient(int id) {   // by passing doctor id
        Patient patient = patientRepository.findById(id).get();

        // now need to chnage in
        PatientResponse patientResponse = new PatientResponse();
        patientResponse.setName(patient.getName());
        patientResponse.setAadharNo(patient.getAadharNo());

        return patientResponse;
    }

    public String deletePatient(int id) {
        patientRepository.deleteById(id);
        String msg = "Patient " + id + " deleted successfully ";
        return msg;
    }

    public PatientResponse updatePatient(PatientRequest patientRequest) {
        String aadharNo = patientRequest.getAadharNo();

        // now update data
        Patient existingPatient = patientRepository.findByAadharNo(aadharNo);
        existingPatient.setName(patientRequest.getName());
        existingPatient.setAadharNo((patientRequest.getAadharNo()));

        Patient updatedPatient = patientRepository.save(existingPatient);

        PatientResponse patientResponse = new PatientResponse();
        patientResponse.setName(updatedPatient.getName());
        patientResponse.setAadharNo(updatedPatient.getAadharNo());

        return patientResponse;
    }

}
