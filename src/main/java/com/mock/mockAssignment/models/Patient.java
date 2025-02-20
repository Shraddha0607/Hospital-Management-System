package com.mock.mockAssignment.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @Column(unique = true, nullable = false)
    private String aadharrNo;

//    @ManyToOne
//    @JoinColumn (name= "doctor_id")
//    @JsonIgnore
//    private Doctor doctor;
//
//    @ManyToMany
//    @JoinColumn (name="hospital_id")
//    @JsonIgnore
//    private Hospital hospital;

    @ManyToMany(mappedBy = "patients")
    private List<Hospital> hospitals;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Appointment> appointments;


}