package com.LeagueOfLegends.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LeagueOfLegends.entity.Player;
import com.LeagueOfLegends.rest.service.ChampionService;
import com.LeagueOfLegends.rest.service.PlayerService;

@RestController
@RequestMapping(path = "/lol")
public class PlayerController {

	@Autowired
	private PlayerService playerService;

	@Autowired
	private ChampionService championService;
	
	private String body = new String();
	private HttpStatus status = null;
	
	@PostMapping(path = "/player")
	public ResponseEntity<?> addPlayer(@RequestBody Player sent){
		body = playerService.addPlayer(sent);
		status = playerService.getStatus();

		return ResponseEntity.status(status).body(body);
	}
	
	@GetMapping(path = "/player/{id}")
	public ResponseEntity<?> getPlayer(@PathVariable int id){
		body = playerService.getPlayer(id);
		status = playerService.getStatus();

		return ResponseEntity.status(status).body(body);
	}
	
	@GetMapping(path = "/player")
	public ResponseEntity<?> getAllPlayers() {
		body = playerService.getAllPlayers();
		status = playerService.getStatus();

		return ResponseEntity.status(status).body(body);
	}
	
	@PutMapping(path = "/player")
	public ResponseEntity<?> putPlayer(@RequestBody Player sent){
		body = playerService.putPlayer(sent);
		status = playerService.getStatus();

		return ResponseEntity.status(status).body(body);
	}
	
	@DeleteMapping(path = "/player")
	public ResponseEntity<?> deletePlayer(@RequestBody Player sent){
		body = playerService.deletePlayer(sent, championService.getChampions());
		status = playerService.getStatus();

		return ResponseEntity.status(status).body(body);
	}

	
}
