package com.homeloan.RepositoryInterface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.homeloan.Model.ApplicantRegistrationForm;
import com.homeloan.Model.SanctionLetter;

@Repository
public interface SanctionLetterRepoInterface extends JpaRepository<SanctionLetter, Integer> {

	
	public ApplicantRegistrationForm findApplicantRegistrationFormBySanctionId(Integer sanctionId);
}
