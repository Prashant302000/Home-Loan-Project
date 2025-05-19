package com.homeloan.RepositoryInterface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.homeloan.Model.ContactUs;

@Repository
public interface ContactusRepository extends JpaRepository<ContactUs, Integer>{

}
