package com.leagueOfLegends.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.LeagueOfLegends.controller.PlayerController;
import com.LeagueOfLegends.model.repository.PlayerRepository;
import com.LeagueOfLegends.service.impl.PlayerServiceImpl;

@ContextConfiguration(classes = PlayerController.class)
@WebMvcTest(PlayerController.class)
public class PlayerControllerTest {

	@Autowired
	private MockMvc mockMVC;

	@MockBean
	private PlayerServiceImpl playerService;

	@MockBean
	private PlayerRepository playerRepository;

	private final static String ROOT_PATH = "/lol/player";

	@Test
	public void getPlayersTest() throws Exception {
		Mockito.when(playerService.getStatus()).thenReturn(HttpStatus.OK);

		mockMVC.perform(get(ROOT_PATH)).andExpect(status().isOk());
	}

	@Test
	public void addPlayerTest() throws Exception {
		Mockito.when(playerService.getStatus()).thenReturn(HttpStatus.CREATED);
		
		mockMVC.perform(post(ROOT_PATH).accept(MediaType.APPLICATION_JSON_VALUE).contentType(MediaType.APPLICATION_JSON_VALUE)
					.content(	"{ \n" + 
								"    \"name\": \"David\",\n" + 
								"    \"nickname\": \"WaterLord\",\n" + 
								"    \"email\": \"test@gmail.com\"\n" + 
								"}"))
					.andExpect(status().isCreated());
	}
}
