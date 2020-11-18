package com.LeagueOfLegends.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.LeagueOfLegends.model.entity.Document;

public interface DocumentRepository extends CrudRepository<Document, Long> {

	Document findById(Integer id);

}
