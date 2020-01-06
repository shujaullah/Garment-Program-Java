/*
 * Name: Shujaullah Ahsan
 * project2: Garment.
 * Course: CSI233 (Fall 2018)
 * Date: December, 14, 2018.
 * Description: The garment project will give the pattern of the garment
                also it will give the width of the garment and  give user the file name 
                for that garment.
 * Both bonuses are attempted in this program in the method name getTheWidth
 *  */
import java.util.*;  // for Scanner
import java.io.*;
public class Garment
{
   // the constant for the garment information text file 

   static String shirtInfo;    
   //  constant for the output file sufix for the  customer
   static final String SUFFIX= ".txt";
   
   // The constant for the maximum and minimum length for the garment pattern. 
   static final int MIN_LENGTH = 5;
   static final int MAX_LENGTH = 15;
   
   
   public static void main(String[] args)
      throws FileNotFoundException
   {
         
     Scanner console = new Scanner(System.in);
     
     System.out.print("Enter the file name: ");
     // get the file information of the garment.
     shirtInfo= console.next();
     
     //The method call that determines the width of the garment.
     
     getTheWidth(shirtInfo);
     //declaring the length of the garment variable 
     int length= 0;
     
     System.out.print("Enter the desired length (5 to 15): ");
     length = console.nextInt();
     // Eat the newline .
     console.nextLine();
     // the loop will run if the user enter invalid length input. 
     while(length < MIN_LENGTH || length > MAX_LENGTH )
       {  
       
         System.out.print("Enter the desired length (5 to 15): ");
         length = console.nextInt();
         console.nextLine();
      
       }  
     // string that store the customer's name. 
     String customerName;
     System.out.print("Enter customers first and the last name(seperated by the space): ");
     
     customerName = console.nextLine().toUpperCase();
     
     // The method will  return the  value for the name of the output file store in the  string 
     //name outputFile 
     String outputFile = getInfo(shirtInfo, customerName);
     // Printhing the name of the  file where   the  customers's  garment is store.
     System.out.print("Customer order in in file : " + outputFile);
     
     // Open outputfile to store the data for the garment.  
     PrintWriter garmentFile = new PrintWriter(outputFile);
     //The method that will write the data in the file
     garmentprint (garmentFile, length);
     
     // closing the outputfile is importatnt in order to ensure that all data written in the file.
     garmentFile.close();
   }
   
   

   // This method will return the order file name  by taking the input file for the garment
   // and the customer's name.
   public static String getInfo(String Info, String name )
   {
         
     String outputFile;
     // using the subsstring that will thake the firt letter  of the  name and last name 
     // of the customer and add in the outfile.
     String nameInitials = name.substring(0,1) 
                           + name.substring(name.indexOf(" ") + 1,name.indexOf(" ") + 2);
                           
     // Outfile will  be the  substring  of the  file enterde by the  user and with initials of name
     // with  the suffix of the  file.
     outputFile = Info.substring(0,Info.lastIndexOf(".")) 
                  + "_"+ nameInitials + SUFFIX;
     
     return outputFile;
   }
   
   
   //This method will give the  width of the garment pattern.
    public static void getTheWidth(String shirtInfo)
         throws FileNotFoundException

   {
       // Opening the file  for to get the input for the  garment width
       Scanner shirtFile = new Scanner(new File(shirtInfo));
       
       String justCheck= "";
       // The EOF loop that will read the end of file .        
       while (shirtFile.hasNext())
        {
            justCheck = shirtFile.nextLine();
            
            
        }
       
       // The string  JustCheck will store the last line of the garment file  which will help
       // to get the width of the garment.
       
       //It will help to do the first bonus of the project 
       // just store the last line as string here and for both full sleeves and 
       // symetric sleeves of the shirt.   
       String testLine1 = "|  ||       ||  |";
       
       // variable for the second bonus condition.
       String testLine2 = "    |       ||  |";
        
       double width;
       //The leftbar have the index for the first bar  in string store in the justCheck for garment.
       // the rightbar store the index for the last bar in the string jsutcheck for the garment.
       
       //regular assignment for the regular width of the garment. 
       int leftBar =justCheck.indexOf("|");
       int rightBar= justCheck.lastIndexOf("|");
       
       // First bonus condition is here.
       //conditio for the first bonus
       if (justCheck.equals(testLine1))
        {
          leftBar = justCheck.indexOf("|")+4;
          rightBar = justCheck.lastIndexOf("|") -4;
          
        }
       
        // Second bonnus of the project.
        //condition for the second project.
       if(justCheck.equals(testLine2))
        {
          rightBar = justCheck.lastIndexOf("|") -4;
          

        }
        
        
       // If both condition will  not satisfied the regular condition run.
        width =  (rightBar - leftBar -1)/2.0 ;
        
         
        System.out.println("Garment comes in the width of " + width);

         
        shirtFile.close();


  }

   
  // This methid will write in the output file for the final garment patternin the  customer's file.
  public static void garmentprint (PrintWriter garmentFileRun, int lengthVal)
      throws FileNotFoundException

  {
       // opening the file  input file for the get the data to  print in the output file
       Scanner shirtFile = new Scanner(new File(shirtInfo));
       
       String justCheck= "";
       // EOF loop will  read the data          
       while (shirtFile.hasNext())
       {
            justCheck = shirtFile.nextLine();
            garmentFileRun.printf("%s%n", justCheck);
            
       }
        // input file closed.
        shirtFile.close();
        //The for  loop will print the  last print of the garment according to the
        // length enter by the customer subtracted by  from it .
        for (int i =0; i < (lengthVal-MIN_LENGTH); i ++)
        {
            garmentFileRun.println(justCheck);
        }
        
        

  }
   
}