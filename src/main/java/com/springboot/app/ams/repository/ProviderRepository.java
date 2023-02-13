package com.springboot.app.ams.repository;

import com.springboot.app.ams.entity.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.springboot.app.ams.entity.Provider;

@Repository
public interface ProviderRepository extends CrudRepository<Provider, Long> {
  @Query("From Article a WHERE a.provider.id = ?1")
	List<Article> findArticlesByProvider(long id);
}

