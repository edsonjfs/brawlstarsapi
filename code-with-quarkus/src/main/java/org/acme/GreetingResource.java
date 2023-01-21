package org.acme;

import brawlstarsapi.infrastructure.maps.domain.Map;
import brawlstarsapi.infrastructure.maps.domain.MapResponse;
import brawlstarsapi.infrastructure.maps.gateways.MapsGateway;
import org.acme.entities.Person;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class GreetingResource {

    private final MapsGateway mapsGateway;

    @Inject
    public GreetingResource(@RestClient MapsGateway mapsGateway) {
        this.mapsGateway = mapsGateway;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello() {
        MapResponse mapResponse = new MapResponse();
        try {
            mapResponse = mapsGateway.getAllMaps();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
//        System.out.println(mapResponse.getList().get(0).toString());
        return Response.ok().entity(mapResponse).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("test")
    public Response test() {
        Person person = new Person();
        person.setAge(27);
        person.setName("Dado");

        return Response.ok(person).build();
    }
}