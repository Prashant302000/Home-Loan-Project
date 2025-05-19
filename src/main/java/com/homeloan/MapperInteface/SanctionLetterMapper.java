package com.homeloan.MapperInteface;

import org.mapstruct.Mapper;

import com.homeloan.DTO.SanctionLetterDTO;
import com.homeloan.Model.SanctionLetter;



@Mapper(componentModel = "spring")
public interface SanctionLetterMapper {

	public SanctionLetter DtoToEntity (SanctionLetterDTO sdto);
	public SanctionLetterDTO EntityToDto(SanctionLetter e);
}
