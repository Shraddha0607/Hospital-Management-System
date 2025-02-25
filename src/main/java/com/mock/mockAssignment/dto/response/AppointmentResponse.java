package com.mock.mockAssignment.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AppointmentResponse {

    private Date appointmentDate;
    private String doctorName;
    private List<String> patientName;
    private String hospitalName;
}
