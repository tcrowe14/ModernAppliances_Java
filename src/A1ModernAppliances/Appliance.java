package A1ModernAppliances;

/**
* Java version of A1ModernAppliances
* Adapted from the C# version
* Skeleton provided by SADT
* Completed by Taylor Crowe
* 000612584
* Original Feb 22, 2024, Converted Sept 13, 2024
*/

// Abstract representation of an appliance

public abstract class Appliance 
{
	// Types of appliances
	public enum ApplianceTypes 
	{
	    REFRIGERATOR,
	    VACUUM,
	    MICROWAVE,
	    DISHWASHER,
	    UNKNOWN
	}

	private final long _itemNumber;
	private final String _brand;
	private int _quantity;
	private final double _wattage;
	private final String _color;
	private final double _price;


	// Constructor for appliance

	// <param name="itemNumber">Item number</param>
	// <param name="brand">Brand</param>
	// <param name="quantity">Quantity</param>
	// <param name="wattage">Wattage</param>
	// <param name="color">Color</param>
	// <param name="price">Price</param>
	protected Appliance(long itemNumber, String brand, int quantity,
			double wattage, String color, double price) 
	{
		this._itemNumber = itemNumber;
		this._brand = brand;
		this._quantity = quantity;
		this._wattage = wattage;
		this._color = color;
		this._price = price;
	}

	public ApplianceTypes getType() 
	{
		return determineApplianceTypeFromItemNumber(_itemNumber);
	}

	// Item number
	public long getItemNumber() 
	{
		return _itemNumber;
	}

	// Brand of appliance
	public String getBrand() 
	{
		return _brand;
	}

	// Quantity of appliance
	public int getQuantity() 
	{
		return _quantity;
	}

	// Wattage of appliance
	public double getWattage() 
	{
		return _wattage;
	}

	// Color of appliance
	public String getColor() 
	{
		return _color;
	}

	// Price of appliance
	public double getPrice() 
	{
		return _price;
	}

	// Availability of appliance, must be greater than 0
	public boolean isAvailable() 
	{
		return _quantity > 0;
	}


	// Checkout appliance. Subtracts one from quantity

	public void checkout() 
	{
		this._quantity = this._quantity - 1;
	}

	// Formats appliance to be stored in file

	public String formatForFile() 
	{
		return String.join(";", String.valueOf(_itemNumber), _brand, String.valueOf(_quantity),
				String.valueOf(_wattage), _color, String.valueOf(_price));
	}

	// Determines appliance type from item number
	// <param name="itemNumberStr">Holds item number as string</param>
	// <param name="firstDigitChar">Holds the first digit of item number</param>
	// <param name="firstDigit">Holds first digit as int for switch case</param>
	// <returns>ApplianceTypes</returns>
	
	public static ApplianceTypes determineApplianceTypeFromItemNumber(long itemNumber) {
	    // Convert itemNumber to String and get the first character
	    String itemNumberStr = Long.toString(itemNumber);
	    // Extract the first digit
	    char firstDigitChar = itemNumberStr.charAt(0);

	    // Convert the first character to an integer
	    int firstDigit = Character.getNumericValue(firstDigitChar);

	    // Determine appliance type based on the first digit. Returns type.
	    switch (firstDigit) {
	        case 1:
	            // Refrigerator
	            return ApplianceTypes.REFRIGERATOR;
	        case 2:
	            // Vacuum
	            return ApplianceTypes.VACUUM;
	        case 3:
	            // Microwave
	            return ApplianceTypes.MICROWAVE;
	        case 4:
	        case 5:
	            // Dishwasher
	            return ApplianceTypes.DISHWASHER;
	        default:
	            // Unknown
	            return ApplianceTypes.UNKNOWN;
	    }
	}
}