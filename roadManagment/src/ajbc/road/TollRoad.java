package ajbc.road;

import java.util.LinkedList;

import ajbc.car.Car;
import ajbc.check_points.CheckPoint;

public class TollRoad {
	
	protected LinkedList<CheckPoint> checkPoints;
	protected LinkedList<Car> cars;
	
	public TollRoad(LinkedList<CheckPoint> checkPoints,LinkedList<Car> cars) {
		this.checkPoints = new LinkedList<CheckPoint>();
		this.cars = new LinkedList<Car>();
		this.checkPoints.addAll(checkPoints);
		this.cars.addAll(cars);
		setCarsIterators();
	}
	
	
	public void addCheckPoints(LinkedList<CheckPoint> checkPoints) {
		this.checkPoints.addAll(checkPoints);
	}
	
	
	public void addCars(LinkedList<Car> cars) {
		this.cars.addAll(cars);
	}
	
	public void addCheckPoint(CheckPoint checkPoint, int position) {
		checkPoints.add(position, checkPoint);
		updateCheckPoints(position,1);
		updatedCarsChekPoints(checkPoints);
		
	}
	
	public void deleteCheckPoint(int position) {
		checkPoints.remove(position);
		updateCheckPoints(position,-1);
		updatedCarsChekPoints(checkPoints);
		
	}

	private void updateCheckPoints(int position,int moveTo) {
		for(int i=position+1; i<checkPoints.size(); i++)
			checkPoints.get(i).setPositionNumber(i+moveTo);
	}
	
	private void setCarsIterators() {
		for(Car car : cars)
			car.assignCheckPoints(checkPoints);
	}
	
	private void updatedCarsChekPoints(LinkedList<CheckPoint> checkPoints) {
		for(Car car: cars)
			car.updateCheckPoints(checkPoints);
	}
	
	
	
	
	
	
	
	

}
