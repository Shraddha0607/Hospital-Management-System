package com.mock.mockAssignment.service;

import com.mock.mockAssignment.dto.request.HospitalRequest;
import com.mock.mockAssignment.models.Hospital;
import com.mock.mockAssignment.models.Patient;
import com.mock.mockAssignment.repository.HospitalRepository;
import com.mock.mockAssignment.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalService {
    @Autowired
    HospitalRepository hospitalRepository;
    public String addHospital(HospitalRequest hospitalRequest){

        // we need to change request in actual object before saving
        Hospital hospital = new Hospital();
        hospital.setName(hospitalRequest.getName());
        hospital.setAddress(hospitalRequest.getAddress());

        hospitalRepository.save(hospital);
        return "Successfully added";
    }
}
