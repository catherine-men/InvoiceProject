//Catherine Men
//895190874

package invoiceproject;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class InvoiceProject {

    public static void main(String[] args) throws FileNotFoundException {
        
        Random rand = new Random();
        int num = rand.nextInt(999-100+1)+100;
        
        PrintWriter outFile = new PrintWriter("receipt_" + num + ".txt");
        char anotherItem = 'y';
        double total = 0;
        
        Scanner in = new Scanner (System.in);
        outFile.println("========================================");
        outFile.println("\t Welcome to Wallmart");
        outFile.println("========================================");
        outFile.printf("%-10s%5s%10s%10s\n", "name", "quantity", "price", "total");
        outFile.println("----------------------------------------");
        
        while (anotherItem == 'y')
        {
         System.out.print("Item: ");
         String itemName = in.next();
                
         System.out.print("Quantity: ");
         int itemQuantity = in.nextInt();
                
         System.out.print("Price: ");
         double itemPrice = in.nextDouble();
        
         total += itemPrice * itemQuantity;
         outFile.printf("%-10s%5d%10s%.2f%5s%.2f\n", itemName, itemQuantity, "$", itemPrice, "$", itemPrice * itemQuantity);
         
         System.out.println();
         System.out.println("Press 'y' to enter a new item. Press anyother key to quit.");
         anotherItem = in.next().charAt(0);
        
        }
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd - hh:mm:ss a");
        String currentDateTimeFormatted = currentDateTime.format(formatter);
        System.out.println("receipt_" + num + " has been issued on " + currentDateTimeFormatted);
        
        outFile.println("----------------------------------------");
        outFile.printf("%33s$%.2f\n", "Your total is ", total);
        outFile.printf("%33s$%.2f\n", "Tax: ", total * 1.09);
        outFile.println("========================================");
        outFile.close();
    }
}
