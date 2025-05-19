
package com.homeloan.DTO;

import java.sql.Timestamp;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.homeloan.Model.ApplicantRegistrationForm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SanctionLetterDTO {

	

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sanctionId;
	@UpdateTimestamp
	private Timestamp  sanctionDate;
	private String sanctionApplicantFirstName;
	private String sanctionApplicantLastName;
	private Long applicantContactNo;
	private String applicantEmailId;
	private Long sanctionLoanAmount;
	private Double sanctionRateOfIntrest;
	private Integer sanctionLoanTenure;
	private Double santionMonthlyEMIAmount;
	private Double sanctionLoanAmountWithIntrest;
	private Double processingCharges;
	private String sanctionLetterStatus;
	private String ledgerStatus;
	private String amountcredit;
	@Lob
	private byte[] sanctionLetterPdf;
    
//	@OneToOne
//	@JoinColumn(name = "applicantForm", referencedColumnName = "appid", insertable = false, updatable = false)
//	private ApplicantRegistrationFormDTO ApplicantForm;
//	
//	@OneToOne
//	@JoinColumn(name = "applicant_form_id")
//	private ApplicantRegistrationForm applicantForm;

	
}
