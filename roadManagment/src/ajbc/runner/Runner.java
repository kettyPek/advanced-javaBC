package ajbc.runner;

import java.util.LinkedList;

import ajbc.car.Car;
import ajbc.check_points.CheckPoint;
import ajbc.road.TollRoad;

public class Runner {

	public static void main(String[] args) {
		
		LinkedList<CheckPoint> checkPoints = new LinkedList<CheckPoint>();
		checkPoints.add(new CheckPoint("point 1","111"));
		checkPoints.add(new CheckPoint("point 2","222"));
		checkPoints.add(new CheckPoint("point 3","333"));
		checkPoints.add(new CheckPoint("point 4","444"));
		
		LinkedList<Car> cars = new LinkedList<Car>();
		cars.add(new Car(123456));
		cars.add(new Car(456789));
		cars.add(new Car(789458));
		cars.add(new Car(987654));
		cars.add(new Car(321456));
		
		TollRoad road = new TollRoad(checkPoints,cars);
		
		for(int i=1; i<=5; i++) {
			for(Car car:cars) {
				car.driveToNextOrPreviousCheckPoint(checkPoints);
				System.out.println(car);
			}
			System.out.println("-----------");
		}
		
		road.deleteCheckPoint(2);
		
		for(int i=1; i<=5; i++) {
			for(Car car:cars) {
				System.out.println(car);
			}
			System.out.println("-----------");
		}
		
		
		
		
		
		

	}

}
