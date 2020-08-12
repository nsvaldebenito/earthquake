package com.earthquake.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.earthquake.domain.EarthquakeEntity;

public interface EarthquakeRepository extends JpaRepository<EarthquakeEntity, Long> {

}
