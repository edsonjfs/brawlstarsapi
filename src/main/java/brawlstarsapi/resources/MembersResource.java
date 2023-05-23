package  brawlstarsapi.resources;

import brawlstarsapi.command.MembersCommand;
import brawlstarsapi.domain.ClubMembersResponse;
import brawlstarsapi.infrastructure.members.gateways.MembersGateway;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/members")
@Produces(MediaType.APPLICATION_JSON)
public class MembersResource {

    private final MembersGateway mapsGateway;

    @Inject
    public MembersResource(@RestClient MembersGateway mapsGateway) {
        this.mapsGateway = mapsGateway;
    }

    @Inject
    public MembersCommand membersCommand;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response members() {
        ClubMembersResponse clubMembersResponse = new ClubMembersResponse();
        try {
            clubMembersResponse = mapsGateway.getClubMembers("#28V2RCJVV", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiIsImtpZCI6IjI4YTMxOGY3LTAwMDAtYTFlYi03ZmExLTJjNzQzM2M2Y2NhNSJ9.eyJpc3MiOiJzdXBlcmNlbGwiLCJhdWQiOiJzdXBlcmNlbGw6Z2FtZWFwaSIsImp0aSI6IjEzZDNlODZjLWViNjgtNDczYi05YWIyLTI2YTkwMTJhZjVhYyIsImlhdCI6MTY4NDQzOTczNiwic3ViIjoiZGV2ZWxvcGVyL2U0NDQ1MTM1LWI1NmItZmVlNC04NjhmLTk1M2VmNDY5MDg5NCIsInNjb3BlcyI6WyJicmF3bHN0YXJzIl0sImxpbWl0cyI6W3sidGllciI6ImRldmVsb3Blci9zaWx2ZXIiLCJ0eXBlIjoidGhyb3R0bGluZyJ9LHsiY2lkcnMiOlsiMTg2LjIyMC4zOC4xNjMiXSwidHlwZSI6ImNsaWVudCJ9XX0.DZzQTmQ0MVVxNPHvYY8JlcXw77zhbqdP9H_DMe3G4TQv0SGsSHbgRYlctmhBhE4d0zdSi9dTwmaVRc2X--mf-w");
            membersCommand.addMembers(clubMembersResponse);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
//        System.out.println(mapResponse.getList().get(0).toString());
        return Response.ok().entity(clubMembersResponse).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("members-ods")
    public Response membersToCsv() {
        ClubMembersResponse clubMembersResponse = new ClubMembersResponse();
        try {
            membersCommand.exportMembersOds();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
//        System.out.println(mapResponse.getList().get(0).toString());
        return Response.ok().entity(clubMembersResponse).build();
    }
}
