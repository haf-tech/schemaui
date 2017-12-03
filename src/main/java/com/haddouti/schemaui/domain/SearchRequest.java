package com.haddouti.schemaui.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "SearchRequest", namespace = "http://com.haddouti.schemaui:search")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {})
public class SearchRequest {

	private Long id;
	private FromTo mileage;
	private FromTo year;
	@XmlElementWrapper(name = "equipments")
	@XmlElement(name = "equipment")
	private List<String> equipments;
	private YN specialCampaign;

	@Override
	public String toString() {
		return "SearchRequest [id=" + id + ", mileage=" + mileage + ", year=" + year + ", equipments=" + equipments
				+ ", specialCampaign=" + specialCampaign + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FromTo getMileage() {
		return mileage;
	}

	public void setMileage(FromTo mileage) {
		this.mileage = mileage;
	}

	public FromTo getYear() {
		return year;
	}

	public void setYear(FromTo year) {
		this.year = year;
	}

	public List<String> getEquipments() {
		return equipments;
	}

	public void setEquipments(List<String> equipments) {
		this.equipments = equipments;
	}

	public YN getSpecialCampaign() {
		return specialCampaign;
	}

	public void setSpecialCampaign(YN specialCampaign) {
		this.specialCampaign = specialCampaign;
	}

}
