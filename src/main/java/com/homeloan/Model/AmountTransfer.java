package com.homeloan.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AmountTransfer {


	@Id
	private int aid;
	private String accountHolderName;
	private Long sanctionLoanAmount;
	private Long accountNumber;	
	private String accountType;
	private String accountBankName;
	private String accountBranch;
	private String accountIFSCCode;
	private String creditstatus;
	private String leadgerStatus;
	public void setAid(Object appid) {
		// TODO Auto-generated method stub
		
	}
	public Object setAccountBankName(Object appBankDetail) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
