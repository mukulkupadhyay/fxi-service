package com.uhc.fxiproviderservice.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Provider {

	@NonNull
	@NotEmpty

	List<String> option_Ip_Coll_List;

	List<String> rec_Xpfh_List;

	List<String> rec_Prac_List;

	List<String> rec_Facility_List;

	List<String> rec_Group_List;

	List<String> rec_Ipa_List;

}
