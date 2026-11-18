import java.util.ArrayList;

public class Client
{
	private String name;
	private double capital;
	private ArrayList<Property> ownedProperties;
	private PropertyType prefferedPropertyType;

	public Client(String name, double capital, PropertyType prefferedPropertyType)
	{
		this.name = name;
		this.capital = capital;
		this.prefferedPropertyType = prefferedPropertyType;
		this.ownedProperties = new ArrayList<Property>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void buyProperty(Property property) {
		this.ownedProperties.add(property);
		this.capital -= property.getPropertyValue();
	}

	private void showOwnedProperties()
	{
		if (ownedProperties.isEmpty())
		{
			System.out.println("No properties owned! :(");
			return;
		}

		for (Property property: ownedProperties)
		{
			property.showPropertyInfo();
		}
	}

	public void showClientInfo()
	{
		System.out.println("Name: " + this.name);
		System.out.println("Captial: " + this.capital);
		System.out.println("Preffered Property Type: " + this.prefferedPropertyType);
		System.out.println("Properties: ");
		showOwnedProperties();
	}

	public double getCapital() {
		return capital;
	}

	public void setCapital(double capital) {
		this.capital = capital;
	}

	public PropertyType getPrefferedPropertyType() {
		return prefferedPropertyType;
	}

	public void setPrefferedPropertyType(PropertyType prefferedPropertyType) {
		this.prefferedPropertyType = prefferedPropertyType;
	}

	public boolean doesItMeetRequirements(Property property)
	{
		if (property.getPropertyValue() <= capital && (property.getPropertyType() == prefferedPropertyType || prefferedPropertyType == null))
		{
			return true;
		}

		return false;
	}
}
