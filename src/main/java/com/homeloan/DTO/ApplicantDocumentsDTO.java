package com.homeloan.DTO;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;

import com.homeloan.Model.GuranterDocuments;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicantDocumentsDTO {

	
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
	
	@OneToOne
	private GuranterDocuments guranterDoc;
}
