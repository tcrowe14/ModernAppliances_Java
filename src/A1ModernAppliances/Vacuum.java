package A1ModernAppliances;

/**
* Java version of A1ModernAppliances
* Adapted from the C# version
* Skeleton provided by SADT
* Completed by Taylor Crowe
* 000612584
* Original Feb 22, 2024, Converted Sept 13, 2024
*/


// Represents a Vacuum
public class Vacuum extends Appliance 
{
	// Field for vacuum grade
	private final String _grade;

	// Field for vacuum battery voltage
	private final short _batteryVoltage;

	// Property for vacuum grade
	public String getGrade() 
	{
		return this._grade;
	}
	
	// Property for vacuum battery voltage
	public Short getBatteryVoltage() 
	{
		return this._batteryVoltage;
	}
	
	/* <summary>
	 * Constructs Vacuum object
	 * </summary>
	 * <param name="itemNumber">Item number</param>
	 * <param name="brand">Brand</param>
	 * <param name="quantity">Quantity</param>
	 * <param name="wattage">Wattage</param>
	 * <param name="color">Color</param>
	 * <param name="price">Price</param>
	 * <param name="grade">Vacuum grade</param>
	 * <param name="batteryVoltage">Battery voltage</param>
	 */
	public Vacuum(long itemNumber, 
			String brand, 
			int quantity, 
			double wattage,
			String color, 
			double price, String grade,
			short batteryVoltage) 
	{
		super(itemNumber, brand, quantity, wattage, color, price);
		this._grade = grade;
		this._batteryVoltage = batteryVoltage;
	}

	// Format the object information so that it can be stored in text file upon
	@Override
	public String formatForFile() 
	{
		String commonFormatted = super.formatForFile();
		return String.join(";", commonFormatted, _grade, Short.toString(_batteryVoltage));
	}

	// toString to make output human readable when trying to output the object
	@Override
	public String toString() 
	{
		String batteryVoltageDescription = _batteryVoltage == 18 ? "Low" : "High";
		return String.format(
				"Item Number: %d%n" +
				"Brand: %s%n" +
				"Quantity: %d%n" +
				"Wattage: %.2f%n" +
				"Color: %s%n" +
				"Price: %.2f%n" +
				"Grade: %s%n" +
				"Battery Voltage: %s",
				getItemNumber(), getBrand(), getQuantity(), getWattage(),
				getColor(), getPrice(), _grade, batteryVoltageDescription);
	}
}