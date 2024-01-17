package com.example.systemtask.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "Task")
public class Task {

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "status")
    private String status;
    @Column(name = "priority")
    private String priority;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "author")
    //@Column(name = "author")
    private Person author;
    @Column(name = "executor")
    private String executor;
    @Column(name = "create_at")
    private LocalDateTime createAt;

}
