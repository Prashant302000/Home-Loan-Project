package com.homeloan.Model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SanctionLetter {

	@Id
	private Integer sanctionId;
	@UpdateTimestamp
	private Timestamp sanctionDate;
	private String sanctionApplicantFirstName;
	private String sanctionApplicantLastName;
	private Long applicantContactNo;
	private String applicantEmailId;
	private Long sanctionLoanAmount;
	private Long sanctionRateOfIntrest;
	private Integer sanctionLoanTenure;
	private Long santionMonthlyEMIAmount;
	private Long sanctionLoanAmountWithIntrest;
	private Long processingCharges;
	private String sanctionLetterStatus;
	private String ledgerStatus;
	private String amountcredit;
	@Lob
	private byte[] sanctionLetterPdf;
//	@OneToOne
//	@JoinColumn(name = "applicantForm", referencedColumnName = "appid", insertable = false, updatable = false)
//	private ApplicantRegistrationForm ApplicantForm;
	public int getSanctionId() {
		// TODO Auto-generated method stub
		return 0;
	}

//	@OneToOne
//	@JoinColumn(name = "applicant_form_id")
//	private ApplicantRegistrationForm applicantForm;

}
