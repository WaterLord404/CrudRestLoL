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
import org.springframework.web.multipart.MultipartFile;

import com.LeagueOfLegends.model.entity.Champion;
import com.LeagueOfLegends.service.impl.ChampionServiceImpl;

@RestController
@RequestMapping(path = "/lol")
public class ChampionController {

	@Autowired
	private ChampionServiceImpl championService;

	private String body = new String();
	private HttpStatus status = null;

	@PostMapping(path = "/champion")
	public ResponseEntity<?> addChampion(@RequestBody Champion sent) {
		body = championService.addChampion(sent);
		status = championService.getStatus();

		return ResponseEntity.status(status).body(body);
	}

	@PostMapping(path = "/{id}/document")
	public ResponseEntity<?> uploadFile(@PathVariable(required = false) String id,
			@RequestParam(name = "mpFile", required = false) MultipartFile mpFile) {
		
		Champion body = championService.addDocument(id, mpFile);
		status = championService.getStatus();

		return ResponseEntity.status(status).body(body);
	}

	@GetMapping(path = "/champion/{id}")
	public ResponseEntity<?> getChampion(@PathVariable int id) {
		Champion body = championService.getChampion(id);
		status = championService.getStatus();

		return ResponseEntity.status(status).body(body);
	}

	@GetMapping(path = "/champion")
	public ResponseEntity<?> getAllChampions() {
		List<Champion> body = championService.getAllChampions();
		status = championService.getStatus();

		return ResponseEntity.status(status).body(body);
	}

	@GetMapping(path = "/champion/attack-dmg/desc")
	public ResponseEntity<?> getAllChampionsOrderedByAttackDamageDesc() {
		List<Champion> body = championService.getAllChampionsOrderedByAttackDamageDesc();
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
		body = championService.deleteChampion(sent);
		status = championService.getStatus();

		return ResponseEntity.status(status).body(body);
	}

}
