package brawlstarsapi.infrastructure.members.gateways;


import brawlstarsapi.domain.ClubMembersResponse;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/v1/clubs/")
@RegisterRestClient(configKey = "services.brawl.base-url")
@RegisterClientHeaders
public interface MembersGateway {
    @GET
    @Path("/{clubTag}/members")
    @Produces(MediaType.APPLICATION_JSON)
    ClubMembersResponse getClubMembers(
            @PathParam("clubTag") String clubTag,
            @HeaderParam("Authorization") String authorization
    );
}
