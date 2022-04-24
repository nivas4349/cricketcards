package com.siva.cricketcards.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author: Siva Srinivasa Pasam
 *
 */
@Data
public class PlayerStats {
//TODO : Mark all the properties which can be null  

	@NotNull
	//matches = 0 means invalid object
    private int matches;
	
	@JsonProperty("batsman/innings")
	@NotNull
	private int batsmanInnings;
	
	@NotNull
	private int sixes;
	
	@JsonProperty("hs")
	@NotNull
	private String highestScore;
	
	@JsonProperty("tenW")
	@NotNull
	private int tenWickets;
	
	@JsonProperty("bowler/avg")
	@NotNull
	private double bowlingAverage;
	
	@JsonProperty("captain")
	@NotNull
	private int captainMatches;
	
	@JsonProperty("mom")
	@NotNull
	private int manOfTheMatches;
	
	@JsonProperty("mos")
	@NotNull
	private int manOfTheSerieses;
	
	@JsonProperty("fourW")
	@NotNull
	private int fourWickets;
	
	@JsonProperty("threeW")
	@NotNull
	private int threeWickets;
	
	@NotNull
    private int hundreds;
	
	@JsonProperty("bowler/wickets")
	@NotNull
    private int wickets;
	
	@JsonProperty("bowler/conceded")
	@NotNull
    private int bowlerConcededRuns;
	
	@JsonProperty("bowler/sr")
	@NotNull
    private double bowlingStrikeRate;
	
	@JsonProperty("bowler/maidens")
	@NotNull
    private int bowlerMaidens;
	
	@NotNull
    private int fifties;
	
	@NotNull
    private int fours;

	@JsonProperty("bowler/innings")
	@NotNull
	private int bowlerInnings;
	
	@JsonProperty("avg")
	@NotNull
    private double battingAverage;
	
	@NotNull
    private float economy;
	
	@JsonProperty("fiveW")
	@NotNull
    private int fiveWickets;
	
	@JsonProperty("sr")
	@NotNull
    private double battingStrikeRate;

	@JsonProperty("batsman/runs")
	@NotNull
	private int runs;
	
}
