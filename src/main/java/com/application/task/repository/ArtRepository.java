package com.application.task.repository;

import com.application.task.domain.Article;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ArtRepository extends CrudRepository<Article, Long> {

    @Override
    List<Article> findAll();

    Article findArtById(Long artId);
}