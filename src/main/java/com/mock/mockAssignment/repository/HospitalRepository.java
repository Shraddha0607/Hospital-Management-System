package com.mock.mockAssignment.repository;

import com.mock.mockAssignment.models.Doctor;
import com.mock.mockAssignment.models.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
}
