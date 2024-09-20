package Helpers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

public abstract class ModernAppliances 
{
	// Constant for location of appliances.txt file
	public static final String APPLIANCES_TEXT_FILE = "res/appliances.txt";

	// Options user can choose
	public static enum Options {
	    NONE(0), CHECKOUT(1), FIND(2), DISPLAY_TYPE(3), RANDOM_LIST(4), SAVE_EXIT(5);

	    private final int value;

	    Options(int value) {
	        this.value = value;
	    }

	    public int getValue() {
	        return value;
	    }

	    public static Options fromValue(int value) {
	        for (Options option : Options.values()) {
	            if (option.getValue() == value) {
	                return option;
	            }
	        }
	        throw new IllegalArgumentException("Invalid option value: " + value);
	    }
	}

	// Holds list of appliances
	private List<Appliance> appliances;

	// Provides immutable list of appliances
	public List<Appliance> getAppliances() 
	{
		return new ArrayList<>(appliances);
	}

	// Called when ModernAppliances instance is created
	public ModernAppliances() 
	{
		this.appliances = this.ReadAppliances();
	}

	// Displays menu options
	public void displayMenu() 
	{
		System.out.println("Welcome to Modern Appliances!");
		System.out.println("How May We Assist You ?");
		System.out.println("1 – Check out appliance");
		System.out.println("2 – Find appliances by brand");
		System.out.println("3 – Display appliances by type");
		System.out.println("4 – Produce random appliance list");
		System.out.println("5 – Save & exit");
		System.out.println("Enter option:");
	}

	// Performs a checkout
	public abstract void checkout();

	// Finds an appliance
	public abstract void find();

	// Displays appliances with type
	public void displayType() {
	    System.out.println("Appliance Types");
	    System.out.println("1 – Refrigerators");
	    System.out.println("2 – Vacuums");
	    System.out.println("3 – Microwaves");
	    System.out.println("4 – Dishwashers");

	    System.out.println("Enter type of appliance: ");

	    // Scanner to read user input
	    Scanner scanner = new Scanner(System.in);
	    String input = scanner.nextLine();
	    
	    int applianceTypeNum = -1;
	    try {
	        applianceTypeNum = Integer.parseInt(input);
	    } catch (NumberFormatException e) {
	        // If input is not a number
	        System.out.println("Invalid appliance type entered.");
	        System.out.println(); // Added blank line for readability
	        return;
	    }

	    // Check if the input is valid (between 1 and 4)
	    if (applianceTypeNum < 1 || applianceTypeNum > 4) {
	        System.out.println("Invalid appliance type entered.");
	        System.out.println(); // Added blank line for readability
	        return;
	    }

	    switch (applianceTypeNum) {
	        case 1:
	            this.displayRefrigerators();
	            break;
	        case 2:
	            this.displayVacuums();
	            break;
	        case 3:
	            this.displayMicrowaves();
	            break;
	        case 4:
	            this.displayDishwashers();
	            break;
	        default:
	            System.out.println("Invalid appliance type entered.");
	            System.out.println(); // Added blank line for readability
	            break;
	    }
	}

	// Displays refrigerators
	public abstract void displayRefrigerators();

	// Displays vacuums
	public abstract void displayVacuums();

	// Displays microwaves
	public abstract void displayMicrowaves();

	// Displays dishwashers
	public abstract void displayDishwashers();

	// Generates random list of appliances
	public abstract void randomList();

	// Saves appliances to text file
	public void save() 
	{
		System.out.print("Saving... ");

		try (PrintWriter fileStream = new PrintWriter(new FileWriter(APPLIANCES_TEXT_FILE))) 
		{
			for (Appliance appliance : appliances) 
			{
				fileStream.println(appliance.formatForFile());
			}
			System.out.println("DONE!");
		} catch (IOException e) {
			System.out.println("Error saving file: " + e.getMessage());
		}
	}

	/* Reads appliances from text file
	 * <param name="line">Holds line from file</param>
	 * <returns>List of appliances</returns>
	 */
	private List<Appliance> ReadAppliances() 
	{
		List<Appliance> appliances = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(APPLIANCES_TEXT_FILE))) 
		{
			String line;
			while ((line = reader.readLine()) != null) 
			{
				Appliance appliance = createApplianceFromLine(line);
				if (appliance != null) {
					appliances.add(appliance);
				}
			}
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}
		return appliances;
	}

	/* 
	 * Creates appliance object from line
	 * <param name="parts">split appliance info from file line</param>
	 * <param name="firstDigit">used to identify appliance type</param>
	 * <returns>Appliance object (or null if line is invalid)</returns>
	 */
	private Appliance createApplianceFromLine(String line) 
	{
		String[] parts = line.split(";");
		int firstDigit = Integer.parseInt(line.substring(0, 1));

		switch (firstDigit) {
		case 1:
			return createRefrigeratorFromParts(parts);
		case 2:
			return createVacuumFromParts(parts);
		case 3:
			return createMicrowaveFromParts(parts);
		case 4:
		case 5:
			return createDishwasherFromParts(parts);
		default:
			return null;
		}
	}

	/*
	* Creates Refrigerator object from parts
	* <param name="parts">Array of strings containing data to create object
	* from</param>
	* <returns>Refrigerator object (or null if length of parts is wrong)</returns>
	*/	
	private Refrigerator createRefrigeratorFromParts(String[] parts) 
	{
		if (parts.length != 9)
			return null;
		// Parse parts and create Refrigerator object
		return new Refrigerator(Long.parseLong(parts[0]),
				parts[1], 
				Integer.parseInt(parts[2]),
				Double.parseDouble(parts[3]),
				parts[4],
				Double.parseDouble(parts[5]),
				Short.parseShort(parts[6]),
				Integer.parseInt(parts[7]),
				Integer.parseInt(parts[8]));
	}

    /*
	* Creates Vacuum object from parts
	* <param name="parts">Array of strings containing data to create object from</param>
	* <returns>Vacuum object (or null if length of parts is wrong)</returns>
	*/
	private Vacuum createVacuumFromParts(String[] parts) 
	{
		if (parts.length != 8)
			return null;
		// Parse parts and create Vacuum object
		return new Vacuum(Long.parseLong(parts[0]),
				parts[1], 
				Integer.parseInt(parts[2]),
				Double.parseDouble(parts[3]),
				parts[4],
				Double.parseDouble(parts[5]),
				parts[6],
				Short.parseShort(parts[7]));
	}
	
    /*
	* Creates Microwave object from parts
	* <param name="parts">Array of strings containing data to create object from</param>
	* <returns>Microwave object (or null if length of parts is wrong)</returns>
	*/
	private Microwave createMicrowaveFromParts(String[] parts) 
	{
		if (parts.length != 8)
			return null;
		// Parse parts and create Microwave object
		return new Microwave(Long.parseLong(parts[0]),
				parts[1], 
				Integer.parseInt(parts[2]),
				Double.parseDouble(parts[3]),
				parts[4],
				Double.parseDouble(parts[5]),
				Float.parseFloat(parts[6]),
				parts[7].charAt(0));
	}

    /*
     * Creates Dishwasher object from parts
     * <param name="parts">Array of strings containing data to create object from</param>
     * <returns>Dishwasher object (or null if length of parts is wrong)</returns>
     */
	private Dishwasher createDishwasherFromParts(String[] parts) 
	{
		if (parts.length != 8)
			return null;
		// Parse parts and create Dishwasher object
		return new Dishwasher(Long.parseLong(parts[0]),
				parts[1],
				Integer.parseInt(parts[2]),
				Double.parseDouble(parts[3]),
				parts[4],
				Double.parseDouble(parts[5]),
				parts[6],
				parts[7]);
	}

    /*
     * Prints out appliances in list
     * <param name="appliances">List of appliances</param>
     * <param name="max">Maximum number of appliances to display (0 is unlimited)</param>
     */
	public void displayAppliancesFromList(List<Appliance> appliances, int max) 
	{
		if (!appliances.isEmpty()) 
		{
			System.out.println("Found appliances:");
			System.out.println();
			for (int i = 0; i < appliances.size() && (max == 0 || i < max); i++) 
			{
				System.out.println(appliances.get(i));
				System.out.println();
			}
		} else {
			System.out.println("No appliances found.");
		}
		System.out.println();
	}
}