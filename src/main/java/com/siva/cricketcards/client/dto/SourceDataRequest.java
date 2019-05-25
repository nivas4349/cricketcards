package com.siva.cricketcards.client.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Siva Srinivasa Pasam
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SourceDataRequest {

	@JsonProperty("type")
	@NotNull
    private String type;
	
	@JsonProperty("format")
	@NotNull
    private String format;
    
	@JsonProperty("player_id")
	@NotNull
    private int playerId;
	
}
