package com.LeagueOfLegends.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.LeagueOfLegends.model.entity.Champion;

@Repository(value = "championRepository")
public interface ChampionRepository extends CrudRepository<Champion, Integer>{
	public Champion findChampionById(int id);
	public List<Champion> findChampionByName(String name);
	
	@Query(value= "SELECT * FROM Champion ORDER BY attackDamage DESC", nativeQuery = true)
	public List<Champion> findAllOrderedByAttackDamageDesc();
}
