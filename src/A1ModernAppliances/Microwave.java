package A1ModernAppliances;

/**
* Java version of A1ModernAppliances
* Adapted from the C# version
* Skeleton provided by SADT
* Completed by Taylor Crowe
* 000612584
* Original Feb 22, 2024, Converted Sept 13, 2024
*/

//Represents a Microwave
public class Microwave extends Appliance 
{
	// Constant for kitchen room type
	public static final char ROOM_TYPE_KITCHEN = 'K';

	// Constant for work site room type 
	public static final char ROOM_TYPE_WORK_SITE = 'W';

	// Field that holds capacity of the microwave
	private final float capacity;

	// Field that holds room type
	private final char roomType;


	// Property for capacity
	public float getCapacity()
	{
		return this.capacity;
    }
	
	// Property for room type
	public int getRoomType() 
	{
		return this.roomType;
	}

	// Property getter for displayable room type
	public String getRoomTypeDisplay() {
		switch (roomType) {
		case ROOM_TYPE_KITCHEN:
			return "Kitchen";
		case ROOM_TYPE_WORK_SITE:
			return "Work Site";
		default:
			return "(Unknown)";
		}
	}

	/*
	 * Constructs Microwave object
	 * </summary>
	 * <param name="itemNumber">Item number</param>
	 * <param name="brand">Brand</param>
	 * <param name="quantity">Quantity</param>
	 * <param name="wattage">Wattage</param>
	 * <param name="color">Color</param>
	 * <param name="price">Price</param>
	 * <param name="capacity">Microwave capacity</param>
	 * <param name="roomType">Type of room for microwave</param>
	 */
	public Microwave(long itemNumber,
			String brand,
			int quantity,
			double wattage,
			String color,
			double price,
			float capacity,
			char roomType) 
	{
		super(itemNumber, brand, quantity, wattage, color, price);
		this.capacity = capacity;
		this.roomType = roomType;
	}

	// Format the object information so that it can be stored in text file upon
	@Override
	public String formatForFile() 
	{
		String commonFormatted = super.formatForFile();
		return String.join(";", commonFormatted, String.valueOf(capacity), String.valueOf(roomType));
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
				"Capacity: %.2f%n" +
				"Room Type: %s",
				getItemNumber(), getBrand(), getQuantity(), getWattage(),
				getColor(), getPrice(), capacity,
				getRoomTypeDisplay());
	}
}