package org.example.exothymeleaf.Model;

import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    private UUID id;
    private String firstName;
    private String lastName;
    private int age;
    private String email;


}
