package com.haddouti.schemaui.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {}, namespace = "http://com.haddouti.schemaui:search")
public class FromTo {

	private String from;
	private String to;

	@Override
	public String toString() {
		return "FromTo [from=" + from + ", to=" + to + "]";
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

}
