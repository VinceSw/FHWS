package de.fhws.Programmieren2.Lektion21.Uebung1;

public class NutritionalInformation
{
	private int portionSize, amountPortions;
	private float amountProtein, amountFat, amountCarbs, amountSodium;
	
	public int getPortionSize()
	{
		return portionSize;
	}

	public int getAmountPortions()
	{
		return amountPortions;
	}

	public float getAmountProtein()
	{
		return amountProtein;
	}

	public float getAmountFat()
	{
		return amountFat;
	}

	public float getAmountCarbs()
	{
		return amountCarbs;
	}

	public float getAmountSodium()
	{
		return amountSodium;
	}

	
	private NutritionalInformation(int portionSize, int amountPortions, float amountProtein, float amountFat, float amountCarbs, float amountSodium)
	{
		this.portionSize = portionSize;
		this.amountPortions = amountPortions;
		this.amountProtein = amountProtein;
		this.amountFat = amountFat;
		this.amountCarbs = amountCarbs;
		this.amountSodium = amountSodium;
	}
	
	public static class NutritionalInformationBuilder
	{
		private int portionSize, amountPortions;
		private float amountProtein, amountFat, amountCarbs, amountSodium;
		
		public NutritionalInformationBuilder(int portionSize, int amountPortions)
		{
			this.portionSize = portionSize;
			this.amountPortions = amountPortions;
		}
		
		public NutritionalInformationBuilder withAmountProtein(float protein)
		{
			this.amountProtein = protein;
			return this;
		}
		
		public NutritionalInformationBuilder withAmountFat(float fat)
		{
			this.amountFat = fat;
			return this;
		}
		
		public NutritionalInformationBuilder withAmountCarbs(float carbs)
		{
			this.amountCarbs = carbs;
			return this;
		}
		
		public NutritionalInformationBuilder withAmountSodium(float sodium)
		{
			this.amountSodium = sodium;
			return this;
		}
		
		public NutritionalInformation build()
		{
			return new NutritionalInformation(portionSize, amountPortions, amountProtein, amountFat, amountCarbs, amountSodium);
		}
	}
}
