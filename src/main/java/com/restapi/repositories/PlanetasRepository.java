package com.restapi.repositories;

import com.restapi.models.Planeta;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlanetasRepository  extends MongoRepository<Planeta, String> {
    Planeta findBy_id(ObjectId _id);
}