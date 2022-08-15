package com.application.task.controller;

import com.application.task.domain.Article;
import com.application.task.exception.ArticleNotFoundException;
import com.application.task.dto.ArticleDto;
import com.application.task.mapper.ArtMapper;
import com.application.task.service.ArtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/art")
@RequiredArgsConstructor
public class ArtController {

    private final ArtMapper artMapper;
    private final ArtService artService;

    @RequestMapping(method = RequestMethod.GET, value = "/getArts")
    public List<ArticleDto> getArts() {
        List<Article> fullList = artService.getAll();
        fullList.sort(Comparator.comparing(Article::getDate));
        return artMapper.mapToArticleDtoList(fullList);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getArt")
    public ArticleDto getArt(@RequestParam Long artId) {
        return artMapper.mapToArticleDto(artService.getArtById(artId));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getArtsByWord")
    public List<ArticleDto> getArtsByWord(String keyWord) {
        List<Article> arts = artService.getAll();
        List<ArticleDto> returnList = null;
        for (int i = 0; i < arts.size(); i++) {
            if (arts.get(i).getTitle_and_description().contains(keyWord)) {
                returnList = artMapper.mapToArticleDtoList(arts);
            }
            else throw new RuntimeException("A word like -- > " + keyWord + " doesn't exist in the table");
        }
        return returnList;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createArt", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createArt(@RequestBody ArticleDto artDto) {
        artService.save(artMapper.mapToArticle(artDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateArt")
    public ArticleDto updateArt(@RequestBody ArticleDto artDto) {
        return artMapper.mapToArticleDto(artService.save(artMapper.mapToArticle(artDto)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteArt")
    public void deleteArt(@RequestParam Long artId) {
        try {
            artService.deleteArt(artId);
        }
        catch(ArticleNotFoundException e){
            throw new ArticleNotFoundException();
        }
    }
}