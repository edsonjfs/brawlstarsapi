package brawlstarsapi.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class VueRouterController {

    @Path("/front")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response front() {
        System.out.println("TESTE");
        return Response.ok(getClass().getResourceAsStream("/META-INF/resources/front.html")).build();
    }


    @Path("/clubs")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response clubs() {
        System.out.println("TESTE");
        return Response.ok(getClass().getResourceAsStream("/META-INF/resources/clubs.html")).build();
    }
}