package com.siva.cricketcards.constants;

/**
 * @author: Siva Srinivasa Pasam
 *
 */
public class CricketCardsConstants {
	public static final String PLAYER_ID_PATH = "{playerId}";
	public static final String PLAYER_ID = "playerId";
	public static final String API_KEY = "api_key";

	public enum FORMAT {
		odi, t20, t20i, test
	}

	public enum TYPE {
		PLAYER_PROFILE("player-profile"), PLAYER_SUMMARY("player-summary");

		private String value;

		private TYPE(String value) {
			this.value = value;

		}

		public String getValue() {
			return value;
		}
	}
}
