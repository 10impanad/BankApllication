package com.spring.hospital.dto;

import lombok.Data;

@Data
public class ResponseStructure<T> {

	private int SourceCode;
	private String message;
	private T data;
}
