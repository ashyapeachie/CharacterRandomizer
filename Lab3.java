/* 
 * author: Ashya
 * filename: Lab3.java
 * description: This program randomizes a playable character for the popular game DnD (Dungeons amd Dragons)
 */

import java.util.Scanner;
import java.util.Random; 
//defining each function

public class Lab3 {
    public static void main(String[] args) {
        System.out.println("\n=== Welcome to the DnD Character Randomizer! ===");
        System.out.println("How many characters would you like to generate?");
        //above is the first thing the user should see when the program first runs propting the user
        
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        boolean continueGeneration = true;
        
        String[] races = {"Human", "Elf", "Dwarf", "Halflings", "Dragonborn"};
        //list of potential race options
        String[] classes = {"Ranger", "Barbarian", "Bard", "Druid", "Rogue"};
        //list of potential class options
        String[] stats = {"Strength", "Dexterity", "Constitution", "Intelligence", "Wisdom", "Charisma"};
        //list of potential character stats
        
        while (continueGeneration) {
            System.out.println("Enter a number (or enter 0 to exit): \n");
            int numCharacters = getPartySize(scanner);
            
            if (numCharacters == 0) {
                System.out.println("Thank you for using the DnD Character Randomizer!");
                break;
            }
            //if the user enters 0, the program will stop and print thank you message 
            
            String [][] characterData = new String[numCharacters][10];
            //creating 2D array that stores character data
            
            for (int c = 0; c < numCharacters; c++) {
                characterData[c][0] = races[rand.nextInt(races.length)];
                characterData[c][1] = classes[rand.nextInt(classes.length)];
                characterData[c][2] = stats[rand.nextInt(stats.length)];
                //randomly assigned race, class, and stats 
                
                for (int s = 2; s < 8; s++) {
                    characterData[c][s] = Integer.toString(rand.nextInt(16) + 4);
                }
            }
            printCharacterInfo(races, classes, characterData);
            
            System.out.println("Would you like to generate more characters for a new party?\n");
        }
        //the above while statement gets the number of characters from the user's input
    }

    /* the method below helps make user the user's input is a valid party size */
    public static int getPartySize(Scanner scanner) {
        int partySize = 0;
        boolean valid = false;
        
        while (!valid) {
            if (scanner.hasNextInt()) {
                partySize = scanner.nextInt();
                if (partySize == 0) {
                    return 0;
                } else if (partySize >= 1 && partySize <= 10) {
                    valid = true;
                } else {
                    System.out.println("Number entered does not work. Please enter a number between 1 and 10:");
                    //message prints if the user's input is invalid and clears the invalid input 
                }
            }
        }
        return partySize;
    }

    /* the method belpw prints character information */
    private static void printCharacterInfo(String[] races, String[] classes, String[][] characterData) {
        for (int c = 0; c < characterData.length; c++) {
            String race = characterData[c][0];
            String classeString = characterData[c][1];
            String STR = characterData[c][2];
            String DEX = characterData[c][3];
            String CON = characterData[c][4];
            String INT = characterData[c][5];
            String WIS = characterData[c][6];
            String CHA = characterData[c][7];

            System.out.println("Your Character " + (c + 1) + "is a: " + race + " " + classes);
            System.out.println("STR: +" + STR + " DEX: +" + DEX "CON: +" + CON + " INT: +" + INT +
                " WIS: +" + WIS + " CHA: +" + CHA);
            System.out.println();
            //System.out.println("Your Character " + (c + 1) + " is a: " + characterData[c][0] + " "+ characterData[c][1]);
            //System.out.println("STR: +" + characterData[c][2] + " "+ "DEX: +" + characterData[c][3] + " " + "CON: +" + 
                //characterData[c][4] + " " + "INT: +" + characterData[c][5] + " " + "WIS: +" + characterData[c][6] + " " + 
                //"CHA: +" + characterData[c][7]);
            //System.out.println(" ");
            //the " " are for the spaces in between attributes to make it easy to look at
        }
        //race is characterData[c][0]
        //class is characterData[c][1]
        //the other attributes are shortened and match each row   
    }
    // wanting to make this block of code nicer to look at
}
