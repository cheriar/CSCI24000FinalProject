import java.io.*;
import java.util.*;

public class Player implements Serializable{
	int balance;
	String name;
	Wheel wheel;
	boolean keepGoing;
	boolean menuKeepGoing;
	Puzzle puzzle;
	int playerTurn;
	int roundCounter;

	public Player(){
		Scanner input = new Scanner(System.in);
		System.out.print("What is your name? ");
		name = input.nextLine();
		wheel = new Wheel();
		// puzzle = new Puzzle(); // just for test harness
	} // end constructor

	public String getName(){
		return name;
	} // end getName

	public void menu(){
		keepGoing = true;
		menuKeepGoing = true;
		Scanner response = new Scanner(System.in);
		while (menuKeepGoing){
			print();
			System.out.println("Select what you want to do:");
			System.out.println("	0) Buy a vowel");
			System.out.println("	1) Solve the puzzle");
			System.out.println("	2) Spin the wheel");
			String input = response.nextLine();
			if (input.equals("0")){
				buyVowel();
			} else if (input.equals("1")){
				solve();
			} else if (input.equals("2")){
				int wedgeType = wheel.spin(balance);
				if (wedgeType == 1){
					menuKeepGoing = wheel.loseATurn.stillYourTurn();
				} else if (wedgeType == 2){
					menuKeepGoing = wheel.bankrupt.stillYourTurn();
					balance = balance + wheel.bankrupt.getCash();
				} else if (wedgeType == 3){
					guessConsonant();
				} // end if/else statement
			} else {
				System.out.println("I didn't get that, can you try again?");
			} // end if/else statement
		} // end while loop
	} // end menu method

	public void guessConsonant(){
		boolean whileBoolean = true;
		Scanner response = new Scanner(System.in);
		while (whileBoolean){
			System.out.print("Guess a consonant: ");
			String guess = response.nextLine();
			guess = guess.trim();
			if (hasVowel(guess)){
				System.out.println("That's a vowel. No cheating!");
			} else if (guess.equals("Open Sesame!")){
				puzzle.masterSajak();
			} else if (guess.length() != 1){
				System.out.println("Please enter one letter only");
			} else {
				whileBoolean = false;
				puzzle.guess(guess);
				if (puzzle.getCounter() == 0){
					menuKeepGoing = false;
					System.out.println("Nope");
				} else {
					System.out.println("Yes! That letter appears " + puzzle.getCounter() + " time(s).");
					balance = balance + (puzzle.getCounter() * wheel.cash.getCash());
				} // end if/else statement
			} // end if/else statement
		} // end while loop
	} // end guessConsonant method

	public void buyVowel(){
		Scanner response = new Scanner(System.in);
		if (balance < 250){
			System.out.println("Insufficient funds");
			System.out.print("Your current balance is $");
			System.out.println(balance);
		} else {
			System.out.print("Guess a vowel: ");
			String guess = response.nextLine();
			guess = guess.trim();
			if (hasVowel(guess)){
				balance = balance - 250;
				puzzle.guess(guess);
				puzzle.checkVowel();
			} else if ((guess.length() != 1) & (Character.isLetter(guess.charAt(0)))){
				System.out.println("Please enter one letter only");
			} else {
				System.out.println("That wasn't a vowel");
			} // end if/else statement
		} // end if/else statement
	} // end buyVowel method

	public void solve(){
		menuKeepGoing = false;
		Scanner response = new Scanner(System.in);
		System.out.println("Enter your solution. Make sure to include the proper symbols and spaces");
		String guess = response.nextLine();
		guess = guess.trim();
		puzzle.guess(guess);
		if (puzzle.getCounter() == 1){
			System.out.println("Correct!");
			balance = balance + 1000;
			keepGoing = false;
		} else {
			System.out.println("Nope");
		} // end if/else statement
	} // end solve method

	public int getBalance(){
		return balance;
	} // end getBalance method

	public boolean getKeepGoing(){
		return keepGoing;
	} // end getKeepGoing method

	public void setPuzzle(Puzzle newPuzzle){
		puzzle = newPuzzle;
	} // end setPuzzle method

	public Puzzle getPuzzle(){
		return puzzle;
	} // end getPuzzle method

	public boolean hasVowel(String letter){
		if ((letter.equalsIgnoreCase("a")) || (letter.equalsIgnoreCase("e")) || (letter.equalsIgnoreCase("i")) || (letter.equalsIgnoreCase("o")) || (letter.equalsIgnoreCase("u"))){
			return true;
		} else {
			return false;
		} // end if/else statement
	} // end hasVowel method

	public void print(){
		System.out.print(name);
		System.out.println("'s turn");
		System.out.print("	$");
		System.out.println(balance);
		System.out.println("");
		System.out.println("");
		puzzle.print();
	} // end print method

	public static void main(String[] args){
		Player player = new Player();
		System.out.println(player.getKeepGoing());
		player.menu();
	} // end test harness

	public void setKeepGoing(boolean stillGoing){
		keepGoing = stillGoing;
	} // end setKeepGoing method

	public void setPlayerTurn(int newPlayerTurn){
		playerTurn = newPlayerTurn;
	} // end setPlayerTurn method

	public int getPlayerTurn(){
		return playerTurn;
	} // end getPlayerTurn method

	public void setRoundCounter(int newRoundCounter){
		roundCounter = newRoundCounter;
	} // end setRoundCounter method

	public int getRoundCounter(){
		return roundCounter;
	} // end getRoundCounter method
} // end class
