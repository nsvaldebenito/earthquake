package com.earthquake.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.earthquake.entity.DateRQ;
import com.earthquake.entity.Earthquake;
import com.earthquake.entity.MagnitudRQ;
import com.earthquake.exceptions.BusinessException;
import com.earthquake.service.EarthquakeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("")
@Api(value="Api Earthquake")
public class EarthquakeController {
	@Autowired
	private EarthquakeService earthquakeService;
	
	@GetMapping(path = "/date", produces = "application/json")
	@ApiOperation(value = "Sismos a partir de una fecha")
	public ResponseEntity<Earthquake> earthquakeDate(@RequestBody DateRQ dateRQ) {
		try {
			return new ResponseEntity<>(earthquakeService.getEarthquakeDate(dateRQ), HttpStatus.OK);
		} catch (BusinessException be) {
			return new ResponseEntity<>(new Earthquake(), HttpStatus.BAD_REQUEST);		}
	}
	
	@GetMapping(path = "/magnitud", produces = "application/json")
	@ApiOperation(value = "Sismos a partir de una Magnitud")
	public ResponseEntity<Earthquake> earthquakeMagnitud(@RequestBody MagnitudRQ magnitudRQ) {
		try {
			return new ResponseEntity<>(earthquakeService.getEarthquakeMagnitud(magnitudRQ), HttpStatus.OK);
		} catch (BusinessException be) {
			return new ResponseEntity<>(new Earthquake(), HttpStatus.BAD_REQUEST);		}
	}
	
	@PostMapping(path = "/save", produces = "application/json")
	@ApiOperation(value = "Guarda los sismos del dia")
	public ResponseEntity earthquakeSave() {
		try {
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception be) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);		}
	}
}
