package com.haddouti.schemaui.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonInclude;

@XmlRootElement(name = "StockVehicleRequest", namespace = "http://com.haddouti.schemaui:stock")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {})
public class StockVehicleRequest {

	private String userId;
	@JsonInclude
	private List<Vehicle> vehicles = new ArrayList<Vehicle>();

	@Override
	public String toString() {
		return "StockVehicleRequest [userId=" + userId + ", vehicles=" + vehicles + "]";
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

}
