package com.homeloan.ServiceImplementation;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.homeloan.Model.UnameAndPass;
import com.homeloan.Model.checkEnquiry;
import com.homeloan.RepositoryInterface.CheckEnquiryRepo;
import com.homeloan.RepositoryInterface.EnquiryRepoInterface;
import com.homeloan.RepositoryInterface.UnameAndPassrepo;
import com.homeloan.ServiceInterface.EnquiryServiceInter;
import com.homeloan.DTO.EnquiryDTO;
import com.homeloan.MapperInteface.EnquiryMapper;
import com.homeloan.Model.Cibilcheck;
import com.homeloan.Model.Enquiry;


@Service
public class EnquiryServiceImpl implements EnquiryServiceInter {

	@Autowired
	private EnquiryRepoInterface ri;
	
	@Autowired
	private UnameAndPassrepo up;

	@Autowired
	private EnquiryMapper mapper;
	
	@Autowired
	private CheckEnquiryRepo cer;

	@Override
	public int saveenquiry(EnquiryDTO edto) {
		
		mapper.DtoToEntity(edto);
		Enquiry eq = new Enquiry();
		eq.setFullName(edto.getFullName());

		eq.setAddress(edto.getAddress());


		eq.setMobNo(edto.getMobNo());


		eq.setEmail(edto.getEmail());


		eq.setAge(edto.getAge());
		
		eq.setPanNo(edto.getPanNo());
		Enquiry eqq = ri.save(eq);
		EnquiryDTO eqd = mapper.EntityToDto(eqq);

//		if (!((edto.getAge() >= 21) && (edto.getAge() <= 55))) {
//
//			throw new IllegalArgumentException("age should be between 25 to 55 ");
//
//		}
//		if (!edto.getEmail().endsWith("@gmail.com")) {
//		throw new IllegalArgumentException("Email ends with @gmail.com ");
//	}
		
//		if (! (edto.getMobNo().toString().length()==10)) 
//		{
//	throw new IllegalArgumentException("ContactNumber must be 10 digit ");
//
//}
		
//		if (!Character.isUpperCase(edto.getFullName().charAt(0))) {
//			throw new IllegalArgumentException("First alphabet must be capital ");
//		}
		
		return eqd.getEid();
	}

	@Override
	public List<Enquiry> getAllEnquiry() {
		
		List<Enquiry> enquiryList=ri.findAll();
		return enquiryList;
	}

	@Override
	public void deleteEnquiry(int eid) {
		
		ri.deleteById(eid);
		
	}

	@Override
	public List<UnameAndPass> getAll() {
		
		return up.findAll();
	}

	@Override
	public Enquiry getEnquiry(int eid) {
		
		return ri.findAllByEid(eid);
	}

	@Override
	public void savecheckenquiry(Enquiry e) {
		
		System.out.println("save");
		 checkEnquiry ce=new checkEnquiry();
		ce.setFullName(e.getFullName());
		ce.setEmail(e.getEmail());
		ce.setAddress(e.getAddress());
		ce.setMobNo(e.getMobNo());
		ce.setPanNo(e.getPanNo());
		ce.setEid(e.getEid());
		ce.setAge(e.getAge());
		Cibilcheck cc=new Cibilcheck();
		cc.setCibilId(1);
		cc.setCibilscore(000);
		cc.setCibilstatus("NA");
		ce.setCc(cc);
		cer.save(ce);
	}

	@Override
	public List<checkEnquiry> getapproveEnquiry() {
		
		return cer.findAll();
	}

	@Override
	public checkEnquiry getcheckenquiry(int eid) {
		
		return cer.findAllByEid(eid);
		
	}

	@Override
	public void newsave(checkEnquiry check) {
		
	cer.save(check);
		
	}

	@Override
	public void savecheckenquiry(checkEnquiry upce) {
	cer.save(upce);
		
	}

	@Override
	public checkEnquiry getsingleCheckenquiry(int eid) {
		
		return cer.findAllByEid(eid);
	}

	

	
}
