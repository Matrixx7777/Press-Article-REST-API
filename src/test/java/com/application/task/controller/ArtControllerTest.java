package com.application.task.controller;

import com.application.task.domain.Article;
import com.application.task.dto.ArticleDto;
import com.application.task.mapper.ArtMapper;
import com.application.task.service.ArtService;
import com.google.gson.Gson;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

@SpringJUnitWebConfig
@WebMvcTest(ArtController.class)
public class ArtControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ArtService artService;

    @MockBean
    private ArtMapper artMapper;

    @Test
    void getArts() throws Exception {
        //Given
        List<Article> articleList =
                List.of(new Article(1L, "FirstTest", LocalDate.of(2022, 9, 14), "Beginning", "Dawid Kocik", new Timestamp(123)));
        List<ArticleDto> articleDtoList =
                List.of(new ArticleDto( 1L,"FirstTest-ArtDtoList", LocalDate.of(2022, 9, 15), "Beginning", "Dawid Kocik", new Timestamp(123)));

        //When
        when(artService.getAll()).thenReturn(articleList);
        when(artMapper.mapToArticleDtoList(articleList)).thenReturn(articleDtoList);

        //Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/art/getArts")
                        .contentType(MediaType.APPLICATION_JSON))
                // getArts fields
                .andExpect(MockMvcResultMatchers.jsonPath
                        ("$", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath
                        ("$[0].id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath
                        ("$[0].title_and_description", Matchers.is("FirstTest-ArtDtoList")))
                .andExpect(MockMvcResultMatchers.jsonPath
                        ("$[0].publication_date", Matchers.is(LocalDate.of(2022, 9, 15))))
                .andExpect(MockMvcResultMatchers.jsonPath
                        ("$[0].journal_name", Matchers.is("Beginning")))
                .andExpect(MockMvcResultMatchers.jsonPath
                        ("$[0].name_and_surname", Matchers.is("Dawid Kocik")))
                .andExpect(MockMvcResultMatchers.jsonPath
                        ("$[0].timestamp", Matchers.is(new Timestamp(123))));
    }

    @Test
    void getArt() throws Exception {
        //Given
        Article article = new Article( 1L, "FirstTest", LocalDate.of(2022, 9, 14), "Beginning", "Dawid Kocik", new Timestamp(123));
        Long getId = article.getId();
        ArticleDto articleDto = new ArticleDto( 1L, "FirstTest-ArtDtoList", LocalDate.of(2022, 9, 15), "Beginning", "Dawid Kocik", new Timestamp(123));

        //When
        when(artService.getArtById(getId)).thenReturn(article);
        when(artMapper.mapToArticleDto(article)).thenReturn(articleDto);

        //Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/art/getArt/1")       //"/v1/task/getTask?taskId=1"
                        .contentType(MediaType.APPLICATION_JSON))
                // getTask fields
                .andExpect(MockMvcResultMatchers.jsonPath
                        ("$", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath
                        ("$[0].id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath
                        ("$[0].title_and_description", Matchers.is("FirstTest-ArtDtoList")))
                .andExpect(MockMvcResultMatchers.jsonPath
                        ("$[0].publication_date", Matchers.is(LocalDate.of(2022, 9, 15))))
                .andExpect(MockMvcResultMatchers.jsonPath
                        ("$[0].journal_name", Matchers.is("Beginning")))
                .andExpect(MockMvcResultMatchers.jsonPath
                        ("$[0].name_and_surname", Matchers.is("Dawid Kocik")))
                .andExpect(MockMvcResultMatchers.jsonPath
                        ("$[0].timestamp", Matchers.is(new Timestamp(123))));
    }

    @Test
    void getArtsByWord() throws Exception {
        //Given
        List<Article> articleList =
                List.of(new Article(1L, "FirstTest", LocalDate.of(2022, 9, 14), "Beginning", "Dawid Kocik", new Timestamp(123)));
        List<ArticleDto> articleDtoList =
                List.of(new ArticleDto( 1L,"FirstTest-ArtDtoList", LocalDate.of(2022, 9, 15), "Beginning", "Dawid Kocik", new Timestamp(123)));

        //When
        when(artService.getAll()).thenReturn(articleList);
        when(artMapper.mapToArticleDtoList(articleList)).thenReturn(articleDtoList);

        //Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/art/getArtsByWord")
                        .contentType(MediaType.APPLICATION_JSON))
                // getArts fields
                .andExpect(MockMvcResultMatchers.jsonPath
                        ("$", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath
                        ("$[0].id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath
                        ("$[0].title_and_description", Matchers.is("FirstTest-ArtDtoList")))
                .andExpect(MockMvcResultMatchers.jsonPath
                        ("$[0].publication_date", Matchers.is(LocalDate.of(2022, 9, 15))))
                .andExpect(MockMvcResultMatchers.jsonPath
                        ("$[0].journal_name", Matchers.is("Beginning")))
                .andExpect(MockMvcResultMatchers.jsonPath
                        ("$[0].name_and_surname", Matchers.is("Dawid Kocik")))
                .andExpect(MockMvcResultMatchers.jsonPath
                        ("$[0].timestamp", Matchers.is(new Timestamp(123))));
    }

    @Test
    void createArt() throws Exception {
        //Given
        Article article = new Article( 1L, "FirstTest", LocalDate.of(2022, 9, 14), "Beginning", "Dawid Kocik", new Timestamp(123));
        ArticleDto articleDto = new ArticleDto( 1L, "FirstTest-ArtDtoList", LocalDate.of(2022, 9, 15), "Beginning", "Dawid Kocik", new Timestamp(123));

        //When
        when(artMapper.mapToArticle(articleDto)).thenReturn(article);
        when(artMapper.mapToArticleDto(article)).thenReturn(articleDto);
        when(artService.save(any(Article.class))).thenReturn(article);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(articleDto);

        //Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/art/createArt")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent)
                )
                //createTask
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    void updateArt() {
        //Given
        Article article = new Article( 1L, "SecondTest", LocalDate.of(2022, 9, 31), "Medium", "No one", new Timestamp(450));
        ArticleDto articleDto = new ArticleDto( 1L, "SecondTest-ArtDtoList", LocalDate.of(2022, 9, 31), "Medium", "Nobody", new Timestamp(450));

        //When
        when(artMapper.mapToArticle(articleDto)).thenReturn(article);
        when(artService.save(any(Article.class))).thenReturn(article);
        when(artMapper.mapToArticleDto(article)).thenReturn(articleDto);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(articleDto);

        //Then
        try {
            mockMvc
                    .perform(MockMvcRequestBuilders
                            .put("/art/updateArt")
                            .contentType(MediaType.APPLICATION_JSON)
                            .characterEncoding("UTF-8")
                            .content(jsonContent)
                    )
                    .andExpect(MockMvcResultMatchers.status().is(200));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void deleteArt() {
        //Given
        Article article = new Article( 1L, "FirstTest", LocalDate.of(2022, 9, 14), "Beginning", "Dawid Kocik", new Timestamp(123));
        Long getId = article.getId();
        ArticleDto articleDto = new ArticleDto( 1L, "FirstTest-ArtDtoList", LocalDate.of(2022, 9, 15), "Beginning", "Dawid Kocik", new Timestamp(123));

        //When
        when(artMapper.mapToArticleDto(article)).thenReturn(articleDto);
        when(artService.getArtById(getId)).thenReturn(article);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(articleDto);

        //Then
        try {
            mockMvc
                    .perform(MockMvcRequestBuilders
                            .delete("/art/deleteArt/1")
                            .contentType(MediaType.APPLICATION_JSON)
                            .characterEncoding("UTF-8")
                            .content(jsonContent)
                    )
                    .andExpect(MockMvcResultMatchers.status().is(200));
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}