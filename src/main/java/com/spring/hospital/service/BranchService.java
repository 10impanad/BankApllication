package com.spring.hospital.service;

import org.springframework.http.ResponseEntity;

import com.spring.hospital.dto.BranchDto;
import com.spring.hospital.dto.ResponseStructure;
import com.spring.hospital.entity.Branch;

public interface BranchService {
ResponseEntity<ResponseStructure<Branch>> createBranch(BranchDto branchDto,int hospitalId);
}
