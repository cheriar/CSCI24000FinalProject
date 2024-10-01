import java.io.*;

public class LoseATurn implements Wedge, Serializable{
	int cash;

	public void landedOn(int playerBalance){
		System.out.println("You landed on the Lose a Turn wedge. Womp womp!");
		cash = 0;
	} // end landedOn method

	public boolean stillYourTurn(){
		return false;
	} // end stillYourTurn method

	public int getCash(){
		return cash;
	} // end getCash method
} // end class


