package ajbc.command_ex;

import java.time.LocalTime;

public class OffCommand extends Command{


	public OffCommand(HeaterApp app) {
		super(app);
	}

	@Override
	public void execute() {
		super.time = LocalTime.now();
		System.out.println("Heater turned OFF on " + super.time );
	}

	@Override
	public String toString() {
		return "Heater turned OFF on " + super.time ;
	}
	
	

}
