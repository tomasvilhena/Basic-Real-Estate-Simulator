import java.util.ArrayList;

public class RealEstateAgency
{
	private String name;
	private ArrayList<Property> ownedProperties;
	private int ownedPropertyAmount;
	private int soldPropertyAmount;

	public RealEstateAgency(String name) {
		this.name = name;
		this.ownedProperties = new ArrayList<Property>();
		this.ownedPropertyAmount = 0;
		this.soldPropertyAmount = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Property> getOwnedProperties() {
		return ownedProperties;
	}

	public Property getPropertyByIndex(int index)
	{
		index--;
		return ownedProperties.get(index);
	}

	public void setOwnedProperties(ArrayList<Property> ownedProperties) {
		this.ownedProperties = ownedProperties;
	}

	public void aquireMultipleProperties(Property[] properties)
	{
		for (Property property: properties)
		{
			ownedProperties.add(property);
			this.ownedPropertyAmount++;
		}
	}

	public void sellProperty(Property property, Client client)
	{
		ownedProperties.remove(property);
		client.buyProperty(property);
		this.soldPropertyAmount++;
	}

	public void showAgencyInfo()
	{
		System.out.println("***** Agency: " + this.name + " *****");
		System.out.println("Amount of Owned Property: " + ownedPropertyAmount);
		System.out.println("Amount of Sold Property: " + soldPropertyAmount);
		System.out.println("Propertiess: ");
		allPropertyListings();
	}

	public void allPropertyListings()
	{
		for (Property property: ownedProperties)
		{
			System.out.println(property.getListing());
		}
	}

	public void propertiessThatMachStatistics(Client client)
	{
		System.out.println("Properties that match the requirements: ");
		ArrayList<Property> matchingProperties = new ArrayList<Property>();
		for (Property property: ownedProperties)
		{
			if (client.doesItMeetRequirements(property))
			{
				matchingProperties.add(property);
			}
		}

		if (matchingProperties.isEmpty())
		{
			System.out.println("No matching Properties with these requirements");
			return;
		}

		int index = 1;
		for (Property property: matchingProperties)
		{

			System.out.println(index + ". " + property.getListing());
			index++;
		}
	}


}
