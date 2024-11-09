package com.spring.hospital.dao;

import java.util.List;

import com.spring.hospital.entity.Hospital;

public interface HospitalDao {
	
Hospital createHospital(Hospital hospital);
Hospital fetchById(int id);
String removeHospital(Hospital h);
Hospital updateHospital(Hospital hospital);
//Hospital fetchAll();
}
