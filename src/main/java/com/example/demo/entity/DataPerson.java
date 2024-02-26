package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("test2")
public class DataPerson {
    private Long id;
    private String firstName;
    private String lastName;
//    private Gender gender;
//    private int age;
//    private String email;

}
