package com.homeloan.Controller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.homeloan.DTO.ApplicantRegistrationFormDTO;
import com.homeloan.MapperInteface.ApplicantFormMapper;
import com.homeloan.Model.ApplicantDocuments;
import com.homeloan.Model.ApplicantGuarantorDetails;
import com.homeloan.Model.ApplicantRegistrationForm;
import com.homeloan.Model.GuranterDocuments;
import com.homeloan.Model.checkEnquiry;
import com.homeloan.ServiceInterface.ApplicantFormServiceInterface;

@RestController
@CrossOrigin("*")
//@RequestMapping(value = "/ApplicantForm")
public class ApplicantFormController {

	@Autowired
	private ApplicantFormServiceInterface si;

	@Autowired
	private ApplicantFormMapper mapper;

	@PostMapping(value = "/saveApplicationForm")
	public ResponseEntity<ApplicantRegistrationFormDTO> saveApplicant(@RequestParam String allData,
			@RequestPart MultipartFile aadharCard, @RequestParam MultipartFile panCard,
			@RequestParam MultipartFile addressProof, @RequestParam MultipartFile photo,
			@RequestParam MultipartFile thumb, @RequestParam MultipartFile signature,
			@RequestParam MultipartFile blankCheque, @RequestParam MultipartFile bankStatement,
			@RequestParam MultipartFile itr, @RequestParam MultipartFile form16,
			@RequestParam MultipartFile guarantorAadhar, @RequestParam MultipartFile guarantorPAN,
			@RequestParam MultipartFile guarantorPhoto, @RequestParam MultipartFile guarantorSignature

	) throws IOException {

		ObjectMapper om = new ObjectMapper();

		ApplicantRegistrationForm applicantRegistrationForm = om.readValue(allData,
				ApplicantRegistrationForm.class);

		GuranterDocuments gurenterdoc = new GuranterDocuments();

		gurenterdoc.setGuarantorAadhar(guarantorAadhar.getBytes());
		gurenterdoc.setGuarantorAadhar(guarantorPAN.getBytes());
		gurenterdoc.setGuarantorAadhar(guarantorPhoto.getBytes());
		gurenterdoc.setGuarantorAadhar(guarantorSignature.getBytes());

		ApplicantDocuments appDoc = new ApplicantDocuments();
		appDoc.setAadharCard(aadharCard.getBytes());
		appDoc.setAadharCard(panCard.getBytes());
		appDoc.setAddressProof(addressProof.getBytes());
		appDoc.setPhoto(photo.getBytes());
		appDoc.setThumb(thumb.getBytes());
		appDoc.setSignature(signature.getBytes());
		appDoc.setBlankCheque(blankCheque.getBytes());
		appDoc.setBankStatement(bankStatement.getBytes());
		appDoc.setItr(itr.getBytes());
		appDoc.setForm16(form16.getBytes());
		appDoc.setGuranterDoc(gurenterdoc);

		applicantRegistrationForm.setAapDoc(appDoc);

		ApplicantRegistrationForm appForm = si.saveapplicantForm(applicantRegistrationForm);
		ApplicantRegistrationFormDTO appDTO = mapper.EntityToDto(appForm);

		return new ResponseEntity<ApplicantRegistrationFormDTO>(appDTO, HttpStatus.OK);

	}

	@GetMapping(value = "/GetAllApplicantData")
	public ResponseEntity<List<ApplicantRegistrationFormDTO>> getAllApplicantdata() {

		List<ApplicantRegistrationForm> appRegForm = si.getAllApplicantdata();

		List<ApplicantRegistrationFormDTO> AppFormDTO = mapper.EntityToDTOlist(appRegForm);

		return new ResponseEntity<List<ApplicantRegistrationFormDTO>>(AppFormDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/getAppFormbyid/{id}")
	public ResponseEntity<ApplicantRegistrationForm> getAppFormByPAN(@PathVariable int id) {
	
		ApplicantRegistrationForm appForm = si.getAllFormByPAN(id);
		System.out.println(appForm.getApplicantFirstName());
		System.out.println(appForm.getCaostatus());
		
		return new ResponseEntity<ApplicantRegistrationForm>(appForm, HttpStatus.OK);
	}
	
	
	
	
	


	@PutMapping(value = "/updateLoanStatus/{eid}")
	public ResponseEntity<Integer> updateLoanStatus(@RequestBody ApplicantRegistrationForm upce,@PathVariable int eid) {
		
		si.updateLoanStatus(upce);

		return new ResponseEntity<Integer>(eid, HttpStatus.OK);
	}
	
	@PutMapping(value = "/updateLoanStatus")
	public ResponseEntity<Integer> updateLoanStatus(@RequestBody ApplicantRegistrationForm upce) {
		
		
		ApplicantRegistrationForm appForm = si.getAllFormByPAN(upce.getAppid());
	
		

		ApplicantDocuments ad=new ApplicantDocuments();
		ad.setDocumentId(appForm.getAapDoc().getDocumentId());
		ad.setAadharCard(appForm.getAapDoc().getAadharCard());
		ad.setAddressProof(appForm.getAapDoc().getAddressProof());
		ad.setBankStatement(appForm.getAapDoc().getBankStatement());
		ad.setForm16(appForm.getAapDoc().getForm16());
		ad.setBlankCheque(appForm.getAapDoc().getBankStatement());
		ad.setItr(appForm.getAapDoc().getItr());
		ad.setThumb(appForm.getAapDoc().getThumb());
		ad.setSignature(appForm.getAapDoc().getSignature());
		ad.setPhoto(appForm.getAapDoc().getPhoto());
		ad.setPanCard(appForm.getAapDoc().getPanCard());
		
		
		GuranterDocuments gd=new GuranterDocuments();
		gd.setGuranterDocID(appForm.getAapDoc().getGuranterDoc().getGuranterDocID());
		gd.setGuarantorAadhar(appForm.getAapDoc().getGuranterDoc().getGuarantorAadhar());
		gd.setGuarantorPAN(appForm.getAapDoc().getGuranterDoc().getGuarantorPAN());
		gd.setGuarantorSignature(appForm.getAapDoc().getGuranterDoc().getGuarantorSignature());
		gd.setGuarantorPhoto(appForm.getAapDoc().getGuranterDoc().getGuarantorPhoto());
		
		ad.setGuranterDoc(gd);
		upce.setAapDoc(ad);
			
		si.updateLoanStatus(upce);
		
		return new ResponseEntity<Integer>(11, HttpStatus.OK);
	}
	
		
	
}
