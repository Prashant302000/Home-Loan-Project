package com.homeloan.RepositoryInterface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.homeloan.Model.ApplicantRegistrationForm;

@Repository
public interface ApplicantFormRepoInterface extends JpaRepository<ApplicantRegistrationForm, Integer>{

	public ApplicantRegistrationForm findAllByAppid(int id);
}
