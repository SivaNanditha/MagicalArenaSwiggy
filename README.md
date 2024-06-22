# Magical Arena

## Description
"Magical Arena" is a Java console game where players battle using health, strength, and attack attributes. They roll dice to attack and defend, aiming to reduce their opponents' health to zero. Fast-paced and strategic, it ends when a player's health depletes.

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher

### Installation

1. **Download the Repository:**
   - Download the zip file from the repository.
   - Extract the contents of the zip file to a directory on your local machine.

2. **Compile and Run the Source Code:**
   - Open a terminal or command prompt.
   - Navigate to the directory where you extracted the zip file.

### Compiling the Java Files

javac com/magicalarena/Main.java


### Running the Game

java com.magicalarena.Main


## How to Play

1. **Enter Attributes:**
   - Enter the attributes for Player A when prompted (health, strength, attack).
   - Enter the attributes for Player B when prompted (health, strength, attack).

2. **Battle Simulation:**
   - The game will simulate the battle between the two players, with the player having less health attacking first.
   - The attacker's attack value, multiplied by the attacking dice roll, determines the damage inflicted, while the defender's strength value, multiplied by the defending dice roll, determines the damage defended.
   - Any excess damage from the attacker reduces the defender's health.

3. **Turn-Based Combat:**
   - The game continues with players exchanging attacker and defender roles until one player's health reaches zero, indicating the end of the match.

4. **Announce Winner:**
   - The game announces the winner based on which player's health reaches zero first.




### Files Description
- **`Player.java`**: Defines the Player class with attributes for health, strength, and attack. Includes methods for rolling dice and reducing health.
- **`Arena.java`**: Manages the fight between two players, including determining the first attacker and simulating the fight.
- **`Main.java`**: The entry point for running the Magical Arena game. Handles user input to create players and start the fight.
- **`TestMagicalArena.java`**: Contains unit tests for the Player and Arena classes to ensure correctness of health reduction, attack damage, defense strength, and overall game logic.

## Running Tests

1. **Open the Project:**
   - Import the project into your preferred Java IDE (Eclipse, IntelliJ, etc.).

2. **Run the Tests:**
   - In your IDE, navigate to `TestMagicalArena.java`.
   - Run the `TestMagicalArena.java` file as a JUnit test.
   - Alternatively, from the terminal, navigate to the `src` directory and run:
     sh
     javac com/magicalarena/TestMagicalArena.java
     java org.junit.runner.JUnitCore com.magicalarena.TestMagicalArena
     

3. **Verify the Results:**
   - Ensure all tests pass without errors.


## Project Structure

- MagicalArena/
  - .settings/
    - org.eclipse.core.resources.prefs
    - org.eclipse.jdt.core.prefs
  - src/
    - com/
      - magicalarena/
        - Arena.java
        - Main.java
        - Player.java
        - TestMagicalArena.java
  - .classpath
  - .gitignore
  - .project
  - README.md
