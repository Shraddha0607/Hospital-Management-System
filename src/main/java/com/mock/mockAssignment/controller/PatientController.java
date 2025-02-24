package com.mock.mockAssignment.controller;

import com.mock.mockAssignment.dto.request.PatientRequest;
import com.mock.mockAssignment.dto.response.PatientResponse;
import com.mock.mockAssignment.models.Patient;
import com.mock.mockAssignment.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    PatientService patientService;

    @PostMapping("/add")
    public String addPatient(@RequestBody PatientRequest patientRequest){
        String msg = patientService.addPatient(patientRequest);
        return msg;
    }

    // Get the number of patients being treated by a given doctor
    @GetMapping("/{id}")
    public PatientResponse getPatient(@PathVariable int id){
        PatientResponse patientResponse = patientService.getPatient(id);
        return patientResponse;
    }

    @PutMapping
    public PatientResponse updatePatient(@RequestBody PatientRequest patientRequest){
        PatientResponse patientResponse = patientService.updatePatient(patientRequest);
        return patientResponse;
    }


    @DeleteMapping ("/{id}")
    public String deletePatient(@PathVariable int id){
        String msg = patientService.deletePatient(id);
        return msg;
    }

}

