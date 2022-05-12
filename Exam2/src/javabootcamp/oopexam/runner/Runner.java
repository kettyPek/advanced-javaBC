package javabootcamp.oopexam.runner;

import java.time.LocalDate;

import javabootcamp.oopexam.doll.Doll;
import javabootcamp.oopexam.doll.Doll.DollType;
import javabootcamp.oopexam.electricToy.ElectricToy;
import javabootcamp.oopexam.kid.Kid;
import javabootcamp.oopexam.toy.Toy;

public class Runner {

	public static void main(String[] args) {
		
		Toy toys [] = new Toy [4];
		Kid kid1 = new Kid("ketty", LocalDate.of(2021,10,5));
		Kid kid2 = new Kid("Guy", LocalDate.of(2019,2,5));
		toys[0] = new Doll(kid1,"Barbie",LocalDate.of(2022,3,5), DollType.HARD);
		toys[1] = new Doll(kid2,"Bear",LocalDate.of(2015,4,5), DollType.SOFT);
		toys[2] = new ElectricToy(kid1,"Car",LocalDate.of(2016,11,5),2);
		toys[3] = new ElectricToy(kid2,"Plane",LocalDate.of(2020,11,5),3);

		for(int i=1; i<=3;i++) {
			System.out.println("Round "+ i + " :");
			for(Toy toy:toys) {	
				System.out.println("current toy is " + toy.toString());
				toy.play();
				System.out.println("----------");
			}
		}

		
		
		

	}

}
