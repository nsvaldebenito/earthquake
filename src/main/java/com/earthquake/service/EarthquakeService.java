package com.earthquake.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.earthquake.config.ApplicationProperties;
import com.earthquake.dal.DalEarthquakeService;
import com.earthquake.domain.CoordinatesEntity;
import com.earthquake.domain.EarthquakeEntity;
import com.earthquake.domain.FeaturesEntity;
import com.earthquake.domain.GeometryEntity;
import com.earthquake.domain.MetadataEntity;
import com.earthquake.domain.PropertiesEntity;
import com.earthquake.entity.DateRQ;
import com.earthquake.entity.Earthquake;
import com.earthquake.entity.EarthquakeRequest;
import com.earthquake.entity.Features;
import com.earthquake.entity.Geometry;
import com.earthquake.entity.MagnitudRQ;
import com.earthquake.exceptions.BusinessException;
import com.earthquake.repository.EarthquakeRepository;
import com.earthquake.util.EarthquakeConstants;
import com.earthquake.util.EarthquakeUtil;

import springfox.documentation.swagger2.mappers.ModelMapper;



@Service
public class EarthquakeService {

	private static final Logger logger = LoggerFactory.getLogger(EarthquakeService.class);
	
	@Autowired
	private DalEarthquakeService dalEarthquakeService;
	
	@Autowired
	private EarthquakeRepository earthquakeRepository;
	 
	 

	public Earthquake getEarthquakeDate(DateRQ dateRQ) throws BusinessException {
		Earthquake earthquake = new Earthquake();
		
		EarthquakeRequest earthquakeRequest = new EarthquakeRequest();
		
		String query= "?format=geojson&starttime="+dateRQ.getStarttime()+"&endtime="+dateRQ.getEndtime();
				
		earthquakeRequest.setEarthquakeQuery(query);
		try {
			earthquake = dalEarthquakeService.getEarthQuake(earthquakeRequest);
			return earthquake;
		} catch (Exception be) {
			logger.error(EarthquakeConstants.ERROR_MESSAGE_SERVICE_RESPONSE, be);
		}
		return earthquake;
	}
	
	public Earthquake getEarthquakeMagnitud(MagnitudRQ magnitudRQ) throws BusinessException {
		Earthquake earthquake = new Earthquake();
		
		EarthquakeRequest earthquakeRequest = new EarthquakeRequest();
		
		String query= "?format=geojson&minmagnitude="+magnitudRQ.getMinMagnitude()+"&maxmagnitude="+magnitudRQ.getMaxMagnitude();
				
		earthquakeRequest.setEarthquakeQuery(query);
		try {
			earthquake = dalEarthquakeService.getEarthQuake(earthquakeRequest);
			return earthquake;
		} catch (Exception be) {
			logger.error(EarthquakeConstants.ERROR_MESSAGE_SERVICE_RESPONSE, be);
		}
		return earthquake;
	}
	
	public void saveEarthquakeDate() throws BusinessException {
		Earthquake earthquake = new Earthquake();
		EarthquakeRequest earthquakeRequest = new EarthquakeRequest();
	         
	     String today =  LocalDate.now().toString();
	     String tomorrow = LocalDate.now().plusDays(1).toString();
			
		String query= "?format=geojson&starttime="+today+"&endtime="+tomorrow;
				
		earthquakeRequest.setEarthquakeQuery(query);
		try {
			earthquake = dalEarthquakeService.getEarthQuake(earthquakeRequest);
			
			EarthquakeEntity earthquakeEntity = new EarthquakeEntity();
			
			MetadataEntity metadataEntity = new MetadataEntity();
			
			PropertiesEntity propertiesEntity = new PropertiesEntity();
			
			FeaturesEntity featuresEntity = new FeaturesEntity();
			
			GeometryEntity geometryEntity = new GeometryEntity();
			
			CoordinatesEntity coordinatesEntity = new CoordinatesEntity();
			
			List<FeaturesEntity> featuresEntityList = new ArrayList<FeaturesEntity>();
			
			metadataEntity.setApi(earthquake.getMetadata().getApi());
			metadataEntity.setCount(earthquake.getMetadata().getCount());
			metadataEntity.setGenerated(earthquake.getMetadata().getGenerated());
			metadataEntity.setStatus(earthquake.getMetadata().getStatus());
			metadataEntity.setTitle(earthquake.getMetadata().getTitle());
			metadataEntity.setUrl(earthquake.getMetadata().getUrl());
			
			earthquakeEntity.setMetadata(metadataEntity);
			earthquakeEntity.setType(earthquake.getType());
			
			metadataEntity.setEarthquake(earthquakeEntity);
			
			for (Features  feature: earthquake.getFeatures()) {
				featuresEntity = new FeaturesEntity() ;		
				featuresEntity.setType(feature.getType());
				featuresEntity.setEarthquake(earthquakeEntity);
				featuresEntity.setId(feature.getId());
				propertiesEntity = new PropertiesEntity() ;
				propertiesEntity.setDetail(feature.getProperties().getDetail());
				propertiesEntity.setFeatures(featuresEntity);
				propertiesEntity.setMag(feature.getProperties().getMag());
				propertiesEntity.setPlace(feature.getProperties().getPlace());
				propertiesEntity.setTime(feature.getProperties().getTime());
				propertiesEntity.setTz(feature.getProperties().getTz());
				propertiesEntity.setUpdated(feature.getProperties().getUpdated());
				propertiesEntity.setUrl(feature.getProperties().getUrl());
				featuresEntity.setProperties(propertiesEntity);
				
				geometryEntity = new GeometryEntity() ;
				geometryEntity.setType(feature.getGeometry().getType());
				geometryEntity.setFeatures(featuresEntity);
				
				featuresEntityList.add(featuresEntity);
				
				featuresEntity.setGeometry(geometryEntity);
			}		
				
			earthquakeEntity.setFeatures(featuresEntityList);
			earthquakeRepository.save(earthquakeEntity);
		      
			
		} catch (Exception be) {
			logger.error(EarthquakeConstants.ERROR_MESSAGE_SERVICE_RESPONSE, be);
		}
		
	}

	
	
}