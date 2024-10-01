Game.class: Game.java Player.class Puzzle.class
	javac Game.java

Player.class: Player.java Wheel.class
	javac Player.java

Wheel.class: Wheel.java LoseATurn.class Bankrupt.class Cash.class
	javac Wheel.java

LoseATurn.class: LoseATurn.java Wedge.class
	javac LoseATurn.java

Wedge.class: Wedge.java
	javac Wedge.java

Bankrupt.class: Bankrupt.java Wedge.class
	javac Bankrupt.java

Cash.class: Cash.java Wedge.class
	javac Cash.java

Puzzle.class: Puzzle.java
	javac Puzzle.java

clean:
	rm *.class

run: Game.class
	java Game
