package javabootcamp.oop.remoteControl;

import java.time.LocalTime;

public class RemoteControl {
	
	protected String transmitMethod;
	
	//constructor
	public RemoteControl(String transmitMethod) {
		setTransmitMethod(transmitMethod);
	}
	
	//methods
	public void setTransmitMethod(String transmitMethod) {
		if(transmitMethod=="RF" || transmitMethod=="IR")
			this.transmitMethod = transmitMethod;
	}
	
	public String getTransmitMethod() {
		return transmitMethod;
	}

	@Override
	public String toString() {
		return "RemoteControl [transmitMethod=" + transmitMethod + "]";
	}
	

}
