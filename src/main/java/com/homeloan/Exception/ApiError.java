package com.homeloan.Exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiError {
	public ApiError(int value, String message2, Date date2, HttpStatus notFound, String requestURI) {
		// TODO Auto-generated constructor stub
	}
	private int statucode;
	private String message;
	private Date date;
	private HttpStatus statusmsg;
	private String urlpath;

}
