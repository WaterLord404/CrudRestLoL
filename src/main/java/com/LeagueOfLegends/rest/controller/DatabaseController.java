package com.LeagueOfLegends.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LeagueOfLegends.entity.Player;
import com.LeagueOfLegends.rest.service.ChampionService;
import com.LeagueOfLegends.rest.service.DatabaseService;
import com.LeagueOfLegends.rest.service.PlayerService;

@RestController
@RequestMapping(path = "/lol")
public class DatabaseController {

	@Autowired
	private DatabaseService DBService;
	
	@Autowired
	private ChampionService championService;
	
	@Autowired
	private PlayerService playerService;
	
	private String body = new String();
	private HttpStatus status = null;
	
	@PostMapping(path = "/player/{id}")
	public ResponseEntity<?> addChampionToPlayer(@RequestBody Player player, @PathVariable int id) {
		body = DBService.addChampionToPlayer(championService.getChampions(), playerService.getPlayers(), player, id);
		status = DBService.getStatus();

		return ResponseEntity.status(status).body(body);
	}
}
