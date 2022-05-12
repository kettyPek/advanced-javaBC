package javabootcamp.oop.exerunner;


import java.time.LocalTime;                        
import javabootcamp.oop.exercise.Television;

public class Runner {

	public static void main(String[] args) {
		
		Television tv1 = new Television("TOSHIBA",2001,6.7f,"RF",1000);
		Television tv2 = new Television("PANASINIC",111,1f,"IR",200);
		
		tv1.display();
		tv2.display();
		
		LocalTime turnOn = tv1.turnOn();		
		long diff = tv1.turnOffSec(turnOn);
		System.out.println(diff);
		
		System.out.println("tv1 is flat: "+ tv1.isFlat());
		
		System.out.println("tv1 is smart: "+ tv1.isSmart());
		
		
		System.out.println(tv1.totalPowerConsumption(3));
		System.out.println(tv1.totalPowerConsumption(4));
		

		int res = tv1.isBigger(tv2);
		String resText = "The Same as";
		if(res==1)
			resText = "Bigger than";
		else if (res == -1)
			resText = "Smaller than";
			
		resText = "TV1 is "+resText+" Tv2";
		System.out.println(resText);
	}

}
