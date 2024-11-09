package com.spring.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.hospital.entity.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

}
