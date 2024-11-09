package com.spring.hospital.dto;

import lombok.Data;

@Data
public class AddressDto {
	private int pinCode;
	private String city;
	private String state;
}
