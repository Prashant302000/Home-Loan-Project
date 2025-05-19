package com.homeloan.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enquiry {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int eid;
	private String fullName;
	private String address;
    private String mobNo;
	private String email;
	private int age;
	private String panNo;

}
