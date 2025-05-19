package com.homeloan.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicantProfessionDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int professionId;
	private String designation;
	private String officeAddress;
	private Long officeMobileNumber;
	private String officeEmailId;
	private String officeName;
	private String applicantAnnualIncome;
	

}
