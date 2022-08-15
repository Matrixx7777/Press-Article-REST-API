package com.application.task.exception;

public class ArticleNotFoundException extends  RuntimeException{
    public ArticleNotFoundException() {
        super("Cannot find the article with the given id");
    }
}