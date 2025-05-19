package com.homeloan.RepositoryInterface;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.homeloan.Model.Ledger;
@Repository
public interface LedgerRepository extends JpaRepository<Ledger, Integer> {

	public List<Ledger> findAllByDefaulterCountGreaterThan(int a);
}
