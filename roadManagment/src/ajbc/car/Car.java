package ajbc.car;

import java.util.LinkedList;
import java.util.ListIterator;

import ajbc.check_points.CheckPoint;

public class Car {
	protected long plateNumber;
	protected int fee;
	protected int position;
	protected LinkedList<CheckPoint> checkPoints = null;
	protected ListIterator<CheckPoint> iteratorCheckPoints = null;
	
	
	public Car(long plateNumber) {
		this.plateNumber = plateNumber;
		fee = 0;
		position = 0 ;
	}
	
	public void assignCheckPoints(LinkedList<CheckPoint> checkPoints) {
		this.checkPoints = checkPoints;
		iteratorCheckPoints = checkPoints.listIterator();
	}
	
	public void updateCheckPoints(LinkedList<CheckPoint> checkPoints) {
		assignCheckPoints(checkPoints);
		for(int i=1;i<position; i++)
			iteratorCheckPoints.next();
		
	}
	public void driveToNextCheckPoint() {
		position = iteratorCheckPoints.nextIndex()+1;
		iteratorCheckPoints.next(); 
		fee +=5;
	}
	
	public void driveToPreviousCheckPoint() {
		position = iteratorCheckPoints.previousIndex()+1;
		iteratorCheckPoints.previous();
		fee +=5;
	}
	
	public void driveToNextOrPreviousCheckPoint(LinkedList<CheckPoint> checkPoints) {
		if(!iteratorCheckPoints.hasPrevious()) {
			driveToNextCheckPoint();
			return;
		}
		if(!iteratorCheckPoints.hasNext()) {
			driveToPreviousCheckPoint();
			return;
		}
		randomDrive();
	}
	
	private void randomDrive() {
		
		int num = (int)(Math.random()*2);
		switch(num) {
		case 0: 
			driveToNextCheckPoint();
			break;
		case 1:
			driveToPreviousCheckPoint();
			break;
		}
	}

	@Override
	public String toString() {
		return "Car [plateNumber=" + plateNumber + ", Current fee =" + fee + ", position=" +position+"]";
	}
	
	
	

}
