package ajbc.tshirts;

import ajbc.tshirts.Tshirt.Sizes;

public class Runner {
	
	public static void main(String [] args) {
		
		Tshirt [] shirts = new Tshirt [3];
		
		Color color1 = new Color((short)5,(short)10,(short)20);
		Color color2 = new Color((short)50,(short)100,(short)200);
		
		Design design1 = new Design(25,15,"yess",color1,50);
		Design design2 = new Design(27,17,"cool",color2,70);
		
	
		shirts[0] = new Tshirt(Sizes.S,design1,0.2,5);
		shirts[1] = new Tshirt(Sizes.M,design2,0.5,50);
		shirts[2] = new Tshirt();
		
		for(Tshirt shirt:shirts) {
			System.out.println(shirt +"\n");
			System.out.println("shirt is expensive: " + shirt.isExpensive());
			System.out.println("-----------");
		}
		
	}
}
