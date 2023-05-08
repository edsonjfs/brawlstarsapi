package brawlstarsapi.command;

import brawlstarsapi.domain.ClubMembersResponse;
import brawlstarsapi.infrastructure.members.gateways.MembersFilesGateway;
import brawlstarsapi.infrastructure.members.gateways.MembersMongoGateway;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.List;

@Singleton
public class MembersCommand {
    @Inject
    MembersMongoGateway membersMongoGateway;

    @Inject
    MembersFilesGateway membersFilesGateway;

    public void addMembers(ClubMembersResponse clubMembersResponse) {
        membersMongoGateway.addMembers(clubMembersResponse);
    }

    public List<Document> getMembers(){
        return membersMongoGateway.getMembers();
    }

    public void exportMembersOds(){
        membersFilesGateway.exportMembersOds();
    }
}
