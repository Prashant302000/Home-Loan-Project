


package com.homeloan.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.homeloan.Model.Email;
import com.homeloan.Model.Ledger;
import com.homeloan.Model.checkEnquiry;
import com.homeloan.ServiceInterface.EmailServiceInterface;

@RestController
@CrossOrigin("*")
public class EmailController {

	
	@Autowired
	EmailServiceInterface seo;
	

	@PostMapping(value = "/sendmail",consumes = MediaType.MULTIPART_FORM_DATA_VALUE )
	public String sendemail(@RequestPart ("toEmail")String toEmail,
			@RequestPart ("sanctionLetter")MultipartFile sanctionLetter )throws JsonMappingException ,
		
		JsonProcessingException{
	
			try {
				System.out.println(toEmail);
				seo.sendSanctionLetter(toEmail, sanctionLetter);
				return "mail send";
			} catch (Exception e) {
			
				return "Error";
			}
			
		}
	
	
	
	@PostMapping(value = "/rejectmail")
	public String rejectmail(@RequestBody checkEnquiry check) {
		
		Email email=new Email();
		email.setToEmail(check.getEmail());
		
		try {
			
			seo.sendrectmail(email.getToEmail());
			return "mail send";
		}
		catch (Exception e) {
			
			return "Error";
		}
	}	
	
	
	@PostMapping(value = "/customermail")
	public String customermail(@RequestBody checkEnquiry check) {
		
		Email email=new Email();
		email.setToEmail(check.getEmail());
		
		try {
			
			seo.sendrectmail(email.getToEmail());
			return "mail send";
		}
		catch (Exception e) {
			
			return "Error";
		}
	}	
		
		

	@PostMapping(value = "/defaultermail")
	public String defaultermail(@RequestBody Ledger le) {
		System.out.println(le.getEmail());
		Email email=new Email();
		email.setToEmail(le.getEmail());
		
		try {
			
			seo.senddefaultermail(email.getToEmail());
			return "mail send";
		}
		catch (Exception e) {
			
			return "Error";
		}
		
	
	}
	
}

