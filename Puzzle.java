import java.io.*;
import java.util.*;

public class Puzzle implements Serializable{
	String answer;
	String category;
	int counter;
	ArrayList<String> guessedLetters = new ArrayList<>();

	public Puzzle(){
		try{
			Scanner readFile = new Scanner(new File("puzzles.csv"));
			String puzzle = new String();
			Random random = new Random();
			int randomNum = random.nextInt(1340); // 1341 is problematic; 77926 lines in the file
			int i;
			for (i = 0; i <= randomNum; i++){
				puzzle = readFile.nextLine();
			} // end for loop
			// puzzle = generatePuzzle(0, randomNum, readFile);
			readFile.close();
			String temp[] = puzzle.split(",", 2);
			category = temp[0];
			answer = temp[1];
		} catch (Exception e){
			System.out.println(e.getMessage());
		} // end try block
	} // end constructor

	//public String generatePuzzle(int lineNum, int targetNum, Scanner scanner){
	//	if (lineNum == targetNum){
	//		String puzzle = scanner.nextLine();
	//		return puzzle;
	//	} else {
	//		scanner.nextLine();
	//		String puzzle = generatePuzzle(lineNum + 1, targetNum, scanner);
	//		return puzzle;
	//	} // end if/else statement
	//} // end generatePuzzle

	public void print(){
		int i;
		String temp = answer;
		temp = temp.toLowerCase();
		for (i = 0; i < answer.length(); i++){
			if (!Character.isLetter(answer.charAt(i))){
				System.out.print(answer.charAt(i));
			} else if (guessedLetters.contains(Character.toString(temp.charAt(i)))){
				System.out.print(answer.charAt(i));
			} else {
				System.out.print("_");
			} // end if/else block
		} // end for loop
		System.out.println("");
		System.out.println("");
		System.out.println(category);
		System.out.println("");
		System.out.println("");
		System.out.print("Guessed letters: ");
		System.out.println(guessedLetters);
	} // end print method

	public void masterSajak(){
		System.out.println("Bleep bloop. Overriding defense protocols...");
		System.out.println("");
                System.out.println("");
                System.out.print("Welcome, Master Sajak. The answer to this puzzle is ");
		System.out.println(answer);
	} // end masterSajak method

	public void guess(String letter){
		letter = letter.toLowerCase();
		counter = 0;
		if (guessedLetters.contains(letter)){
			System.out.println("This one was already guessed");
		} else if (letter.length() > 1){
			if (letter.equalsIgnoreCase(answer)){
				counter = 1;
			} // end if statement
		} else {
			int i;
			for (i = 0; i < answer.length(); i++){
				if (letter.equalsIgnoreCase(Character.toString(answer.charAt(i)))){
					counter++;
				} // end if statement
			} // end for loop
			guessedLetters.add(letter);
		} // end if/else statement
	} // end guess method

	public int getCounter(){
		return counter;
	} // end getCounter

	public void checkVowel(){
		boolean hasMoreVowels = false;
		int i;
		for (i = 0; i < answer.length(); i++){
			String temp = Character.toString(answer.charAt(i));
			temp = temp.toLowerCase();
			if (((temp.equalsIgnoreCase("a")) || (temp.equalsIgnoreCase("e")) || (temp.equalsIgnoreCase("i")) || (temp.equalsIgnoreCase("o")) || (temp.equalsIgnoreCase("u"))) && (!guessedLetters.contains(temp))){
				hasMoreVowels = true;
			} // end if statement
		} // end for loop
		if (!hasMoreVowels){
			System.out.println("No more vowels remaining");
		} // end if statement
	} // end checkVowel method

	public static void main(String[] args){
		Puzzle puzzle = new Puzzle();
		puzzle.print();
		puzzle.masterSajak();
		puzzle.guess("a");
		puzzle.print();
		puzzle.guess("a");
		puzzle.print();
	} // end test harness
} // end class

