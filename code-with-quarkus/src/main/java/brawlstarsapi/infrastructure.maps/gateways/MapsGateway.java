package brawlstarsapi.infrastructure.maps.gateways;


import brawlstarsapi.infrastructure.maps.domain.MapResponse;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/v1/maps")
@RegisterRestClient(configKey = "services.brawl.base-url")
public interface MapsGateway{

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    MapResponse getAllMaps();

}
