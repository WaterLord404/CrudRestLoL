package com.LeagueOfLegends.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.LeagueOfLegends.entity.Champion;
import com.LeagueOfLegends.entity.Player;

@Service
public class DatabaseService {

	private String response = new String();
	private HttpStatus status;
	private List<String> ids = new ArrayList<String>();
	
	public String addChampionToPlayer(List<Champion> champions, List<Player> players, Player playerSent, int idChampionSent) {
		boolean encontradoId = false;
		
		response = "Campeon o Jugador no encontrado";
		status = HttpStatus.NOT_FOUND;

		Player player = null;
		Champion champion = null;
		
		for (Player i : players) {
			if (i.getId() == playerSent.getId()) {
				player = i;
			}
		}
		
		for (Champion i : champions) {
			if (i.getId() == idChampionSent) {
				champion = i;
			}
		}
		
		for (String i : ids) {
			if ((Integer.toString(idChampionSent) + Integer.toString(player.getId())).equals(i)){
				encontradoId = true;
			}
		}
		
		if (encontradoId == false) {
			if (champion != null && player != null) {
				ids.add(Integer.toString(idChampionSent) + Integer.toString(player.getId()));
				
				player.getChampionsId().add(idChampionSent);
				champion.getPlayers().add(player);
				status = HttpStatus.CREATED;
				response = "Campeon añadido a jugador correctamente";
			}
		} else {
			status = HttpStatus.CONFLICT;
			response = "Ya existe ese campeon con tal jugador";
		}
		
		return response;
	}

	public HttpStatus getStatus() {
		return status;
	}

	
}
