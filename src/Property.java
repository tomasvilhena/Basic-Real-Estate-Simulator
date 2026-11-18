public class Property
{
	private String location;
	private String listing;
	private double propertyValue;
	private PropertyType propertyType;

	public Property(String location, String listing, double propertyValue, PropertyType propertyType)
	{
		this.location = location;
		this.listing = listing;
		this.propertyValue = propertyValue;
		this.propertyType = propertyType;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getListing() {
		return listing;
	}

	public void setListing(String listing) {
		this.listing = listing;
	}

	public double getPropertyValue() {
		return propertyValue;
	}

	public void setPropertyValue(double propertyValue) {
		this.propertyValue = propertyValue;
	}

	public PropertyType getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(PropertyType propertyType) {
		this.propertyType = propertyType;
	}

	public void showPropertyInfo()
	{
		System.out.println(this.getListing());
		System.out.println(this.getPropertyValue());
		System.out.println(this.getPropertyType());
	}
}
