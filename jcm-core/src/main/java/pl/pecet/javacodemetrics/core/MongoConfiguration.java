package pl.pecet.javacodemetrics.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories
public class MongoConfiguration extends AbstractMongoConfiguration {

	@Override
	protected String getDatabaseName() {
		return "jcmdb";
	}

	@Override
	public Mongo mongo() throws Exception {
		return new MongoClient("localhost", 27017);
	}

	@Bean
	public GridFsTemplate gridFsTemplate() throws Exception {
		return new GridFsTemplate(mongoDbFactory(), mappingMongoConverter());
	}
}