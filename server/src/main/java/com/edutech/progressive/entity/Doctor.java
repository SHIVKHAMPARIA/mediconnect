package com.edutech.progressive.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="doctor")
public class Doctor implements Comparable<Doctor>{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="doctor_id")
    private int doctorId;

    @Column(name = "full_name",nullable = false)
    private String fullName;

    @Column(name="specialty")
    private String specialty;

    @Column(name="contact_number")
    private String contactNumber;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name="years_of_experience")
    private int yearsOfExperience;

    @OneToMany(mappedBy = "doctor", orphanRemoval = true, cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Clinic> clinics=new ArrayList<>();

    public Doctor() {
    }
    
    public Doctor(int doctorId, String fullName, String specialty, String contactNumber, String email,int yearsOfExperience) {
        this.doctorId = doctorId;
        this.fullName = fullName;
        this.specialty = specialty;
        this.contactNumber = contactNumber;
        this.email = email;
        this.yearsOfExperience = yearsOfExperience;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }



    // public List<Clinic> getClinics() {
    //     return clinics;
    // }


    // public void setClinics(List<Clinic> clinics) {
    //     this.clinics = clinics;
    // }

    
    @Override
    public int compareTo(Doctor o) {
        return Integer.compare(this.yearsOfExperience, o.yearsOfExperience);
    }

   

}

