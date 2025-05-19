package com.homeloan.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicantGuarantorDetailsDTO {
	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer guarantorId;
	private String guarantorFirstName;
	private String guarantorMiddleName;
	private String guarantorLastName;
	private String guarantorDateOfBirth;
	private String guarantorGender;
	private String guarantorAddress;
	private Long guarantorMobileNumber;
	private String guarantorEmailID;
	private Long guarantorAadharNumber;
	private String guarantorPANnumber;
	private String guarantorRelationWithCustomer;

}
