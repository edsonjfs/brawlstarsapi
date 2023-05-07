package brawlstarsapi.infrastructure.maps.gateways;


import brawlstarsapi.infrastructure.maps.domain.GameModeResponse;
import brawlstarsapi.infrastructure.maps.domain.MapResponse;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/v1/gamemodes")
@RegisterRestClient(configKey = "services.brawl.base-url")
public interface GamemodeGateway {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    GameModeResponse getGameMode(@PathParam("id") String id);
}
