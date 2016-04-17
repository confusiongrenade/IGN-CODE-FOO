/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package azertyv1;


import static java.lang.Boolean.TRUE;
import static java.lang.Boolean.FALSE;
import java.util.Scanner;
/**
 *
 * @author Nick
 */
         
public class AZERTYV1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Program turns an off brand AZERTY keyboard with a sticky h key into a QWERTY keyboard
        // it scans in  the key presses and then after pressing enter, it converts it to QWERTY.
        // also to compensate for the sticky H key, the program disregaurds multiple h key presses in a run when converting. 
        // if the h key some how gets fixed, all you need to do to turn off the repeated h is set the value of STICKYH to FALSE
        System.out.println("AZERTY Version 1.0 for instructions, type VERBOSE");
        Scanner a = new Scanner(System.in); // reads in the input
        String s=""; //  the current string read in
        String QWERTYSTRING; // the converted string
        int quit = 0; // determines whether the user  wants to quit the program
        int i; // used as a counter
        char QWERTY; // a single character to convert from AZERTY to QWERTY
        
        boolean STICKYH = TRUE; // if this character is true STICKYH mode is on.  this mode prevents repeated h input if that key happens to stick
        char prevchar= '0'; // used in sticky h mode to determine if a previous key was, in fact, h
        
        
        while (quit == 0) { // the program runs until the quit condition is met
        s = a.nextLine(); // string s is read as the next line of input
        while (s.length()  == 0) // this part prevents the program from crashing after a line with no information is presented
        {
          s = a.nextLine();  
        }
        
        
        if ( s.equals("QUIT")) // the quit condition.  if the user type QUIT in all capitals  then the program ends
        {
            
            quit = 1;
            break;
        }
        if ( s.equals("STICKYHON")) // the quit condition.  if the user type QUIT in all capitals  then the program ends
        {
            System.out.println("Stick H mode is now on.  Successive repeats of the character h will be ignored.  To turn it off, type STICKYHOFF and then press enter.");
           STICKYH = TRUE;
           s = a.nextLine(); 
        }
        if ( s.equals("STICKYHOFF")) // the quit condition.  if the user type QUIT in all capitals  then the program ends
        {
            System.out.println("Stick H mode is now off.  Successive repeats of the character h will be read in and interpretted.  To turn it back on, type STICKYHON and then press enter.");
            STICKYH = FALSE;
            s = a.nextLine(); 
        }
        if ( s.equals("VERBOSE"))
        {
        System.out.println("I am so sorry that aliens have replaced your QWERTY keyboard with an off brand AZERTY keyboards with a sticky H key. \nGross.  luckily for you, This program reads in AZERTY input and outputs QWERTY, \nso your memorized hand patterns for typing will not have to change.  \nAs an added bonus, I also included a fix for the sticky H key.  \nThe program automatically disregaurds excessive h key presses, \nso if you type hhhhhhhhhello it just becomes hello.  \nIf your keboard is somehow fixed and you want to turn this feature off, Just type STICKYHOFF.  \nEnjoy, and sorry about your current keyboard. With love, Nick Carroll\nAlso, to Quit, type QUIT");
        s = a.nextLine();
        }
        
        i=0;
        QWERTYSTRING ="";
        while (i < s.length()) // the program iterates through the string 
        {    
        char AZERTY = s.charAt(i);  // the string is seperagted by character
        
        
       
       if(prevchar == 'h' && AZERTY == 'h' && STICKYH == TRUE) //this part implements the STICKYH part
       {
          
          i++;  // basically it just skips the letter if stikyh is on and there are two h's in a row
           
           
       }
       else{
       QWERTY = convert(AZERTY); // if the character is not a repeated h, just go ahead and convert th character
       prevchar = QWERTY; // this is stored to check to see if uts an h
       QWERTYSTRING+=QWERTY; // add the converted character to the finished string
       
       i++; 
       }
        }
        System.out.println(QWERTYSTRING); // print out the translated string once it reconstructed
        prevchar = '0'; // set the previous character so that it doesnt't 
        }
        }

    public static char convert(char a)
    {
        char switchstatment; // this program takes in a character from an AZERTY board, and replaces it with a the coresponding cjharacter from a qwert board

        switch (a){
            //first line on the AZERTY Keyboard
          case 'a':
            switchstatment= 'q';
            break;
          case 'A':
            switchstatment= 'Q';
            break;
           case 'z':
            switchstatment= 'w';
            break;
          case 'Z':
            switchstatment= 'W';
            break;
          case '^':
            switchstatment='[';
            break;
          case '¨': 
            switchstatment='{';
            break;
          case '$': 
            switchstatment=']';
            break;
          case '£':
            switchstatment='}';
            break;
         //second line of the azerty keyboard
          case 'q':
            switchstatment= 'a';
            break;
          case 'Q':
            switchstatment= 'A';
            break;
          case 'm':
            switchstatment= ';';
            break;
          case 'M':
            switchstatment= ':';
            break;
          case 'ù': 
            switchstatment='\''; // the single quote must be escaped out of
            break;
          case '%':
            switchstatment='\"'; // the double quote must be escaped out of
            break;
           case '*':
            switchstatment='\\'; // the escape character must also be escaped out of
            break;
          case 'μ':
            switchstatment='|';
            break;
            //Third line of the azerty keyboard
          case 'w':
            switchstatment= 'z';
            break;
          case 'W':
            switchstatment= 'Z';
            break;
          case ',':
            switchstatment='m';
            break;
          case '?':
            switchstatment='M';
            break;
           case ';':
            switchstatment=',';
            break;
          case '.':
            switchstatment='<';
            break; 
          case ':':
            switchstatment='.';
            break;
          case '/':
            switchstatment='>';
            break;
          case '§': 
            switchstatment='?';
            break;
          case '!':
            switchstatment='/';
            break;
            //Top line for AZERTY keyboard
          case '²':
            switchstatment='`';
            break;
          case '³': // this character does not appear in IGN's Provided example for an AZERTY board, but further research indicated that this key would map to the ~ key
            switchstatment='~';
            break;
          case '&':
            switchstatment='1';
            break;
          case '1':
            switchstatment='!';
            break;
          case '2':
            switchstatment='@';
            break;
          case 'é': 
            switchstatment='2';
            break;
          case '3':
            switchstatment='#';
            break; 
          case '"':
            switchstatment='3';
            break; 
          case '\'':
            switchstatment='4';
            break;
          case '4':
            switchstatment='$';
            break;
         case '5':
            switchstatment='%';
            break;
          case '(':
            switchstatment='5';
            break;
          case '-':
            switchstatment = '6'; 
            break; 
          case '6':
            switchstatment='^';
            break;
          case 'è': 
            switchstatment='7';
            break;
          case '7': 
            switchstatment='&';
            break; 
          case '_': 
            switchstatment='8';
            break;
          case '8':  
            switchstatment='*';
            break;
          case '9': 
            switchstatment='(';
            break;
          case 'ç': 
            switchstatment='9';
            break;
          case '0':
            switchstatment=')';
            break;
          case 'à':
            switchstatment='0';
            break;
          case ')':
            switchstatment='-';
            break;
          case '°':
            switchstatment = '_';
            break;
          default :
            switchstatment=a;
            break;
        }
        
          return switchstatment;
    }

        
}

