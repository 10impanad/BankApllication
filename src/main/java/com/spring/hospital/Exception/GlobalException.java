package com.spring.hospital.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.spring.hospital.dto.ResponseStructure;

@RestControllerAdvice
public class GlobalException{

	@ExceptionHandler(HospitalNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> dataNotFoundException(HospitalNotFoundException e){
		ResponseStructure<String> response=new ResponseStructure<>();
		response.setSourceCode(HttpStatus.NOT_FOUND.value());
		response.setMessage("Not Found");
		response.setData(e.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(response,HttpStatus.NOT_FOUND);
	}
	
}
