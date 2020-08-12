package com.earthquake.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "properties")
public class PropertiesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@JoinColumn(name = "id_feature")
	@OneToOne(fetch = FetchType.LAZY)
	private FeaturesEntity features;

	@Column(name = "mag")
	private String mag;

	@Column(name = "place")
	private String place;

	@Column(name = "time")
	private String time;

	@Column(name = "updated")
	private String updated;

	@Column(name = "tz")
	private String tz;

	@Column(name = "url")
	private String url;

	@Column(name = "detail")
	private String detail;

}
