package org.acme;

import brawlstarsapi.infrastructure.maps.domain.Map;
import brawlstarsapi.infrastructure.maps.domain.MapResponse;
import brawlstarsapi.infrastructure.maps.gateways.MapsGateway;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/hello")
public class GreetingResource {

    private final MapsGateway mapsGateway;

    @Inject
    public GreetingResource(@RestClient MapsGateway mapsGateway) {
        this.mapsGateway = mapsGateway;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public MapResponse hello() {
        MapResponse mapResponses = mapsGateway.getAllMaps();

        System.out.println(mapResponses.getList().get(0).toString());
        return mapResponses;
    }
}