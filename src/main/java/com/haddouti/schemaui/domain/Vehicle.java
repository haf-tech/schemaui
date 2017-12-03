package com.haddouti.schemaui.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {}, namespace = "http://com.haddouti.schemaui:vehicle")
public class Vehicle {
	private Long id;
	private String title;

	private VehicleConfiguration vehicleConfig = new VehicleConfiguration();
	private VehicleMarketing vehicleMarketing;

	public Vehicle() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public VehicleConfiguration getVehicleConfig() {
		return vehicleConfig;
	}

	public void setVehicleConfig(VehicleConfiguration vehicleConfig) {
		this.vehicleConfig = vehicleConfig;
	}

	public VehicleMarketing getVehicleMarketing() {
		return vehicleMarketing;
	}

	public void setVehicleMarketing(VehicleMarketing vehicleMarketing) {
		this.vehicleMarketing = vehicleMarketing;
	}

}