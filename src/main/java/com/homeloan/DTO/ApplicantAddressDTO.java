package com.homeloan.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicantAddressDTO {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addressid;
	private Integer houseNumber;
	private String landmark;
	private String streetName;
	private String city;
	private String taluka;
	private String district;
	private String state;
	private String country;
	private Long pincode;
}
