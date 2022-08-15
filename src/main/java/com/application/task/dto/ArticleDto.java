package com.application.task.dto;

import lombok.*;
import java.sql.*;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class ArticleDto {
    private Long id;
    private String title_and_description;
    private LocalDate date;
    private String journal_name;
    private String authorsFullName;
    private Timestamp timestamp;
}