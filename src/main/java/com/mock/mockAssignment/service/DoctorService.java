package com.mock.mockAssignment.service;

import com.mock.mockAssignment.dto.request.AppointmentRequest;
import com.mock.mockAssignment.dto.request.DoctorRequest;
import com.mock.mockAssignment.dto.request.HospitalRequest;
import com.mock.mockAssignment.dto.response.DoctorResponse;
import com.mock.mockAssignment.dto.response.HospitalResponse;
import com.mock.mockAssignment.models.Doctor;
import com.mock.mockAssignment.models.Hospital;
import com.mock.mockAssignment.repository.DoctorRepository;
import com.mock.mockAssignment.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.print.Doc;

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
        doctor.setSpecialization(doctorRequest.getSpecialization());

        // get hospital
        Hospital hospital = hospitalRepository.findById(doctorRequest.getHospitalId()).get();

        // save in actual object
        doctor.setHospital(hospital);

        doctorRepository.save(doctor);
        return "Successfully added.";
    }

    public DoctorResponse getDoctor(int id){
        Doctor doctor  = doctorRepository.findById(id).get();

        // need to return doctor response
        DoctorResponse doctorResponse = new DoctorResponse();
        doctorResponse.setName(doctor.getName());
        doctorResponse.setSpecialization(doctor.getSpecialization());
        doctorResponse.setHospitalId(doctor.getId());

        return doctorResponse;
    }


    public String deleteDoctor(int id){
        doctorRepository.deleteById(id);
        return "Doctor deleted successfully";
    }

    public DoctorResponse updateDoctor(DoctorRequest doctorRequest, int doctorId){
        Doctor existingDoctor = doctorRepository.findById(doctorId).get();

        existingDoctor.setName(doctorRequest.getName());
        existingDoctor.setSpecialization(doctorRequest.getSpecialization());
        existingDoctor.setId(doctorRequest.getHospitalId());

        Doctor updatedDoctor = doctorRepository.save(existingDoctor);

        DoctorResponse doctorResponse = new DoctorResponse();
        doctorResponse.setName(updatedDoctor.getName());
        doctorResponse.setSpecialization(updatedDoctor.getSpecialization());
        doctorResponse.setHospitalId(updatedDoctor.getId());

        return doctorResponse;
    }


}
