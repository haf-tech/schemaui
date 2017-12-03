package com.haddouti.schemaui.stock.rest;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.haddouti.schemaui.domain.CodeText;
import com.haddouti.schemaui.domain.StockVehicleRequest;
import com.haddouti.schemaui.domain.StockVehicleResponse;
import com.haddouti.schemaui.domain.StockVehicleResponse.Status;
import com.haddouti.schemaui.util.JsonSchemaGenerator;

@RestController
@RequestMapping("/stock/v1")
public class RestStock {

	private static Logger log = LoggerFactory.getLogger(RestStock.class);

	@RequestMapping(method = RequestMethod.POST, path = "/add", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public @ResponseBody StockVehicleResponse addVehicles(@RequestBody StockVehicleRequest req) {

		log.info("addVehicles(): request={}", req);

		StockVehicleResponse response = new StockVehicleResponse();
		response.setVehicles(req.getVehicles());
		Status allStatus = new Status();
		response.setStatus(allStatus);
		List<CodeText> st = new ArrayList<CodeText>();
		allStatus.setStatus(st);
		CodeText ct = new CodeText();
		st.add(ct);
		ct.setCode("0");
		ct.setText("OK");

		return response;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/add", params = { "json" })
	public @ResponseBody String schemaAddVehicles(@RequestParam("json") String json) {

		log.info("schemaAddVehicles(): json={}", json);
		return JsonSchemaGenerator.generateSchema(StockVehicleRequest.class);
	}
}
