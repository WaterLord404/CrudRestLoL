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

import com.LeagueOfLegends.entity.Champion;
import com.LeagueOfLegends.rest.service.ChampionService;
import com.LeagueOfLegends.rest.service.PlayerService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping(path = "/lol")
public class ChampionController {

	@Autowired
	private ChampionService championService;

	@Autowired
	private PlayerService playerService;
	
	private String body = new String();
	private HttpStatus status = null;

	@PostMapping(path = "/champion")
	public ResponseEntity<?> addChampion(@RequestBody Champion sent) {
		body = championService.addChampion(sent);
		status = championService.getStatus();

		return ResponseEntity.status(status).body(body);
	}

	@GetMapping(path = "/champion/{id}")
	public ResponseEntity<?> getChampion(@PathVariable int id) throws JsonProcessingException {
		body = championService.getChampion(id);
		status = championService.getStatus();

		return ResponseEntity.status(status).body(body);
	}

	@GetMapping(path = "/champion")
	public ResponseEntity<?> getAllChampions() {
		body = championService.getAllChampions();
		status = championService.getStatus();
		
		return ResponseEntity.status(status).body(body);
	}

	@PutMapping(path = "/champion")
	public ResponseEntity<?> putChampion(@RequestBody Champion sent) {
		body = championService.putChampion(sent);
		status = championService.getStatus();
		
		return ResponseEntity.status(status).body(body);
	}

	@DeleteMapping(path = "/champion")
	public ResponseEntity<?> deleteChampion(@RequestBody Champion sent) {
		body = championService.deleteChampion(sent,playerService.getPlayers());
		status = championService.getStatus();
		
		return ResponseEntity.status(status).body(body);
	}

}
