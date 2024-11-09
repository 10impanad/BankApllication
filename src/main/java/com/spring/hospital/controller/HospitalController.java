package com.spring.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.hospital.dto.HospitalDto;
import com.spring.hospital.dto.ResponseStructure;
import com.spring.hospital.entity.Hospital;
import com.spring.hospital.service.HospitalService;

import jakarta.persistence.Access;

@RequestMapping("/hospital")
@RestController
public class HospitalController {
	@Autowired
	private HospitalService hospitalService;

	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Hospital>> createHospital(@RequestBody HospitalDto hospitaldto) {
		return hospitalService.createHospital(hospitaldto);
	}
	@DeleteMapping("/remove/{hospitalId}")
	public ResponseEntity<ResponseStructure<String>> removeHospital(@PathVariable int hospitalId) {
		return hospitalService.removeHospital(hospitalId);
	}
	
	@GetMapping("/fetch/{hospitalId}")
	public ResponseEntity<ResponseStructure<Hospital>> fetchHospital(@PathVariable int hospitalId){
		return hospitalService.fetchHospital(hospitalId);
	}
	
	@PutMapping("/update/{hospitalId}")
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(@PathVariable int hospitalId, @RequestBody HospitalDto hospitaldto){
		return hospitalService.updateHospital(hospitalId, hospitaldto);
	}
}
