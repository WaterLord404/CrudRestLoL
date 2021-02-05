package com.LeagueOfLegends.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.LeagueOfLegends.model.entity.Player;
import com.LeagueOfLegends.model.entity.dto.PlayerDTO;
import com.LeagueOfLegends.service.impl.PlayerServiceImpl;

@RestController
@RequestMapping(path = "/lol")
public class PlayerController {

	@Autowired
	private PlayerServiceImpl playerService;

	private String body = new String();
	private HttpStatus status = null;

	@PostMapping(path = "/player")
	public ResponseEntity<?> addPlayer(@RequestBody PlayerDTO sent) {
		PlayerDTO body = playerService.addPlayer(sent);
		status = playerService.getStatus();

		return ResponseEntity.status(status).body(body);
	}

	@GetMapping(path = "/player/{id}")
	public ResponseEntity<?> getPlayer(@PathVariable int id) {
		PlayerDTO body = playerService.getPlayer(id);
		status = playerService.getStatus();

		return ResponseEntity.status(status).body(body);
	}

	@GetMapping(path = "/player")
	public ResponseEntity<?> getAllPlayers() {
		List<Player> body = playerService.getAllPlayers();
		status = playerService.getStatus();

		return ResponseEntity.status(status).body(body);
	}
	
	@GetMapping(path = "/player/nickname")
	public ResponseEntity<?> getAllPlayerWitchNameStartsWith(@RequestParam String name) {
		List<Player> body = playerService.getAllPlayerWitchNameStartsWith(name);
		status = playerService.getStatus();

		return ResponseEntity.status(status).body(body);
	}

	@PutMapping(path = "/player")
	public ResponseEntity<?> putPlayer(@RequestBody Player sent) {
		body = playerService.putPlayer(sent);
		status = playerService.getStatus();

		return ResponseEntity.status(status).body(body);
	}

	@DeleteMapping(path = "/player")
	public ResponseEntity<?> deletePlayer(@RequestBody Player sent) {
		body = playerService.deletePlayer(sent);
		status = playerService.getStatus();

		return ResponseEntity.status(status).body(body);
	}

}
