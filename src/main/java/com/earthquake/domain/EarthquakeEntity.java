package com.earthquake.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.earthquake.entity.Metadata;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "earthquake")
public class EarthquakeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	private String type;
	
	@OneToOne(mappedBy = "earthquake", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private  MetadataEntity metadata;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private  List<FeaturesEntity> features;
	 
	 

}
