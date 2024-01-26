package com.example.systemtask.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    @Setter
    @Getter
    private String email;

    @Setter
    @Getter
    private String password;

}
