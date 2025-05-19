




package com.homeloan.ServiceImplementation;

import jakarta.mail.MessagingException;

import jakarta.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;



import com.homeloan.ServiceInterface.EmailServiceInterface;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class EmailServiceImpl implements EmailServiceInterface{
	
	@Value("${spring.mail.username}")
	String fromMail;
	
	@Autowired
	 JavaMailSender mailSender;

	@Override
	public void sendSanctionLetter(String toEmail, MultipartFile sanctionLetter) {
MimeMessage mimeMessage= mailSender.createMimeMessage();
		System.out.println("22222");
		MimeMessageHelper helper;
		try {
			helper=new MimeMessageHelper(mimeMessage, true);
			helper.setTo(toEmail);
			helper.setFrom(fromMail);
			helper.setSubject("Home Loan Offer Letter");
			helper.setText("Dear sir ,Please find attached offer sanction letter!" );
			helper.addAttachment("sanctionletter.pdf", sanctionLetter );
		}catch (MessagingException e) {
			
			
			
		}
		mailSender.send(mimeMessage);
		
	}

	





	@Override
	public void sendrectmail(String toEmail) {
		 
		
		  MimeMessage mimeMessage= mailSender.createMimeMessage();
			System.out.println("22222");
			MimeMessageHelper helper;
			try {
				helper=new MimeMessageHelper(mimeMessage, true);
				helper.setTo(toEmail);
				helper.setFrom(fromMail);
				helper.setSubject("Reject Mail");
				helper.setText("""
                        your cibil is Rejected and You are Not Eligible
                        For Further Process.
                         We are Not Happy to inform you that your Home Loan request has been Rejected and is currently being Not Processed.
                        Further, we inform you that we have sent an email containing attached documents.
                        Also we have sent you the terms and conditions of the loans sanctioned.\s
                        We would like to schedule your meeting with the finance officer of the company for any further information and clarifications that you might wish to know.\s
                        
                        We are happy to be doing business with you.\s
                        
                        List of Documents Required (we will recheck your doc ) :-\s
                        
                        1.Aadhar Card\s
                        2.Pan Card\s
                        3.Income Tax Return of Last Two Years\s
                        4.Salary Slips of Last Three Months\s
                        5.Passport Size Photograph\s
                        6.Bank Passbook Copy\s
                        
                        \s
                         Thanking You.\s
                        Mr.PIYUSH KOLHE\s
                        Loan Officer
                        SADAN Home Loan\s
                         Karvenagar\s
                        Pune, Maharashtra\s
                         India-411052
                        
                        Thank You For Banking With Us\s
                        
                        SADAN Home Loan.....!!!!\
                        """);
    		      		
    		  
	        	
			
			}catch (MessagingException e) {
				
				
				
			}
			mailSender.send(mimeMessage);
	     
	    		   
		        		
		
		
	}
	
	


	
	public void Contactusmail(String toEmail) {
		 
		
		  MimeMessage mimeMessage= mailSender.createMimeMessage();
			MimeMessageHelper helper;
			try {
				helper=new MimeMessageHelper(mimeMessage, true);
				helper.setTo(toEmail);
				helper.setFrom(fromMail);
				helper.setSubject("Contact us");
				helper.setText("""
                Dear Customer  ,
                Thanks for reaching out to SADAN HOME LOAN  Support,\s
                your concerns are of top priority for us.
                Our support team will take a look and get back to you at the earliest.\s
                
                Regards,
                SADAN HOME LOAN  Support
                
                
                
                 IMPORTANT: It is vital that you do not share your Password,	Card details, PIN, CVV, or any other sensitive information with anyone,			even our employees advise our customers to completely disregard any such communications.Additionally, the information contained in this email is privileged and confidential. It is the responsibility of an unintended recipient to notify the sender and delete this email and any attachments.\
                """

);



   
	        	
			
			}catch (MessagingException e) {
				
				
				
			}
			mailSender.send(mimeMessage);
	     
	    		   
		        		
		
		
	}







	@Override
	public void senddefaultermail(String toEmail) {

		
		  MimeMessage mimeMessage= mailSender.createMimeMessage();
			System.out.println("22222");
			MimeMessageHelper helper;
			try {
				helper=new MimeMessageHelper(mimeMessage, true);
				helper.setTo(toEmail);
				helper.setFrom(fromMail);
				helper.setSubject("Reject Mail");
				helper.setText("""
                        your cibil is Rejected and You are Not Eligible
                        For Further Process.
                         We are Not Happy to inform you that your Home Loan request has been Rejected and is currently being Not Processed.
                        Further, we inform you that we have sent an email containing attached documents.
                        Also we have sent you the terms and conditions of the loans sanctioned.\s
                        We would like to schedule your meeting with the finance officer of the company for any further information and clarifications that you might wish to know.\s
                        
                        We are happy to be doing business with you.\s
                        
                        List of Documents Required (we will recheck your doc ) :-\s
                        
                        1.Aadhar Card\s
                        2.Pan Card\s
                        3.Income Tax Return of Last Two Years\s
                        4.Salary Slips of Last Three Months\s
                        5.Passport Size Photograph\s
                        6.Bank Passbook Copy\s
                        
                        \s
                         Thanking You.\s
                        Mr.PIYUSH KOLHE\s
                        Loan Officer
                        SADAN Home Loan\s
                         Karvenagar\s
                        Pune, Maharashtra\s
                         India-411052
                        
                        Thank You For Banking With Us\s
                        
                        SADAN Home Loan.....!!!!\
                        """);
  		      		
  		  
	        	
			
			}catch (MessagingException e) {
				
				
				
			}
			mailSender.send(mimeMessage);
	     
	    		   
		        		
		
		
		
	}
	
	


	
}


	
	