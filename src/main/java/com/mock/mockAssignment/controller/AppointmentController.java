package com.mock.mockAssignment.controller;

import com.mock.mockAssignment.dto.request.AppointmentRequest;
import com.mock.mockAssignment.dto.response.AppointmentResponse;
import com.mock.mockAssignment.models.Appointment;
import com.mock.mockAssignment.models.Doctor;
import com.mock.mockAssignment.service.AppointmentService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;
    @PostMapping
    public String getAppointment(@RequestBody AppointmentRequest appointmentRequest){
        String msg = appointmentService.addAppointment(appointmentRequest);
        return msg;
    }

    @GetMapping("/{id}")
    public AppointmentResponse getAppointment(@PathVariable int id){
        AppointmentResponse appointmentResponse = appointmentService.getAppointment(id);
        return  appointmentResponse;
    }

    @DeleteMapping
    public String deleteAppointment(int id){
        String msg = appointmentService.deleteAppointment(id);
        return msg;
    }

    @PutMapping("/update/{id}")
    public AppointmentResponse updateAppointment (@RequestBody AppointmentRequest appointmentRequest, @PathVariable int id) {
        AppointmentResponse appointmentResponse = appointmentService.updateAppointment(appointmentRequest, id);
        return appointmentResponse;
    }


}
