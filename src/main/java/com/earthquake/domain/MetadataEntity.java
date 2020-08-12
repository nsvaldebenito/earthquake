package com.earthquake.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.earthquake.entity.Earthquake;
import com.earthquake.entity.Metadata;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "metadata")
public class MetadataEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
    @JoinColumn(name = "id_earthquake")
    @OneToOne(fetch = FetchType.LAZY)
    private EarthquakeEntity earthquake;
    
    @Column(name = "generated")
    private Double generated;
    
    @Column(name = "url")
	private String url;
    
    @Column(name = "title")
	private String title;
    
    @Column(name = "status")
	private int status;
    
    @Column(name = "api")
	private String api;
    
    @Column(name = "count")
	private int count;

}
