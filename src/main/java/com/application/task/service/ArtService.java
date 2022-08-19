package com.application.task.service;

import com.application.task.domain.Article;
import com.application.task.repository.ArtRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArtService {

    @Autowired
    private final ArtRepository artRepository;

    public List<Article> getAll() {return artRepository.findAll();}

    public Article getArtById(Long artId) {return  artRepository.findArtById(artId);}

    public Article save(final Article article) {return artRepository.save(article);}

    public void deleteArt(final Long artId) {artRepository.deleteById(artId);}
}