package com.homeloan.ServiceImplementation;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Optional;

import jakarta.activation.DataSource;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.util.ByteArrayDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.homeloan.Model.ApplicantRegistrationForm;
import com.homeloan.Model.GenerateSanctionPDF;
import com.homeloan.Model.SanctionLetter;
import com.homeloan.RepositoryInterface.ApplicantFormRepoInterface;
import com.homeloan.RepositoryInterface.SanctionLetterRepoInterface;
import com.homeloan.ServiceInterface.SanctionLetterServiceInter;

@Service
public class SanctionLetterServiceImpl implements SanctionLetterServiceInter {

	@Autowired
	private SanctionLetterRepoInterface ri;

	@Autowired
	private ApplicantFormRepoInterface ari;

	@Autowired
	JavaMailSender sender;

	@Value("${spring.mail.username}")
	private String fromEmailId;

	@Override
	public SanctionLetter saveSanctionLetter(SanctionLetter sc,int id) {

		
		ApplicantRegistrationForm ap=ari.findAllByAppid(id);
		
		SanctionLetter sl=new SanctionLetter();
		sl.setSanctionId(ap.getAppid());
		sl.setSanctionApplicantFirstName(ap.getApplicantFirstName());
		sl.setSanctionApplicantLastName(ap.getApplicantLastName());
		sl.setApplicantContactNo(ap.getApplicantMobileNumber());
		sl.setApplicantEmailId(ap.getApplicantEmailId());
		sl.setSanctionLoanAmount(sc.getSanctionLoanAmount());
		sl.setSanctionLoanAmountWithIntrest(sc.getSanctionLoanAmountWithIntrest());
		sl.setSanctionLoanTenure(sc.getSanctionLoanTenure());
		sl.setSantionMonthlyEMIAmount(sc.getSantionMonthlyEMIAmount());
		sl.setSanctionRateOfIntrest(sc.getSanctionRateOfIntrest());
		sl.setProcessingCharges(sc.getProcessingCharges());
		SanctionLetter sac = ri.save(sl);
//		ApplicantRegistrationForm aapForm = ri.findApplicantRegistrationFormBySanctionId(sac.getSanctionId());
//
//		sac.setApplicantContactNo(aapForm.getApplicantmobilenumber());
//		sac.setSanctionApplicantFirstName(aapForm.getApplicantFirstName());
//		sac.setSanctionApplicantLastName(aapForm.getApplicantLastName());
//		sac.setApplicantEmailId(aapForm.getApplicantEmailId());

		//SanctionLetter sac1 = ri.save(sac);

		return sac;
	}

	@Override
	public Optional<SanctionLetter> getsacLetter(int sanctionId) {

		Optional<SanctionLetter> sanLetter = ri.findById(sanctionId);
		return sanLetter;
	}

	@Override
	public void deleteSacLetter(int sanctionId) {

		ri.deleteById(sanctionId);

	}

	@Override
	public ByteArrayInputStream createSanctionpdf(int sanctionId) {

		Optional<SanctionLetter> sacLetter = ri.findById(sanctionId);

		SanctionLetter sl = sacLetter.get();

		// ApplicantRegistrationForm aapF = new ApplicantRegistrationForm();


		ApplicantRegistrationForm aapForm = ari.findAllByAppid(sanctionId);

		String title = "Welcome to SADHAN Bank";

		String content = "\n\n\n" + "To, \n" + "Mr/Mrs. " + aapForm.getApplicantFirstName() + " "
				+ aapForm.getApplicantLastName() + "\n" + "City : " + aapForm.getAppAddress().getCity() + "\n"
				+ "Taluka : " + aapForm.getAppAddress().getTaluka() + "\n" + "District : "
				+ aapForm.getAppAddress().getDistrict() + "\n" + "State : " + aapForm.getAppAddress().getState() + " - "
				+ aapForm.getAppAddress().getPincode() + "\n" + "Country : " + aapForm.getAppAddress().getCountry()
				+ "\n" + "Contact Number : " + aapForm.getApplicantMobileNumber() + "\n" + "Email ID : "
				+ aapForm.getApplicantEmailId() + "\n\n" + "Dear Mr/Ms. " + sl.getSanctionApplicantFirstName() + " "
				+ sl.getSanctionApplicantLastName() + ", \n \n" + "Subject: Sanction of Home Loan of Rs. "
				+ sl.getSanctionLoanAmount() + "\n" + "With reference to your Home loan application dated "
				+ sl.getSanctionDate() + " we are pleased to inform you that an Home loan of Rs."
				+ sl.getSanctionLoanAmount()
				+ " has been sanctioned for purchasing your dream car on the following terms and conditions: \n\n"
				+ "1. Name of Applicant           :   " + sl.getSanctionApplicantFirstName() + " "
				+ sl.getSanctionApplicantLastName() + "\n" + "2. Nature of Loan                :    Home Loan \n"
				+ "3. Amount Sanctioned         :   " + sl.getSanctionLoanAmount() + "\n"
				+ "4. Rate of Interest               :   " + sl.getSanctionRateOfIntrest() + "% per annum \n"
				+ "5. Repayment Period          :   Loan is repayable in " + sl.getSanctionLoanTenure()
				+ " equated monthly \n" + "6. Installment                      :   Rs. "
				+ sl.getSantionMonthlyEMIAmount() + "\n" + "7. Amount With Intrest        :   Rs. "
				+ sl.getSanctionLoanAmountWithIntrest() + "\n" + "8. Guarantor's Name          :   "
				+ aapForm.getAppGurenter().getGuarantorFirstName() + " "
				+ aapForm.getAppGurenter().getGuarantorLastName() + "\n"
				+ "9. Disbursement                 :   Loan will be disbursed on getting Online Banking. All terms and Conditions of loan are met. \n\n\n"
				+ "Thanking you. \n\n" + "Yours truly, \n" + "SADAN Bank Pvt Ltd..";

		ByteArrayOutputStream out = GenerateSanctionPDF.generatePdf(title, content);

		byte[] pdf = out.toByteArray();
		sl.setSanctionLetterPdf(pdf);
		sl.setSanctionLetterStatus("GENERATED");
		ri.save(sl);

		return new ByteArrayInputStream(out.toByteArray());
	}

	@Override
	public void sendSanctionMail(int sanctionId) {

		Optional<SanctionLetter> sacLetter = ri.findById(sanctionId);
		SanctionLetter sc = sacLetter.get();

		byte[] pdfData = sc.getSanctionLetterPdf();

		DataSource sd = new ByteArrayDataSource(pdfData, "application/octet-stream");

		try {

			MimeMessage mm = sender.createMimeMessage();

			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mm, true);

			// SimpleMailMessage mailMessage=new SimpleMailMessage();
			mimeMessageHelper.setFrom(fromEmailId);
			mimeMessageHelper.setTo(sc.getApplicantEmailId());
			mimeMessageHelper.setText("Dear Mr/Mrs. " + sc.getSanctionApplicantFirstName() + " "
					+ sc.getSanctionApplicantLastName() + "\n" + "   "
					+ " We are pleased to inform you that based on your online loan application to our fianance company SADHAN BANK PVT. LTD. "
					+ "\n" + "   " + " Bearing Application Number : " + sc.getSanctionId()
					+ " we are offering you an in-princile e-Sanction based on the information provided by you, under the "
					+ " program. \n" + "         "
					+ " This in principle e-Sanction for your loan is subject to the following terms and conditions. \n"
					+

					"Mobile Number : " + sc.getApplicantContactNo() + "\n" + "Loan Amount     : "
					+ sc.getSanctionLoanAmount() + "\n" + "Loan Tenure       : " + sc.getSanctionLoanTenure() + "\n"
					+ "EMI                      : " + sc.getSantionMonthlyEMIAmount() + "\n" + "Processing Fee   : "
					+ sc.getProcessingCharges() + "\n \n" + "Thanking you. \n" + "Your's truly, \n"
					+ "SADHAN Bank Pvt Ltd.");

			mimeMessageHelper.setSubject("Your Loan Is Sanctioned");

			mimeMessageHelper.addAttachment("sd.pdf", sd);

			sender.send(mm);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public List<SanctionLetter> getsanction() {
		
		return ri.findAll();
	}

	@Override
	public void updatesanctionStatus(SanctionLetter upce) {
		ri.save(upce);
		
	}

}
