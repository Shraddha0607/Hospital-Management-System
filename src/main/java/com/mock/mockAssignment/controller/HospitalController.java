package com.mock.mockAssignment.controller;
import com.mock.mockAssignment.dto.request.HospitalRequest;
import com.mock.mockAssignment.models.Hospital;
import com.mock.mockAssignment.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hospital")
public class HospitalController {
    @Autowired
    HospitalService hospitalService;

    @PostMapping("/add")
    public String addHospital(@RequestBody HospitalRequest hospitalRequest){
        String msg = hospitalService.addHospital(hospitalRequest);
        return msg;
    }

}
