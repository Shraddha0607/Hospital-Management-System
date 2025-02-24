package com.mock.mockAssignment.service;

import com.mock.mockAssignment.dto.request.AppointmentRequest;
import com.mock.mockAssignment.dto.response.AppointmentResponse;
import com.mock.mockAssignment.models.Appointment;
import com.mock.mockAssignment.models.Doctor;
import com.mock.mockAssignment.models.Patient;
import com.mock.mockAssignment.repository.*;
import com.mock.mockAssignment.repository.DoctorRepository;
import com.mock.mockAssignment.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    AppointmentRepository  appointmentRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    PatientRepository patientRepository;
    public String addAppointment( AppointmentRequest appointmentRequest){

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
            List<Integer> lstPatient =  appointmentRequest.getPatientIds();
            for(int patientId : lstPatient){
                Patient patient = patientRepository.findById(patientId).orElse(null);

                if(patient == null){

                }
//            appointment.setPatient(patient);
            }

        }
        catch(Exception e){
            System.out.println("Either null patient or doctor");
        }

        // set status as newly scheduled
        appointment.setStatus("scheduled");
        appointmentRepository.save(appointment);
        return "Successfully added.";
    }

    public AppointmentResponse getAppointment(int id){
        Appointment appointment = appointmentRepository.findById(id).get();

        AppointmentResponse appointmentResponse = new AppointmentResponse();
        appointmentResponse.setAppointmentDate(appointment.getAppointmentDate());

        String doctorName = doctorRepository.findById(appointment.getId()).get().getName();
        appointmentResponse.setDoctorName(doctorName);

//        String patientName = appointment.getPatient().get().getName();
//        appointmentResponse.setPatientName(patientName);

        // now get patient
        List<Patient> lstPatient =  appointment.getPatient();
        List<String> patientsName = new ArrayList<>();
        for(Patient patient : lstPatient){
            if(patient == null){

            }
            patientsName.add(patient.getName());

        }

        appointmentResponse.setPatientName(patientsName);

        return appointmentResponse;

    }

    public String deleteAppointment(int id){
        // to cancel appointment
        // fetch the appointment and changed the status to cancel

        Appointment existingAppointment = appointmentRepository.findById(id).get();
        existingAppointment.setStatus("Cancelled");
        appointmentRepository.save(existingAppointment);

        return "Appointment cancelled successfully";
    }

    public AppointmentResponse updateAppointment(AppointmentRequest appointmentRequest, int id){
        Appointment existingAppointment = appointmentRepository.findById(id).get();

        // now need to update
        existingAppointment.setStatus("Completed");
        Appointment updatedAppointment =  appointmentRepository.save(existingAppointment);

        AppointmentResponse appointmentResponse = new AppointmentResponse();
        appointmentResponse.setAppointmentDate(updatedAppointment.getAppointmentDate());

        String doctorName = doctorRepository.findById(updatedAppointment.getId()).get().getName();
        appointmentResponse.setDoctorName(doctorName);

        // now get patient
        List<Patient> lstPatient =  updatedAppointment.getPatient();
        List<String> patientsName = new ArrayList<>();
        for(Patient patient : lstPatient){
            if(patient == null){

            }
            patientsName.add(patient.getName());

        }

        appointmentResponse.setPatientName(patientsName);


        return appointmentResponse;
    }
}
