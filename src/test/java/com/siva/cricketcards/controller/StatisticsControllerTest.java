package com.siva.cricketcards.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;

/**
 * @author: Siva Srinivasa Pasam
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureMockMvc
public class StatisticsControllerTest {

	private static final String SACHIN_PLAYER_ID = "1934";
	// TODO : use Taken based authentication or oAuth for Testing
	private static final String USER_NAME = "siva";
	private static final String PASSWORD = "lakshmi4349";
	private static final String SACHIN_RESPONSE = "{\"matches\":463,\"batsman/innings\":452,\"sixes\":195,\"hs\":\"200*\","
			+ "\"tenW\":0,\"bowler/avg\":44.48051834106445,\"captain\":146,\"mom\":62,\"mos\":15,\"fourW\":4,\"threeW\":8,"
			+ "\"hundreds\":49,\"bowler/wickets\":154,\"bowler/conceded\":6850,\"bowler/sr\":52.298702239990234,"
			+ "\"bowler/maidens\":24,\"fifties\":96,\"fours\":2016,\"bowler/innings\":270,\"avg\":44.832116788321166,"
			+ "\"economy\":5.1031,\"fiveW\":2,\"sr\":86.23578415313334,\"batsman/runs\":18426}";

	@Autowired
	private MockMvc mvc;

	@Test
	public void shouldGetPlayerStatsFromControllerByAvailablePlayerId() throws Exception {
		MockHttpServletResponse response = mvc
				.perform(get("/statistics?").param("playerId", SACHIN_PLAYER_ID)
						.with(user(USER_NAME).password(PASSWORD)).accept(MediaType.APPLICATION_JSON))
				.andReturn().getResponse();
		assertNotNull(response);
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		assertThat(response.getContentAsString()).isEqualTo(SACHIN_RESPONSE);
	}
}
