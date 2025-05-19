package com.homeloan.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.homeloan.Model.AmountTransfer;
import com.homeloan.Model.Ledger;
import com.homeloan.Model.SanctionLetter;
import com.homeloan.ServiceInterface.Ledgerserviceiterface;

@RestController
@CrossOrigin("*")
public class LedgerController {

	@Autowired
	Ledgerserviceiterface leg;
	
	@PostMapping(value = "/generateledger")
	public ResponseEntity<Ledger> saveLedger(@RequestBody SanctionLetter sl) throws IOException{
		
		 Ledger li   = leg.saveledgerp(sl);
		 
	return new ResponseEntity<Ledger>(li, HttpStatus.CREATED);
		
	}
	
	
	
	@GetMapping(value = "/getdataall")
	public ResponseEntity<List<Ledger>> showledger(){
		List<Ledger> showallledger = leg.showallledger();
		
		return new ResponseEntity<List<Ledger>>(showallledger,HttpStatus.OK);
	}	
	
	
	
	@GetMapping(value = "/getsingleall/{ledgerId}")
	public ResponseEntity<Ledger>showone(@PathVariable Integer ledgerId){
		
		   Ledger showone = leg.showone(ledgerId);
		
	    return new ResponseEntity<Ledger>(showone, HttpStatus.OK);
	}
	
	
	
	
	@PutMapping(value = "/emipaid/{eid}")
	public ResponseEntity<Integer> emipaidStatus(@RequestBody Ledger upce,@PathVariable int eid) {
		
		leg.emipaidStatus(upce,eid);

		return new ResponseEntity<Integer>(eid, HttpStatus.OK);
	}
	

	@PutMapping(value = "/emiUnpaid")
	public ResponseEntity<Integer> emiUnpaidStatus(@RequestBody Ledger upce) {
		
		leg.emiUnpaidStatus(upce);

		return new ResponseEntity<Integer>(11, HttpStatus.OK);
	}

	@GetMapping(value = "/getdefaultall")
	public ResponseEntity<List<Ledger>> getdefaulter(){
		
		List<Ledger> de = leg.defaulterget();
		de.forEach(a->{
			System.out.println(a.getLedgerFirstName());
		});
		
	    return new ResponseEntity<List<Ledger>>(de, HttpStatus.OK);
	}
	
	
	
	
	
}

