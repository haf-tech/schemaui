package com.haddouti.schemaui.domain;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {}, namespace = "http://com.haddouti.schemaui:vehicle")
public class VehicleConfiguration {

	private Date firstRegistrationDate;
	private Double mileage;
	private Integer year;
	private List<CodeText> equipments;

	@Override
	public String toString() {
		return "VehicleConfiguration [firstRegistrationDate=" + firstRegistrationDate + ", mileage=" + mileage
				+ ", year=" + year + ", equipments=" + equipments + "]";
	}

	public Date getFirstRegistrationDate() {
		return firstRegistrationDate;
	}

	public void setFirstRegistrationDate(Date firstRegistrationDate) {
		this.firstRegistrationDate = firstRegistrationDate;
	}

	public Double getMileage() {
		return mileage;
	}

	public void setMileage(Double mileage) {
		this.mileage = mileage;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public List<CodeText> getEquipments() {
		return equipments;
	}

	public void setEquipments(List<CodeText> equipments) {
		this.equipments = equipments;
	}

}
