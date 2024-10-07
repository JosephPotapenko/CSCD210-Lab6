package cscd210methods;

import java.util.Scanner;

public class CSCD210Lab6Methods
{
   //This method has a menu that you choose the option for
   public static int menu(final Scanner kb)
   {
      int choice;   
      do
      {
         //Menu
         System.out.println();
         System.out.println("Please choose from the following");
         System.out.println("1) Enter a new number");
         System.out.println("2) Print the number of even/odd/zeros");                           
         System.out.println("3) Print if the number is light or heavy");
         System.out.println("4) Print the value of E");
         System.out.println("5) Print the number in reverse order");
         System.out.println("6) Quit!");
         System.out.print("Enter your choice: ");
         choice = Integer.parseInt(kb.nextLine());
            
         // Test choices for validity
         if(choice < 1 || choice > 6)
            System.out.println("Your input was not one of the choices. Enter one of the choices or the program will not continue. ");
               
      }while(choice < 1 || choice > 6); 
      
      //Parameter exceptions
      if(kb == null)
         throw new IllegalArgumentException("Bad Params in menu");
         
      return choice;
   }//end menu
   
   //This method takes in a number and counts how many of the digits
   //are odd, how many are even, and how many are zero 
   public static void oddEvenZero(final int theNum)
   {
      //Parameter exceptions
      if(theNum < 1)
         throw new IllegalArgumentException("Bad Params in oddEvenZero");
         
     //Initialize counters
     int copy, x, even, odd, zero;  
     copy = theNum;
     even = 0;
     odd = 0;
     zero = 0;
     x = 0;
                     
      // While loop counter
      while(copy > 0)
      {
         x = copy % 10;
         if(x == 0)
            zero++;
         else if(x % 2 == 1)
            odd++;
         else
            even++;
         copy /= 10;
      } // end case 2 while loop
                     
      System.out.printf("%d has %d odds, %d evens and %d zeros.", theNum, odd, even, zero);
      System.out.println();
      
   }//end oddEvenZero
   
   //This method prints whether a number is light or heavy
   public static void lightOrHeavy(final int theNum, final Scanner kb)
   {
      if(theNum < 1 || kb == null)
         throw new IllegalArgumentException("Bad Params in lightOrHeavy");
      
      double theNumAvg = CSCD210Lab6Methods.calcAvg(theNum);
      int secondNum = CSCD210Lab6Methods.readPosNum(kb);
      double secondNumAvg = CSCD210Lab6Methods.calcAvg(secondNum);
      
      if(theNumAvg > secondNumAvg)
         System.out.println("The initial number you provided is heavy");
      else
         System.out.println("The initial number you provided is light");
   }//end lightOrHeavy
   
   //This method prints E
   public static void printE(final int theNum)
   {
      if(theNum < 1)
         throw new IllegalArgumentException("Bad Params in printE");
         
      double sum=1;
    
      for (int x = 1; x <= theNum; x++)
      {
         double factorial = 1;
         for(int y = 1; y <= x; y++)
         {
             factorial = factorial * y;
         }
         sum = sum + (1/factorial);
      }
      System.out.println(sum);
      
   }//end PrintE

   //This method prints your number in reverse
   public static void printReverse(final int theNum)
   {
      if(theNum < 1)
         throw new IllegalArgumentException("Bad Params in printReverse");
      int x=0, copy = theNum;
      while(copy > 0)
      {
         x = copy % 10;
         System.out.print(x);
         copy = copy/10;
      }
   }//end printReverse
   
   //This method test whether the number is positive
   public static int readPosNum(final Scanner kb)
   {
      int num;
      System.out.println("Please enter a positive number:");
      num = Integer.parseInt(kb.nextLine());
      while (num < 1)
      {
         System.out.println("You entered a bad input.");
         System.out.println("Please enter a positive number:");
         num = Integer.parseInt(kb.nextLine());
      }
      return num;
   } //end readPosNum  
   
   //This helper method calculates the average of all the digits in a number
   private static double calcAvg(int num)
   {
      if(num < 1)
         throw new IllegalArgumentException("Bad Params in calcAvg");
         
      int count = 0, numSingle;
      double sum = 0;
      while(num > 0)
      {
         numSingle = num % 10;
         count++;
         sum = sum + numSingle;
         num = num / 10;
      }
      return sum/count;
   }//end calcAvg
}