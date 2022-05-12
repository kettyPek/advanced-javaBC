package javabootcamp.oop.vmRunner;

import java.util.Scanner;

import javabootcamp.oop.vendingMachine.HotChocolate;
import javabootcamp.oop.vendingMachine.HotEspresso;
import javabootcamp.oop.vendingMachine.HotLatte;
import javabootcamp.oop.vendingMachine.OrangeJuice;
import javabootcamp.oop.vendingMachine.Produceable;
import javabootcamp.oop.vendingMachine.Sprite;
import javabootcamp.oop.vendingMachine.VendingMachine;
import javabootcamp.oop.vendingMachine.AppleJuice;
import javabootcamp.oop.vendingMachine.Cola;
import javabootcamp.oop.vendingMachine.Drink.DrinkBase;
import javabootcamp.oop.vendingMachine.HotCappuccino;

public class Runner {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (VendingMachine.canProduce) {
			showMenu();
			int opt = Integer.parseInt(sc.next());
			if (opt == 0)
				break;
			Produceable drink = createDrink(opt);
			drink.produce();
		}
	}

	private static Produceable createDrink(int opt) {
		switch (opt) {
		case 0:
			System.out.println("Bye Bye");
		case 1: 
			return new HotChocolate();
		case 2: 
			return new HotEspresso();
		case 3: 
			return new HotCappuccino();
		case 4: 
			return new HotLatte();
		case 5: 
			return new Cola();
		case 6: 
			return new Sprite();
		case 7: 
			return new OrangeJuice();
		case 8: 
			return new AppleJuice();
		}
		return null;
	}

	public static void showMenu() {
		System.out.println("Please select a drink or enter 0 to exit:");
		System.out.println("1. Hot Chocolate\n" + "2. Hot Espresso\n" + "3. Hot Cappuccino\n" + "4. Hot Latte\n"
				+ "5. Cola\n" + "6. Sprite\n" + "7. Orange Juice\n" + "8. Apple Juice");
	}

}
