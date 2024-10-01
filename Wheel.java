import java.io.*;
import java.util.*;

public class Wheel implements Serializable{
	LoseATurn loseATurn = new LoseATurn();
	Bankrupt bankrupt = new Bankrupt();
	Cash cash = new Cash();

	public int spin(int playerBalance){
		Random random = new Random();
		int randomNum = random.nextInt(23);
		if (randomNum == 0){
			loseATurn.landedOn(playerBalance);
			return 1;
		} else if ((randomNum == 1) || (randomNum == 2)){
			bankrupt.landedOn(playerBalance);
			return 2;
		} else {
			cash.landedOn(playerBalance);
			return 3;
		} // end if/else statement
	} // end spin method
} // end class
