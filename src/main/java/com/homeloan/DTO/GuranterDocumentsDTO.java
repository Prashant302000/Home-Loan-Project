package com.homeloan.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuranterDocumentsDTO {
	
   
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int guranterDocID;
	@Lob
	private byte[] guarantorAadhar;
	@Lob
	private byte[] guarantorPAN;
	@Lob
	private byte[] guarantorPhoto;
	@Lob
	private byte[] guarantorSignature;
	
}
