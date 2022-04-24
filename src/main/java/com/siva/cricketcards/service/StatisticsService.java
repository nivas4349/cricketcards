package com.siva.cricketcards.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.siva.cricketcards.client.SourceDataClient;
//import com.siva.cricketcards.client.dto.SourceDataRequest;
import com.siva.cricketcards.constants.CricketCardsConstants;
import com.siva.cricketcards.dto.PlayerStats;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: Siva Srinivasa Pasam
 *
 */
@Component
@Slf4j
public class StatisticsService {

	@Autowired
	SourceDataClient sourceDataClient;

	public PlayerStats getPlayerStats(String playerId) {

		String playerStatsStr = sourceDataClient.getPlayerStats(playerId);
//		.getBody();
		ObjectMapper mapper = new ObjectMapper();
		PlayerStats playerStats = null;
//		try {
			log.info("playerStats==="+playerStatsStr);
			//			playerStats = mapper.readValue(playerStatsStr, PlayerStats.class);
//		} catch (IOException e) {
//			log.error("Error while getting player stats for playerId : " + playerId, e);
//		}
		if (playerStats.getMatches() == 0) {
			throw new RuntimeException("Player Not Found");
		}
		return playerStats;
	}
	
//	public List<PlayerStats> getPlayersStats() {
//		
//	}
}
