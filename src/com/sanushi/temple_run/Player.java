/**
 * 
 */
package com.sanushi.temple_run;

import java.util.ArrayList;

/**
 * @author Sanushi Salgado
 *
 */
public class Player {
	
	private static int playerNumber;
	
	private String name;
	
	private int age;
	
	private int numberOfCoinsCollected;
	
	private double score;
	
	private double distanceReached;
	
	protected static ArrayList<Player> allPlayers = new ArrayList<>();
	
	
	public Player(String name, int age, int numberOfCoinsCollected, double score, double distanceReached) {
		this.name = name;
		this.age = age;
		this.numberOfCoinsCollected = numberOfCoinsCollected;
		this.score = score;
		this.distanceReached = distanceReached;
		playerNumber++;
	}
	

	public double getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public double getDistanceReached() {
		return distanceReached;
	}

	public void setDistanceReached(int distanceReached) {
		this.distanceReached = distanceReached;
	}

	public static int getPlayerNumber() {
		return playerNumber;
	}

	public static void setPlayerNumber(int playerNumber) {
		Player.playerNumber = playerNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public int getNumberOfCoinsCollected() {
		return numberOfCoinsCollected;
	}

	public void setNumberOfCoinsCollected(int numberOfCoinsCollected) {
		this.numberOfCoinsCollected = numberOfCoinsCollected;
	}
	
}
