package com.homeloan.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Ledger {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer ledgerId;
	private String email;
	private String ledgerFirstName;
	private String ledgerLastName;
	@UpdateTimestamp
	private Date ledgerCreateDate;
	private Long loanAmount;
	private Long totalPaywithIntrest;
	private Integer tenure;
	private Long rateOfIntrest;
	private Long monthlyEmi;
	private Long remainingAmount;
	private Integer remainingEMI;
	private Long amountPaidTillDate;
	private Integer defaulterCount;
	@UpdateTimestamp
	private Date lastEmiDate;
	public char[] getLedgerFirstName() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
	
	

