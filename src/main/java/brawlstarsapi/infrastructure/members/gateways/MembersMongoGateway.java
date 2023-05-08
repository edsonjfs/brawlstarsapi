package brawlstarsapi.infrastructure.members.gateways;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;


import brawlstarsapi.domain.ClubMembersResponse;
import brawlstarsapi.domain.Member;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class MembersMongoGateway {

    @Inject MongoClient mongoClient;

    public void addMembers(ClubMembersResponse listMembers){
        MongoCollection<Document> membersCollection = this.getCollection();
        List<String> membrosAtivos = new ArrayList<String>();

        for (Member member : listMembers.getItems()){
           Document document = new Document().
                   append("name", member.getName()).
                   append("tag", member.getTag()).
                   append("active", true);

           membrosAtivos.add(member.getTag());
           FindIterable<Document> memberFound =  membersCollection.find(new Document("tag", member.getTag()));

           if (memberFound.first() == null) {
                getCollection().insertOne(document);
           }
       }
        setInctiveMember(membersCollection, membrosAtivos);
    }

    public List<Document> getMembers() {
        MongoCollection<Document> membersCollection = this.getCollection();
        List<Document> membersDocuments = membersCollection.find(new Document().append("active", true)).into(new ArrayList<>());
        return membersDocuments;
    }

    private void setInctiveMember(MongoCollection<Document> membersCollection, List<String> membrosAtivos) {
        for (Document document : membersCollection.find()) {
            if(!membrosAtivos.contains(document.get("tag").toString())){
                Document query = new Document().append("tag", document.get("tag"));
                Bson update = Updates.set("active", false);

                membersCollection.updateOne(query, update);
            }
        }
    }

    private MongoCollection getCollection(){
        return mongoClient.getDatabase("brawlStars").getCollection("members");
    }
}
