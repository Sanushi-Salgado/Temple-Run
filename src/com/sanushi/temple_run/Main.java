package com.sanushi.temple_run;

import java.util.Scanner;

public class Main implements GameManager {

	Scanner sc = new Scanner(System.in);

	@Override
	public void getDetails() {
		System.out.print("Enter competitor name            : ");
		String name = sc.next();
		sc.nextLine();

		System.out.print("Enter competitor age             : ");
		int age = sc.nextInt();

		System.out.print("Enter number of coins collected  : ");
		int coinsCollected = sc.nextInt();

		System.out.print("Enter the score achieved         : ");
		double score = sc.nextDouble();

		System.out.print("Enter the distance reached       : ");
		double distanceReached = sc.nextDouble();

		// Add the new player
		Player player = new Player(name, age, coinsCollected, score, distanceReached);
		Player.allPlayers.add(player);

		System.out.println("\nDo you want to enter another player? (Enter Y/N)");
		String answer = sc.next();

		if (answer.equalsIgnoreCase("N"))
			displayMenu();

		do {
			getDetails();
		} while (answer.equalsIgnoreCase("Y"));

	}
	

	@Override
	public void displayMenu() {
		System.out.println("\n\nEnter 1 to view all competitor details");
		System.out.println("Enter 2 to view a selected competitors details");
		System.out.println("Enter 3 to view all three winners");
		System.out.println("Enter 4 to view a selected winner");

		int optionNo = sc.nextInt();
		while (optionNo < 1 || optionNo > 4) {
			System.out.println("Please enter a valid option number!");
			optionNo = sc.nextInt();
		}

		switch (optionNo) {
			case 1:
				getAllCompetitorDetails();
				break;
			case 2:
				getSelectedCompetitorDetails();
				break;
			case 3:
				viewAllThreeWinners();
				break;
			case 4:
				viewSelectedWinner();
				break;
		}

	}
	

	@Override
	public void getAllCompetitorDetails() {
		System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s \n", "Player No", "Name", "Age", "Coins collected",
				"Score Achieved", "Distance reached");

		for (int i = 0; i < Player.allPlayers.size(); i++) {
			System.out.printf("%-12d %-12s %-12d %-12d %-12.2f %-12.2f", i + 1, Player.allPlayers.get(i).getName(),
					Player.allPlayers.get(i).getAge(), Player.allPlayers.get(i).getNumberOfCoinsCollected(),
					Player.allPlayers.get(i).getScore(), Player.allPlayers.get(i).getDistanceReached());
		}

		displayMenu();
	}
	

	@Override
	public void getSelectedCompetitorDetails() {
		boolean isFound = false;
		
		do {

			System.out.print("Enter player no: ");
			int playerNo = sc.nextInt();
			
			for (int i = 0; i < Player.allPlayers.size(); i++) {
				if ((i + 1) == playerNo) {
					isFound = true;
					Player player = Player.allPlayers.get(i);
					System.out.println("Competitor No    : " + (i + 1));
					printPlayerDetails( player );
				}

				break;
			}
			
			if(!isFound)
				 System.out.println("!!!!!! Player does not exist. Please enter a valid number. !!!!!!\n");

		} while(!isFound);

		displayMenu();

	}
	
	
	public void getPlayerWithHighestScore() {
		double max = Player.allPlayers.get(0).getScore();
		int playerNumber = 0;
		
		for(int i=0; i<Player.allPlayers.size(); i++) {
			if( Player.allPlayers.get(i).getScore() > max ) {
				max =  Player.allPlayers.get(i).getScore();
				playerNumber = i;
			}
			
		}
		
		System.out.println("*************Competior with the highest score**********************");
		Player player = Player.allPlayers.get(playerNumber);
		System.out.println("Competitor No    : " + playerNumber);
		printPlayerDetails( player );	
	}
	
	
	public void getPlayerWithHighestCoins() {
		double max = Player.allPlayers.get(0).getNumberOfCoinsCollected();
		int playerNumber = 0;
		
		for(int i=0; i<Player.allPlayers.size(); i++) {
			if( Player.allPlayers.get(i).getScore() > max ) {
				max =  Player.allPlayers.get(i).getNumberOfCoinsCollected();
				playerNumber = i;
			}
			
		}
		
		System.out.println("*****Competior who collected the maximum number of gold coins******");
		Player player = Player.allPlayers.get(playerNumber);
		System.out.println("Competitor No    : " + playerNumber);
		printPlayerDetails( player );
	} 
	
	
	public void getPlayerWithHighestDistance() {
		double max = Player.allPlayers.get(0).getDistanceReached();
		int playerNumber = 0;
		
		for(int i=0; i<Player.allPlayers.size(); i++) {
			if( Player.allPlayers.get(i).getScore() > max ) {
				max =  Player.allPlayers.get(i).getDistanceReached();
				playerNumber = i;
			}
		}
		
		System.out.println("***************Competior who ran the maximum distance***************");
		Player player = Player.allPlayers.get(playerNumber);
		System.out.println("Competitor No    : " + playerNumber);
		printPlayerDetails( player );

	} 
	
	
	public void printPlayerDetails(Player player) {
		System.out.println("Name             : " + player.getName());
		System.out.println("Age              : " + player.getAge());
		System.out.println("Score Achieved   : " + player.getScore());
		System.out.println("Coins Collected  : " + player.getNumberOfCoinsCollected());
		System.out.println("Distance Reached : " + player.getDistanceReached());
		System.out.println("*******************************************************************\n\n");
	}
	

	@Override
	public void viewAllThreeWinners() {
		getPlayerWithHighestScore();

		getPlayerWithHighestCoins();
		
		getPlayerWithHighestDistance();
		
		displayMenu();
	}
	

	@Override
	public void viewSelectedWinner() {
		System.out.println("Enter 1 to display player with the highest score");
		System.out.println("Enter 2 to display player collected the maximum number of gold coins");
		System.out.println("Enter 3 to display player who ran the maximum distance");

		int optionNo = sc.nextInt();
		while (optionNo < 1 || optionNo > 4) {
			System.out.println("Please enter a valid option number!");
			optionNo = sc.nextInt();
		}

		switch (optionNo) {
			case 1:
				getPlayerWithHighestScore();
				break;
	
			case 2:
				getPlayerWithHighestCoins();
				break;
	
			case 3:
				getPlayerWithHighestDistance();
				break;
		}

		displayMenu();

	}

	
	public static void main(String[] args) {
		new Main().getDetails();
	}

}
