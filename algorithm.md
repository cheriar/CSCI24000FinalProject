# Goals
To write a multiplayer Wheel of Fortune game

# Inputs
The input of the Game constructor is a boolean named load. The input of the setName method is a String newName, the input of the setBalance method is an int newBalance, and the input of the setCash method is an int cash. The input of the setRoundCounter method is an int newRoundCounter. The input of the hasVowel method is a String letter. The input of the setKeepGoing method is a boolean stillGoing. The input of the setPlayerTurn method is an int newPlayerTurn.

# Outputs
The main method in the Game class call the appropriate constructor. The Game constructor with the parameter loads the saved game and calls the menu method, and the empty Game constructor calls the menu method, and sets the values of the Player names. The menu method gives the option to play next round or save and quit, or quit without saving. The saveAndQuit method serializes the data and calls the goodbye method, and the goodbye method returns a goodbye message. The round method generates a new Puzzle named puzzle, calls the setPuzzle method with puzzle as the argument for all 3 players, and then constructs a while loop with the condition being that the keepGoing method from all 3 players returns true. The loop calls the menu method from player1. If the keepGoing method from all 3 players returns true, the menu method from player 2 gets called. If the keepGoing method from all 3 players return true, the menu method from player3 gets called. The print method prints the player name and their balances

The spin method has a 1/24 chance of getting a LoseATurn wedge, 1/12 chance of getting a Bankrupt wedge, and a 7/8 chance of getting a Cash wedge. The landedOn method gets called in accordance to what it lands on.

The menu method in the Player class first sets menuKeepGoing to true and then it enters a while loop in which the condition is menuKeepGoing. In the while loop, it gives the option to buy a vowel, solve the puzzle, or spin the wheel. The spin the wheel option checks the return type of the spin method, calls the respective landedOn method and sets the balance and menuKeepGoing accordingly. If the return type is Cash, then it calls the guessConsonant method instead of setting the balance. The guessConsonant method checks if hasVowel returns false, or gives input with length != 1, and if not, then it calls the guess method from the puzzle instance with the argument being the input. If the getCounter method from the puzzle instance = 0, menuKeepGoing = false, else the getCounter method from the puzzle instance * the getCash method from the cash instance of the wheel instance gets added to balance. The buyVowel method checks if hasVowel returns true, and checks if the balance >= 250, and if so, then it calls the guess method from the puzzle instance with the argument being the input and also subtracts 250 from the balance. It then calls the checkVowel method from the puzzle instance.The solve method passes the input as an argument for the guess method in the puzzle instance, and sets menuKeepGoing to false. If the getCounter method from the puzzle instance returns 1, it sets keepGoing to false. It then adds 1000 to the balance, and prints "Correct!" The getBalance method returns the balance, the setKeepGoing and getKeepGoing methods set and get the keepGoing boolean, the setPuzzle and getPuzzle set and get the puzzle instance, the setPlayerTurn and getPlayerTurn methods set and get the playerTurn, and the setRoundCounter and getRoundCounter methods set and get the roundCounter

The landedOn method in the LoseATurn class prints the message saying that the player landed on the Lose a Turn wedge. The stillYourTurn method returns false. The getCash method returns 0

The landedOn method in the Bankrupt class prints the message saying that the player landed on the Bankrupt wedge. It also sets cash to playerBalance * -1. The stillYourTurn method returns false. The getCash method returns cash

The landedOn method in the Cash class determines the cash amount and prints the message saying that the player landed on a $(cash) wedge. The stillYourTurn method returns true, and the getCash method returns cash

The print method in the Puzzle class returns the String value to be printed (that is, the puzzle variable and category, formatted properly). It will do so by iterating through the puzzle. The guess method will iterate through the puzzle, and if a spot in the answer = the letter variable and it != the same spot in the puzzle, then add 1 to the counter and make that spot in puzzle = the letter variable. The getCounter method should return the counter. The hasVowel method returns if there is a vowel in the letter argument. The checkVowel method checks if there are any vowels left to be solved, and if there isn't, it prints "No more vowels."

# Step-by-step

## In the Wedge interface
- Declare a public void landedOn method that takes the parameter int playerBalance
- Declare a public boolean stillYourTurn method
- Declare a public int getCash method

## In the LoseATurn class that implements Serialization, Wedge
- Let there be an int named cash

### In the landedOn method with parameter int playerBalance
- print "You landed on the Lose a Turn wedge. Womp womp!"

### In the stillYourTurn method
- return false

### In the getCash method
- return cash

## In the Bankrupt class that implements Serialization, Wedge
- Let there be an int named cash

### In the landedOn method with parameter int playerBalance
- print "Oh no, you landed on the Bankrupt Wedge!"
- cash = playerBalance * (-1)

### In the stillYourTurn method
- return false

### In the getCash method
- return cash

## In the Cash class that implements Serialization, Wedge
- Let there be an int named cash

### In the landedOn method with parameter int playerBalance
- Generate a random number from 0-20 named randomNum
- if the randomNum = 0, 1, 2, 3, 4, or 5
    - cash = 500
- else if randomNum = 6
    - cash = 550
- else if randomNum = 7, 8, 9, or 10
    - cash = 600
- else if randomNum = 11, 12, 13
    - cash = 650
- else if randomNum = 14, 15, 16
    - cash = 700
- else if randomNum = 17
    - cash = 800
- else if randomNum = 18
    - cash = 850
- else if randomNum = 19
    - cash = 900
- else if randomNum = 20
    - cash = 5000
- else
    - print "Something is wrong in Cash landedOn"
- print "You landed on the $(cash) wedge"

### In the stillYourTurn method
- return true

### In the getCash method
- return cash

## In the Wheel class
- Let there be an instance of LoseATurn named loseATurn
- Let there be an instance of Bankrupt named bankrupt
- Let there be an instance of Cash named cash

### In the spin method with the parameter of int playerBalance
- Generate a random number from 0-23 named randomNum
- if randomNum = 0
    - call the landedOn method from the loseATurn instance
    - return 1
- else if randomNum = 1, 2
    - call the landedOn method from the bankrupt instance
    - return 2
- else
    - call the landedOn method from the cash instance
    - return 3

## In the Player class
- Let there be an int named balance that = 0
- Let there be a String name
- Let there be a Wheel named wheel
- Let there be a boolean named keepGoing
- Let there be a boolean named menuKeepGoing
- Let there be a Puzzle named puzzle
- Let there be an int named playerTurn
- Let there be an int named roundCounter

### In the Constructor
- print "What is your name" and let name be the input

### In the getName method
- return name


### In the menu method
- Let keepGoing = true
- Let menuKeepGoing = true
- Construct a while loop with the condition being menuKeepGoing
    - call the print method
    - print "Select what you want to do
        0) Buy a vowel
        1) Solve the puzzle
        2) Spin the wheel"
    - let the input be a String called input
    - if input is 0
        - call the buyVowel method
    - else if input is 1
        - call the solve method
    - else if input is 2
        - let int wedgeType = the return of the spin method from the wheel instance with balance being the argument
        - if wedgeType = 1
            - menuKeepGoing = the return of the stillYourTurn method from the loseATurn instance
        - else if wedgeType = 2
            - menuKeepGoing = the return of the stillYourTurn method from the bankrupt instance
            - balance = balance + the return of the getCash method from the bankrupt instance of the wheel instance
        - else if wedgeType = 3
            - call the guessConsonant method

### In the guessConsonant method
- let there be a boolean named whileBoolean that = true
- Construct a while loop with the condition being whileBoolean
    - print "Guess a consonant" and let the input be stored in the String variable named guess
    - trim the guess
    - if the hasVowel method with the argument of guess returns true
        - print "That's a vowel. No cheating!"
    - else if guess is "Open Sesame!"
        - call the masterSajak method from the puzzle instance
    - else if the length of guess != 1
        - print "Please enter one letter only"
    - else
        - whileBoolean = false
        - call the guess method from the puzzle instance with the argument being guess
        - if the getCounter method from the puzzle instance = 0
            - menuKeepGoing = false
            - print "Nope"
        - else
            - print "Yes! That letter appears (getCounter method from puzzle instance) time(s)."
            - balance = balance + (the getCounter method from the puzzle instance * the getCash method from the cash instance of the wheel instance)

### In the buyVowel method 
- print "Guess a vowel" and let the input be stored in the String variable named guess
- trim guess
- if the hasVowel method returns true
    - if balance >= 250
        - balance = balance - 250
        - call the guess method from the puzzle instance with the argument being guess
        - call the checkVowel method from the puzzle instance
    - else
        - print "Insufficient funds
        Your current balance is $(balance)"
- else if the length of guess != 1
    - print "Please enter one letter only"
- else
    - print "That wasn't a vowel"

### In the solve method
- print "Enter your solution. Make sure to include the proper symbols and spaces." and let the input be stored in the String variable named guess
- Let menuKeepGoing = false
- Trim the guess
- call the guess method from the puzzle instance with the argument being guess
- if the getCounter method from the puzzle instance = 1
    - print "Correct!"
    - balance = balance + 1000
    - keepGoing = false
- else
    - print "Nope"

### In the getBalance method
- return balance

### In the getKeepGoing method
- return keepGoing

### In the setPuzzle method with the parameter being a Puzzle named newPuzzle
- Let puzzle = newPuzzle

### In the getPuzzle method
- return puzzle

### In the hasVowel method with the parameter being a String letter
- if the letter is a, e, i, o, or u
    - return true
- else
    - return false

### In the print method
- print "(name)'s turn
    $(balance)
    
    "
- call the print method from the puzzle instance

### In the setKeepGoing method with parameter boolean stillGoing
- let keepGoing = stillGoing

### In the setPlayerTurn method with parameter int newPlayerTurn
- let playerTurn = newPlayerTurn

### In the getPlayerTurn method
- return playerTurn

### In the setRoundCounter method with parameter int newRoundCounter
- let roundCounter = newRoundCounter

### In the getRoundCounter method
- return roundCounter

## In the Puzzle class
- Let there be a String named answer
- Let there be a String named category
- Let there be an int named counter
- Let there be an ArrayList named guessedLetters of type String

### In the Constructor
- read from file
- generate a random number from 0-1340 named randomNum
- skip that many lines in the file reader
- Let the String puzzle = the result of the file reader reading one line
- Let there be an array of Strings named temp that is the result of splitting puzzle into 2 Strings, with comma being the separator
- Let category = the 1st String in temp
- Let answer = the 2nd String in temp

### In the print method
- Let there be an int named i
- Let there be a String named temp that = answer
- Change temp to lowercase
- Construct a for loop with the sentry being i = 0, the condition being that i < the length of answer, and the change being that one gets added to i with every passing of the loop
    - if the i-th character in the answer String is not a letter or is not in the guessedLetters arrayList
        - print the i-th character in the answer String
    - else
        - print "_"
- print two extra spaces
- print the category
- print two extra spaces
- print "Guessed letters: (guessedLetters)"

### In the masterSajak method
- print "Bleep bloop. Overriding defense protocol...
    
    Welcome, Master Sajak. The answer is (answer)"

### In the guess method with parameter String letter
- Set counter to 0
- make the letter lowercase
- if letter is in the guessedLetters arrayList
    - print "This one was already guessed"
- else if the length of letter > 1
    - if letter = answer
        - counter = 1
- else 
    - Let there be an int named i
    - Construct a for loop with the sentry being i = 0, the condition being that i < the length of answer, and the change being that one gets added to i with every passing of the loop
        - if the i-th character in answer = letter
            - add 1 to the counter
    - add letter to guessedLetters

### In the getCounter method
- return counter

### In the checkVowel method
- Let there be a boolean named hasMoreVowels that = false
- Let there be an int named i
- Construct a for loop with the sentry being i = 0, the condition being that i < the length of answer, and the change being that one gets added to i with every passing of the loop
    - if the i-th character in answer = a, e, i, o, or u, and the i-th character in answer isn't in guessedLetters
        - hasMoreVowels = true
- if hasMoreVowels is false
    - print "No more vowels remaining"

## In the Game class
- Let there be a Puzzle named puzzle
- Let there be an array of 3 Player instances named players
- Let there be an int named roundCounter
- Let there be an int named playerTurn

### In the empty constructor
- Initialize the players array
- Initialize the puzzle
- call the menu method

### In the constructor with parameter boolean load
- Create a new FileInputStream named fileInput that reads from WheelOfFortune.dat
- Create a new ObjectInputStream named readObject that deserializes Objects from fileInput
- Let there be an int named i
- Contruct a for loop with the sentry being that i = 0, the condition being that i < 3, and the change being that one gets added to i with every passing of the loop
    - Let the object in the i-th position of the players array = whatever is read from readObject

### In the menu method
- print "Select an option:
        0) Play next round
        1) Quit without saving
        2) Save and quit"
- Let the input be a String named input
- if input is 0
    - call the round method
- else if input is 1
    - call the goodbye method
- else if input is 2
    - call the saveAndQuit method

### In the saveAndQuit method
- delete WheelOfFortune.dat
- Create a new FileOutputStream named fileOutput that reads to WheelOfFortune.dat
- Create a new ObjectOutputStream named saveObject that writes to fileOutput
- Let there be an int named i
- Contruct a for loop with the sentry being that i = 0, the condition being that i < 3, and the change being that one gets added to i with every passing of the loop
    - write the i-th object in the players array
- call the goodbye method

### In the goodbye method
- print "Goodbye, folks! See you later!"

### In the round method
- Let puzzle get a new Puzzle
- print "Round (whatever round it is)"
- Let there be an int named i
- Construct a for loop with the sentry being i = 0, the condition being that i < 3, and the change being that one gets added to i with every passing of the loop
    - call the setPuzzle method for the i-th Player in the players array with the argument being puzzle
    - call the setKeepGoing method for the i-th Player in the players array with the argument being true
    - let playerTurn = the getPlayerTurn method from the i-th Player in the players array
- Let there be an int named j

- Construct a while loop with the condition being that the getKeepGoing from all 3 players is true
    - call the menu method from the i-th Player in the players array
    - let puzzle = the getPuzzle method from the i-th Player in the players array
    - Construct a for loop with the sentry being j, the condition being that j < 3, and the change being that one gets added to j with every passing of the loop
        - call the setPuzzle method for the j-th Player in the players array with the argument being puzzle
    - increase playerTurn by one
    - call the print method
    - if playerTurn = 3
        - set playerTurn = 0
- increase roundCounter by 1
- call the setRoundCounter method from the 0-th Player in the players array with the argument being roundCounter
- if roundCounter = 3
    - determine which player has the highest balance and say who wins
    - call the goodbye method
- else
    - call the menu method

### In the print method
- print "(player1 name)'s balance: (player1 balance)
(player2 name)'s balance: (player2 balance)
(player3 name)'s balance: (player3 balance)

"

### In the main method
- if WheelOfFortune.dat exists
    - print "Select an Option:
        0) Load an existing game
        1) Start a new game"
    - if the user response is 0
        - create a Game using the constructor with the boolean argument being true
    - else if the user response is 1
        - create a Game using the empty constructor
- else 
    - create a Game using the empty constructor
