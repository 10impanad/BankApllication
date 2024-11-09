package com.spring.hospital.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity
public class Branch {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY,generator="hos_name")
	@SequenceGenerator(initialValue = 1,name="hos_name",allocationSize = 1)
private int id;
private String name;
@ManyToOne
@JoinColumn
private Hospital hospital;
@OneToOne
private Address address;
@ManyToMany
@JoinTable(joinColumns=@JoinColumn, inverseJoinColumns=@JoinColumn)
private List<Doctor> doctors;
}
