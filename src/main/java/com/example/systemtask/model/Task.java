package com.example.systemtask.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "Task")
public class Task {

    @Id
    @Column(name = "id")
    @Setter
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    @Column(name = "title")
    private String title;
    @Setter
    @Getter
    @Column(name = "description")
    private String description;

    @Setter
    @Getter
    @Column(name = "status")
    private String status;

    @Setter
    @Getter
    @Column(name = "priority")
    private String priority;

    @Setter
    @Getter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author", referencedColumnName = "email")
    //@Column(name = "author")
    private Person author;

    @Setter
    @Getter
    @Column(name = "executor")
    private String executor;

    @Setter
    @Getter
    @Column(name = "create_at")
    private LocalDateTime createAt;

}
