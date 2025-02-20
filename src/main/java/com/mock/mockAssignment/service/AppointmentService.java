package com.mock.mockAssignment.service;

import com.mock.mockAssignment.dto.request.AppointmentRequest;
import com.mock.mockAssignment.models.Appointment;
import com.mock.mockAssignment.models.Doctor;
import com.mock.mockAssignment.models.Patient;
import com.mock.mockAssignment.repository.AppointmentRepository;
import com.mock.mockAssignment.repository.DoctorRepository;
import com.mock.mockAssignment.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    PatientRepository patientRepository;
    public String getAppointment( AppointmentRequest appointmentRequest){

        // now need to fix the appointment
        Appointment appointment = new Appointment();
        appointment.setAppointmentDate(appointmentRequest.getAppointmentDate());

        // check if doctor is valid
        try{
            int doctorId = appointmentRequest.getDoctorId();
            Doctor doctor = doctorRepository.findById(doctorId).orElse(null);

            if(doctor == null){

            }
            appointment.setDoctor(doctor);

            // now get patient
            int patientId = appointmentRequest.getPatientId();
            Patient patient = patientRepository.findById(patientId).orElse(null);

            if(patient == null){

            }
            appointment.setPatient(patient);

        }
        catch(Exception e){
            System.out.println("Either null patient or doctor");
        }

        // set status as newly scheduled
        appointment.setStatus("scheduled");
        appointmentRepository.save(appointment);
        return "Successfully added.";
    }


}
