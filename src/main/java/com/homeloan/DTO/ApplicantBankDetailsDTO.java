package com.homeloan.DTO;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApplicantBankDetailsDTO {

	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bankid;
	private String accountHolderName;
	private Long accountNumber;
	private String accountType;
	private String accountBankName;
	private String accountBarnch;
	private String accountIFSCCode;
	
	
	
}
