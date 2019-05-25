package com.siva.cricketcards.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import java.io.IOException;

import javax.validation.constraints.NotNull;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.siva.cricketcards.client.SourceDataClient;
import com.siva.cricketcards.client.dto.SourceDataRequest;
import com.siva.cricketcards.constants.CricketCardsConstants;
import com.siva.cricketcards.dto.PlayerStats;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class StatisticsEndToEndTest {

	private static final String TEXT_PLAIN_VALUE_UTF8_VALUE = "text/plain; charset=UTF-8";
	private static final String URI = "http://analytics05.cricket.net/xquery/espn/player";
	private static final int SACHIN_PLAYER_ID = 1934;
//	private static final int DHONI_PLAYER_ID = 7593;
	private static final String SACHIN_RESPONSE = "{\"matches\":463,\"batsman/innings\":452,\"sixes\":195,\"hs\":\"200*\","
			+ "\"tenW\":0,\"bowler/avg\":44.48051834106445,\"captain\":146,\"mom\":62,\"mos\":15,\"fourW\":4,\"threeW\":8,"
			+ "\"hundreds\":49,\"bowler/wickets\":154,\"bowler/conceded\":6850,\"bowler/sr\":52.298702239990234,"
			+ "\"bowler/maidens\":24,\"fifties\":96,\"fours\":2016,\"bowler/innings\":270,\"avg\":44.832116788321166,"
			+ "\"economy\":5.1031,\"fiveW\":2,\"sr\":86.23578415313334,\"batsman/runs\":18426}";

	private static ObjectMapper objectMapper = new ObjectMapper();
	private static PlayerStats sachinObj;
	static {
		try {
			sachinObj = objectMapper.readValue(SACHIN_RESPONSE, PlayerStats.class);
		} catch (IOException e) {
			Assert.fail();
		}
	}

	SourceDataRequest sdr = new SourceDataRequest(CricketCardsConstants.TYPE.PLAYER_SUMMARY.getValue(),
			CricketCardsConstants.FORMAT.odi.name(), SACHIN_PLAYER_ID);

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	SourceDataClient sourceDataClient;

	@Test
	public void contextLoads() {
	}

	@Test
	public void shouldGetPlayerStatsDirectlyFromSourceByAvailablePlayerId() {
		ResponseEntity<String> responseEntity = restTemplate.postForEntity(URI, getHttpEntity(sdr), String.class);
		vaidateResponse(responseEntity);
	}

	@Test
	public void shouldGetPlayerStatsFromSourceClientByAvailablePlayerId() {
		ResponseEntity<String> responseEntity = sourceDataClient.getPlayerStats(sdr);
		vaidateResponse(responseEntity);
	}

	private void vaidateResponse(ResponseEntity<String> responseEntity) {
		try {
			assertNotNull(responseEntity);
			assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
			assertEquals(TEXT_PLAIN_VALUE_UTF8_VALUE, responseEntity.getHeaders().get(HttpHeaders.CONTENT_TYPE).get(0));
			PlayerStats playerStats = objectMapper.readValue(responseEntity.getBody(), PlayerStats.class);
			assertEquals(sachinObj, playerStats);
		} catch (IOException e) {
			Assert.fail();
		}
	}

	@NotNull
	private HttpEntity<?> getHttpEntity() {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
		httpHeaders.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_UTF8_VALUE);

		return new HttpEntity<>(httpHeaders);
	}

	@NotNull
	private HttpEntity<SourceDataRequest> getHttpEntity(SourceDataRequest sourceDataRequest) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
		httpHeaders.add(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN_VALUE);

		return new HttpEntity<>(sourceDataRequest, httpHeaders);
	}

}
