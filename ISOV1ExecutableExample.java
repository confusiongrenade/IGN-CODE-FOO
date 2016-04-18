/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isov1;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.*;
import java.util.Scanner;
//import ISOLibraryV2.*; 
/**
 *
 * @author Nick
 */
public class ISOV1ExecutableExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
      System.out.println("Enter a date in one of the acceptable formats: (eg Sun, 20 Mar 2016 16:05:07 A)");
      Scanner a = new Scanner(System.in);
      String line = a.nextLine();
      
      //String line = "Sun, 20 Mar 2016 16:05:07 A";
      line = convert(line);
      
      System.out.println(line);
      
    }
    public static String convert(String line) {
      String Day = null;
      String Year = null;
      String Month = null;
      String Minutes =null;
      String Seconds = null;
      String Hour = null;
      int keepGoing =1;
      // String to be scanned to find the pattern.
      //String line = "Sun, 20 Mar 2016 16:05:07 A";
      
      
      
      // this is the currently tested regex expression
      String pattern = "^(\\d\\d?)\\/(\\d{2})\\/(\\d{4})$"; // mathces the 3/20/2016 pattern, also supports 03/20/2016

      // Create a Pattern object
      Pattern r = Pattern.compile(pattern);

      // Now create matcher object.
      Matcher m = r.matcher(line);
      if (m.find( )) { 
          Year = m.group(3);
          
         if (m.group(1).length() == 1)
         {
         Month = '0' + m.group(1);
         Day = m.group(2);
         }
         else if (Integer.parseInt(m.group(1)) > 12 ){
             Day = m.group(1);
             Month = m.group(2);
         }
         else if (Integer.parseInt(m.group(2)) > 12 ){
             Day = m.group(2);
             Month = m.group(1);
         }
         else
         {
            while (keepGoing == 1) 
            {
             System.out.println("Which format are you using?(type 1 or 2)  1)MM/DD/YYY 2)DD/MM/YYYY ");
             Scanner b = new Scanner(System.in);
             String Helper = b.nextLine();
             if (Helper.equals("1"))
             {
               Month = m.group(1);        
               Day = m.group(2);
               keepGoing = 0;
             }
             else if (Helper.equals("2"))
             {
             Month = m.group(2);
             Day = m.group(1);
             keepGoing =0;
             }
             else
             {
             System.out.println("Not a valid option.  Try again.");
             }
            }
          }
        return Year+ "-" + Month + "-" + Day ;
      } else {
         //System.out.println("NO MATCH");
      }
      
      
      
      
      pattern = "^(\\d\\d?):(\\d{2}):(\\d{2})\\s(.M)$"; // mathces the 4:05:07 PM pattern, also supports 04:05:07 PM
      int hour;
      r = Pattern.compile(pattern);
      m = r.matcher(line);
       if (m.find( )) {  
           
           Hour = ISOHour(m.group(1),m.group(4));
           Minutes = m.group(2);
           Seconds =  m.group(3);
           
          return Hour + ":" + Minutes + ":" +Seconds ;
      }
      
      
       
      pattern = "^(\\w+),\\s(\\w+)\\s(\\d\\d?),\\s(\\d{4})$"; // mathces the "Sunday, March 20, 2016" pattern, also supports 03/20/2016

      
      // Create a Pattern object
      r = Pattern.compile(pattern);
      m = r.matcher(line);
       if (m.find( )) {  
           
           Day = ISODay(m.group(3));
        Month = stringConvert(m.group(2));
         Year = m.group(4);
         
         return Year + '-' + Month +'-' +  Day;
      } else {
        // System.out.println("NO MATCH");
         
      }
       
       
       
        
      pattern = "^(\\w+),\\s(\\w+)\\s(\\d\\d?),\\s(\\d{4})\\s(\\d\\d?):(\\d{2})\\s(.M)$"; // mathces the "Sunday, March 20, 2016" pattern, also supports 03/20/2016

      
      // Create a Pattern object
      r = Pattern.compile(pattern);
      m = r.matcher(line);
       if (m.find( )) {  
         Year = m.group(4);
         
        //System.out.println( m.group(0) + m.group(1).toUpperCase() );
        //String r = m.group(1).toUpperCase();
         Month = stringConvert(m.group(2).toUpperCase());
         System.out.println(Month);
         
         if (m.group(3).length() == 1){
             Day= '0' + m.group(3);
         }
         else 
         {
             Day= m.group(3);
         }
         
         if (m.group(7).equals("PM") )
         {
          hour = Integer.parseInt(m.group(5));
          hour += 12;
         }
         else
         {
           hour = Integer.parseInt(m.group(5));
         }
         
         Minutes = m.group(6);
         
         
          return Year + '-'+Month+'-'+Day+'T'+hour+':'+Minutes+'Z';
      } else {
         //return"NO MATCH";
         
      }
       
        
        
      pattern = "^(\\w+),\\s(\\w+)\\s(\\d\\d?),\\s(\\d{4})\\s(\\d\\d?):(\\d{2}):(\\d{2})\\s(.M)$"; // mathces the Sunday, March 20, 2016 4:05:07 PM pattern, also supports 03/20/2016

      
      // Create a Pattern object
      r = Pattern.compile(pattern);
      m = r.matcher(line);
       if (m.find( )) {  
         Year = m.group(4);
         
        //System.out.println( m.group(0) + m.group(1).toUpperCase() );
        //String r = m.group(1).toUpperCase();
         Month = stringConvert(m.group(2).toUpperCase());
         //System.out.println(Month);
         
         if (m.group(3).length() == 1){
             Day= '0' + m.group(3);
         }
         else 
         {
             Day= m.group(3);
         }
         
         if (m.group(8).equals("PM") )
         {
          hour = Integer.parseInt(m.group(5));
          hour += 12;
          Hour =  Integer.toString(hour);
         }
         else if (m.group(5).length() == 1)
         {
           Hour ='0'+ m.group(5);
         }
         else
         {
             Hour = m.group(5);
         }
         
         Minutes = m.group(6);
         Seconds = m.group(7);
         
         
          return Year + '-'+Month+'-'+Day+'T'+Hour+':'+Minutes+':' + Seconds + 'Z';
      } else {
          //System.out.println("NO MATCH");
         
      }
       
       
         
      pattern = "^(\\w+)\\s(\\d\\d?)th of\\s(\\w+)\\s(\\d{4})\\s(\\d\\d?):(\\d{2}):(\\d{2})\\s(.M)$"; // mathces the Sunday, March 20, 2016 4:05:07 PM pattern, also supports 03/20/2016
///Sunday 20th of March 2016 04:05:07 PM
      
      // Create a Pattern object
      r = Pattern.compile(pattern);
      m = r.matcher(line);
       if (m.find( )) {  
         Year = m.group(4);
         Month = stringConvert(m.group(3).toUpperCase());
         Day=ISODay(m.group(2));
         Hour = ISOHour(m.group(5),m.group(8));
         Minutes = m.group(6);
         Seconds = m.group(7);
          return Year + '-'+Month+'-'+Day+'T'+Hour+':'+Minutes+':' + Seconds + 'Z';
      } else {
         //System.out.println("NO MATCH");
      }
        pattern = "^(\\w+),\\s(\\w+)\\s(\\d\\d?),\\s(\\d{4})$"; // mathces the Sunday, March 20, 2016 4:05:07 PM pattern, also supports 03/20/2016
///Sunday, MAR 20, 2016
      
      // Create a Pattern object
      r = Pattern.compile(pattern);
      m = r.matcher(line);
       if (m.find( )) {  
         Year = m.group(4);
         Month = stringConvert(m.group(2).toUpperCase());
         Day=ISODay(m.group(3));
       
         return Year + '-'+Month+'-'+Day;
      } else {
        // System.out.println("NO MATCH");
      }
       
       
        pattern = "^(\\d\\d?)\\/(\\d{2})\\/(\\d{4})\\s(\\d\\d?):(\\d{2})\\s(.M)$"; // mathces the Sunday, March 20, 2016 4:05:07 PM pattern, also supports 03/20/2016
///3/20/2016 4:05 PM
      
      // Create a Pattern object
      r = Pattern.compile(pattern);
      m = r.matcher(line);
       if (m.find( )) {  
         Year = m.group(3);
         Month = stringConvert(m.group(1).toUpperCase());
         Day=ISODay(m.group(2));
         
         Hour = ISOHour(m.group(4),m.group(6));
         Minutes = m.group(5);
         //Seconds = m.group(7);

          return Year + '-'+Month+'-'+Day+'T'+Hour+':'+Minutes+ 'Z';
      } else {
        // System.out.println("NO MATCH");
      }
       
       
          pattern = "^(\\d\\d?)\\/(\\d{2})\\/(\\d{4})\\s(\\d\\d?):(\\d{2}):(\\d{2})\\s(.M)$$"; // mathces the Sunday, March 20, 2016 4:05:07 PM pattern, also supports 03/20/2016
///3/20/2016 4:05:07 PM
      
      // Create a Pattern object
      r = Pattern.compile(pattern);
      m = r.matcher(line);
       if (m.find( )) {  
         Year = m.group(3);
         Month = stringConvert(m.group(1).toUpperCase());
         Day=ISODay(m.group(2));
         
         Hour = ISOHour(m.group(4),m.group(7));
         Minutes = m.group(5);
         Seconds = m.group(6);

          return Year + '-'+Month+'-'+Day+'T'+Hour+':'+Minutes+ ':'+Seconds +'Z';
      } else {
         //System.out.println("NO MATCH");
      }
       
        pattern = "^(\\w+)\\s(\\d\\d?),\\s(\\d{4})$"; // mathces the Sunday, March 20, 2016 4:05:07 PM pattern, also supports 03/20/2016
///March 20, 2016
      
      // Create a Pattern object
      r = Pattern.compile(pattern);
      m = r.matcher(line);
       if (m.find( )) {  
         Year = m.group(3);
         Month = stringConvert(m.group(1).toUpperCase());
         Day=ISODay(m.group(2));
         /*
         Hour = ISOHour(m.group(4),m.group(7));
         Minutes = m.group(5);
         Seconds = m.group(6);
*/
          return Year + '-'+Month+'-'+Day;
      } else {
         //System.out.println("NO MATCH");
      }
   pattern = "^(\\w+)\\s(\\d\\d?)$"; // mathces the Sunday, March 20, 2016 4:05:07 PM pattern, also supports 03/20/2016
///March 20
      
      // Create a Pattern object
      r = Pattern.compile(pattern);
      m = r.matcher(line);
       if (m.find( )) {  
         //Year = m.group(3);
         Month = stringConvert(m.group(1).toUpperCase());
         Day=ISODay(m.group(2));
        
          System.out.println(Month+'-'+Day);
      } else {
      //   System.out.println("NO MATCH");
      }
   
        pattern = "^(\\w+),\\s(\\d{4})$"; // mathces the Sunday, March 20, 2016 4:05:07 PM pattern, also supports 03/20/2016
///March, 2016
      
      // Create a Pattern object
      r = Pattern.compile(pattern);
      m = r.matcher(line);
       if (m.find( )) {  
         Year = m.group(2);
         Month = stringConvert(m.group(1).toUpperCase());
     
        return Year+'-'+Month;
      } else {
        // System.out.println("NO MATCH");
      }
   
        pattern = "^(\\w+),\\s(\\d\\d?)\\s(\\w+)\\s(\\d{4})\\s(\\d{2}):(\\d{2}):(\\d{2})\\s(\\w+)$"; // mathces the Sun, 20 Mar 2016 16:05:07 GMT pattern, also supports 03/20/2016
///Sun, 20 Mar 2016 16:05:07 GMT
      
      // Create a Pattern object
      r = Pattern.compile(pattern);
      m = r.matcher(line);
       if (m.find( )) {  
         Year = m.group(4);
         Month = stringConvert(m.group(3).toUpperCase());
         Day=ISODay(m.group(2));
         String Offset = offsetConvert(m.group(8));
         Hour = ISOHour(m.group(5),"AM");
         Minutes = m.group(6);
         Seconds = m.group(7);

          return Year+'-'+Month+'-'+Day+'T'+Hour+':'+Minutes+ ':'+Seconds+Offset;
      } else {
         //System.out.println("NO MATCH");
      }
   
       String Minus;
       String Offset;
       
        pattern = "^(\\w+),\\s(\\d\\d?)\\s(\\w+)\\s(\\d{4})\\s(\\d{2}):(\\d{2}):(\\d{2})\\s(-?)(\\d{4})$"; // mathces the Sun, 20 Mar 2016 16:05:07 GMT pattern, also supports 03/20/2016
//Sun, 20 Mar 2016 16:05:07 -0800
      
      // Create a Pattern object
      r = Pattern.compile(pattern);
      m = r.matcher(line);
       if (m.find( )) {  
         Year = m.group(4);
         Month = stringConvert(m.group(3).toUpperCase());
         Day=ISODay(m.group(2));
         
         Hour = ISOHour(m.group(5),"AM");
         Minutes = m.group(6);
         Seconds = m.group(7);
         Minus= m.group(8);
         Offset=m.group(9);
          Offset= Character.toString(m.group(9).charAt(0))+ Character.toString(m.group(9).charAt(1))+ ':'+Character.toString(m.group(9).charAt(2))+Character.toString(m.group(9).charAt(3));
          return Year+'-'+Month+'-'+Day+'T'+Hour+':'+Minutes+ ':'+Seconds+Minus+Offset;
      } else {
         //System.out.println("NO MATCH");
      }
       
       
         
        pattern = "^(\\d{4})(\\d{2})(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$"; // mathces the Sun, 20 Mar 2016 16:05:07 GMT pattern, also supports 03/20/2016
//20160320 16:05:07 
      
      // Create a Pattern object
      r = Pattern.compile(pattern);
      m = r.matcher(line);
       if (m.find( )) {  
         Year = m.group(1);
         Month = stringConvert(m.group(2).toUpperCase());
         Day=ISODay(m.group(3));
         
         Hour = ISOHour(m.group(4),"AM");
         Minutes = m.group(5);
         Seconds = m.group(6);
          return Year+'-'+Month+'-'+Day+'T'+Hour+':'+Minutes+ ':'+Seconds+'Z';
      } else {
         //System.out.println("NO MATCH");
      }
       
       
       
       
       
     
      
        
        pattern = "^(\\d{4})(\\d{2})(\\d{2})$"; // mathces the Sun, 20 Mar 2016 16:05:07 GMT pattern, also supports 03/20/2016
//// 20160320
      
      // Create a Pattern object
      r = Pattern.compile(pattern);
      m = r.matcher(line);
       if (m.find( )) {  
         Year = m.group(1);
         Month = stringConvert(m.group(2).toUpperCase());
         Day=ISODay(m.group(3));
          return Year+'-'+Month+'-'+Day;
      } else {
         //System.out.println("NO MATCH");
      }
       
   
       
       
        
        pattern = "^(\\d{4})\\.(\\d{2})\\.(\\d{2})$"; // mathces the Sun, 20 Mar 2016 16:05:07 GMT pattern, also supports 03/20/2016
////2016.03.20
      
      // Create a Pattern object
      r = Pattern.compile(pattern);
      m = r.matcher(line);
       if (m.find( )) {  
         Year = m.group(1);
         Month = stringConvert(m.group(2).toUpperCase());
         Day=ISODay(m.group(3));
         
           return Year+'-'+Month+'-'+Day;
      } else {
        // System.out.println("NO MATCH");
      }
       
       
       
       
       
        pattern = "^(\\d\\d?)\\s(\\w+)\\s(\\d{4})$"; // mathces the Sun, 20 Mar 2016 16:05:07 GMT pattern, also supports 03/20/2016
///20 March 2016
      
      // Create a Pattern object
      r = Pattern.compile(pattern);
      m = r.matcher(line);
       if (m.find( )) {  
         Year = ISOYear(m.group(3));
         Month = stringConvert(m.group(2).toUpperCase());
         Day=ISODay(m.group(1));
         
          return Year+'-'+Month+'-'+Day;
      } else {
       //  System.out.println("NO MATCH");
      }
       
       
       
       //2016-20-03T16:05:07-08:00
       
       
       
        pattern = "^(\\d{4})-(\\d{2})-(\\d{2})T(\\d{2}):(\\d{2}):(\\d{2})(-|\\+)(\\d{2}):(\\d{2})$"; // mathces the Sun, 20 Mar 2016 16:05:07 GMT pattern, also supports 03/20/2016
/////2016-20-03T16:05:07-08:00
      
      // Create a Pattern object
      r = Pattern.compile(pattern);
      m = r.matcher(line);
       if (m.find( )) {  
         Year = ISOYear(m.group(1));
         Month = stringConvert(m.group(2).toUpperCase());
         Day=ISODay(m.group(3));
         
        Hour = ISOHour(m.group(4),"AM");
         Minutes = m.group(5);
         Seconds = m.group(6);
         String Sign = m.group(7);
         String OffsetOne= m.group(8);
         String OffsetTwo= m.group(9);
        return Year+'-'+Month+'-'+Day+ 'T' + Hour + ':' +Minutes+ ':'+Seconds+ Sign+ OffsetOne+':' +OffsetTwo ;
          
      } else {
         //System.out.println("NO MATCH");
      }
       return "";
    }
    
    public static String ISODay(String m){
        String Day;
        if (m.length() == 1){
             Day= '0' + m;
         }
         else 
         {
             Day= m;
         }
         return Day;
    }
    public static String ISOYear(String m){
        String Year = m;
        while (Year.length() < 4)
         {
             Year= '0' + Year;
         }
         return Year;
    }
    public static String ISOHour(String m, String PM){
        int hour;
        String Hour;
        if (PM.equals("PM") )
         {
          hour = Integer.parseInt(m);
          hour += 12;
          Hour =  Integer.toString(hour);
         }
         else if (m.length() == 1)
         {
           Hour ='0'+ m;
         }
         else
         {
             Hour = m;
         }
        return Hour;
         
    }
    public static String stringConvert(String s) {
  
  switch (s) {
    case "1":
    case "JAN":
    case "JANUARY":
        return "01";
    case "2":
    case "FEB":
    case "FEBRUARY":
        return "02";
    case "3":
    case "MAR":
    case "MARCH":
        return "03";
    case "4":
    case "APR":
    case "APRIL":
        return "04";
    case "5":
    case "MAY":
        return "05";
    case "6":
    case "JUN":
    case "JUNE":
        return "06";
    case "7":
    case "JUL":
    case "JULY":
        return "07";
    case "8":
    case "AUG":
    case "AUGUST":
        return "08";
    case "9":
    case "SEPT":
    case "SEPTEMBER":
        return "09";
    case "10":
    case "OCT":
    case "OCTOBER":
        return "10";
    case "11":
    case "NOV":
    case "NOVEMBER":
        return "11";
    case "12":
    case "DEC":
    case "DECEMBER":
        return "12";
  
  }
  return s;
  
}
    public static String offsetConvert(String s){
        switch (s){
            
            
            case "AMST":
                return "-03:00";
              case "AMT" : // amazon time
                return "-04:00";
            case "AKDT":
                return "-08:00";
             case "AKST":
                return "-09:00";   
            case "A":
                return "+01:00";
            case "ADT":
                return "+03:00";
            case "AFT" :
            case "ALMT":
                return "+04:30";
          
            case "ACWST":
                return "+08:45";
            case "ACST":
            case "ACT":
                return "+9:30";
            case "AEST":
            case "AET" :
                return "+10:00";
            case "ACDT":
                return "+10:30";
            case "AEDT":
                return "+11:00";
            case "ANAST":
            case "ANAT":
                return "+12:00";
            
                
            
                
        }
        return"";
    }
}
