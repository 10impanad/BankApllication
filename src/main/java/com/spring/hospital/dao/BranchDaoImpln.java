package com.spring.hospital.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.hospital.entity.Branch;
import com.spring.hospital.entity.Hospital;
import com.spring.hospital.repository.BranchRepository;

@Repository
public class BranchDaoImpln implements BranchDao{
	@Autowired
	private BranchRepository branchr;

	@Override
	public Branch addBranch(Branch branch) {
	return branchr.save(branch);		
	}
	

}
