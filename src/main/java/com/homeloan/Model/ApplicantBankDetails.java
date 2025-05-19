package com.homeloan.Model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApplicantBankDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bankid;
	private String accountHolderName;
	private Long accountNumber;
	private String accountType;
	private String accountBankName;
	private String accountBarnch;
	private String accountIFSCCode;
	
	
	
}
