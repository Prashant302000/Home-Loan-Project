package com.homeloan.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicantProfessionDetailsDTO {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer professionId;
	private String designation;
	private String officeAddress;
	private Long officeMobileNumber;
	private String officeEmailId;
	private String officeName;
	private String applicantAnnualIncome;
	

}
