package A1ModernAppliances;

/**
* Java version of A1ModernAppliances
* Adapted from the C# version
* Skeleton provided by SADT
* Completed by Taylor Crowe
* 000612584
* Original Feb 22, 2024, Converted Sept 13, 2024
*/

// Represents a Dishwasher
public class Dishwasher extends Appliance 
{
	// Constant for quietest sound rating
	public static final String SOUND_RATING_QUIETEST = "Qt";

	// Constant for quieter sound rating
	public static final String SOUND_RATING_QUIETER = "Qr";

	// Constant for quiet sound rating
	public static final String SOUND_RATING_QUIET = "Qu";

	// Constant for moderate sound rating
	public static final String SOUND_RATING_MODERATE = "M";

	// Field that holds feature
	private final String feature;

	// Field that holds sound rating
	private final String soundRating;


	// Display getter for sound rating
	public String getSoundRatingDisplay() 
	{
		switch (soundRating) {
		case SOUND_RATING_QUIETEST:
			return "Quietest";
		case SOUND_RATING_QUIETER:
			return "Quieter";
		case SOUND_RATING_QUIET:
			return "Quiet";
		case SOUND_RATING_MODERATE:
			return "Moderate";
		default:
			return "(Unknown)";
		}
	}
	
	// Property getter for sound rating
	public String getSoundRating() 
	{
		return this.soundRating;
	}

	/*
	* Constructs Dishwasher instance
	* <param name="itemNumber">Item number</param>
	* <param name="brand">Brand</param>
	* <param name="quantity">Quantity</param>
	* <param name="wattage">Wattage</param>
	* <param name="color">Color</param>
	* <param name="price">Price</param>
	* <param name="feature">Feature</param>
	* <param name="soundRating">Sound rating</param> 
	*/
	public Dishwasher(long itemNumber,
			String brand,
			int quantity,
			double wattage,
			String color,
			double price,
			String feature,
			String soundRating) 
	{
		super(itemNumber, brand, quantity, wattage, color, price);
		this.feature = feature;
		this.soundRating = soundRating;
	}

	// Format the object information so that it can be stored in text file upon
	@Override
	public String formatForFile() 
	{
		String commonFormatted = super.formatForFile();
		return String.join(";", commonFormatted, feature, soundRating);
	}

	// toString to make output human readable when trying to output the object
	@Override
	public String toString() 
	{
		return String.format(
				// %d is used for integers (itemNumber, quantity, wattage
				"Item Number: %d%n" +
				// %s is for strings (brand, color, roomTypeDisplay)
				"Brand: %s%n" +
				"Quantity: %d%n" +
				// %.2f is for floating-point numbers with 2 decimal precision (price, capacity)
				"Wattage: %.2f%n" +			
				"Color: %s%n" +
				"Price: %.2f%n" +
				"Feature: %s%n" +
				"Sound Rating: %s",
				getItemNumber(), getBrand(), getQuantity(), getWattage(),
				getColor(), getPrice(), feature,
				getSoundRatingDisplay());
	}
}