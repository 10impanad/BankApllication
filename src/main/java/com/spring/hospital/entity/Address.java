package com.spring.hospital.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY,generator="hos_name")
	@SequenceGenerator(initialValue = 1,name="hos_name",allocationSize = 1)
private int Id;
private int pinCode;
private String city;
private String state;
}
