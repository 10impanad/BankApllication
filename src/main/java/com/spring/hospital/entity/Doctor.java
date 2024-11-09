package com.spring.hospital.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity
public class Doctor {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	private String name;
	private String specialization;
	private double salary;
	@ManyToMany(mappedBy="doctors")
	private List<Branch> branches;
	
}
