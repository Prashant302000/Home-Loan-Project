package com.homeloan.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cibilcheck {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int cibilId;
	private int cibilscore;
	private String cibilstatus;
	public void setCibilscore(int cibil) {
		// TODO Auto-generated method stub
		
	}
	public void setCibilstatus(String string) {
		// TODO Auto-generated method stub
		
	}
	
	
}
