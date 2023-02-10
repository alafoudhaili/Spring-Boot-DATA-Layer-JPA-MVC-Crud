package com.springboot.app.ams.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.springboot.app.ams.entity.Provider;

@Repository
public interface ProviderRepository extends CrudRepository<Provider, Long> {

}

