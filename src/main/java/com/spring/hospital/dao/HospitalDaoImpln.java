package com.spring.hospital.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.hospital.entity.Hospital;
import com.spring.hospital.repository.HospitalRepository;

@Repository
public class HospitalDaoImpln implements HospitalDao {
	@Autowired
	private HospitalRepository hospitalRepository;

	@Override
	public Hospital createHospital(Hospital hospital) {
		// TODO Auto-generated method stub
		return hospitalRepository.save(hospital);
	}

	@Override
	public Hospital fetchById(int id) {
		Optional<Hospital> opt= hospitalRepository.findById(id);
		if(opt!=null) {
			return opt.get();
		}
		else {
			return null;
		}
	}
	
	

	@Override
	public String removeHospital(Hospital h) {
//		Optional<Hospital> opt= hospitalRepository.findById(hospitalId);
		  hospitalRepository.delete(h);
		return "deleted Successfully"; 
	}

	@Override
	public Hospital updateHospital(Hospital hospital) {
return hospitalRepository.save(hospital);
	}

//	@Override
//	public Hospital fetchAll() {
//		// TODO Auto-generated method stub
//		
//		return hospital;
//	}
	
	

}
