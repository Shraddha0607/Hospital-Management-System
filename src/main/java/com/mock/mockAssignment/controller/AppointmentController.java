package com.mock.mockAssignment.controller;

import com.mock.mockAssignment.dto.request.AppointmentRequest;
import com.mock.mockAssignment.models.Appointment;
import com.mock.mockAssignment.models.Doctor;
import com.mock.mockAssignment.service.AppointmentService;
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
        String msg = appointmentService.getAppointment(appointmentRequest);
        return msg;
    }


}
