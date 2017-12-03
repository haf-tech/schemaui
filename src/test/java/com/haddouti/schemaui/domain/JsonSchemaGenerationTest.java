package com.haddouti.schemaui.domain;

import java.io.IOException;
import java.util.Date;

import javax.xml.bind.JAXBException;

import org.junit.Ignore;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.JsonSchemaGenerator;
import com.fasterxml.jackson.module.jsonSchema.customProperties.HyperSchemaFactoryWrapper;
import com.fasterxml.jackson.module.jsonSchema.factories.SchemaFactoryWrapper;
import com.fasterxml.jackson.module.jsonSchema.factories.VisitorContext;

public class JsonSchemaGenerationTest {

	public static class VisitorContextWithoutSchemaInlining extends VisitorContext {
		@Override
		public String addSeenSchemaUri(JavaType aSeenSchema) {
			return getSeenSchemaUri(aSeenSchema);
		}

		@Override
		public String getSeenSchemaUri(JavaType aSeenSchema) {
			// return isModel(aSeenSchema) ? javaTypeToUrn(aSeenSchema) : null;
			// Avoid any references
			return null;
		}

		protected boolean isModel(JavaType type) {
			return type.getRawClass() != String.class && !isBoxedPrimitive(type) && !type.isPrimitive()
					&& !type.isMapLikeType() && !type.isCollectionLikeType() && !type.isArrayType();
		}

		protected static boolean isBoxedPrimitive(JavaType type) {
			return type.getRawClass() == Boolean.class || type.getRawClass() == Byte.class
					|| type.getRawClass() == Long.class || type.getRawClass() == Integer.class
					|| type.getRawClass() == Short.class || type.getRawClass() == Float.class
					|| type.getRawClass() == Double.class;
		}
	}

	public void testGenerateSchema() throws JAXBException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		// configure mapper, if necessary, then create schema generator
		JsonSchemaGenerator schemaGen = new JsonSchemaGenerator(mapper);
		JsonSchema schema = schemaGen.generateSchema(SearchRequest.class);

		System.out.println(schema.toString());

	}

	@Test
	@Ignore
	public void testJsonSchemaGeneration() {
		// final SchemaFactoryWrapper visitor = new SchemaFactoryWrapper();
		final SchemaFactoryWrapper visitor = new HyperSchemaFactoryWrapper();
		final ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.acceptJsonFormatVisitor(mapper.constructType(SearchRequest.class), visitor);
			final com.fasterxml.jackson.module.jsonSchema.JsonSchema jsonSchema = visitor.finalSchema();
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonSchema));
		} catch (JsonMappingException jsonEx) {
		} catch (JsonProcessingException jsonEx) {
		}
	}

	@Test
	@Ignore
	public void testJsonSchemaGenerationStockVehicle() {
		final SchemaFactoryWrapper visitor = new SchemaFactoryWrapper();
		// final SchemaFactoryWrapper visitor = new HyperSchemaFactoryWrapper();
		final ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.acceptJsonFormatVisitor(mapper.constructType(StockVehicleRequest.class), visitor);
			final com.fasterxml.jackson.module.jsonSchema.JsonSchema jsonSchema = visitor.finalSchema();
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonSchema));
		} catch (JsonMappingException jsonEx) {
		} catch (JsonProcessingException jsonEx) {
		}
	}

	@Test
	@Ignore
	public void testJsonSchemaGenerationWithoutRefStockVehicle() {
		final SchemaFactoryWrapper visitor = new SchemaFactoryWrapper();
		final ObjectMapper mapper = new ObjectMapper();
		try {
			visitor.setVisitorContext(new VisitorContextWithoutSchemaInlining());

			mapper.acceptJsonFormatVisitor(mapper.constructType(StockVehicleRequest.class), visitor);
			final com.fasterxml.jackson.module.jsonSchema.JsonSchema jsonSchema = visitor.finalSchema();
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonSchema));
		} catch (JsonMappingException jsonEx) {
		} catch (JsonProcessingException jsonEx) {
		}
	}

	@Test
	public void testJsonSchemaGeneration2() {
		final SchemaFactoryWrapper visitor = new SchemaFactoryWrapper();
		final ObjectMapper mapper = new ObjectMapper();
		try {
			visitor.setVisitorContext(new VisitorContextWithoutSchemaInlining());

			mapper.acceptJsonFormatVisitor(mapper.constructType(SearchRequest.class), visitor);
			final com.fasterxml.jackson.module.jsonSchema.JsonSchema jsonSchema = visitor.finalSchema();
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonSchema));
		} catch (JsonMappingException jsonEx) {
		} catch (JsonProcessingException jsonEx) {
		}
	}

	@Test
	public void testJsonSchemaGenerationWithoutRefStockVehicle2() {
		final SchemaFactoryWrapper visitor = new SchemaFactoryWrapper();
		final ObjectMapper mapper = new ObjectMapper();
		try {

			mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
			// write date as string instead of timestamps
			mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

			// Overwrite the standard DateSerializer which use DATE_TIME as type
			// in json
			// In our case is only DATE wanted
			SimpleModule dateModule = new SimpleModule();
			dateModule.addSerializer(Date.class, new DateFormatSerializer());
			mapper.registerModule(dateModule);

			mapper.acceptJsonFormatVisitor(mapper.constructType(StockVehicleRequest.class), visitor);
			System.out.println(mapper.writeValueAsString(visitor.finalSchema()));
		} catch (JsonMappingException jsonEx) {
		} catch (JsonProcessingException jsonEx) {
		}
	}

	public static class DateFormatSerializer extends DateSerializer {

		/**
		 * 
		 */
		private static final long serialVersionUID = -2118707665648638640L;

		@Override
		protected void _acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint, boolean asNumber)
				throws JsonMappingException {
			if (asNumber) {
				visitIntFormat(visitor, typeHint, JsonParser.NumberType.LONG, JsonValueFormat.UTC_MILLISEC);
			} else {
				visitStringFormat(visitor, typeHint, JsonValueFormat.DATE);
			}
		}
	}

}
