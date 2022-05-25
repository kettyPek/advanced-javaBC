package ajbc.forecast;

public class Forecast {
	
	private String city;
	private float temprature;
	private int humidityPercent;
	
	public Forecast(String city, float temprature, int humidityPercent) {
		this.city = city;
		this.temprature = temprature;
		this.humidityPercent = humidityPercent;
	}

	@Override
	public String toString() {
		return "Forecast [city=" + city + ", temprature=" + temprature + ", humidityPercent=" + humidityPercent + "]";
	}

	public String getCity() {
		return city;
	}

	public float getTemprature() {
		return temprature;
	}
	
	public int getHumidityPercent() {
		return humidityPercent;
	}
	
}
