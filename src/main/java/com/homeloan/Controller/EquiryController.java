package com.homeloan.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homeloan.DTO.EnquiryDTO;
import com.homeloan.MapperInteface.EnquiryMapper;
import com.homeloan.Model.Cibilcheck;
import com.homeloan.Model.Enquiry;
import com.homeloan.Model.UnameAndPass;
import com.homeloan.Model.checkEnquiry;
import com.homeloan.ServiceInterface.EnquiryServiceInter;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/Enquiry")
public class EquiryController {

	@Autowired
	private EnquiryServiceInter si;

	@Autowired
	private EnquiryMapper mapper;

	
	
	@PostMapping(value = "/saveEnquiry")
	public ResponseEntity<Integer> saveEnquiry(@RequestBody EnquiryDTO edto) {
		
		System.out.println(edto.getFullName());
		int id = si.saveenquiry(edto);

		return new ResponseEntity<Integer>(id, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/getenquiry")
	public ResponseEntity<List<Enquiry>> getAllEnquiry()
	{
	List<Enquiry> enquiryList=si.getAllEnquiry();
	
	return new ResponseEntity<List<Enquiry>>(enquiryList,HttpStatus.OK);
	}
	@DeleteMapping(value = "/deleteEnquiry/{eid}")
	public ResponseEntity<String> deleteEnquiry(@PathVariable int eid)
	{
		Enquiry e=si.getEnquiry(eid);
		
		si.savecheckenquiry(e);
		
		si.deleteEnquiry(eid);
		
		return new ResponseEntity<String>("success",HttpStatus.CREATED);
	}

	@GetMapping(value="/login")
	public ResponseEntity<List<UnameAndPass>> getAll()
	{
	List<UnameAndPass> enquiryList=si.getAll();
	
	return new ResponseEntity<List<UnameAndPass>>(enquiryList,HttpStatus.OK);
	}
	
	@GetMapping(value = "/getApproveenquiry")
	public ResponseEntity<List<checkEnquiry>> getApproveEnquiry()
	{
	List<checkEnquiry> enquiryList=si.getapproveEnquiry();
	
	return new ResponseEntity<List<checkEnquiry>>(enquiryList,HttpStatus.OK);
	}
	
	@GetMapping(value = "/getsingleCheckenquiry/{eid}")
	public ResponseEntity<checkEnquiry>getsingleCheckenquiry(@PathVariable int eid)
	{
	checkEnquiry enquiryList=si.getsingleCheckenquiry(eid);
	
	
	return new ResponseEntity<checkEnquiry>(enquiryList,HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/saveCibil/{cibil}/{eid}")
	public ResponseEntity<Integer> saveCibil(@PathVariable int cibil,@PathVariable int eid) {
		
		Cibilcheck cb = new Cibilcheck();

	
		cb.setCibilscore(cibil);

		

		if (cibil <= 600) {
			cb.setCibilstatus("NOT SATISFACTORY");
		} else if (cibil >= 600 && cibil <= 750) {

			cb.setCibilstatus("OK");
		}

		else if (cibil >= 750) {
			cb.setCibilstatus("SATISFACTORY");
		}

		checkEnquiry check=si.getcheckenquiry(eid);
		check.setCc(cb);
		si.newsave(check);
		
		
		return new ResponseEntity<Integer>(11, HttpStatus.OK);
	}
	
	
	
	@PutMapping(value = "updateenquiry/{eid}")

	public ResponseEntity<Integer> UpdateCheckEnquiry(@RequestBody checkEnquiry upce,@PathVariable int eid) {
		
		si.savecheckenquiry(upce);

		return new ResponseEntity<Integer>(eid, HttpStatus.OK);
	}
	
	
}
