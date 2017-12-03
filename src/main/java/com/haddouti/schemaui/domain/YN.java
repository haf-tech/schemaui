package com.haddouti.schemaui.domain;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlEnum
@XmlType(propOrder = {}, namespace = "http://com.haddouti.schemaui:general")
public enum YN {

	Y, N;
}
