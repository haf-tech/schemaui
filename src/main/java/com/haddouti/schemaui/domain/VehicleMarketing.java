package com.haddouti.schemaui.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {}, namespace = "http://com.haddouti.schemaui:vehicle")
public class VehicleMarketing {

	private YN specialCampaign;
	private List<VehicleMarketingCampaign> campaigns = new ArrayList<VehicleMarketingCampaign>();

	@Override
	public String toString() {
		return "VehicleMarketing [specialCampaign=" + specialCampaign + ", campaigns=" + campaigns + "]";
	}

	public YN getSpecialCampaign() {
		return specialCampaign;
	}

	public void setSpecialCampaign(YN specialCampaign) {
		this.specialCampaign = specialCampaign;
	}

	public List<VehicleMarketingCampaign> getCampaigns() {
		return campaigns;
	}

	public void setCampaigns(List<VehicleMarketingCampaign> campaigns) {
		this.campaigns = campaigns;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(propOrder = {}, namespace = "http://com.haddouti.schemaui:vehicle")
	public static class VehicleMarketingCampaign {
		private String title;
		private String desc;
		@XmlJavaTypeAdapter(DateWithoutTimeAdapter.class)
		private Date createdAt;
		@XmlJavaTypeAdapter(DateWithoutTimeAdapter.class)
		private Date limitedAt;

		@Override
		public String toString() {
			return "VehicleMarketingCampaign [title=" + title + ", desc=" + desc + ", createdAt=" + createdAt
					+ ", limitedAt=" + limitedAt + "]";
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		public Date getLimitedAt() {
			return limitedAt;
		}

		public void setLimitedAt(Date limitedAt) {
			this.limitedAt = limitedAt;
		}

	}
}
