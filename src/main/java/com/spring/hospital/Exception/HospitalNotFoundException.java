package com.spring.hospital.Exception;

public class HospitalNotFoundException extends RuntimeException {

	public HospitalNotFoundException(String msg){
		super(msg);
	}
}
