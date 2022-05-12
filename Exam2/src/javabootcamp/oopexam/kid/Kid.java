package javabootcamp.oopexam.kid;

import java.time.LocalDate;
import java.time.Period;
/**
 * Contains name, birth date and current age of a kid
 * @author ketty
 *
 */
public class Kid {
	
	protected String name;
	protected final LocalDate BIERT_DATE;
	protected int currentAge;
	protected AgeGroup ageGroup;
	
	public Kid(String name, LocalDate birthDate) {
		this.name = name;
		this.BIERT_DATE = birthDate;
		calculateCurrentAge();
		sortToAgeGroup();
	}

	public String getName() {
		return name;
	}
	
	public int getCurrentAge() {
		return currentAge;
	}

	public LocalDate getBIERT_DATE() {
		return BIERT_DATE;
	}
	
	public AgeGroup getAgeGroup() {
		return ageGroup;
	}
	
	/**
	 * Calculates kid`s age
	 */
	private void calculateCurrentAge() {
		LocalDate today = LocalDate.now();
		Period p = Period.between(today, BIERT_DATE);
		currentAge = Math.abs(p.getYears());
	}
	
	/**
	 * sort the kid to a group by its age
	 */
	private void sortToAgeGroup() {
		if(currentAge>=0 && currentAge<=1)
			ageGroup = AgeGroup.A;
		else if(currentAge>=2 && currentAge<=4)
			ageGroup = AgeGroup.B;
		else if(currentAge>=5 && currentAge<=10)
			ageGroup = AgeGroup.C;
		else
			ageGroup = AgeGroup.D;
		
	}
	
	/**
	 * Describe kid groups 
	 * A 0-1
	 * B 2-4
	 * C 4-6
	 * D 6+
	 * @author ketty
	 *
	 */
	public static enum AgeGroup {
		A,B,C,D;
	}
	

}
