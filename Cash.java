import java.io.*;
import java.util.*;

public class Cash implements Wedge, Serializable{
	int cash;

	public void landedOn(int playerBalance){
		Random random = new Random();
		int randomNum = random.nextInt(20);
		if ((randomNum == 0) || (randomNum == 1) || (randomNum == 2) || (randomNum == 3) || (randomNum == 4) || (randomNum == 5)){
			cash = 500;
		} else if (randomNum == 6){
			cash = 550;
		} else if ((randomNum == 7) || (randomNum == 8) || (randomNum == 9) || (randomNum == 10)){
			cash = 600;
		} else if ((randomNum == 11) || (randomNum == 12) || (randomNum == 13)){
			cash = 650;
		} else if ((randomNum == 14) || (randomNum == 15) || (randomNum == 16)){
			cash = 700;
		} else if (randomNum == 17){
			cash = 800;
		} else if (randomNum == 18){
			cash = 850;
		} else if (randomNum == 19){
			cash = 900;
		} else if (randomNum == 20){
			cash = 5000;
		} else {
			System.out.println("Something is wrong in Cash landedOn");
		} // end if/else statement
		System.out.print("You landed on the $");
		System.out.print(cash);
		System.out.println(" wedge");
	} // end landedOn method

	public boolean stillYourTurn(){
		return true;
	} // end stillYourTurn method

	public int getCash(){
		return cash;
	} // end getCash method
} // end class



			
