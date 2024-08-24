package com.sumitsahu.journalApp.entity;

import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "Users")
@Data
public class User {

    private ObjectId id;
    @Indexed(unique = true)     //Automatically unique nhi hota isliye hum application properties mein add karenge spring.data.mongodb.auto-index-creation=true
    @NonNull
    private String userName;

    @NonNull
    private String password;

    @DBRef
    List<JournalEntry> journalEntries=new ArrayList<>();   //hum referencecreate kr rhe usesr k andr journalentry ka
    // jo journal entries mein entry hai uska eernce rakh rhi ye

    private List<String>roles;


    //ye saare fields ki getter and setters function likhe ki zarurat nhi hai
    // because humne lombok usekr liya hai woh apnw aap saare getters and setters
    //function create kr dega.
    //Step 1: add dependency
    //Step 2: plugins kro intellijIdea mein
    //Step 3: Use kro saare functions.
}
