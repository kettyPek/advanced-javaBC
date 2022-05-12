package javabootcamp.system;

import java.time.LocalDateTime;
import java.util.Properties;

public class Runner {

	public static void main(String[] args) {
		
		LocalDateTime cuurentDay = LocalDateTime.now();
		System.out.println("Day of the week: " +cuurentDay.getDayOfWeek() + " current time: " + cuurentDay.toLocalTime());
		
		Properties props =  System.getProperties();
		System.out.println("User name: " + props.getProperty("user.name"));
		
		String userEmail = "user.email"; 
		props.setProperty(userEmail, "ketty.pekatsky@hmail.com");
		System.out.println("Email: " + props.getProperty("user.email"));
		
		String userPhoneNum = "user.phoneNumber"; 
		props.setProperty(userPhoneNum, "054-6255399");
		System.out.println("Phone number: " + props.getProperty("user.phoneNumber"));
		System.out.println("OS architecture:" + props.getProperty("os.arch"));
		System.out.println("OS type: " + props.getProperty("os.name"));

	}

}
