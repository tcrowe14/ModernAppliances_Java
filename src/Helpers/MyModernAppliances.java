package Helpers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import A1ModernAppliances.Appliance;
import A1ModernAppliances.Dishwasher;
import A1ModernAppliances.Microwave;
import A1ModernAppliances.Refrigerator;
import A1ModernAppliances.Vacuum;

/**
* Java version of A1ModernAppliances
* Adapted from the C# version
* Skeleton provided by SADT
* Completed by Taylor Crowe
* 000612584
* Original Feb 22, 2024, Converted Sept 13, 2024
*/


public class MyModernAppliances extends ModernAppliances 
{

	// Create new scanner to read info	
	private Scanner scanner = new Scanner(System.in);

	/*
	 * Option 1: Performs a checkout
	 * Takes user input and verifies the itemnumber
	 * the appliance is then checked out if stock
	 * available. Otherwise an error message is displayed.
	 */
	
	@Override
	public void checkout() 
	{
		System.out.println("");
		System.out.println("Enter the item number of an appliance:");
		
		// Create long variable to hold item number
		long itemNumber;
		
        // Get user input as string and assign to variable.
		String input = scanner.nextLine();

		// Convert user input from string to long and store as item number variable.
		try 
		{
			itemNumber = Long.parseLong(input);
		} catch (NumberFormatException e) 
		{
			System.out.println("Invalid item number.");
			return;
		}

		// Create 'foundAppliance' variable to hold appliance with item number
        // Assign null to foundAppliance (foundAppliance may need to be set as nullable)
		Appliance foundAppliance = null;

        // Loop through Appliances
		for (Appliance appliance : this.getAppliances()) 
		{
            // Test appliance item number equals entered item number
			if (appliance.getItemNumber() == itemNumber) 
			{
                // Assign appliance in list to foundAppliance variable
				foundAppliance = appliance;
				break;
			}
		}
        // Test appliance was not found (foundAppliance is null)
        // Write "No appliances found with that item number."
		if (foundAppliance == null) 
		{
			System.out.println("No appliances found with that item number.");
			System.out.println("");
        // Otherwise (appliance was found)
		} else 
		{
            // Test found appliance is available
			if (foundAppliance.isAvailable()) 
			{
                // Checkout found appliance
				foundAppliance.checkout();
                // Write "Appliance has been checked out."
				System.out.println("Appliance \"" + itemNumber + "\" has been checked out.");
				System.out.println("");
            // Otherwise (appliance isn't available)
			} else {
                // Write "The appliance is not available to be checked out."
				System.out.println("The appliance is not available to be checked out.");
				System.out.println("");
			}
		}
	}


	/*
	 * Option 2: Finds appliances
	 * Takes user input and stores in brand variable
	 * searches through the array and returns the matching
	 * brands, ignoring case. Adds on the found appliances
	 * to the list and displays on screen.
	 */

	@Override
	public void find() 
	{
        // Write "Enter brand to search for:"
		System.out.println("Enter brand to search for:");

        // Create string variable to hold entered brand
        // Get user input as string and assign to variable.
		String brand = scanner.nextLine();

        // Create list to hold found Appliance objects
		List<Appliance> found = new ArrayList<>();

        // Iterate through loaded appliances
		for (Appliance appliance : this.getAppliances()) 
		{
            // Test current appliance brand matches what user entered
            // Converts user input to lowercase and compares to stored Brand as lowercase)
			if (appliance.getBrand().equalsIgnoreCase(brand)) 
			{
                // Add current appliance in list to found list
				found.add(appliance);
			}
		}
        // Display found appliances
		displayAppliancesFromList(found, 0);
	}

	
	/*
	 * Displays Refrigerators
	 * holds a variable to carry number of doors
	 * asks user for input and loops until a valid
	 * input is entered. Adds the found refrigerator
	 * appliances to list and displays on screen.
	 * <param name="numDoors">Number of doors to find (or null for any number)</param>
	 */
	
	@Override
	public void displayRefrigerators() 
	{
        Scanner scanner = new Scanner(System.in);

        System.out.println("");
        // Write "Possible options:"
        System.out.println("Possible options:");
        // Write "0 - Any"
        System.out.println("0 - Any");
        // Write "2 - Double doors"
        System.out.println("2 - Double doors");
        // Write "3 - Three doors"
        System.out.println("3 - Three doors");
        // Write "4 - Four doors"
        System.out.println("4 - Four doors");

        // Create variable to hold entered number of doors
        int numDoors = 0;

        // Get user input as string and assign to variable
        String userInput;

        // Added a while loop until a valid number of doors is entered.
        while (true) 
        {
            // Write "Enter number of doors: "
            System.out.println("Enter number of doors: ");
            userInput = scanner.nextLine();

            if (userInput.equals("0") || userInput.equals("2") || 
            		userInput.equals("3") || userInput.equals("4")) 
            {
                // Convert user input from string to int and store as number of doors variable.
                numDoors = Integer.parseInt(userInput);
                // Break out of loop (since we found what we need to)
                break;
            } else 
            {
                // Otherwise (input is something else)
                // Write "Invalid input."
                System.out.println("Invalid input. Please enter a valid number of doors.");
                // Add blank line for readability
                System.out.println("");
            }
        }

        // Create list to hold found Appliance objects
        List<Appliance> foundAppliances = new ArrayList<>();

        // Iterate/loop through Appliances
        for (Appliance appliance : this.getAppliances()) 
        {
            // Test that current appliance is a refrigerator
            if (appliance instanceof Refrigerator) {
                Refrigerator refrigerator = (Refrigerator) appliance;

                // Test user entered 0 or refrigerator doors equals what user entered.
                if (numDoors == 0 || refrigerator.getDoors() == numDoors) 
                {
                    // Add current appliance to the found list
                    foundAppliances.add(refrigerator);
                }
            }
        }

        // Display found appliances
        displayAppliancesFromList(foundAppliances, 0);
    }

	/*
	/*
	 * Displays Vacuums
	 * holds a variable to carry grade and voltage
	 * asks user for input and loops until a valid
	 * input is entered for both. Adds the found vacuum
	 * appliances to list and displays on screen.
	 * <param name="grade">Grade of vacuum to find (or null for any grade)</param>
	 * <param name="voltage">Vacuum voltage (or 0 for any voltage)</param>
	 */

	@Override
	public void displayVacuums() 
	{
        Scanner scanner = new Scanner(System.in);

        System.out.println("");
        // Write "Possible options:"
        System.out.println("Possible options:");
        // Write "0 - Any"
        System.out.println("0 - Any");
        // Write "1 - Residential"
        System.out.println("1 - Residential");
        // Write "2 - Commercial"
        System.out.println("2 - Commercial");

        // Create grade variable to hold grade to find (Any, Residential, or Commercial)
        String grade = null;
        String userInput;

        // Create bool variable to validate input
        boolean validGradeInput = false;

        while (!validGradeInput) {
            // Write "Enter grade:"
            System.out.println("Enter grade: ");
            // Get user input as string and assign to variable
            userInput = scanner.nextLine();

            if (userInput.equals("0") || userInput.equals("1") || userInput.equals("2")) 
            {
                switch (userInput) {
                    // Test input is "0"
                    // Assign "Any" to grade
                    case "0":
                        grade = "Any";
                        break;
                    // Test input is "1"
                    // Assign "Residential" to grade
                    case "1":
                        grade = "Residential";
                        break;
                    // Test input is "2"
                    // Assign "Commercial" to grade
                    case "2":
                        grade = "Commercial";
                        break;
                }
                validGradeInput = true;
            } else {
                // Otherwise (input is something else)
                // Write "Invalid option."
                System.out.println("Invalid input. Please enter a valid grade type.");
                // Add blank line for readability
                System.out.println("");
            }
        }

        // Write "Possible options:"
        System.out.println("Possible options:");
        // Write "0 - Any"
        System.out.println("0 - Any");
        // Write "1 - 18 Volt"
        System.out.println("1 - 18 Volt");
        // Write "2 - 24 Volt"
        System.out.println("2 - 24 Volt");

        // Create variable to hold voltage
        int voltage = 0;

        // Create bool variable to validate input
        boolean validVoltInput = false;

        while (!validVoltInput) 
        {
            // Write "Enter voltage:"
            System.out.println("Enter voltage: ");

            // Get user input as string
            userInput = scanner.nextLine();

            if (userInput.equals("0") || userInput.equals("1") || userInput.equals("2")) 
            {
                switch (userInput) 
                {
                    // Test input is "0"
                    // Assign 0 to voltage
                    case "0":
                        voltage = 0;
                        break;
                    // Test input is "1"
                    // Assign 18 to voltage
                    case "1":
                        voltage = 18;
                        break;
                    // Test input is "2"
                    // Assign 24 to voltage
                    case "2":
                        voltage = 24;
                        break;
                }
                validVoltInput = true;
            } else {
                // Otherwise (input is something else)
                // Write "Invalid option."
                System.out.println("Invalid input. Please enter a valid voltage type.");
                // Add blank line for readability
                System.out.println("");
            }
        }

        // Create found variable to hold list of found appliances.
        List<Appliance> foundAppliance = new ArrayList<>();

        // Loop through Appliances
        for (Appliance appliance : this.getAppliances())
        {
            // Check if current appliance is vacuum
            if (appliance instanceof Vacuum) 
            {
                Vacuum vacuum = (Vacuum) appliance;
                // Test grade is "Any" or grade is equal to current vacuum grade 
                // and voltage is 0 or voltage is equal to current vacuum voltage
                if ((grade.equals("Any") || grade.equals(vacuum.getGrade())) && 
                		(voltage == 0 || voltage == vacuum.getBatteryVoltage())) 
                {
                    // Add current appliance to found list
                    foundAppliance.add(appliance);
                }
            }
        }

        // Display found appliances
        displayAppliancesFromList(foundAppliance, 0);
    }
	
	/*
	 * Displays Microwaves
	 * holds a variable to carry room type
	 * asks user for input and loops until a valid
	 * input is entered. Adds the found microwave
	 * appliances to list and displays on screen.
	 * <param name="roomType">type of room to find (or null for any type)</param>
	 */

	@Override
	public void displayMicrowaves() 
	{
	    Scanner scanner = new Scanner(System.in);
	    
	    System.out.println("");
	    // Write "Possible options:"
	    System.out.println("Possible options:");

	    // Write "0 - Any"
	    System.out.println("0 - Any");
	    // Write "1 - Kitchen"
	    System.out.println("1 - Kitchen");
	    // Write "2 - Work site"
	    System.out.println("2 - Work site");

	    // Create char variable that holds room type
	    char roomType = ' ';

	    // Create boolean variable to validate input
	    boolean validInput = false;

	    while (!validInput) {
	        // Write "Enter room type:"
	        System.out.println("Enter room type: ");

	        // Get user input as string and assign to variable
	        String userInput = scanner.nextLine();

	        if (userInput.equals("0") || userInput.equals("1") || userInput.equals("2")) 
	        {
	            switch (userInput) {
	                // Test input is "0"
	                // Assign 'A' to room type variable
	                case "0":
	                    roomType = 'A';
	                    break;
	                // Test input is "1"
	                // Assign 'K' to room type variable
	                case "1":
	                    roomType = 'K';
	                    break;
	                // Test input is "2"
	                // Assign 'W' to room type variable
	                case "2":
	                    roomType = 'W';
	                    break;
	            }
	            validInput = true;
	        } else {
	            // Otherwise (input is something else)
	            // Write "Invalid option."
	            System.out.println("Invalid input. Please enter a valid room type.");
	            // Add blank line for readability
	            System.out.println("");
	        }
	    }

	    // Create list to hold found appliances
	    List<Appliance> foundAppliance = new ArrayList<>();

	    // Loop through appliances
        for (Appliance appliance : this.getAppliances())
	    {
	        // Test if current appliance is Microwave
	        if (appliance instanceof Microwave) 
	        {
	            // Downcast Appliance to Microwave
	            Microwave microwave = (Microwave) appliance;
	            // Test if room type equals 'A' or matches microwave room type
	            if (roomType == 'A' || microwave.getRoomType() == roomType) 
	            {
	                // Add current appliance to found list
	                foundAppliance.add(microwave);
	            }
	        }
	    }

	    // Display found appliances
	    displayAppliancesFromList(foundAppliance, 0);
	}

	/*
	 * Displays Dishwashers
	 * holds a variable to carry sound rating
	 * asks user for input and loops until a valid
	 * input is entered. Adds the found dishwasher
	 * appliances to list and displays on screen.
	 * <param name="soundRating">sound rating to find (or null for any rating)</param>
	 */
	
	@Override
	public void displayDishwashers() 
	{
	    Scanner scanner = new Scanner(System.in);

	    System.out.println("");
	    // Write "Possible options:"
	    System.out.println("Possible options:");

	    // Write "0 - Any"
	    System.out.println("0 - Any");
	    // Write "1 - Quietest"
	    System.out.println("1 - Quietest");
	    // Write "2 - Quieter"
	    System.out.println("2 - Quieter");
	    // Write "3 - Quiet"
	    System.out.println("3 - Quiet");
	    // Write "4 - Moderate"
	    System.out.println("4 - Moderate");

	    // Create variable to hold sound rating
	    String soundRating = "";

	    // Create boolean variable to validate input
	    boolean validInput = false;

	    while (!validInput) {
	        // Write "Enter the sound rating:"
	        System.out.println("Enter the sound rating: ");

	        // Get user input as string and assign to variable
	        String userInput = scanner.nextLine();

	        if (userInput.equals("0") || userInput.equals("1") || 
	        		userInput.equals("2") || userInput.equals("3") || userInput.equals("4")) 
	        {
	            switch (userInput) 
	            {
	                case "0":
	                    // Assign "Any" to soundRating
	                    soundRating = "Any";
	                    break;
	                case "1":
	                    // Assign "Qt" to soundRating
	                    soundRating = "Qt";
	                    break;
	                case "2":
	                    // Assign "Qr" to soundRating
	                    soundRating = "Qr";
	                    break;
	                case "3":
	                    // Assign "Qu" to soundRating
	                    soundRating = "Qu";
	                    break;
	                case "4":
	                    // Assign "M" to soundRating
	                    soundRating = "M";
	                    break;
	            }
	            validInput = true;
	        } else {
	            // Otherwise, invalid input
	            System.out.println("Invalid input. Please enter a valid sound rating.");
	            System.out.println(""); // Add blank line for readability
	        }
	    }

	    // Create a list to hold found appliances
	    List<Appliance> foundAppliance = new ArrayList<>();

	    // Loop through appliances
	    for (Appliance appliance : this.getAppliances()) 
	    {
	        // Test if current appliance is Dishwasher
	        if (appliance instanceof Dishwasher) {
	            // Downcast Appliance to Dishwasher
	            Dishwasher dishwasher = (Dishwasher) appliance;
	            // Test if sound rating is "Any" or matches current dishwasher's sound rating
	            if (soundRating.equals("Any") || dishwasher.getSoundRating().equals(soundRating)) 
	            {
	                // Add current appliance to the found list
	                foundAppliance.add(dishwasher);
	            }
	        }
	    }

	    // Display found appliances
	    displayAppliancesFromList(foundAppliance, 0);
	}

	/*
	 * Random List of Appliances
	 * asks user for input and for type of appliance
	 * and number of appliances.
	 * Adds appliances to list and displays on screen.
	 * <param name="applianceType">type of appliances find (or null for any kind)</param>
	 * <param name="numOfAppliances">number of appliances find (or null for all)</param>
	 */

	@Override
	public void randomList() 
	{
		Scanner scanner = new Scanner(System.in);

	    System.out.println("");
	    // Write "Appliance Types"
	    System.out.println("Appliance Types");
	    // Write "0 - Any"
	    System.out.println("0 - Any");
	    // Write "1 – Refrigerators"
	    System.out.println("1 – Refrigerators");
	    // Write "2 – Vacuums"
	    System.out.println("2 – Vacuums");
	    // Write "3 – Microwaves"
	    System.out.println("3 – Microwaves");
	    // Write "4 – Dishwashers"
	    System.out.println("4 – Dishwashers");

	    // Write "Enter type of appliance:"
	    System.out.println("Enter type of appliance: ");

	    // Get user input as string and assign to applianceType variable
	    String applianceType = scanner.nextLine();

	    // Write "Enter number of appliances:"
	    System.out.println("Enter number of appliances: ");

	    // Get user input as string and convert to integer
	    int numOfAppliances = Integer.parseInt(scanner.nextLine());

	    // Create a list to hold found appliances
	    List<Appliance> foundAppliance = new ArrayList<>();

	    // Loop through appliances
	    for (Appliance appliance : this.getAppliances()) {
	        switch (applianceType) {
	            // Test inputted appliance type is "0"
	            case "0":
	                // Add current appliance to the found list
	                foundAppliance.add(appliance);
	                break;
	            // Test inputted appliance type is "1"
	            case "1":
	                // Test if current appliance is a Refrigerator
	                if (appliance instanceof Refrigerator) {
	                    foundAppliance.add(appliance);
	                }
	                break;
	            // Test inputted appliance type is "2"
	            case "2":
	                // Test if current appliance is a Vacuum
	                if (appliance instanceof Vacuum) {
	                    foundAppliance.add(appliance);
	                }
	                break;
	            // Test inputted appliance type is "3"
	            case "3":
	                // Test if current appliance is a Microwave
	                if (appliance instanceof Microwave) {
	                    foundAppliance.add(appliance);
	                }
	                break;
	            // Test inputted appliance type is "4"
	            case "4":
	                // Test if current appliance is a Dishwasher
	                if (appliance instanceof Dishwasher) {
	                    foundAppliance.add(appliance);
	                }
	                break;
	            default:
	                System.out.println("Invalid option.");
	                // Add blank line for readability
	                System.out.println("");
	                return;
	        }
	    }

	    // Randomize list of found appliances
	    Collections.shuffle(foundAppliance);

	    // Display found appliances (up to the max number inputted)
	    displayAppliancesFromList(foundAppliance, numOfAppliances);
	}
}