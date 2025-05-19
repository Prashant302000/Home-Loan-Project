package com.homeloan.DTO;


import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.OneToOne;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
public class ApplicantRegistrationFormDTO {

	
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer appid;
	private String applicantFirstName;
	private String applicantMiddleName;
	private String applicantLastName;
	private String motherName;
	private String noOfDependents;
	private String applicantDateOfBirth;
	private String applicantGender;
	private Long applicantMobileNumber;
	private String applicantEmailId;
	private String applicantAadharNumber;
	private String applicantPANnumber;
	private String applicantMaritalStatus;
	private String customerLoanStatus;//customerLoanStatus
	private String caostatus;
	
	@OneToOne(cascade = CascadeType.ALL)
	private ApplicantAddressDTO appAddress;
	
	@OneToOne(cascade = CascadeType.ALL)
	private ApplicantProfessionDetailsDTO appProfessionDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private ApplicantBankDetailsDTO appBankDetail;
	
	@OneToOne(cascade = CascadeType.ALL)
	private ApplicantGuarantorDetailsDTO appGurenter;
	
	@OneToOne(cascade = CascadeType.ALL)
	private ApplicantDocumentsDTO aapDoc;
}
