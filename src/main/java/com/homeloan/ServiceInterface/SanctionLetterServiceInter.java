package com.homeloan.ServiceInterface;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.homeloan.Model.SanctionLetter;

public interface SanctionLetterServiceInter {

	public SanctionLetter saveSanctionLetter(SanctionLetter sc, int id);

	public Optional<SanctionLetter> getsacLetter(int sanctionId);

	public void deleteSacLetter(int sanctionId);

	public ByteArrayInputStream createSanctionpdf(int sanctionId);

	public void sendSanctionMail(int sanctionId);

	public List<SanctionLetter> getsanction();

	public void updatesanctionStatus(SanctionLetter upce);

}
