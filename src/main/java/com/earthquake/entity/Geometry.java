package com.earthquake.entity;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Geometry implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2453191973939042801L;
	private String type;
	private List<Double> coordinates;

}
