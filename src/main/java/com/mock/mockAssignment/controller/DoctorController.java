package com.mock.mockAssignment.controller;

import com.mock.mockAssignment.dto.request.AppointmentRequest;
import com.mock.mockAssignment.dto.request.DoctorRequest;
import com.mock.mockAssignment.dto.request.HospitalRequest;
import com.mock.mockAssignment.dto.response.DoctorResponse;
import com.mock.mockAssignment.dto.response.HospitalResponse;
import com.mock.mockAssignment.models.Doctor;
import com.mock.mockAssignment.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    @PostMapping
    public String addDoctor(@RequestBody DoctorRequest doctorRequest){
        String msg = doctorService.addDoctor(doctorRequest);
        return msg;
    }

    @GetMapping("{id}")
    public DoctorResponse getDoctor(@PathVariable int id){
        DoctorResponse doctorResponse = doctorService.getDoctor(id);
        return  doctorResponse;
    }

    @PutMapping("/update/{id}")
    public DoctorResponse updatePatient(@RequestBody DoctorRequest doctorRequest, @PathVariable int id){
        DoctorResponse doctorResponse = doctorService.updateDoctor(doctorRequest, id);
        return doctorResponse;
    }


    @DeleteMapping ("/{id}")
    public String deleteHospital(@PathVariable int id){
        String msg = doctorService.deleteDoctor(id);
        return msg;
    }

}

//POST: Add  hospital, patients, doctors
//Get the number of patients being treated by a given doctor
//Get the patient that was admitted the most
//GET: Find the patient that visited most number of hospitals