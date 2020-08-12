package com.earthquake.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "features")
public class FeaturesEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_feature")
	private int id_feature;
			
    @JoinColumn(name = "id_earthquake")
    @ManyToOne(fetch = FetchType.LAZY)
    private EarthquakeEntity earthquake;
    
    @OneToOne(mappedBy = "features", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
   	private  PropertiesEntity properties;
    
    @OneToOne(mappedBy = "features", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
   	private  GeometryEntity geometry;
    
    @Column(name = "type")
    private String type;
    
    @Column(name = "id")
    private String id;
    
   
	
    
   
	

}
