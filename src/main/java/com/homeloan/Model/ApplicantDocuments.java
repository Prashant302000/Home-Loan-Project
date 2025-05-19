package com.homeloan.Model;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicantDocuments {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer documentId;
	@Lob
	private byte[] aadharCard;
	@Lob
	private byte[] panCard;
	@Lob
	private byte[] addressProof;
	@Lob
	private byte[] photo;
	@Lob
	private byte[] thumb;
	@Lob
	private byte[] signature;
	@Lob
	private byte[] blankCheque;
	@Lob
	private byte[] bankStatement;
	@Lob
	private byte[] itr;
	@Lob
	private byte[] form16; 
	
	@OneToOne(cascade = CascadeType.ALL)
	private GuranterDocuments guranterDoc;

	public void setAadharCard(byte[] bytes) {
		// TODO Auto-generated method stub
		
	}

	public void setAddressProof(byte[] bytes) {
		// TODO Auto-generated method stub
		
	}

	public void setPhoto(byte[] bytes) {
		// TODO Auto-generated method stub
		
	}

	public void setThumb(byte[] bytes) {
		// TODO Auto-generated method stub
		
	}
} 
