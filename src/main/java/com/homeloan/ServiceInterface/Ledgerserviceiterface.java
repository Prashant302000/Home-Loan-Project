package com.homeloan.ServiceInterface;

import java.util.List;

import com.homeloan.Model.Ledger;
import com.homeloan.Model.SanctionLetter;

public interface Ledgerserviceiterface {

	
 public	Ledger saveledgerp(SanctionLetter sl);
 
  List<Ledger>showallledger();
  
   Ledger showone(Integer ledgerId );

public void emipaidStatus(Ledger upce, int eid);

public void emiUnpaidStatus(Ledger upce);

public List<Ledger> defaulterget();
 
}
