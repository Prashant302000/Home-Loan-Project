package com.homeloan.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Email {
	private String fromEmail;
	private String toEmail;
	private String subject;
	private String text;

}
