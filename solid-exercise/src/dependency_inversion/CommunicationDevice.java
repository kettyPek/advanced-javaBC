package dependency_inversion;

public interface CommunicationDevice {
	
	String generateWeatherAlert(String weatherDescription);
	
	void diasplayAlert(String Alert);
}
