package com.mock.mockAssignment.service;

import com.mock.mockAssignment.dto.request.HospitalRequest;
import com.mock.mockAssignment.dto.response.HospitalResponse;
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

    public HospitalResponse getHospital(int id){
        Hospital hospital = hospitalRepository.findById(id).get();

        HospitalResponse hospitalResponse = new HospitalResponse();
        hospitalResponse.setName(hospital.getName());
        hospitalResponse.setAddress(hospital.getAddress());

        return hospitalResponse;
    }

    public String deleteHospital(int id){
        hospitalRepository.deleteById(id);
        return "Hospital deleted successfully";
    }

    public HospitalResponse updateHospital(HospitalRequest hospitalRequest, int hospitalId){
        Hospital existingHospital = hospitalRepository.findById(hospitalId).get();

        existingHospital.setName(hospitalRequest.getName());
        existingHospital.setAddress(hospitalRequest.getAddress());

        Hospital updatedHospital = hospitalRepository.save(existingHospital);

        // now need to return
        HospitalResponse hospitalResponse = new HospitalResponse();
        hospitalResponse.setName(updatedHospital.getName());
        hospitalResponse.setAddress(updatedHospital.getAddress());

        return  hospitalResponse;
    }

}
