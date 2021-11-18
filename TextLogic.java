import java.util.Scanner;

import java.text.DecimalFormat;

public class TextLogic {

//all important variables to use in shipping
static double product;
static double money = 0.00;
static double fees = 0.00;
static double finalValueFee = 0.00;
static double finalFee = 0.00;
static int attempt = 0;
static double weight, distance, ounce, startup, weight1, ounce1, distance1, finalFee1;
static String province, item, name, address;
static int channelChoice = 0;

  static Scanner nameScan = new Scanner(System.in);
  static Scanner in = new Scanner(System.in);
  static DecimalFormat df = new DecimalFormat("#.00");
  
  public static void Info() {
	  System.out.println("Here is the info: \n\n");
	  
	  SwitchChannel();
  }

  public static void Account() {
 
    System.out.println("Welcome to your Belux account. Please enter the following details. ");
         System.out.println("What is your name? \n");
                name = nameScan.nextLine();
               
                System.out.println("Enter your $ amount you'd like to deposit. Limit is $100.00: ");
                 money = in.nextDouble();

                if(money == 69) {
                System.out.println("I see what u tryna do there.");
                money = 100;
                attempt++;
                }
                if(money > 100.00 || money <= .1) {
                System.out.println("Invalid amount.");
                System.out.println("Money set to $100");
                money = 100;
                attempt++;
                }

                if(money <= 100.00 && money > .1) {
                System.out.println("*SYSTEM: $" +money+ " IN ACCOUNT*\n");
                }
                System.out.println("What is your state/province? \n ");
                province = in.next();
               
                System.out.println("Enter your address. No spaces: \n");
                address = in.next();
               
                System.out.println("Account data complete.\n\n");

                System.out.println("You are about to switch channels. Insert '1' to switch or insert '2' to re-do 'Account' details again.");
                channelChoice = in.nextInt();
                if(channelChoice == 1) {
                	SwitchChannel();
                } else if(channelChoice == 2) {
                	Account();
                }
                
                
        }

        public static void Shipping() {

               
                 System.out.println("Please specify what you would like to ship. No spaces: \n");
                item = in.next();
                while(true) {
                System.out.println("Please enter the cost of your item. No '$' sign: \n");
                product = in.nextDouble();
               
                finalValueFee = product/25;          
                
                weight = .5;

                System.out.println("Please enter the weight of the package. Max weight is 100 pounds: ");
                System.out.println("If your item wieghs in ounces, please type '0'. \n");
                weight = in.nextInt();

               
                if(weight > 100 || weight <= -1) {
                        System.out.println("Your package weight is above or below the limit. Please try again: \n");
                        attempt++;
                        weight1 = in.nextInt();
                } else if(weight1 > 100 || weight1 < 1) {
                attempt++;
                }
       


                System.out.println("Please enter the package ounces: (Number from 1-16) \n");
                ounce = in.nextInt();

                //conditional to check whether ounce input is correct
               
                if(ounce < 1 || ounce > 16) {
                System.out.println("Invalid ounce amount. Please try again: \n");
                ounce1 = in.nextInt();
                attempt++;
                } else if(ounce1 < 1 || ounce1 > 16) {
                attempt++;
                }

             
                   System.out.println("Please type in the distance your package will cover in miles: \n");
                distance = in.nextInt();
               
               
if(distance <= 0) {
                 System.out.println("Input is invalid. Please try again: ");
                 distance1 = in.nextInt();
                } else if(distance <= .99999999) {
                attempt++;
                } else if(distance <= .99999999 && distance1 <= .99999999) {
                SwitchChannel();
                }
if(distance > 0 && distance1 == .5) {
distance1 = distance;
}

                   if(attempt >= 5) {
                  System.out.println("We have detected strange activity. Please restart.");
                  SwitchChannel();
                   }
                   
                   if (weight1 <=2 )
                   {
                     fees = 1.10;
                   }else if(weight1 > 2 && weight1 <=6){
                         fees = 2.20;
                   }else if(weight1 > 6 && weight1 <=10){
                         fees = 3.70;
                   }else if(weight1 > 10 && weight1 <=15){
                         fees = 4.80;
                   }else if(weight1 > 15 && weight1 <=30){
                     fees = 7.25;
                   }else if(weight1 > 30 && weight1 <=50){
                     fees = 9.55;
                   }else if(weight1 > 50 && weight1 <=70){
                     fees = 12.65;
                   }else if(weight1 > 70){
                     fees = 17.95;
                   }

                   if (weight <=2 )
                   {
                     fees = 1.10;
                   }else if(weight > 2 && weight <=6){
                         fees = 2.20;
                   }else if(weight > 6 && weight <=10){
                         fees = 3.70;
                   }else if(weight > 10 && weight <=15){
                         fees = 4.80;
                   }else if(weight > 15 && weight <=30){
                     fees = 7.25;
                   }else if(weight > 30 && weight <=50){
                     fees = 9.55;
                   }else if(weight > 50 && weight <=70){
                     fees = 12.65;
                   }else if(weight > 70){
                     fees = 17.95;
                   }                                 
                   finalFee1 = fees + finalValueFee;
                   String finfee1 = df.format(finalFee1);
                   
                   if(weight > 1 && weight <= 100 && ounce > 1 && ounce <= 16 && distance >= 1) {
                                   System.out.println("Shipping '" +item+ "' from shipper " +name+ ", "+province+ ", " +address+ ". Weight of the package is " +weight+ "lbs, " + ounce + " ounces." );
                                   System.out.println("The total distance to the destination is " +distance+ " miles.");
                                   System.out.println("The total fees for your shipping is $" + finfee1 + "\n \n");
                          }                                           
                   if(weight1 > 1 && weight1 <= 100 && ounce > 1 && ounce <= 16 && distance >= 1) {
                                  System.out.println("Shipping '" +item+ "' from shipper " +name+ ", "+province+ ", " +address+ ". Weight of the package is " +weight1+ "lbs, " + ounce + " ounces." );
                                   System.out.println("The total distance to the destination is " +distance+ " miles.");
                                   System.out.println("The total fees for your shipping is $" + finfee1 + "\n \n");
                          }                                                           
                   if(weight > 1 && weight <= 100 && ounce1 > 1 && ounce1 <= 16 && distance >= 1) {
                                   System.out.println("Shipping '" +item+ "' from shipper " +name+ ", "+province+ ", " +address+ ". Weight of the package is " +weight+ "lbs, " + ounce1 + " ounces." );
                                   System.out.println("The total distance to the destination is " +distance+ " miles.");
                                   System.out.println("The total fees for your shipping is $" + finfee1 + "\n \n");
                          }                                           
                   if(weight > 1 && weight <= 100 && ounce > 1 && ounce <= 16 && distance1 >= 1) {
                                   System.out.println("Shipping '" +item+ "' from shipper " +name+ ", "+province+ ", " +address+ ". Weight of the package is " +weight+ "lbs, " + ounce + " ounces." );
                                   System.out.println("The total distance to the destination is " +distance1+ " miles.");
                                   System.out.println("The total fees for your shipping is $" + finfee1 + "\n \n");
                          }                        
                   if(weight1 > 1 && weight1 <= 100 && ounce > 1 && ounce <= 16 && distance1 >= 1) {
                                   System.out.println("Shipping '" +item+ "' from shipper " +name+ ", "+province+ ", " +address+ ". Weight of the package is " +weight1+ "lbs, " + ounce + " ounces." );
                                   System.out.println("The total distance to the destination is " +distance1+ " miles.");
                                   System.out.println("The total fees for your shipping is $" + finfee1 + "\n \n");
                          }                                        
                  if(weight1 > 1 && weight1 <= 100 && ounce1 > 1 && ounce1 <= 16 && distance1 >= 1) {      
                              System.out.println("Shipping '" +item+ "' from shipper " +name+ ", "+province+ ", " +address+ ". Weight of the package is " +weight1+ "lbs, " + ounce1 + " ounces." );
                                   System.out.println("The total distance to the destination is " +distance1+ " miles.");
                                   System.out.println("The total fees for your shipping is $" + finfee1 + "\n \n");
                          }
                   if(weight > 1 && weight <= 100 && ounce1 > 1 && ounce1 <= 16 && distance1 >= 1) {
                                   System.out.println("Shipping '" +item+ "' from shipper " +name+ ", "+province+ ", " +address+ ". Weight of the package is " +weight+ "lbs, " + ounce1 + " ounces." );
                                   System.out.println("The total distance to the destination is " +distance1+ " miles.");
                                   System.out.println("The total fees for your shipping is $" + finfee1 + "\n \n");
                          }
                   if(weight1 > 1 && weight1 <= 100 && ounce1 > 1 && ounce1 <= 16 && distance >= 1) {
                                   System.out.println("Shipping '" +item+ "' from shipper " +name+ ", "+province+ ", " +address+ ". Weight of the package is " +weight+ "lbs, " + ounce1 + " ounces." );
                                   System.out.println("The total distance to the destination is " +distance1+ " miles.");
                                   System.out.println("The total fees for your shipping is $" + finfee1 + "\n \n");
                          }
                                                                 
                   finalFee = fees + finalValueFee;
                   double finalMoney = money - finalFee;
                   String decMoney = df.format(finalMoney);                 
                   
                   System.out.println("Money left: $" + decMoney);                                    
                   System.out.println("Thanks for shipping with Belux! \n \n \n");
                   
                   System.out.println("You are about to switch channels. Insert '1' to switch or insert '2' to ship again.");
                   channelChoice = in.nextInt();
                   if(channelChoice == 1) {
                   	SwitchChannel();
                   } else if(channelChoice == 2) {
                   	Shipping();
                   }
                   
                   break;
                   
             }
        }               
                   //will be adding values and to the shipping further on
                public static void ShippingService() {
                   System.out.println("Here are all the shipping services: \n\n");
                   System.out.println("BLMS: Belux Mailing Service");
                   System.out.println("BLFS: Belux First Class");
                   System.out.println("BLLW: Belux Light Weight");
                   System.out.println("BLRS: Belux Regular Shipping");
                   System.out.println("BLPS: Belux Prioity Shipping");
                   System.out.println("BLSS: Belux Special Service");
                   System.out.println("BL2D: Belux 2-Day");
                   System.out.println("BLA: Belux Air");
                   System.out.println("BLON: Belux Overnight \n\n");
                                   
                   System.out.println("You are about to switch channels. Insert '1' to switch or insert '2' to keep reveiwing shipping services.");
                   channelChoice = in.nextInt();
                   if(channelChoice == 1) {
                   	SwitchChannel();
                   } else if(channelChoice == 2) {
                   	ShippingService();
                   }
                }   
                
        public static void Reset() {    
        	
        product = 0;
        channelChoice = 0;
        money = 0.00;
        fees = 0.00;
        finalValueFee = 0.00;
        finalFee = 0.00;
        attempt = 0;
        weight = .5;
        ounce = .5;
        distance = .5;
        province = "";
        item = "";
        name = "";
        address = "";   
        
                System.out.println("All data has been reset. \n\n");
               
                SwitchChannel();
                }
                public static void SwitchChannel() {
                	
                System.out.println("**Please input account details** Otherwise shipping statements will contain null data.");
                System.out.println("^Scroll up to see previous updates^");
                System.out.println(" _____________________________");
                System.out.println("|Welcome to Belux Shipping Co.|");
                System.out.println("|Where would you like to go?  |");
                System.out.println("|                             |");
                System.out.println("| (1) Account                 |");
                System.out.println("| (2) Shipping                |");
                System.out.println("| (3) ShippingService         |");
                System.out.println("| (4) Reset                   |");
	        System.out.println("| (5) Info                    |");
                System.out.println("|_____________________________|");                
                startup = in.nextInt();
                
                if(startup == 1) {
                       Account();                       
                } else if(startup == 2) {
                       Shipping();
                } else if(startup == 3) {
                       ShippingService();
                } else if(startup == 4) {
                          Reset();
                } else if(startup == 5){
		         Info();	
		} else {
                System.out.println("Please specify what channel you would like to go to: \n");
                 SwitchChannel();
		}

}                                                                                                                                                                                               
public static void main(String[] args) {
	
System.out.println("**Please input account details** Otherwise shipping statements will contain null data.");
System.out.println(" _____________________________");
System.out.println("|Welcome to Belux Shipping Co.|");
System.out.println("|Where would you like to go?  |");
System.out.println("|                             |");
System.out.println("| (1) Account                 |");
System.out.println("| (2) Shipping                |");
System.out.println("| (3) ShippingService         |");
System.out.println("| (4) Reset                   |");
System.out.println("| (5) Info                    |");
System.out.println("|_____________________________|");
startup = in.nextInt();

if(startup == 1) {
        Account();
} else if(startup == 2) {
        Shipping();
} else if(startup == 3) {
        ShippingService();
} else if(startup == 4) {
	Reset();
} else if(startup == 5) {
	Info();
} else {	
   System.out.println("Please input a number.");
        SwitchChannel();
}	
}
}
