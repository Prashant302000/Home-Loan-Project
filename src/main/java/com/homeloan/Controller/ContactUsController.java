package com.homeloan.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.homeloan.Model.ContactUs;
import com.homeloan.ServiceInterface.Contactusserviceiterface;
import com.homeloan.ServiceInterface.EmailServiceInterface;

@CrossOrigin("*")
	@RestController
	public class ContactUsController {
		
		@Autowired
		Contactusserviceiterface seo;
		
		@Autowired
		EmailServiceInterface esi;
		

		@PostMapping(value = "/savecontact")
		public ResponseEntity<ContactUs>savecontact(@RequestBody ContactUs us){
			
			
		     ContactUs conus=seo.savecontact(us);
		     
		     esi.Contactusmail(us.getEmail());
		     
			
			return new ResponseEntity<ContactUs>(conus,HttpStatus.CREATED);
			
		}
		
		
//		@GetMapping(value = "/getallinqury")
//		public HttpEntity<List<Contactus>> getallenquryies(){
//			
//			
//			  List<Contactus> findqury =seo.getallenqury();
//			  
//			  return new ResponseEntity<List<Contactus>>(findqury, HttpStatus.OK);
//		}
//		
	

}
