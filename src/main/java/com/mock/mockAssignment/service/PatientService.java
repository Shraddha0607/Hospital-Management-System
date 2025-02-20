package com.mock.mockAssignment.service;

import com.mock.mockAssignment.dto.request.PatientRequest;
import com.mock.mockAssignment.models.Patient;
import com.mock.mockAssignment.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;

    public String addPatient(PatientRequest patientRequest) {

        // need to change to patient class
        Patient patient = new Patient();
        patient.setName(patientRequest.getName());
        patient.setAadharrNo(patientRequest.getAadharrNo());

        patientRepository.save(patient);
        return "Successfully added";
    }

    public long getPatientCountById(int id) {
        long count = 0;
        try {
            //count = patientRepository.findAll().stream().filter(x -> x.getDoctor().getId() == id).count();
        } catch (Exception e) {
            System.out.println("Error in service");
            e.printStackTrace();
        }
        return count;
    }

    public Patient getPatientWithMaxVistToHospitals() {

        List<Patient> patients = patientRepository.findAll();
        Map<Integer, List<Patient>> patientsPerHospital = patients.stream().collect(groupingBy(Patient::getId));

        int maxHospitalCount = 0;
        int patientIdWithMaxCount = -1;
        int count = 0;
        for (Map.Entry<Integer, List<Patient>> patient : patientsPerHospital.entrySet()) {
            if (patient.getValue().size() > maxHospitalCount) {
                maxHospitalCount = patient.getValue().size();
                patientIdWithMaxCount = patient.getKey();
            }
            System.out.println("iteration " + count);
            count ++;
        }
        // now till here we get at id


        return patientRepository.findById(patientIdWithMaxCount).get();
//        System.out.println("for loop ended");
//        return new Patient();


    }

    // Helper method to find a Patient by ID
//    private Patient findPatientById(Integer id, List<Patient> patients) {
//        return patients.stream()
//                .filter(patient -> patient.getId().equals(id))  // Find patient by ID
//                .findFirst()
//                .orElseThrow(() -> new RuntimeException("Patient not found"));
//    }


}


//public int getPatientsByDoctor(int doctorId) {
//    return patientRepository.countPatientsByDoctor(doctorId);
//}
//
//public Patient getMostAdmittedPatient() {
//    return patientRepository.findMostAdmittedPatient();
//}
//
//public Patient getPatientWithMostHospitals() {
//    return patientRepository.findPatientWithMostHospitals();
//}
