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
	
	private Player mokedPlayer;
	
	@BeforeEach
	private void init() {
		sut = new PlayerServiceImpl(mockedRepo);
		mokedPlayer = mock(Player.class);
		mockedRepo = mock(PlayerRepository.class);
	}
	
	@Test
	private void updatePlayerTest() {
		Player playerSent = new Player(1,"Test", "Player", "test@player");
		sut.putPlayer(playerSent);
		
		when(mockedRepo.findPlayerById(playerSent.getId())).thenReturn(playerSent);
		
	}
}
