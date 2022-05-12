package ajbc.exam;

import java.io.Serializable;
import java.time.LocalDate;

public class Dragon implements Serializable{
	
	private final int MIN_FLAME_INTENSITY = 0;
	private final int MAX_FLAME_INTENSITY = 10;
	
	private String name;
	private LocalDate birthdate;
	private int flameIntensity;
	
	
	public Dragon(String name, LocalDate birthdate, int flameIntensity) {
		this.name = name;
		this.birthdate = birthdate;
		this.flameIntensity = flameIntensity;
	}
	
	public void setBirthDate(LocalDate birthDate) throws TooYoungException{
		LocalDate minBirthDate = LocalDate.of(888, 8, 8);
		if(birthDate.isBefore(minBirthDate))
			throw new TooYoungException();
		else
			this.birthdate = birthDate;
		
	}


	@Override
	public String toString() {
		return "Dragon [name=" + name + ", birthdate=" + birthdate + ", flameIntensity=" + flameIntensity + "]";
	}
	
	
	
	

}
