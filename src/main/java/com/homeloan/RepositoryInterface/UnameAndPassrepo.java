package com.homeloan.RepositoryInterface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.homeloan.Model.UnameAndPass;

@Repository
public interface UnameAndPassrepo extends JpaRepository<UnameAndPass, Integer> {

}
