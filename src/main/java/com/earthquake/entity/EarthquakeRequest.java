package com.earthquake.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EarthquakeRequest implements Serializable {

    private static final long serialVersionUID = 1809990138126488561L;

    private String earthquakeQuery;
}
