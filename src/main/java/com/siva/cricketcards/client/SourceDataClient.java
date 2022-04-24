package com.siva.cricketcards.client;

import static com.siva.cricketcards.constants.CricketCardsConstants.API_KEY;
import static com.siva.cricketcards.constants.CricketCardsConstants.PLAYER_ID;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.siva.cricketcards.client.config.RetryClientConfiguration;
//import com.siva.cricketcards.client.dto.SourceDataRequest;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: Siva Srinivasa Pasam
 *
 */
@FeignClient(url = "${datasource.api.url}", name = "ISourceDataClient" , configuration = RetryClientConfiguration.class)
public interface SourceDataClient {

	@GetMapping(/*headers = {
			"apiKey=${reprice.api.apiKey}" }, */consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
	String getPlayerStats(@PathVariable(name = PLAYER_ID) String playerId);
//	ResponseEntity<String> getPlayerStats(@PathVariable(name = PLAYER_ID) String playerId);
}
