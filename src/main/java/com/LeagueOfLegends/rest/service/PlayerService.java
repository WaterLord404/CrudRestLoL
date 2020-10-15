package com.LeagueOfLegends.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.LeagueOfLegends.entity.Champion;
import com.LeagueOfLegends.entity.Player;

@Service
public class PlayerService {
	private List<Player> players = new ArrayList<>();
	private String response = new String();
	private HttpStatus status;

	public String addPlayer(Player sent) {
		response = "Ya existe ese jugador";
		status = HttpStatus.CONFLICT;

		Player player = new Player(sent.getId(), sent.getName(), sent.getNickname(), sent.getEmail());

		if (!players.contains(player)) {
			players.add(player);
			status = HttpStatus.CREATED;
			response = "Jugador creado correctamente";
		}

		return response;
	}

	public String getPlayer(int id) {
		response = "Jugador no encontrado";
		status = HttpStatus.NOT_FOUND;

		for (Player i : players) {
			if (i.getId() == id) {
				response = i.toString();
				status = HttpStatus.OK;
			}
		}

		return response;
	}

	public String getAllPlayers() {
		response = "No existen jugadores";
		status = HttpStatus.NOT_FOUND;

		if (players != null && !players.isEmpty()) {
			response = players.toString();
			status = HttpStatus.OK;
		}
		return response;
	}

	public String putPlayer(Player sent) {
		response = "Jugador no encontrado";
		status = HttpStatus.NOT_FOUND;

		for (Player i : players) {
			if (i.getId() == sent.getId()) {
				i.setNickname(sent.getNickname());
				i.setEmail(sent.getEmail());

				response = "Jugador actualizado correctamente";
				status = HttpStatus.OK;
			}
		}

		return response;
	}

	public String deletePlayer(Player sent, List<Champion> champions) {
		response = "Player no encontrado";
		status = HttpStatus.NOT_FOUND;
		
		Player player = null;
		Player aux = null;
		
		if (players != null && !players.isEmpty()) {
			for (Player i : players) {
				if (i.getId() == sent.getId()) {
					player = i;
				}
			}
		}
			
		if(champions != null && !champions.isEmpty()) {
			for (Champion i : champions) {
				if(i.getPlayers() != null && !i.getPlayers().isEmpty()) {
					for (Player j : i.getPlayers()) {
						if (j.getId() == sent.getId()) {
							aux = j;
						}
					}
					i.getPlayers().remove(aux);
				}
			}
			
		}
		
		if(player != null) {
			players.remove(player);
			response = "Player borrado correctamente";
			status = HttpStatus.OK;
		}
		
		return response;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public HttpStatus getStatus() {
		return status;
	}

}
