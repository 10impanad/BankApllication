package com.spring.hospital.service;

import org.springframework.http.ResponseEntity;

import com.spring.hospital.dto.HospitalDto;
import com.spring.hospital.dto.ResponseStructure;
import com.spring.hospital.entity.Hospital;

public interface HospitalService {
public ResponseEntity<ResponseStructure<Hospital>> createHospital(HospitalDto hospitaldto);
public ResponseEntity<ResponseStructure<String>> removeHospital(int hospitalId); 
public ResponseEntity<ResponseStructure<Hospital>> updateHospital(int hospitalId,HospitalDto hospitalDetails);
public ResponseEntity<ResponseStructure<Hospital>> fetchHospital(int hospitalId);
}
