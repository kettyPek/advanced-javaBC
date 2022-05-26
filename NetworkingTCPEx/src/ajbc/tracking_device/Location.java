package ajbc.tracking_device;

import java.time.LocalTime;

public class Location {
	
	private double longtitude;
	private double altitude;
	private LocalTime timeStamp;
	
	public Location(double longtitude, double altitude) {
		super();
		this.longtitude = longtitude;
		this.altitude = altitude;
		this.timeStamp = LocalTime.now();
	}
	
	public Location(double longtitude, double altitude,LocalTime timeStamp) {
		super();
		this.longtitude = longtitude;
		this.altitude = altitude;
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return longtitude + "-" + altitude + "-" + timeStamp ;
	}
	
}
