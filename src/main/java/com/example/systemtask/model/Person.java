package com.example.systemtask.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "Person")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    @Getter
    private Long id;

    @Column(name = "email")
    @Setter
    @Getter
    private String email;

    @Column(name = "password")
    @Setter
    @Getter
    private String password;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Task> tasks;

}
