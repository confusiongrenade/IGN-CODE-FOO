/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avengersassemblebridge;

/**
 *
 * @author Nick
 */
public class AvengersAssembleBridge {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Introduce the Scenario and The avengers
        System.out.println("In the comics, the Avengers haven't ever destroyed the Golden Gate Bridge (Citation 1)");
        
        System.out.println("But, If they were to make a suprise visit to beatiful San Fransisco Bay Area, \nAnd destory the Golden Gate Bridge, not only would there be many political ramifications \nabout Govenrment oversieght of superheros, but they bridge would also need to be rebuilt as well\n");
        //Introduce Legos
        System.out.println("The natural choice to rebuild the bridge, is, of course, to utilize LEGOs");
        
        double legoHieght = 9.6; // in milimeters
        double legoWidth = 15.8; // in mm
        double legoLength = 31.8; // mm 
        
        System.out.println("A standardized 2X4 Lego Brick is:");
        System.out.println(legoHieght + "mm tall, or "+ (legoHieght= legoHieght/1000) + " Meters");
        System.out.println(legoWidth + "mm wide, or "+ (legoWidth = legoWidth/1000) + " Meters");
        System.out.println(legoLength + "mm wide, or "+ (legoLength = legoLength/1000) + " Meters");
        System.out.println("(citation 2)");
        double legoVolume;
        System.out.println("This gives us a volume of "+(legoVolume = legoHieght*legoWidth*legoLength)+" meters cubed per brick.");
        
        // Dimensions of Golden Gate bridge
        double bLength = 2788; // length including distance to toll plaza
        double bWidth = 27; // width in meters
        double bDepth = 7.6; // depth
        System.out.println("The Golden Gate Bridge has a length of "+ bLength+" meters, \na deck width of " + bWidth + ", \nand a deck deph of "+ bDepth + " meters. (Citation 3)");
        double dVolume = bLength*bWidth*bDepth;
        System.out.println("Which means, if the Golden Gate Bridge was Just a flat plank, then its volume would be "+ dVolume + " meters cubed");
        double dBricks = dVolume/ legoVolume ;
        //int val = new BigDecimal(stringValue).intValue();
        System.out.println("Which means that it would take "+ dBricks + "(about 100 Billion) standard 2X4 lego bricks \nto recreate *JUST* the deck of the Golden Gate Bridge ");
        
        System.out.println("But we dont want to replace just the deck of the bridge, we want to replace all of it.\nThe next step would be to rebuild the towers");
        
        
        double tHeight = 227;
        double SouthTowerDepth = 34;
        double legWidth = 10;
        double legDepth = 16;
        
        System.out.println("The Golden Gate Bridge has 2 support towers, each of which is "+ tHeight + " meters tall" );
        System.out.println("Each of these towers has two legs, which at the base are "+ legWidth + " meters wide");
        System.out.println("And " + legDepth + " meters long");
        System.out.println("The two southern legs also have an additional underwater depth of " + SouthTowerDepth+ " meters");
        System.out.println("Using these stats to model the towers, \nthe number of legos required can be found by comparing the volume of the towers \nto the amount of legos needed to make that volume (Citation 4)");
        double ntVolume;
        System.out.println("The hieght of the North tower is " + tHeight + " \nmultiplied by the width ("+legWidth+") and the depth ("+legDepth+") \ngives us the volume of one leg of the north tower:"+( ntVolume= legDepth*legWidth*tHeight)+" cubic meters" );
        System.out.println("Of course since there are two legs in the tower, the total value of the \nnorth tower can be approximated by 2 times the volume, or "+ (2*ntVolume) + " cubic meters.");
        System.out.println("The southern is the same as the northern except that it is "+ SouthTowerDepth + " more meters underwater");
        System.out.println("So you just have to add on that much to the hieght before you take the volume");
        double stVolume = (SouthTowerDepth+tHeight)*legDepth*legWidth;
        System.out.println("Which ends up making one leg of South Tower "+ stVolume + " cubic meters");
        double tBricks;
        double towerVolume;
        System.out.println("Thus the total volume of all the towers is " + (towerVolume=2*stVolume+2*ntVolume) + " cubic meters");
        System.out.println("The legos required to meet this volume is the volume of the Towers \ndivided by the volume of a lego brick, which gives you:" + (tBricks = towerVolume/legoVolume) +" Bricks\nOr, 30 Billion Lego Bricks which, gives a a grand total of " + (tBricks+dBricks)+" Bricks total");

        double cDiameter = .92;
        double cLength = 2332;
        
        System.out.println("In addtion, the cables are "+ cDiameter +" meters in diameter, and " + cLength+" meters long");
        double cVolume = 3.14159265*(cDiameter/2)*(cDiameter/2)*cLength;
        System.out.println("Which by the same math gives you a volume of "+cVolume+" cubic meters.");
        double cBricks;
        System.out.println("Add two of those together, and then divide by the volume of a lego brick to find the numbers of \nBricks to recreate this: "+ (cBricks=2*cVolume/legoVolume) +" bricks");
        System.out.println("This brings the Grand Total of the all the Lego Bricks to recreate the Golden Gate Bridge to " + (cBricks+tBricks+dBricks) +" Bricks Total!");
        System.out.println("(aka 151.6 Billion Lego Bricks!)");
        
        citations();
    }
    public static void citations(){
        // first citation
        System.out.println("Citation 1: According to the Marvel wiki, \nThe Golden Gate Bridge is used a back drop for a number of avengers fights\nBut the avengers usually end up saving the bridge, not destroying it. \nhttp://marvel.wikia.com/wiki/Golden_Gate_Bridge");
        System.out.println("Citation 2: I was suprised lego bricks were that specific... \nthey also have a tolerance of .1mm.\nhttp://www.robertcailliau.eu/Lego/Dimensions/zMeasurements-en.xhtml");
        System.out.println("Citation 3: for the length and width: http://goldengatebridge.org/research/factsGGBDesign.php\nfor the depth: http://www.archinomy.com/case-studies/1908/golden-gate-bridge-san-francisco");
        System.out.println("Citation 4: My Brain");
    }
    
}
