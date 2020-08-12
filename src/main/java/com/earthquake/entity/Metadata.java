package com.earthquake.entity;

import java.io.Serializable;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Metadata implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8208680129678590690L;
	


   
	private Double generated;
	private String url;
	private String title;
	private int status;
	private String api;
	private int count;
	
	

}
