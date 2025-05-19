package com.homeloan.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
public class ApplicantRegistrationForm {

	@Id
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
	private ApplicantAddress appAddress;
	
	@OneToOne(cascade = CascadeType.ALL)
	private ApplicantProfessionDetails appProfessionDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private ApplicantBankDetails appBankDetail;
	
	@OneToOne(cascade = CascadeType.ALL)
	private ApplicantGuarantorDetails appGurenter;
	
	@OneToOne(cascade = CascadeType.ALL)
	private ApplicantDocuments aapDoc;

	public Object getAppid() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getAppBankDetail() {
		// TODO Auto-generated method stub
		return null;
	}


}
