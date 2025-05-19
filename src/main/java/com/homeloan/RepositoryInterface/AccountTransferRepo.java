package com.homeloan.RepositoryInterface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.homeloan.Model.AmountTransfer;
@Repository
public interface AccountTransferRepo extends JpaRepository<AmountTransfer, Integer> {
 
	public AmountTransfer findAllByAid(int id);
}
