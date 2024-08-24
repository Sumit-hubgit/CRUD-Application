package com.sumitsahu.journalApp.entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Document(collection = "journal_entries")
@Data
@NoArgsConstructor
public class JournalEntry {

    @Id
    private ObjectId id;
    @NonNull
    private  String title;      //POJO
    private String content;
    private LocalDateTime date;



    //ye saare fields ki getter and setters function likhe ki zarurat nhi hai
    // because humne lombok use kr liya hai woh apne aap saare getters and setters
    //function create kr dega.
    //Step 1: add dependency
    //Step 2: plugins kro intellijIdea mein
    //Step 3: Use kro saare functions.
}
