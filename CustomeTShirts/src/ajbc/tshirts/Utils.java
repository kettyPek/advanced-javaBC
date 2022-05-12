package ajbc.tshirts;

public class Utils {
	
	public static boolean valueInRange(double value, double minValue, double maxValue) {
		if(value>=minValue && value<=maxValue)
			return true;
		return false;
	}
	
	public static boolean valueInRange(short value, short minValue, short maxValue) {
		if(value>=minValue && value<=maxValue)
			return true;
		return false;
	}
	

}
