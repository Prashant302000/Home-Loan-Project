
package com.homeloan.Controller;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.homeloan.DTO.SanctionLetterDTO;
import com.homeloan.MapperInteface.SanctionLetterMapper;
import com.homeloan.Model.ApplicantRegistrationForm;
import com.homeloan.Model.SanctionLetter;
import com.homeloan.ServiceInterface.SanctionLetterServiceInter;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/SanctionLetter")
public class SanctionLetterController {

	@Autowired
	private SanctionLetterServiceInter si;

	@Autowired
	SanctionLetterMapper mapper;

	@PostMapping(value = "/saveSanctionLetter/{id}")
	public ResponseEntity<SanctionLetterDTO> SanctionLetterpost(@RequestBody SanctionLetterDTO sc,@PathVariable int id) {
		//ObjectMapper om = new ObjectMapper();

		// SanctionLetter sc = om.readValue(scantionLetterDetails,
		// SanctionLetter.class);
System.out.println("hiii");
		// sc.setSanctionLetterPdf(sanctionLetterPdf.getBytes());

		SanctionLetter scl = mapper.DtoToEntity(sc);

		
		
		
		SanctionLetter sacletter = si.saveSanctionLetter(scl,id);

		ByteArrayInputStream pdf = si.createSanctionpdf(sacletter.getSanctionId());

		SanctionLetterDTO sacLetterDto = mapper.EntityToDto(sacletter);

		return new ResponseEntity<SanctionLetterDTO>(sacLetterDto, HttpStatus.OK);

	}

	@GetMapping(value = "/getSanctionLetterById/{sanctionId}")
	public ResponseEntity<SanctionLetterDTO> getsacLetter(@PathVariable int sanctionId) {
		Optional<SanctionLetter> scaLetter = si.getsacLetter(sanctionId);

		SanctionLetter sl = scaLetter.get();
		SanctionLetterDTO sacLetterDTO = mapper.EntityToDto(sl);

		return new ResponseEntity<SanctionLetterDTO>(sacLetterDTO, HttpStatus.OK);

	}

	@DeleteMapping(value = "/deleteSanctionLetter/{sanctionId}")
	public ResponseEntity<String> deletescL(@PathVariable int sanctionId) {
		si.deleteSacLetter(sanctionId);

		return new ResponseEntity<String>("success", HttpStatus.OK);
	}

	// http://localhost:8080/SanctionLetter/GenerateSanctionLetterPdf/1
	@GetMapping(value = "/GenerateSanctionLetterPdf/{sanctionId}")
	public ResponseEntity<InputStreamResource> SanctionLetterPdf(@PathVariable int sanctionId) {

		ByteArrayInputStream pdf = si.createSanctionpdf(sanctionId);

		HttpHeaders headers = new HttpHeaders();

		headers.set("Content-Disposition", "");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(pdf));

	}

	@GetMapping(value = "/SendEmailWithPdf/{sanctionId}")
	public ResponseEntity<String> sendSanctionMail(@PathVariable int sanctionId) {

		si.sendSanctionMail(sanctionId);

		return new ResponseEntity<String>("mail sent successfully", HttpStatus.OK);

	}

	
	@GetMapping(value = "/getsanction")
	public ResponseEntity<List<SanctionLetter>> getsanction()
	{
		List<SanctionLetter> list=si.getsanction();
		
	
		
		return new ResponseEntity<List<SanctionLetter>>(list, HttpStatus.OK);
	}
	
	@PutMapping(value = "/updatesanctionStatus/{eid}")
	public ResponseEntity<Integer> updateLoanStatus(@RequestBody SanctionLetter upce,@PathVariable int eid) {
		
		si.updatesanctionStatus(upce);

		return new ResponseEntity<Integer>(eid, HttpStatus.OK);
	}
	
}
