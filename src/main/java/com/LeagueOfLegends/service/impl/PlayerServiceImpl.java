package com.LeagueOfLegends.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.LeagueOfLegends.model.entity.Player;
import com.LeagueOfLegends.model.entity.dto.PlayerDTO;
import com.LeagueOfLegends.model.entity.dto.PlayerDTOConverter;
import com.LeagueOfLegends.model.repository.PlayerRepository;

@Service
public class PlayerServiceImpl {

	private String response = new String();
	private HttpStatus status;
	
	private PlayerRepository playerRepository;	

	@Autowired
	public PlayerServiceImpl(PlayerRepository mockedRepo) {
		this.playerRepository = mockedRepo;
	}
	
	@Autowired
	private PlayerDTOConverter converter;

	public PlayerDTO addPlayer(PlayerDTO playerDTO) {
		status = HttpStatus.CONFLICT;
		
		// DTO to player
		Player player = converter.playerDTOToPlayer(playerDTO);

		//Persist data
		playerRepository.save(player);

		status = HttpStatus.CREATED;
		
		return converter.playerToPlayerDTO(player);
	}

	public List<Player> getAllPlayers() {
		status = HttpStatus.NOT_FOUND;
		List<Player> players = null;
		
		if (playerRepository.findAll().spliterator().getExactSizeIfKnown() != 0) {
			players = (List<Player>) playerRepository.findAll();
			status = HttpStatus.OK;
		}
		return players;
	}
	
	public List<Player> getAllPlayerWitchNameStartsWith(String string) {
		status = HttpStatus.NOT_FOUND;
		List<Player> players = null;
		
		if (playerRepository.findAll().spliterator().getExactSizeIfKnown() != 0) {
			players = (List<Player>) playerRepository.findAllPlayerWitchNameStartsWith(string);
			status = HttpStatus.OK;
		}
		return players;
	}
	
	public PlayerDTO getPlayer(int id) {
		status = HttpStatus.NOT_FOUND;
		PlayerDTO dto = null;
		
		if (playerRepository.findPlayerById(id) != null) {
			
			// player to DTO
			dto = converter.playerToPlayerDTO(playerRepository.findPlayerById(id));
			
			status = HttpStatus.OK;
		}
		return dto;
	}

	public String putPlayer(Player sent) {
		response = "Jugador no encontrado";
		status = HttpStatus.NOT_FOUND;

		if (playerRepository.findPlayerByName(sent.getName()) != null) {
			
			playerRepository.findPlayerByName(sent.getName()).setNickname(sent.getNickname());
			playerRepository.findPlayerByName(sent.getName()).setEmail(sent.getEmail());

			//Persist data
			playerRepository.save(playerRepository.findPlayerById(sent.getId()));
			
			response = "Jugador actualizado correctamente";
			status = HttpStatus.OK;
		}
		return response;
	}

	public String deletePlayer(Player sent) {
		response = "Player no encontrado";
		status = HttpStatus.NOT_FOUND;
		
		if (playerRepository.findPlayerById(sent.getId()) != null) {
			playerRepository.delete(playerRepository.findPlayerById(sent.getId()));
			response = "Player borrado correctamente";
			status = HttpStatus.OK;
		}
		return response;
	}

	public HttpStatus getStatus() {
		return status;
	}



}
