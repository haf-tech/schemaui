package com.haddouti.schemaui.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {}, namespace = "http://com.haddouti.schemaui:general")
public class CodeText {

	private String code;
	private String text;

	@Override
	public String toString() {
		return "CodeText [code=" + code + ", text=" + text + "]";
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
