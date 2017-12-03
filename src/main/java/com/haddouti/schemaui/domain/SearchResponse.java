package com.haddouti.schemaui.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "SearchResponse", namespace = "http://com.haddouti.schemaui:search")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {})
public class SearchResponse {

	private List<Vehicle> vehicles = new ArrayList<Vehicle>();

	@Override
	public String toString() {
		return "SearchResponse [vehicles=" + vehicles + "]";
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

}
