package javabootcamp.oop.exercise;

import java.time.LocalTime;

public interface Appliable {
	
	LocalTime turnOn();
	long turnOffSec(LocalTime on);
}
