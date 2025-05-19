package com.homeloan.DTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminStaffDTO {

	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer adminId;


}
