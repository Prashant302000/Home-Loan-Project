package com.homeloan.ServiceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homeloan.Model.ApplicantRegistrationForm;
import com.homeloan.RepositoryInterface.ApplicantFormRepoInterface;
import com.homeloan.ServiceInterface.ApplicantFormServiceInterface;

@Service
public class ApplicantFormServiceImplementation implements ApplicantFormServiceInterface {
	@Autowired
	private ApplicantFormRepoInterface ri;

	@Override
	public ApplicantRegistrationForm saveapplicantForm(ApplicantRegistrationForm applicantRegistrationForm) {

		ApplicantRegistrationForm aapForm = ri.save(applicantRegistrationForm);

		return aapForm;
	}

	@Override
	public List<ApplicantRegistrationForm> getAllApplicantdata() {

		List<ApplicantRegistrationForm> appForm = ri.findAll();
		return appForm;
	}

	@Override
	public ApplicantRegistrationForm getAllFormByPAN(int id) {

		ApplicantRegistrationForm appForms = ri.findAllByAppid(id);
		return appForms;
	}

	@Override
	public void updateLoanStatus(ApplicantRegistrationForm upce) {
		ri.save(upce);
		
	}

}
