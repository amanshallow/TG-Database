package dev.microprofile.starter;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Path("/resource")
public class StarterResource {
    // Connection String
    private final MongoClient mongoClient = MongoClients.create("mongodb+srv://aman:amanspassword@tg-database.1q9gs.mongodb.net/TG-Database?retryWrites=true&w=majority");
    private final MongoDatabase training = mongoClient.getDatabase("Groceries");
    private final MongoCollection<Document> collection = training.getCollection("Users");

    @GET
    @Path("/user")
    public String getRequest() {
        // READ
        FindIterable<Document> iterDoc = collection.find();
        Iterator it = iterDoc.iterator();
        List<Document> documents = new ArrayList<>();
        while (it.hasNext()) {
            documents.add((Document) it.next());
        }
        return documents.toString();
    }

    @GET
    @Path("/user/{name}")
    public String getOneId(@PathParam("name") String name) {
        // READ: Query for a specific entry.
        Document result = collection.find(new Document("name", name)).first();
        if (result != null) {
            return result.toJson();
        }
        return null;
    }

    @PUT
    @Path("/user/{name}")
    public Response update(@PathParam("name") String name, @QueryParam("name") String rplName) {
        // UPDATE:
        if(getOneId(name) == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Name not Found").build();
        }
        collection.updateOne(Filters.eq("name", name), Updates.set("name", rplName));
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/user/{email}")
    public Response delete(@PathParam("email") String email) {
        // DELETE:
        if (collection.findOneAndDelete(new Document("email", email)) == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.status(Response.Status.OK).build();
    }

    @POST
    @Path("/user")
    public Response create (@QueryParam("name") String name, @QueryParam("email") String email,
                            @QueryParam("age") int age) {
        Document document1 = new Document("name", name).append("age", age).append("email", email);
        List<Document> documents = new ArrayList<>();
        documents.add(document1);
        collection.insertMany(documents);

        return Response.status(Response.Status.OK).build();

    }
}