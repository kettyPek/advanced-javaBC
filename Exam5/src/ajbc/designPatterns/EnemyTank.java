package ajbc.designPatterns;

public class EnemyTank implements Enemy{

	@Override
	public void turnRight() {
		System.out.println("Turned Right");
		
	}

	@Override
	public void turnLeft() {
		System.out.println("Turned Left");
		
	}

	@Override
	public void driveForward() {
		System.out.println("Drove forward");
		
	}

	@Override
	public void driveBackwords() {
		System.out.println("Drove backwards");
		
	}

	@Override
	public void fireWeapon() {
		System.out.println("Fired a weapon");
		
	}

}
