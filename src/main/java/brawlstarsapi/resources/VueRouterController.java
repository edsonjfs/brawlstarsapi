package brawlstarsapi.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/clubs")
public class VueRouterController {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response index() {
        System.out.println("TESTE");
        return Response.ok(getClass().getResourceAsStream("/META-INF/resources/clubs.html")).build();
    }
}