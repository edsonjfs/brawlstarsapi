package org.acme;

import brawlstarsapi.infrastructure.maps.command.MembersCommand;
import brawlstarsapi.infrastructure.maps.domain.ClubMembersResponse;
import brawlstarsapi.infrastructure.maps.gateways.MembersGateway;
import org.acme.entities.Person;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/members")
@Produces(MediaType.APPLICATION_JSON)
public class GreetingResource {

    private final MembersGateway mapsGateway;

    @Inject
    public GreetingResource(@RestClient MembersGateway mapsGateway) {
        this.mapsGateway = mapsGateway;
    }

    @Inject
    public MembersCommand membersCommand;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response members() {
        ClubMembersResponse clubMembersResponse = new ClubMembersResponse();
        try {
            clubMembersResponse = mapsGateway.getClubMembers("#28V2RCJVV", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiIsImtpZCI6IjI4YTMxOGY3LTAwMDAtYTFlYi03ZmExLTJjNzQzM2M2Y2NhNSJ9.eyJpc3MiOiJzdXBlcmNlbGwiLCJhdWQiOiJzdXBlcmNlbGw6Z2FtZWFwaSIsImp0aSI6ImVhMjEzMjZlLTU3ZGUtNDBmYS05MmQ4LTRiOWVmYzIzYTNmZCIsImlhdCI6MTY3ODcyNDM3OCwic3ViIjoiZGV2ZWxvcGVyLzViMDNjNDM3LTVmZDctMjM0NS0yMDcxLTI2YWZlNjU3MGNmNyIsInNjb3BlcyI6WyJicmF3bHN0YXJzIl0sImxpbWl0cyI6W3sidGllciI6ImRldmVsb3Blci9zaWx2ZXIiLCJ0eXBlIjoidGhyb3R0bGluZyJ9LHsiY2lkcnMiOlsiMTc3LjguNTQuMTciXSwidHlwZSI6ImNsaWVudCJ9XX0.g-p5JR9REDUf9Cw9IlMGVPdWOmA1A7z2LeYWLlRrcyj3QlGkXlcaAmEPE9zs9oS2AqIhfJ5N_LOoJbs4azyWsA");
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