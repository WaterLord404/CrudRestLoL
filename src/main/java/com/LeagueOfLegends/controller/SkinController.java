package com.LeagueOfLegends.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/lol")
public class SkinController {
	
//	@Autowired
//	private SkinService skinService;
//
//	private String body = new String();
//	private HttpStatus status = null;
	
//	@PostMapping(path = "/skin")
//	public ResponseEntity<?> addSkin(@RequestBody Skin sent) {
//		body = skinService.addSkin(sent,champion);
//		status = skinService.getStatus();
//
//		return ResponseEntity.status(status).body(body);
//	}
//
//	@GetMapping(path = "/skin/{id}")
//	public ResponseEntity<?> getSkin(@PathVariable int id) {
//		body = skinService.getSkin(id);
//		status = skinService.getStatus();
//
//		return ResponseEntity.status(status).body(body);
//	}
//
//	@GetMapping(path = "/skin")
//	public ResponseEntity<?> getAllSkins() {
//		body =  skinService.getAllSkins();
//		status = skinService.getStatus();
//
//		return ResponseEntity.status(status).body(body);
//	}
//	
//	@PutMapping(path = "/skin")
//	public ResponseEntity<?> putSkin(@RequestBody Skin sent) {
//		body = skinService.putSkin(sent);
//		status = skinService.getStatus();
//
//		return ResponseEntity.status(status).body(body);
//	}
//
//	@DeleteMapping(path = "/skin")
//	public ResponseEntity<?> deleteSkin(@RequestBody Skin sent) {
//		body = skinService.deleteSkin(sent);
//		status = skinService.getStatus();
//
//		return ResponseEntity.status(status).body(body);
//	}

}
