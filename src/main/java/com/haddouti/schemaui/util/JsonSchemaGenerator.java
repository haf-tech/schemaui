package com.haddouti.schemaui.util;

import java.util.Date;

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
import com.fasterxml.jackson.module.jsonSchema.factories.SchemaFactoryWrapper;
import com.fasterxml.jackson.module.jsonSchema.factories.VisitorContext;

/**
 * Generates a JSON Schema using Jackson and a JAXB class.
 * 
 * This utility class generates a JSON Schema based on a given JAXB class. Any
 * Date will be mapped to DATE without Time. Additionally is reference to
 * (pre-)defined types deactivated, this simplifies to usage of the JSON Schema.
 *
 */
public class JsonSchemaGenerator {

	public static String generateSchema(Class<?> clazz) {
		final SchemaFactoryWrapper visitor = new SchemaFactoryWrapper();
		final ObjectMapper mapper = new ObjectMapper();
		try {
			visitor.setVisitorContext(new VisitorContextWithoutSchemaInlining());

			mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
			// write date as string instead of timestamps
			mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

			// Overwrite the standard DateSerializer which use DATE_TIME as type
			// in json
			// In our case is only DATE wanted
			SimpleModule dateModule = new SimpleModule();
			dateModule.addSerializer(Date.class, new DateFormatSerializer());
			mapper.registerModule(dateModule);

			mapper.acceptJsonFormatVisitor(mapper.constructType(clazz), visitor);
			final com.fasterxml.jackson.module.jsonSchema.JsonSchema jsonSchema = visitor.finalSchema();
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonSchema);
		} catch (JsonMappingException jsonEx) {
		} catch (JsonProcessingException jsonEx) {
		}

		return null;
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

	public static class VisitorContextWithoutSchemaInlining extends VisitorContext {

		@Override
		public String getSeenSchemaUri(JavaType aSeenSchema) {
			// Avoid any references
			return null;
		}

	}
}
