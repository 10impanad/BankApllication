package com.spring.hospital.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity
public class Hospital {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY,generator="hos_name")
	@SequenceGenerator(initialValue = 1,name="hos_name",allocationSize = 1)
private int Id;
private String hospitalName;
private int branchCount;
@OneToMany(mappedBy="hospital")
@JsonIgnore
private List<Branch> branches;


}
