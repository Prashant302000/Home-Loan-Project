 package com.homeloan.Model;

import java.io.ByteArrayOutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class GenerateSanctionPDF {

	public static ByteArrayOutputStream generatePdf(String title, String content) 
	{
		ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
		
		Document document=new Document();
		
		PdfWriter.getInstance(document, outputStream);
		
		document.open();
		
		Font font=FontFactory.getFont(FontFactory.HELVETICA_BOLD,30);
		
		Paragraph paragraph=new Paragraph(title, font);
		
		paragraph.setAlignment("Center");
		
		document.add(paragraph);
		
		Paragraph paragraph2=new Paragraph();
		
		paragraph2.add(content);
		
		document.add(paragraph2);
		
		document.close();
		
		return outputStream;
	}

}
