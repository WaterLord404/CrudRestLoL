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

import com.LeagueOfLegends.entity.Skin;
import com.LeagueOfLegends.rest.service.ChampionService;
import com.LeagueOfLegends.rest.service.SkinService;

@RestController
@RequestMapping(path = "/lol")
public class SkinController {
	
	@Autowired
	private ChampionService championService;
	
	@Autowired
	private SkinService skinService;

	private String body = new String();
	private HttpStatus status = null;
	
	@PostMapping(path = "/skin")
	public ResponseEntity<?> addSkin(@RequestBody Skin sent) {
		body = skinService.addSkin(sent, championService.getChampions());
		status = skinService.getStatus();

		return ResponseEntity.status(status).body(body);
	}

	@GetMapping(path = "/skin/{id}")
	public ResponseEntity<?> getSkin(@PathVariable int id) {
		body = skinService.getSkin(id);
		status = skinService.getStatus();

		return ResponseEntity.status(status).body(body);
	}

	@GetMapping(path = "/skin")
	public ResponseEntity<?> getAllSkins() {
		body =  skinService.getAllSkins();
		status = skinService.getStatus();

		return ResponseEntity.status(status).body(body);
	}
	
	@PutMapping(path = "/skin")
	public ResponseEntity<?> putSkin(@RequestBody Skin sent) {
		body = skinService.putSkin(sent);
		status = skinService.getStatus();

		return ResponseEntity.status(status).body(body);
	}

	@DeleteMapping(path = "/skin")
	public ResponseEntity<?> deleteSkin(@RequestBody Skin sent) {
		body = skinService.deleteSkin(sent);
		status = skinService.getStatus();

		return ResponseEntity.status(status).body(body);
	}

}
