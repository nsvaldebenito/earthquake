package com.earthquake.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DateRQ implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3289100416613531044L;
	private String starttime;
	private String endtime;

}
