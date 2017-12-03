package com.haddouti.schemaui.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateWithoutTimeAdapter extends XmlAdapter<String, Date> {

	private static final SimpleDateFormat DF = new SimpleDateFormat("dd-MM-yyyy");

	@Override
	public String marshal(Date date) throws Exception {

		return DF.format(date);
	}

	@Override
	public Date unmarshal(String date) throws Exception {
		return DF.parse(date);
	}

}
