public enum PropertyType {
	ApartmentBuilding,
	Condominium,
	TownHouse,
	DetachedHouse,
	Duplex,
	PentHouse,
	ResidentialComplex,
	HousingEstate,
	StudioApartment,
	Dormitory;

	public static void listAll()
	{
		int currentIndex = 1;
		for (PropertyType type: PropertyType.values())
		{
			System.out.println(currentIndex + "." + " " + type);
			currentIndex++;
		}
	}

	public static PropertyType getPropertyTypeByIndex(int index)
	{
		index--;
		return PropertyType.values()[index];
	}
}
