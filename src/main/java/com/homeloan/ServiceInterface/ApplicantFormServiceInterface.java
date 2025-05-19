package com.homeloan.ServiceInterface;

import java.util.List;

import org.springframework.stereotype.Service;

import com.homeloan.Model.ApplicantRegistrationForm;


public interface ApplicantFormServiceInterface {

	public ApplicantRegistrationForm saveapplicantForm(ApplicantRegistrationForm applicantRegistrationForm);

	public List<ApplicantRegistrationForm> getAllApplicantdata();

	public ApplicantRegistrationForm getAllFormByPAN(int id);

	public void updateLoanStatus(ApplicantRegistrationForm upce);

}
