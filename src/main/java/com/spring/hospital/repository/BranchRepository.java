package com.spring.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.hospital.entity.Branch;

public interface BranchRepository  extends JpaRepository<Branch, Integer>{

}
