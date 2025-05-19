package com.homeloan.ServiceInterface;

import org.springframework.web.multipart.MultipartFile;




public interface EmailServiceInterface {
	
	void sendSanctionLetter(String toEmail, MultipartFile sanctionLetter);

	void sendrectmail(String toEmail);
	
	public void Contactusmail(String toEmail);

	void senddefaultermail(String toEmail);
}


