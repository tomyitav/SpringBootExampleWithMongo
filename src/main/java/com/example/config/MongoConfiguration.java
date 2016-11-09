package com.example.config;

import java.net.UnknownHostException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
 
@Configuration
@EnableMongoRepositories(basePackages = {"com.example"})
public class MongoConfiguration  extends AbstractMongoConfiguration {
    @Override
    protected String getDatabaseName() {
        return "trains";
    }
 
    public @Bean
    Mongo mongo() throws UnknownHostException {
        ServerAddress serverAddress = new ServerAddress("localhost", 27017);
        MongoClientOptions options = MongoClientOptions.builder().connectionsPerHost(4).socketKeepAlive(true).build();
        Mongo mongo = new MongoClient(serverAddress,options);
        return mongo;
    }
    @Bean(name="MongoTemplate")
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), "trains");
    }
 
}