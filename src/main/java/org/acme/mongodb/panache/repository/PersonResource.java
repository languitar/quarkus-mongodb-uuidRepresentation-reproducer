package org.acme.mongodb.panache.repository;

import org.bson.Document;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.UUID;

@Path("/repository/persons")
@Consumes("application/json")
@Produces("application/json")
public class PersonResource {
    @Inject
    PersonRepository personRepository;

    @GET
    @Path("/bug")
    public void bug(String id) {
        // works
        Person person = new Person();
        person.uuid = UUID.randomUUID();
        personRepository.persistOrUpdate(person);

        // doesn't work
        personRepository.mongoCollection().updateMany(
                new Document().toBsonDocument(),
                new Document("$set", new Document("uuid", UUID.randomUUID())).toBsonDocument());
    }
}
