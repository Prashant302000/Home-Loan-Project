package com.homeloan.DTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@SuppressWarnings("unused")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnquiryDTO {

	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int eid;
	private String fullName;
	private String address;
	private String mobNo;
	private String email;
	private int age;
	private String panNo;
	public Object getFullName() {
		// TODO Auto-generated method stub
		return null;
	}
}
