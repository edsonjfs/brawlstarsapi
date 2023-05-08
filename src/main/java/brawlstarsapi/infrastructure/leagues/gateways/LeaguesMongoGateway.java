package brawlstarsapi.infrastructure.leagues.gateways;

import com.mongodb.client.MongoClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class LeaguesMongoGateway {

    @Inject
    MongoClient mongoClient;

}

