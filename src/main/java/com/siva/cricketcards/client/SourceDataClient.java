package com.siva.cricketcards.client;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.siva.cricketcards.client.config.RetryClientConfiguration;
import com.siva.cricketcards.client.dto.SourceDataRequest;

/**
 * @author: Siva Srinivasa Pasam
 *
 */
@FeignClient(url = "${datasource.api.url}", name = "ISourceDataClient" , configuration = RetryClientConfiguration.class)
public interface SourceDataClient {

	@PostMapping(/*headers = {
			"apiKey=${reprice.api.apiKey}" }, */consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
	ResponseEntity<String> getPlayerStats(@RequestBody SourceDataRequest sourceDataRequest);

}