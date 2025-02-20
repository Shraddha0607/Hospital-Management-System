package com.mock.mockAssignment.controller;

import com.mock.mockAssignment.dto.request.AppointmentRequest;
import com.mock.mockAssignment.dto.request.DoctorRequest;
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
    public Doctor getDoctor(@PathVariable int id){
        Doctor doctor = doctorService.getDoctor(id);
        return  doctor;
//        System.out.println("reach");
//        return  new Doctor();
    }


}

//POST: Add  hospital, patients, doctors
//Get the number of patients being treated by a given doctor
//Get the patient that was admitted the most
//GET: Find the patient that visited most number of hospitals