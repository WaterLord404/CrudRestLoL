package com.LeagueOfLegends.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.LeagueOfLegends.entity.Player;

@Repository(value = "playerRepository")
public interface PlayerRepository extends CrudRepository<Player, Integer>{

	public Player findPlayerById(int id);
	
	@Query(value = "select p from Player p where p.nickname LIKE :nickname%")
	public List<Player> findAllPlayerWitchNameStartsWith(@Param("nickname") String string);
}
