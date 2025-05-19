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
public class CibilcheckDTO {

	
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int cibilId;
	private int cibilscore;
	private String cibilstatus;
	
}
