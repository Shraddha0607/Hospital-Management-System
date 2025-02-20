package com.mock.mockAssignment.service;

import com.mock.mockAssignment.dto.request.AppointmentRequest;
import com.mock.mockAssignment.dto.request.DoctorRequest;
import com.mock.mockAssignment.models.Doctor;
import com.mock.mockAssignment.models.Hospital;
import com.mock.mockAssignment.repository.DoctorRepository;
import com.mock.mockAssignment.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    HospitalRepository hospitalRepository;


    public String addDoctor( DoctorRequest doctorRequest){

        // create actual doctor object to save
        Doctor doctor = new Doctor();
        doctor.setName(doctorRequest.getName());
        doctor.setDepartment(doctorRequest.getDepartment());

        // get hospital
        Hospital hospital = hospitalRepository.findById(doctorRequest.getHospitalId()).get();

        // save in actual object
        doctor.setHospital(hospital);

        doctorRepository.save(doctor);
        return "Successfully added.";
    }

    public Doctor getDoctor(int id){
        Doctor doctor  = doctorRepository.findById(id).get();
        return doctor;
    }

}
