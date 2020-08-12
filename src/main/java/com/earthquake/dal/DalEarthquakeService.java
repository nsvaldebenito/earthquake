package com.earthquake.dal;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.earthquake.component.RequestFactory;
import com.earthquake.entity.Earthquake;
import com.earthquake.entity.EarthquakeRequest;
import com.earthquake.exceptions.BusinessException;
import com.earthquake.util.EarthquakeConstants;

@Service
@PropertySource("classpath:application.properties")
public class DalEarthquakeService {
	
	@Value("${dal.earthquake.service.url}")
    private String dalEarthquakeURL;

    @Autowired
    private RequestFactory requestFactory;

    private RestTemplate restTemplate;

    @PostConstruct
    private void init(){
        restTemplate = requestFactory.getRestTemplate();
    }
    
	    public Earthquake getEarthQuake(EarthquakeRequest earthquakeRequest) throws BusinessException {

	       MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
	       headers.add("Content-Type", "application/json");
	  	       
	       HttpEntity<String> httpEntity = new HttpEntity<>(headers);
	        
	        String url = dalEarthquakeURL + EarthquakeConstants.EARTHQUAKE_PATH + earthquakeRequest.getEarthquakeQuery();
	        ResponseEntity<Earthquake> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, new ParameterizedTypeReference<Earthquake>(){});
	    
	        if(response.getStatusCode().equals(HttpStatus.OK)){
	            return response.getBody();
	        }else {
	            throw new BusinessException(response.getStatusCode());
	        }
	    }
}  