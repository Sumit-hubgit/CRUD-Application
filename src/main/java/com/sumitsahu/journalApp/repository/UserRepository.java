package com.sumitsahu.journalApp.repository;

import com.sumitsahu.journalApp.entity.JournalEntry;
import com.sumitsahu.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {

    User findByUserName(String username);
}
