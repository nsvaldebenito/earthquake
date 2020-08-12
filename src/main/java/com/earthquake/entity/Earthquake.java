package com.earthquake.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Earthquake implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3269596761871531854L;
	private String type;
	private Metadata metadata;
	private List<Features> features;


}
