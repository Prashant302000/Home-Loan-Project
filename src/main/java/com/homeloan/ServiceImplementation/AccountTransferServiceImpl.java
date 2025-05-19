package com.homeloan.ServiceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homeloan.Model.AmountTransfer;
import com.homeloan.Model.ApplicantRegistrationForm;
import com.homeloan.Model.SanctionLetter;
import com.homeloan.RepositoryInterface.AccountTransferRepo;
import com.homeloan.RepositoryInterface.ApplicantFormRepoInterface;
import com.homeloan.RepositoryInterface.SanctionLetterRepoInterface;
import com.homeloan.ServiceInterface.AccountTransferService;

@Service
public class AccountTransferServiceImpl implements AccountTransferService {

	@Autowired
	AccountTransferRepo atr;
	
	@Autowired
	SanctionLetterRepoInterface slr;
	
	@Autowired
	ApplicantFormRepoInterface afr;

	@Override
	public void transfer(SanctionLetter sl) {
		
		ApplicantRegistrationForm form=afr.findAllByAppid(sl.getSanctionId());
		
		
		AmountTransfer at=new AmountTransfer();
		at.setAid(form.getAppid());
		at.setAccountBankName(form.getAppBankDetail()).getAccountBankName());
		at.setAccountBranch(form.getAppBankDetail().getAccountBarnch());
		at.setAccountHolderName(form.getAppBankDetail().getAccountHolderName());
		at.setAccountIFSCCode(form.getAppBankDetail().getAccountIFSCCode());
		at.setAccountNumber(form.getAppBankDetail().getAccountNumber());
		at.setAccountType(form.getAppBankDetail().getAccountType());
		at.setSanctionLoanAmount(sl.getSanctionLoanAmount());
		
		atr.save(at); 
	}

	@Override
	public List<AmountTransfer> getAll() {
		
		return atr.findAll();
	}

	@Override
	public AmountTransfer getSingleAll(int id) {
		
		return atr.findAllByAid(id);
	}

	@Override
	public void updatesanctionStatus(AmountTransfer upce) {
		atr.save(upce);
		
	}
} 
