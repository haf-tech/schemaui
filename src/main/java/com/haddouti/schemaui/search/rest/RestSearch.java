package com.haddouti.schemaui.search.rest;

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

import com.haddouti.schemaui.domain.SearchRequest;
import com.haddouti.schemaui.domain.SearchResponse;
import com.haddouti.schemaui.domain.Vehicle;
import com.haddouti.schemaui.util.JsonSchemaGenerator;

@RestController
@RequestMapping("/search/v1")
public class RestSearch {

	private static Logger log = LoggerFactory.getLogger(RestSearch.class);

	@RequestMapping(method = RequestMethod.POST, path = "/detail", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public @ResponseBody SearchResponse searchVehicles(@RequestBody SearchRequest req) {

		log.info("searchVehicles(): request={}", req);

		SearchResponse response = new SearchResponse();
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		response.setVehicles(vehicles);

		return response;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/detail", params = { "json" })
	public @ResponseBody String schemaSearchVehicles(@RequestParam("json") String json) {

		log.info("schemaSearchVehicles(): json={}", json);
		return JsonSchemaGenerator.generateSchema(SearchRequest.class);
	}
}
