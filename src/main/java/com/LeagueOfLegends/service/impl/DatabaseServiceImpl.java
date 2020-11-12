package com.LeagueOfLegends.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.LeagueOfLegends.model.repository.ChampionRepository;
import com.LeagueOfLegends.model.repository.PlayerRepository;

@Service
public class DatabaseServiceImpl {

	private String response = new String();
	private HttpStatus status;

	@Autowired
	private ChampionRepository championRepository;
	
	@Autowired
	private PlayerRepository playerRepository;
	
	public String addChampionToPlayer(String championName, int playerID) {
		response = "No se ha encontrado el jugador o el campeon";
		status = HttpStatus.NOT_FOUND;
		
		//si el player existe y el campeon
		if(championRepository.findChampionByName(championName) != null && playerRepository.findPlayerById(playerID) != null) {
			
			//coge la lista de champion del player y le añade el nuevo
			playerRepository.findPlayerById(playerID).getchampions().add(championRepository.findChampionByName(championName).get(0));
			
			//persist
			playerRepository.save(playerRepository.findPlayerById(playerID));
			
			response = "Creado correctamente";
			status = HttpStatus.CREATED;
		}
		
		return response;
	}

	public HttpStatus getStatus() {
		return status;
	}

}
