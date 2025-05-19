package com.homeloan.ServiceInterface;

import java.util.List;

import com.homeloan.Model.AmountTransfer;
import com.homeloan.Model.SanctionLetter;

public interface AccountTransferService {

	void transfer(SanctionLetter sl);

	List<AmountTransfer> getAll();

	AmountTransfer getSingleAll(int id);

	void updatesanctionStatus(AmountTransfer upce);

}
