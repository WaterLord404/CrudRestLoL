package com.LeagueOfLegends.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LeagueOfLegends.service.impl.DatabaseServiceImpl;

@RestController
@RequestMapping(path = "/lol")
public class DatabaseController {

	@Autowired
	private DatabaseServiceImpl databaseService;
	
	
	private String body = new String();
	private HttpStatus status = null;
	
	@PostMapping(path = "/{championName}/{playerID}")
	public ResponseEntity<?> addChampionToPlayer(@PathVariable String championName, @PathVariable int playerID) {
		body = databaseService.addChampionToPlayer(championName, playerID);
		status = databaseService.getStatus();

		return ResponseEntity.status(status).body(body);
	}
}
