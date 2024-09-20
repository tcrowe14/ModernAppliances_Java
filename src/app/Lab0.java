package app;

import java.util.Scanner;

/**
 * This is Taylor's version of Lab0
 * 
 * @author Taylor Crowe
 */
import Helpers.ModernAppliances;
import Helpers.MyModernAppliances;

/**
* Java version of A1ModernAppliances
* Adapted from the C# version
* Skeleton provided by SADT
* Completed by Taylor Crowe
* 000612584
* Original Feb 22, 2024, Converted Sept 13, 2024
*/

// Entry point for program
public class Lab0 
{
	public static void main(String[] args) 
	{
        ModernAppliances modernAppliances = new MyModernAppliances();
        ModernAppliances.Options option = ModernAppliances.Options.NONE;

        Scanner scanner = new Scanner(System.in);

        while (option != ModernAppliances.Options.SAVE_EXIT) 
        {
            modernAppliances.displayMenu();

            int input;
            if (scanner.hasNextInt()) 
            {
                input = scanner.nextInt();
                scanner.nextLine();
                try {
                    option = ModernAppliances.Options.fromValue(input);
                } catch (IllegalArgumentException e) 
                {
                    System.out.println("Invalid option entered. Please try again.");
                    // Added blank line for readability
                    System.out.println(); 
                    continue;
                }

                switch (option) 
                {
                    case CHECKOUT:
                        modernAppliances.checkout();
                        break;
                    case FIND:
                        modernAppliances.find();
                        break;
                    case DISPLAY_TYPE:
                        modernAppliances.displayType();
                        break;
                    case RANDOM_LIST:
                        modernAppliances.randomList();
                        break;
                    case SAVE_EXIT:
                        modernAppliances.save();
                        break;
                    default:
                        System.out.println("Invalid option entered. Please try again.");
                        // Added blank line for readability
                        System.out.println(); 
                        break;
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                // Consume invalid input
                scanner.next(); 
                // Added blank line for readability
                System.out.println(); 
            }
        }

        scanner.close();
    }
}