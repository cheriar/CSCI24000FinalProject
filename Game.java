import java.io.*;
import java.util.*;

public class Game{
	Puzzle puzzle;
	Player[] players;
	int roundCounter;
	int playerTurn;

	public Game(){
		System.out.println("Wheel! Of! Fortune!");
		players = new Player[3];
		roundCounter = 0;
		playerTurn = 0;
		int i;
		for (i = 0; i < 3; i++){
			System.out.print("Player ");
			System.out.println(i + 1);
			players[i] = new Player();
		} // end for loop
		menu();
	} // end empty constructor

	public Game(boolean load){
		System.out.println("Welcome back to Wheel of Fortune!");
		players = new Player[3];
		if (load){
			try{
				FileInputStream fileInput = new FileInputStream("WheelOfFortune.dat");
				ObjectInputStream readObject = new ObjectInputStream(fileInput);
				int i;
				for (i = 0; i < 3; i++){
					players[i] = (Player)readObject.readObject();
				} // end for loop
			} catch (Exception e){
				System.out.println(e.getMessage());
			} // end try block
			roundCounter = players[0].getRoundCounter();
			menu();
		} // end if statement
	} // end constructor

	public void menu(){
		boolean bool = true;
		while (bool){
			Scanner input = new Scanner(System.in);
			System.out.println("Select an option:");
			System.out.println("	0) Play next round");
			System.out.println("	1) Quit without saving");
			System.out.println("	2) Save and quit");
			String response = input.nextLine();
			if (response.equals("0")){
				bool = false;
				int i;
				playerTurn = 0;
				for (i = 0; i < 3; i++){
					if (!players[i].getKeepGoing()){
                                		playerTurn = i + 1;
                                		if (playerTurn == 3){
                                        		playerTurn = 0;
                                		} // end if statement
					} // end if statement
					players[i].setPlayerTurn(playerTurn);
				} // end for loop
				round();
			} else if (response.equals("1")){
				bool = false;
				goodbye();
			} else if (response.equals("2")){
				bool = false;
				saveAndQuit();
			} else {
				System.out.println("I didn't get that, can you try again?");
			} // end if/else statement
		} // end while loop
	} // end menu method

	public void saveAndQuit(){
		try{
			File file = new File("WheelOfFortune.dat");
			file.delete();
			FileOutputStream fileOutput = new FileOutputStream("WheelOfFortune.dat");
			ObjectOutputStream saveObject = new ObjectOutputStream(fileOutput);
			int i;
			for (i = 0; i < 3; i++){
				saveObject.writeObject(players[i]);
			} // end for loop
		} catch (Exception e){
			System.out.println(e.getMessage());
		} // end try block
		goodbye();
	} // end saveAndQuit method

	public void goodbye(){
		System.out.println("Goodbye, folks! See you later!");
	} // end goodbye method

	public void round(){
		puzzle = new Puzzle();
		System.out.println("Round " + (players[0].getRoundCounter() + 1));
		int i;
		for (i = 0; i < 3; i++){
			players[i].setPuzzle(puzzle);
			players[i].setKeepGoing(true);
			playerTurn = players[i].getPlayerTurn();
		} // end for loop
		int j;
		while ((players[0].getKeepGoing()) && (players[1].getKeepGoing()) && (players[2].getKeepGoing())){
			players[playerTurn].menu();
			puzzle = players[playerTurn].getPuzzle();
			for (j = 0; j < 3; j++){
				players[j].setPuzzle(puzzle);
			} // end for loop
			playerTurn++;
			print();
			if (playerTurn == 3){
				playerTurn = 0;
			} // end if statement
		} // end while loop
		roundCounter++;
		players[0].setRoundCounter(roundCounter);
		if (roundCounter == 3){
			if((players[0].getBalance() > players[1].getBalance()) & (players[0].getBalance() > players[2].getBalance())){
				System.out.println(players[0].getName() + " wins!");
			} else if ((players[1].getBalance() > players[0].getBalance()) & (players[1].getBalance() > players[2].getBalance())){
                                System.out.println(players[1].getName() + " wins!");
			} else if ((players[2].getBalance() > players[0].getBalance()) & (players[2].getBalance() > players[1].getBalance())){
                                System.out.println(players[2].getName() + " wins!");
			} else {
				System.out.println("Tie!");
			} // end if/else statement
			File file = new File("WheelOfFortune.dat");
                        file.delete();
			goodbye();
		} else {
			menu();
		} // end if/else statement
	} // end round method

	public void print(){
		int i;
		for (i = 0; i < 3; i++){
			System.out.print(players[i].getName());
			System.out.print("'s balance: $");
			System.out.println(players[i].getBalance());
		} // end for loop
		System.out.println("");
		System.out.println("");
	} // end print method

	public static void main(String[] args){
		// check if WheelOfFortune.dat exists. if so, give user the option to continue saved game.
		File file = new File("WheelOfFortune.dat");
		Scanner input2 = new Scanner(System.in);
		if (file.exists()){
			boolean bool = true;
			while (bool){
				System.out.println("Select an option");
				System.out.println("	0) Load existing game");
				System.out.println("	1) Start new game");
				String response = input2.nextLine();
				if (response.equals("0")){
					bool = false;
					Game game = new Game(true);
				} else if (response.equals("1")){
					bool = false;
					Game game = new Game();
				} else {
					System.out.println("I didn't get that, can you try again?");
				} // end if/else statement
			} // end while loop
		} else {
			Game game = new Game();
		} // end if/else statement
	} // end main method
} // end class





