package com.spring.hospital.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.hospital.dao.BranchDao;
import com.spring.hospital.dao.HospitalDao;
import com.spring.hospital.dto.BranchDto;
import com.spring.hospital.dto.ResponseStructure;
import com.spring.hospital.entity.Branch;
import com.spring.hospital.entity.Hospital;
@Service
public class BranchServiceImpln implements BranchService {
	@Autowired
	private  BranchDao branchDao;
	@Autowired
	private HospitalDao hospitalDao;
	@Override
	public ResponseEntity<ResponseStructure<Branch>> createBranch(BranchDto branchDto, int hospitalId) {
		Hospital foundHospital=hospitalDao.fetchById(hospitalId);
		Branch branches=new Branch();
		branches.setName(branchDto.getName());
		branches.setHospital(foundHospital);
	Branch branchh=	branchDao.addBranch(branches);
		Hospital hospital=new Hospital();
		List<Branch> list=foundHospital.getBranches();
		if(list!=null) {
			list.add(branches);
			hospital.setBranchCount(hospital.getBranchCount()+1);
		}
		else {
			list=new ArrayList<Branch>();
			list.add(branches);
			hospital.setBranchCount(hospital.getBranchCount()+1);
		}
		
		ResponseStructure<Branch> responseStructure=new ResponseStructure<Branch>();
		responseStructure.setSourceCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(branchh);
		
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.CREATED);
	}

}
