package com.mock.mockAssignment.controller;

import com.mock.mockAssignment.dto.request.PatientRequest;
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
    public String addDoctor(@RequestBody PatientRequest patientRequest){
        String msg = patientService.addPatient(patientRequest);
        return msg;
    }

    // Get the number of patients being treated by a given doctor
    @GetMapping("/getPatientCount/{id}")
    public long getPatientCount(@PathVariable int id){
        long noOfPatient = patientService.getPatientCountById(id);
        return noOfPatient;
    }

    //GET: Find the patient that visited most number of hospitals
    @GetMapping("/getPatientWithMaxVisit")
    public Patient getPatientWithMaxVistToHospitals(){
        Patient patient = patientService.getPatientWithMaxVistToHospitals();
        return  patient;
    }


}

//@GetMapping("/doctor/{doctorId}")
//public int getPatientsByDoctor(@PathVariable int doctorId) {
//    return patientService.getPatientsByDoctor(doctorId);
//}
//
//@GetMapping("/most-admitted")
//public Patient getMostAdmittedPatient() {
//    return patientService.getMostAdmittedPatient();
//}
//
//@GetMapping("/most-hospitals")
//public Patient getPatientWithMostHospitals() {
//    return patientService.getPatientWithMostHospitals();
//}
