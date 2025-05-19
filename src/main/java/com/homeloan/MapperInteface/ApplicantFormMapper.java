package com.homeloan.MapperInteface;

import java.util.List;

import org.mapstruct.Mapper;

import com.homeloan.DTO.ApplicantRegistrationFormDTO;
import com.homeloan.Model.ApplicantRegistrationForm;
@Mapper(componentModel = "spring")
public interface ApplicantFormMapper {

	public ApplicantRegistrationForm DtoToEntity(ApplicantRegistrationFormDTO apf);
	public ApplicantRegistrationFormDTO EntityToDto(ApplicantRegistrationForm ar);
	public List<ApplicantRegistrationFormDTO> EntityToDTOlist(List<ApplicantRegistrationForm> aapForm);
	
}
