import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

public class Main
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		RealEstateAgency agency = new RealEstateAgency("Special Sauce");
		Property[] properties = {
			new Property("Lisbon", "Modern apartment building near the city centre", 185000, PropertyType.ApartmentBuilding),
			new Property("Porto", "Luxury condominium with swimming pool", 145000, PropertyType.Condominium),
			new Property("Setúbal", "Three-bedroom townhouse with garden", 120000, PropertyType.TownHouse),
			new Property("Cascais", "Detached family house with private pool", 420000, PropertyType.DetachedHouse),
			new Property("Amadora", "Two-floor duplex with balcony", 98000, PropertyType.Duplex),
			new Property("Lisbon", "Penthouse overlooking the Tagus River", 350000, PropertyType.PentHouse),
			new Property("Braga", "Residential complex with 24 apartments", 195000, PropertyType.ResidentialComplex),
			new Property("Évora", "Housing estate with private parking", 280000, PropertyType.HousingEstate),
			new Property("Coimbra", "Furnished studio apartment near the university", 45000, PropertyType.StudioApartment),
			new Property("Porto", "Student dormitory with 40 rooms", 390000, PropertyType.Dormitory),
			new Property("Faro", "Modern condominium near the beach", 155000, PropertyType.Condominium),
			new Property("Sintra", "Detached countryside house", 190000, PropertyType.DetachedHouse),
			new Property("Almada", "Townhouse with rooftop terrace", 135000, PropertyType.TownHouse),
			new Property("Aveiro", "Duplex apartment near the canals", 75000, PropertyType.Duplex),
			new Property("Lisbon", "Contemporary studio in the city centre", 85000, PropertyType.StudioApartment),
			new Property("Leiria", "Small apartment building in a quiet neighbourhood", 55000, PropertyType.ApartmentBuilding),
			new Property("Funchal", "Luxury penthouse with ocean views", 410000, PropertyType.PentHouse),
			new Property("Viseu", "Residential complex with shared gardens", 165000, PropertyType.ResidentialComplex),
			new Property("Beja", "Small detached house in the countryside", 65000, PropertyType.DetachedHouse),
			new Property("Oeiras", "Modern townhouse near the coast", 230000, PropertyType.TownHouse)
		};

		agency.aquireMultipleProperties(properties);

		String name;
		int capital = 0;
		String answer;
		PropertyType propertyType = null;

		System.out.println("Set client Name: ");
		name = input.nextLine();

		System.out.println("Set client's total capital: ");

		while(true)
		{
			try
			{
				capital = Integer.parseUnsignedInt(input.nextLine());
				break;
			}
			catch (NumberFormatException e)
			{
				System.out.println("Invalid Amount!\n");
				continue;
			}
		}

		System.out.println("Do you have a preffered property type? N/Y");

		do
		{
			answer = input.nextLine().toLowerCase();

			if (!answer.toLowerCase().equals("n") && !answer.toLowerCase().equals("y"))
			{
				System.out.println("Invalid Answer, type N (no), or Y (yes)");
			}
		} while (!answer.toLowerCase().equals("n") && !answer.toLowerCase().equals("y"));

		if (answer.equals("y"))
		{
			int propertyTypeNumber = 0;
			System.out.println("Preffered property type from the following ones: ");
			PropertyType.listAll();

			while(true)
			{
				try
				{
					propertyTypeNumber = Integer.parseUnsignedInt(input.nextLine());
					if (propertyTypeNumber < 1 || propertyTypeNumber > 10)
					{
						throw new NumberFormatException();
					}

					break;
				}
				catch (NumberFormatException e)
				{
					System.out.println("Invalid Property Type Number!");
					System.out.println("Try again!\n");
				}
			}

			propertyType = PropertyType.getPropertyTypeByIndex(propertyTypeNumber);
		}

		Client client = new Client(name, capital, propertyType);
		int option = 0;
		Property selectedProperety = null;

		do
		{
			System.out.println("------------ House market -----------");
			System.out.println("0. Show your info.");
			System.out.println("1. Show agency info.");
			System.out.println("2. List all Available Properties.");
			System.out.println("3. List of all Properties that match your requirements.");
			System.out.println("4. Aquire a Property");
			System.out.println("5-99. Leave");

			while(true)
			{
				try
				{
					option = Integer.parseUnsignedInt(input.nextLine());
					break;
				}
				catch (NumberFormatException e)
				{
					System.out.println("Invalid Amount!\n");
					continue;
				}
			}

			switch (option)
			{
				case 0:
				{
					client.showClientInfo();
					break;
				}

				case 1:
				{
					agency.showAgencyInfo();
					break;
				}

				case 2:
				{
					System.out.println("List of properties: ");
					agency.allPropertyListings();
					break;
				}

				case 3:
				{
					agency.propertiessThatMachStatistics(client);
					break;
				}

				case 4:
				{
					int propertyNumber = 0;
					System.out.println("Property to Buy: ");
					agency.propertiessThatMachStatistics(client);

					while(true)
					{
						try
						{
							propertyNumber = Integer.parseUnsignedInt(input.nextLine());
							if (propertyNumber < 1 || propertyNumber > agency.getOwnedProperties().toArray().length)
							{
								throw new NumberFormatException();
							}

							break;
						}
						catch (NumberFormatException e)
						{
							System.out.println("Invalid Property Number!\n");
						}
					}

					selectedProperety = agency.getPropertyByIndex(propertyNumber);
					agency.sellProperty(selectedProperety, client);
				}

				default: System.exit(0);
			}
		} while (true);

	}
}
