package com.spring.hospital.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.hospital.dao.BranchDao;
import com.spring.hospital.dao.HospitalDao;
import com.spring.hospital.dto.HospitalDto;
import com.spring.hospital.dto.ResponseStructure;
import com.spring.hospital.entity.Branch;
import com.spring.hospital.entity.Hospital;

@Service
public class HospitalServiceImpln implements HospitalService{
	@Autowired
private HospitalDao hospitalDao;
	@Autowired
	private BranchDao branchDao;
	public ResponseEntity<ResponseStructure<Hospital>> createHospital(HospitalDto hospitaldto) {
		Hospital hos=new Hospital();
		hos.setHospitalName(hospitaldto.getHospitalName());
		
		ResponseStructure<Hospital> response=new ResponseStructure<>();
		response.setSourceCode(HttpStatus.CREATED.value());
		response.setMessage("Success");
		response.setData(hospitalDao.createHospital(hos));
		return new ResponseEntity<ResponseStructure<Hospital>>(response,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<String>> removeHospital(int hospitalId){
		Hospital hos=hospitalDao.fetchById(hospitalId);
		
		List<Branch> branch=hos.getBranches();
		for(Branch b:branch) {
			b.setHospital(null);
			branchDao.addBranch(b);
		}
	
		
		String result=hospitalDao.removeHospital(hos);
		ResponseStructure<String> reponse=new ResponseStructure<>();
		reponse.setData(result);
		reponse.setMessage("remobved successfully");
		reponse.setSourceCode(HttpStatus.OK.value());
		
		return new ResponseEntity<ResponseStructure<String>>(reponse,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(int hospitalId, HospitalDto hospitalDetails) {
		Hospital hospital=hospitalDao.fetchById(hospitalId);
		
		if(hospital!=null) {
			
		hospital.setHospitalName(hospitalDetails.getHospitalName());
		Hospital update=hospitalDao.updateHospital(hospital);
		ResponseStructure<Hospital> response=new ResponseStructure<>();
		response.setSourceCode(HttpStatus.OK.value());
		response.setMessage("Updated");
		response.setData(update);
		return new ResponseEntity<ResponseStructure<Hospital>>(response,HttpStatus.OK);
	}
		else {
			return null;
		}
	}
	public ResponseEntity<ResponseStructure<Hospital>> fetchHospital(int hospitaldto) {
		Hospital hos=hospitalDao.fetchById(hospitaldto);
		
		
//		hos.setHospitalName(hospitaldto.getHospitalName());
	
		ResponseStructure<Hospital> response=new ResponseStructure<>();
		response.setSourceCode(HttpStatus.CREATED.value());
		response.setMessage("Success");
		response.setData(hospitalDao.fetchById(hos.getId()));
		return new ResponseEntity<ResponseStructure<Hospital>>(response,HttpStatus.CREATED);
	}
	
}
