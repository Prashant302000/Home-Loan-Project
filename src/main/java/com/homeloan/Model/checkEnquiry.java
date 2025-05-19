package com.homeloan.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class checkEnquiry {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int eid;
	private String fullName;
	private String address;
    private String mobNo;
	private String email;
	private int age;
	private String panNo;
	private String status;
	private String mailstatus;
	@OneToOne(cascade =CascadeType.ALL)
	private Cibilcheck  cc;
	public Object getEmail() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setCc(Cibilcheck cb) {
		// TODO Auto-generated method stub
		
	}

}

