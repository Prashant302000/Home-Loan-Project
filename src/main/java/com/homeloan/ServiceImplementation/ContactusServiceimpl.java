package com.homeloan.ServiceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homeloan.Model.ContactUs;
import com.homeloan.RepositoryInterface.ContactusRepository;
import com.homeloan.ServiceInterface.Contactusserviceiterface;
@Service
public class ContactusServiceimpl implements Contactusserviceiterface {

	@Autowired 
	ContactusRepository reo;
	@Override
	public ContactUs savecontact(ContactUs us) {
		// TODO Auto-generated method stub
		return reo.save(us);
	}

}
