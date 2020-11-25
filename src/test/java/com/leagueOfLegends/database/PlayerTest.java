package com.leagueOfLegends.database;

import static org.mockito.Mockito.mock; 
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.LeagueOfLegends.model.entity.Player;
import com.LeagueOfLegends.model.repository.PlayerRepository;
import com.LeagueOfLegends.service.impl.PlayerServiceImpl;

public class PlayerTest {

	private PlayerServiceImpl sut;
	
	private PlayerRepository mockedRepo;
	
	private Player mokedPlayer = new Player("Test","David","test@gmail.com");
	
	@BeforeEach
	private void init() {
		mockedRepo = mock(PlayerRepository.class);
		mokedPlayer = mock(Player.class);
	
		sut = new PlayerServiceImpl(mockedRepo);
	}
	
	@Test
	public void updatePlayerTest() {
		Player playerSent = new Player("Test", "Cambiado", "test@@@@@@@");
	
		when(mockedRepo.findPlayerByName(playerSent.getName())).thenReturn(mokedPlayer);

		sut.putPlayer(playerSent);
		
		assert(playerSent.getNickname() == "Cambiado");
	}
}
