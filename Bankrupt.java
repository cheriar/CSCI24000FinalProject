import java.io.*;

public class Bankrupt implements Wedge, Serializable{
	int cash;

	public void landedOn(int playerBalance){
		System.out.println("Oh no, you landed on the Bankrupt Wedge!");
		cash = playerBalance * (-1);
	} // end landedOn method

	public boolean stillYourTurn(){
		return false;
	} // end stillYourTurn method

	public int getCash(){
		return cash;
	} // end getCash method
} // end class


