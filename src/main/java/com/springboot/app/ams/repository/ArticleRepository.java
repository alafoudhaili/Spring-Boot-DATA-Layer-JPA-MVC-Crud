package com.springboot.app.ams.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.springboot.app.ams.entity.Article;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Long> {

}
