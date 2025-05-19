package com.homeloan.RepositoryInterface;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


import com.homeloan.Model.checkEnquiry;
@Service
public interface CheckEnquiryRepo extends JpaRepository<checkEnquiry, Integer> {

	public checkEnquiry findAllByEid(int eid);
	

}
