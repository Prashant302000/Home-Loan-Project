package com.homeloan.ServiceInterface;

import java.util.List;

import com.homeloan.DTO.EnquiryDTO;
import com.homeloan.Model.Enquiry;
import com.homeloan.Model.UnameAndPass;
import com.homeloan.Model.checkEnquiry;

public interface EnquiryServiceInter{

public 	int saveenquiry(EnquiryDTO edto);

public List<Enquiry> getAllEnquiry();

public void deleteEnquiry(int eid);

public List<UnameAndPass> getAll();

public Enquiry getEnquiry(int eid);

public void savecheckenquiry(Enquiry e);

public List<checkEnquiry> getapproveEnquiry();

public checkEnquiry getcheckenquiry(int eid);

public void newsave(checkEnquiry check);

public void savecheckenquiry(checkEnquiry upce);

public checkEnquiry getsingleCheckenquiry(int eid);

}
