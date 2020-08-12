package com.earthquake.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Properties implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7471219535721910021L;
	private String mag;
	private String place;
	private String time;
	private String updated;
	private String tz;
	private String url;
	private String detail;
		private String felt;
		private String cdi;
		private String mmi;
		private String alert;
		private String status;
		private String tsunami;
		private String sig;
		private String net;
		private String code;
		private String ids;
		private String sources;
		private String types;
		private String nst;
		private String dmin;
		private String rms;
		private String gap;
		private String magType;
		private String type;
		private String title;
	
}
