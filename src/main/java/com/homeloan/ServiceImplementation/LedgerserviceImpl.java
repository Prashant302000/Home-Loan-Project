package com.homeloan.ServiceImplementation;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homeloan.Model.AmountTransfer;
import com.homeloan.Model.Ledger;
import com.homeloan.Model.SanctionLetter;
import com.homeloan.RepositoryInterface.LedgerRepository;
import com.homeloan.ServiceInterface.Ledgerserviceiterface;

@Service
public class LedgerserviceImpl implements Ledgerserviceiterface  {

@Autowired
LedgerRepository lr;



	@Override
	public List<Ledger> showallledger() {
    List<Ledger> findAll = lr.findAll();
		return findAll;
	}


	@Override
	public Ledger showone(Integer ledgerId) {
		
	        Optional<Ledger> lId = lr.findById(ledgerId);
	
	        if(lId.isPresent()) {
	        	Ledger lo=lId.get();
	        	return  lo;	
	        }
			
	        return new Ledger();
			
	}


	@Override
	public Ledger saveledgerp(SanctionLetter sl) {
	
		
		Ledger l=new Ledger();
		l.setLedgerId(sl.getSanctionId());
		l.setLedgerFirstName(sl.getSanctionApplicantFirstName());
		l.setLedgerLastName(sl.getSanctionApplicantLastName());
		l.setLoanAmount(sl.getSanctionLoanAmount());
		l.setMonthlyEmi(sl.getSantionMonthlyEMIAmount());
		l.setTenure(sl.getSanctionLoanTenure());
		l.setRateOfIntrest(sl.getSanctionRateOfIntrest());
		l.setAmountPaidTillDate(sl.getSantionMonthlyEMIAmount());
		l.setEmail(sl.getApplicantEmailId());
	
		l.setRemainingEMI(sl.getSanctionLoanTenure()-0);
		l.setDefaulterCount(0);
		l.setTotalPaywithIntrest(sl.getSanctionLoanAmountWithIntrest());
		l.setRemainingAmount( sl.getSanctionLoanAmountWithIntrest()-0);
		
		
		return lr.save(l);
	}


	@Override
	public void emipaidStatus(Ledger le, int eid) {
		Ledger l=new Ledger();
		l.setLedgerId(le.getLedgerId());
		l.setLedgerFirstName(le.getLedgerFirstName());
		l.setLedgerLastName(le.getLedgerLastName());
		l.setLoanAmount(le.getLoanAmount());
		l.setMonthlyEmi(le.getMonthlyEmi());
		l.setTenure(le.getTenure());
		l.setRateOfIntrest(le.getRateOfIntrest());
		l.setAmountPaidTillDate(le.getAmountPaidTillDate()+le.getMonthlyEmi());
		l.setAmountPaidTillDate(le.getAmountPaidTillDate()+le.getMonthlyEmi());

		l.setEmail(le.getEmail());
	
		l.setRemainingEMI(le.getRemainingEMI()-1);
		l.setDefaulterCount(le.getDefaulterCount());
		l.setTotalPaywithIntrest(le.getTotalPaywithIntrest());
		l.setRemainingAmount( le.getRemainingEMI()*le.getMonthlyEmi()-le.getMonthlyEmi());
		
		lr.save(l);
		
	}


	@Override
	public void emiUnpaidStatus(Ledger le) {
		
		lr.save(le);
		
	}


	@Override
	public List<Ledger> defaulterget() {
		return lr.findAllByDefaulterCountGreaterThan(2);
	}







}
