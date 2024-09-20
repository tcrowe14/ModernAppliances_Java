package A1ModernAppliances;

/**
* Java version of A1ModernAppliances
* Adapted from the C# version
* Skeleton provided by SADT
* Completed by Taylor Crowe
* 000612584
* Original Feb 22, 2024, Converted Sept 13, 2024
*/

//Represents a Refrigerator
public class Refrigerator extends Appliance 
{
	// Field that holds number of fridge doors
	private final short doors;

	// Width of the fridge
	private final int width;

	// Height of the fridge
	private final int height;

	// Property for doors
	public int getDoors() 
	{
		return this.doors;
	}
	
	// Property for height
	public int getHeight() 
	{
		return this.height;
	}
	
	// Property for width
	public int getWidth() 
	{
		return this.width;
	}
	/*
	 * Constructs Refrigerator object
	 * </summary>
	 * <param name="itemNumber">Item number</param>
	 * <param name="brand">Brand</param>
	 * <param name="quantity">Quantity</param>
	 * <param name="wattage">Wattage</param>
	 * <param name="color">Color</param>
	 * <param name="price">Price</param>
	 * <param name="doors">Number of doors</param>
	 * <param name="width">Fridge width</param>
	 * <param name="height">Fridge height</param>
	 */
	public Refrigerator(long itemNumber, 
			String brand, int quantity, 
			double wattage, 
			String color, 
			double price,
			short doors, 
			int width, 
			int height) {
		super(itemNumber, brand, quantity, wattage, color, price);
		this.doors = doors;
		this.width = width;
		this.height = height;
	}


	// Format the object information so that it can be stored in text file upon
	@Override
	public String formatForFile() 
	{
		String commonFormatted = super.formatForFile();
		return String.join(";", commonFormatted, String.valueOf(doors), 
				String.valueOf(width), String.valueOf(height));
	}

	// toString to make output human readable when trying to output the object
	@Override
	public String toString() 
	{
		return String.format(
				"Item Number: %d%n" +
						"Brand: %s%n" +
						"Quantity: %d%n" +
						"Wattage: %.2f%n" +
						"Color: %s%n" +
						"Price: %.2f%n" +
						"Doors: %d%n" +
						"Width: %d%n" +
						"Height: %d",
				getItemNumber(),
				getBrand(),
				getQuantity(),
				getWattage(),
				getColor(),
				getPrice(),
				doors, width, height);
	}
}