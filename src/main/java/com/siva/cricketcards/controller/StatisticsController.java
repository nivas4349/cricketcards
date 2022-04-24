package com.siva.cricketcards.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.siva.cricketcards.dto.PlayerStats;
import com.siva.cricketcards.service.StatisticsService;

/**
 * @author: Siva Srinivasa Pasam
 *
 */
@RestController("/statistics")
public class StatisticsController {

	@Autowired
	private StatisticsService statisticsService;

//	@Autowired
//    private CompressionService compressionService;

//	@GetMapping(produces = APPLICATION_JSON_UTF8_VALUE)
//	public PlayerStats getPlayerStats(@RequestParam("playerId") String playerId) {
////        byte[] compressedResponse = statisticsService.getPlayerStats(playerId);
////        return deCompressedResponse(compressedResponse);
//		return statisticsService.getPlayerStats(playerId);
//	}

	@GetMapping(produces = APPLICATION_JSON_UTF8_VALUE)
	public PlayerStats getAllPlayersStats() {
//        byte[] compressedResponse = statisticsService.getPlayerStats(playerId);
//        return deCompressedResponse(compressedResponse);
		String playerId = "sr:player:646278";
		return statisticsService.getPlayerStats(playerId);
	}

//	private String deCompressedResponse(byte[] compressedResponse) {
//        return compressionService.decompress(compressedResponse);
//    }
}
