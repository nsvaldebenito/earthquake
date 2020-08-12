package com.earthquake.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Features implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8512672450812876854L;
	private String type;
	private Properties properties;
	private Geometry geometry;
	private String id;
}
