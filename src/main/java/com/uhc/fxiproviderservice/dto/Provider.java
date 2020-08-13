package com.uhc.fxiproviderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Provider {

	public Config Config;
	public OPTIONIPCOLL OPTION_IP_COLL;
	public RECXPFH REC_XPFH;
	public RECGRP REC_GRP;

	static  class Config {
		public String FacetsIdentity;
		public String Region;
	}

	static class OPTIONIPCOLL {
		public String OPTION_NAME;
		public String OPTION_VALUE;
	}

	static class RECXPFH {
		public String XPFH_UPDATE_CD;
		public String XPFH_ENTITY_TYPE;
		public String MCTN_ID;
		public String PRPR_ID;
	}

	static class RECPRPR {
		public String PRPR_UPDATE_CD;
		public String PRPR_ENTITY;
		public String PRPR_CL_EFT_IND;
		public String PRPR_EDI_DEST_ID;
		public String PRPR_RA_DEST_IND;
	}

	static class RECMCBR {
		public String MCBD_ID;
		public String MCBR_ACCT_NO;
		public String MCBR_ACCT_NAME;
		public String MCBR_ACCT_NO_QUA;
	}

	static class RECGRP {
		public RECPRPR REC_PRPR;
		public RECMCBR REC_MCBR;
	}
}