/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrabblevalues;


import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Nick
 */
public class ScrabbleValues {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException
    { // this program is designed to compare a list of letters given by the user against the list of words given by IGN
      // from the list of letters, the program determines what combination of those letters forms the highest scoring 
      // word on the list, and displays that word and the score that word is
        
        System.out.print("Please type the absolute pathname of the datafile you want to use to find scrabble words: (for eample: /usr/share/dict/words) ");
        // takes in the list of letters the user wants to find the best word for
        Scanner dictionary = new Scanner(System.in); // scans in the letters the user wants to check for a scrabble word
        String dictionaryString = dictionary.nextLine();  // reads the letters into a string
        
        FileInputStream in = null;  // creates a stream to input the list of words from the provided files
        System.out.print("Please type a list of letters that you want to use to create a word: (for eample: asdf) ");
        // takes in the list of letters the user wants to find the best word for
        Scanner letters = new Scanner(System.in); // scans in the letters the user wants to check for a scrabble word
        String letterString = letters.nextLine().toLowerCase();  // reads the letters into a string
        int i; // this integer is used as a counter in the four loops of this program
        try{ // "/Users/Nick/NetBeansProjects/ScrabbleValues/src/scrabblevalues/words.txt"
        in = new FileInputStream(dictionaryString); // reads in the file through the absolute path
        } catch (IOException e) 
        {
            System.err.println("IOExcption caught:" + e.getMessage());
        }
        int content=0; // the variable that the file reads into
        int highestPoints= 0; // this variable stores the highest point value of the best word
        int currentPoints=0; // this variable stores the point total of the current value to check it against the highest value
        String currentString ="asdfasdf"; // stores the current word, its currently holding a very insightful message
        String highestString = ""; // stores the highest word currently found
        String LETTERS  = letterString;
        int h; // used to determine whether the word matches with the list of characters
        
        //First we read in one character  of content from the datafile.  
        while ((content = in.read()) != -1)  //Each  word is read in one character at a time, 
        {
				
            currentString = ""; // set the value of the current string to Null
            currentPoints = 0; // sets the point for the current word to be zero
            letterString = LETTERS;                 
                               
            while (content != '\n') // from the data file, we read check one word at a time, each word is determined by a new line
            {            
                h = wordMatch( (char)content, letterString); // if letters read in dont match the word we are checking          
                if (h==-1) 
                {
                    currentPoints = 0;
                    currentString= ""; // then we reset the string and the score 
                    while (content != '\n') // read in the rest of word so we start at the begining of the next one...
                    {
                        content= in.read(); // and go to the end of the word to stat looking at the next one 
                        if (content == -1)
                            {
                            break; // this is here so we can break even if the word we are checing is the last word in the file
                            }     
                    } 
                    break;  
                } 
                else{
                    letterString = letterString.substring(0,h) + letterString.substring(h+1);
                }
                // if the word we are matching does go with the inputted letters...
                currentPoints += pointValue((char)content); // it adds the appropriate point total for the character to the running score...
                currentString += (char) content; // and adds the appropriate character to the running string
                content = in.read(); // go on to the next character
                if (content == -1)
                    {
                        break; // but break if its the end of file
                    }
            }
            if (currentPoints>=highestPoints) // if the word we just matched is highet than our highest currently found word
            {
                highestPoints = currentPoints; // then update the currently found highest point total
                highestString = currentString; // and the most valuable word
            }
	}
        
        if (highestPoints != 0) // If a word was found ...
        {
            System.out.print("The most valuable word in the list is: " + highestString + ", with a point value of "+ highestPoints+" points");               
            //  display the word and its point value
        }
        else
        {
            System.out.print("No words were found that matched your inputted letters.  Sorry!");
            // otherwise it just prints a message and ends the program
        }
    }
public static int pointValue( char content)
    { // this function takes in a character and then returns the integer point vaue of that character according to the rules of scrabble
        switch (content) 
        {
            // ten point letters
            case 'q':
            case 'z':
                return 10;
            // eight point letters
            case 'j':
            case 'x':
                return 8;
            // the sole five point letter aka just k
            case 'k':
                return 5;
            // four point letters
            case 'f':
            case 'h':
            case 'v':
            case 'w':
            case 'y':
                return 4;
            // three point letters
            case 'b':
            case 'c':
            case 'm':
            case 'p':
                return 3;
            //two point letters
            case 'd':
            case 'g':
                return 2;
            // one point letters
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'r':
            case 's':            
            case 't': 
            case 'l':   
            case 'n':
                return 1;   
        }
        return 0; //if the character read in is not a letter, such as a a newline character or EOF character, then the program returns 0 points 
    }
public static int wordMatch(char content, String letters)
    {
        int i;
        for (i=0; i < letters.length(); i++)
        {
            if (content == letters.charAt(i))
            {
                return i;
            }
        }
    return -1;
    }
}