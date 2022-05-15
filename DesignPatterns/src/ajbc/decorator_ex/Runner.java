package ajbc.decorator_ex;

public class Runner {
	
	public static void main (String [] args) {
		
		
		Dress basicDress = new BasicDecorator("Red","M");
		Dress basicFancy = new FancyDecorator(basicDress);
		Dress basicCasual = new CasualDecorator(basicDress);
		Dress basicFancySporty = new SportyDecorator(new FancyDecorator(basicDress));
		Dress basicFancyCasual = new CasualDecorator(new FancyDecorator(basicDress));
		Dress basicSportCasualFancy= new FancyDecorator(new CasualDecorator(new SportyDecorator(basicDress)));
		
		basicDress.create();
		basicFancy.create();
		basicCasual.create();
		basicFancySporty.create();
		basicFancyCasual.create();
		basicSportCasualFancy.create();
		
	}

}
