package com.spring.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.hospital.dto.BranchDto;
import com.spring.hospital.dto.ResponseStructure;
import com.spring.hospital.entity.Branch;
import com.spring.hospital.service.BranchService;


@RequestMapping("/hospital/branch")
@RestController
public class BranchController {
	@Autowired
	private BranchService branchService;

	@PostMapping("/save/{id}")
	public ResponseEntity<ResponseStructure<Branch>> createBranch(@RequestBody BranchDto branchDto,@PathVariable int id) {
		return branchService.createBranch(branchDto, id);
	}

}
