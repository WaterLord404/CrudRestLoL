package com.LeagueOfLegends.model.entity.dto;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.LeagueOfLegends.model.entity.Player;

@Component
public class PlayerDTOConverter {

	@Autowired
	private PasswordEncoder passwordEncoder;

	public Player playerDTOToPlayer (PlayerDTO dto) {
		Player player = new Player();
		
		player.setName(dto.getName());
		player.setNickname(dto.getNickname());
		player.setPassword(passwordEncoder.encode(dto.getPassword()));
		player.setEmail(dto.getEmail());
		
		player.setRiotPoints(0);
		player.setBlueEssence(0);
		player.setOrangeEssence(0);
		player.setActive(true);
		player.setCreationDate(LocalDate.now());
		player.setLastTimeActiveDate(LocalDate.now());
		player.setChampions(new ArrayList<>());
		
		return player;
	}
	
	public PlayerDTO playerToPlayerDTO(Player player) {
		PlayerDTO dto = new PlayerDTO();
		
		dto.setName(player.getName());
		dto.setEmail(player.getEmail());
		dto.setNickname(player.getNickname());
		dto.setRiotPoints(player.getRiotPoints());
		
		return dto;
	}
	
}
