package com.mock.mockAssignment.controller;
import com.mock.mockAssignment.dto.request.HospitalRequest;
import com.mock.mockAssignment.dto.request.PatientRequest;
import com.mock.mockAssignment.dto.response.HospitalResponse;
import com.mock.mockAssignment.dto.response.PatientResponse;
import com.mock.mockAssignment.models.Hospital;
import com.mock.mockAssignment.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hospital")
public class HospitalController {
    @Autowired
    HospitalService hospitalService;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/add")
    public String addHospital(@RequestBody HospitalRequest hospitalRequest){
        String msg = hospitalService.addHospital(hospitalRequest);
        return msg;
    }

    @GetMapping("/{id}")
    public HospitalResponse getHospital(@PathVariable int id){
        HospitalResponse hospitalResponse = hospitalService.getHospital(id);
        return hospitalResponse;
    }

    @PutMapping("/update/{id}")
    public HospitalResponse updatePatient(@RequestBody HospitalRequest hospitalRequest, @PathVariable int id){
        HospitalResponse hospitalResponse = hospitalService.updateHospital(hospitalRequest, id);
        return hospitalResponse;
    }


    @DeleteMapping ("/{id}")
    public String deleteHospital(@PathVariable int id){
        String msg = hospitalService.deleteHospital(id);
        return msg;
    }
}
