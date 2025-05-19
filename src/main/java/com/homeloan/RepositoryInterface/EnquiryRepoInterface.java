package com.homeloan.RepositoryInterface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.homeloan.Model.Enquiry;

@Repository
public interface EnquiryRepoInterface extends JpaRepository<Enquiry, Integer>{

	public  Enquiry findAllByEid(int eid);
}
