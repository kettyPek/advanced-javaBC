package ajbc.exam;

import java.io.Serializable;

public class Food implements Serializable{
	
	protected String name;
	private Taste taste;
	private Macronutrients macronutrientsType;
	
	public Food(String name, Taste taste, Macronutrients macronutrientsType) throws NonCapatilizedException {
		this.name = name;
		this.taste = taste;
		this.macronutrientsType = macronutrientsType;
	}
	
	
	public void setName(String name) throws NonCapatilizedException{
		if(name.charAt(0)<'A' || name.charAt(0)>'Z')
			throw new NonCapatilizedException();	
		else
			this.name = name;
	}
	
	public boolean isDesert() {
		if(taste == Taste.SWEET && macronutrientsType == Macronutrients.CARBO_HYDRATE)
			return true;
		return false;
	}

	@Override
	public String toString() {
		return "Food [name=" + name + ", taste=" + taste + ", macronutrientsType=" + macronutrientsType + "]";
	}



	public enum Taste{
		
		SWEET,
		SOUR,
		BITTER,
		UMAMI;
	}
	
	public enum Macronutrients{
		
		PROTEIN,
		CARBO_HYDRATE,
		FAT;
	}

}
