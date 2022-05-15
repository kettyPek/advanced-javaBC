package ajbc.command_ex;

import java.time.LocalTime;

public class OnCommand extends Command{

	private int workingMinutes ;
	private String action;

	public OnCommand(HeaterApp app) {
		super(app);
	}

	@Override
	public void execute() {
		super.time = LocalTime.now();
		workingMinutes = super.app.getWorkingMinutes();
		if(workingMinutes<=90)
			action = "Heater turned ON for "+ workingMinutes + " on " + super.time;
		else
			action = "Working time must be less then 90 minutes";
		System.out.println(action);
	}

	@Override
	public String toString() {
		return action;
	}
	
	

}
