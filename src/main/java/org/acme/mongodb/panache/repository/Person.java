package org.acme.mongodb.panache.repository;

import io.quarkus.mongodb.panache.common.MongoEntity;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import java.time.LocalDate;
import java.util.UUID;

@MongoEntity(collection = "ThePerson")
public class Person {
    public ObjectId id;

    public UUID uuid;

}
