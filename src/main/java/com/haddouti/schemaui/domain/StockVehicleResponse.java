package com.haddouti.schemaui.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "StockVehicleResponse", namespace = "http://com.haddouti.schemaui:stock")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {})
public class StockVehicleResponse {

	private StockVehicleResponse.Status status = new StockVehicleResponse.Status();
	private List<Vehicle> vehicles = new ArrayList<Vehicle>();

	@Override
	public String toString() {
		return "StockVehicleResponse [status=" + status + ", vehicles=" + vehicles + "]";
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(propOrder = {})
	public static class Status {
		private List<CodeText> status = new ArrayList<CodeText>();

		@Override
		public String toString() {
			return "Status [status=" + status + "]";
		}

		public List<CodeText> getStatus() {
			return status;
		}

		public void setStatus(List<CodeText> status) {
			this.status = status;
		}

	}

	public StockVehicleResponse.Status getStatus() {
		return status;
	}

	public void setStatus(StockVehicleResponse.Status status) {
		this.status = status;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

}
