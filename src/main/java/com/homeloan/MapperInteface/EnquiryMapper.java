package com.homeloan.MapperInteface;




import org.mapstruct.Mapper;

import com.homeloan.DTO.EnquiryDTO;
import com.homeloan.Model.Enquiry;



@Mapper(componentModel = "spring")
public interface EnquiryMapper{
	
	public Enquiry DtoToEntity (EnquiryDTO sdto);
	public EnquiryDTO EntityToDto(Enquiry e);
	
	
	
}

