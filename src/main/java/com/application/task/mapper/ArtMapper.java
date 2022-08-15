package com.application.task.mapper;

import com.application.task.domain.Article;
import com.application.task.dto.ArticleDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArtMapper {

    public Article mapToArticle(final ArticleDto artDto) {
        return new Article(
                artDto.getId(),
                artDto.getTitle_and_description(),
                artDto.getDate(),
                artDto.getJournal_name(),
                artDto.getAuthorsFullName(),
                artDto.getTimestamp()
        );
    }

    public ArticleDto mapToArticleDto(final Article article) {
        return new ArticleDto(
                article.getId(),
                article.getTitle_and_description(),
                article.getDate(),
                article.getJournal_name(),
                article.getAuthorsFullName(),
                article.getTimestamp()
        );
    }

    public List<ArticleDto> mapToArticleDtoList(final List<Article> articleList) {
        return articleList.stream()
                .map(this::mapToArticleDto)
                .collect(Collectors.toList());
    }
}