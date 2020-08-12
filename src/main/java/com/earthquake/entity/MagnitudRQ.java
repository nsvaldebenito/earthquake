package com.earthquake.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MagnitudRQ implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2775946284735724251L;
	private String minMagnitude;
	private String maxMagnitude;
}
