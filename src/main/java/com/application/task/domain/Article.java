package com.application.task.domain;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "articles")
public class Article {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "title_and_description")
    private String title_and_description;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "journal_name")
    private String journal_name;

    @Column(name = "authorsFullName")
    private String authorsFullName;

    @Column(name = "timestamp")
    private Timestamp timestamp;
}