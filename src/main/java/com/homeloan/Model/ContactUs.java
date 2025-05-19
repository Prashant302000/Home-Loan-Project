package com.homeloan.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactUs {

		@Id
	   @GeneratedValue(strategy = GenerationType.AUTO)
		private int conid;
    	private String name;
	    private String email;
	    private long phone_number;
	    private String subject;
	    private String message;
		public String getEmail() {
			// TODO Auto-generated method stub
			return null;
		}
}
