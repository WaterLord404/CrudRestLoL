package com.leagueOfLegends.controller.endpoint;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;

import com.LeagueOfLegends.LeagueOfLegendsApplication;
import com.LeagueOfLegends.model.entity.Player;

@ContextConfiguration(classes = LeagueOfLegendsApplication.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PlayercontrollerEPTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate template;

	private final String BASE_URL = "http://localhost:%s/lol/player";

	@Test
	public void getPlayersTest() {
		assert (template.getForEntity(getURL(), Player.class).getBody() == null);
	}

	@Test
	public void addPlayerTest() {
		Integer id = template.postForObject(getURL(), new Player("Test", "test", "tesssT"), Integer.class);
		
		assert(template.getForEntity(getURL()+"/"+id, Player.class).getBody()!=null);

	}
	
	private String getURL() {
		return String.format(BASE_URL, port);
	}
}
