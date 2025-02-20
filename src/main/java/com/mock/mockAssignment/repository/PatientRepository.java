package com.mock.mockAssignment.repository;

import com.mock.mockAssignment.models.Doctor;
import com.mock.mockAssignment.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
//    @Query("SELECT COUNT(p) FROM Patient p WHERE p.doctor.doctorId = :doctorId")
//    int countPatientsByDoctor(int doctorId);
//
//    @Query("SELECT p FROM Patient p GROUP BY p.id ORDER BY COUNT(p.hospital) DESC LIMIT 1")
//    Patient findMostAdmittedPatient();
////
//    @Query("SELECT p FROM Patient p GROUP BY p.id ORDER BY COUNT(DISTINCT p.hospital) DESC LIMIT 1")
//    Patient findPatientWithMostHospitals();
}
