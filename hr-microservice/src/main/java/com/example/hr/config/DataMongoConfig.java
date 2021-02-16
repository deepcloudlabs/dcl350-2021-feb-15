package com.example.hr.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import com.example.hr.converter.ZonedDateTimeReadConverter;
import com.example.hr.converter.ZonedDateTimeWriteConverter;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@deepcloudlabs.com>
 *
 */
@Configuration
public class DataMongoConfig extends AbstractMongoClientConfiguration {

	@Value("${spring.data.mongodb.database}")
	private String database;

	@Override
	protected String getDatabaseName() {
		return this.database;
	}

	@Bean
	public MongoCustomConversions customConversions(ZonedDateTimeReadConverter zonedDateTimeReadConverter,
			ZonedDateTimeWriteConverter zonedDateTimeWriteConverter) {
		List<Converter<?, ?>> converters = new ArrayList<Converter<?, ?>>();

		converters.add(zonedDateTimeReadConverter);
		converters.add(zonedDateTimeWriteConverter);
		return new MongoCustomConversions(converters);
	}

}
