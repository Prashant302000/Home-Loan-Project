package com.homeloan.Controller;

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

import com.homeloan.DTO.SanctionLetterDTO;
import com.homeloan.Model.AmountTransfer;
import com.homeloan.Model.SanctionLetter;
import com.homeloan.ServiceInterface.AccountTransferService;

@RestController
@CrossOrigin("*")
public class AmountTransferController {

	@Autowired
	AccountTransferService ats;
	
	@PostMapping(value = "/TransferAmount")
	public ResponseEntity<Integer> transfer(@RequestBody SanctionLetter sl)
	{
		ats.transfer(sl);
		
		return new ResponseEntity<Integer>(11, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getloanalldata")
	public ResponseEntity<List<AmountTransfer>> getall()
	{
	List<AmountTransfer> list=	ats.getAll();
		
		return new ResponseEntity<List<AmountTransfer>>(list, HttpStatus.OK);
	}
	
	@	GetMapping(value = "/getsingledata/{id}")
	public ResponseEntity<AmountTransfer> getSingleall(@PathVariable int id)
	{
	AmountTransfer list=	ats.getSingleAll(id);
		
		return new ResponseEntity<AmountTransfer>(list, HttpStatus.OK);
	}
	
	@PutMapping(value = "/updateStatus/{eid}")
	public ResponseEntity<Integer> updateStatus(@RequestBody AmountTransfer upce,@PathVariable int eid) {
		
		ats.updatesanctionStatus(upce);

		return new ResponseEntity<Integer>(eid, HttpStatus.OK);
	}
	
	
	
	
	
	
}
