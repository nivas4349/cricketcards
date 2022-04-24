package com.siva.cricketcards.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Experiments {
//	private static final String URI = "mysql://vr5egrdrlrw8x056:btqf8o6xqrh6vl36@etdq12exrvdjisg6.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/mf4u7k9sy1h98iiy";
//
//	private static final String HOST = "etdq12exrvdjisg6.cbetxkdyhwsb.us-east-1.rds.amazonaws.com";
//	private static final String PORT = "3306";
//	private static final String DB = "mf4u7k9sy1h98iiy";
//	private static final String USER = "vr5egrdrlrw8x056";
//	private static final String PWD = "btqf8o6xqrh6vl36";
//	private static final String URL = "jdbc:mysql//" + HOST + ":" + PORT + "/" + DB;
//
//	public static void main(String[] args) {
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection con = getConnection();
//			Statement stmt = con.createStatement();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static Connection getConnection() throws URISyntaxException, SQLException {
//		URI jdbUri = new URI(URI);
//
//		String username = jdbUri.getUserInfo().split(":")[0];
//		String password = jdbUri.getUserInfo().split(":")[1];
//		String port = String.valueOf(jdbUri.getPort());
//		String jdbUrl = "jdbc:mysql://" + jdbUri.getHost() + ":" + port + jdbUri.getPath();
//
//		return DriverManager.getConnection(jdbUrl, username, password);
//	}
//
}
