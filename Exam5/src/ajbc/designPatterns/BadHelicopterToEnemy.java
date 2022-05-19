package ajbc.designPatterns;

public class BadHelicopterToEnemy implements Enemy{
	
	private BadHelicopter badtHelicopter;
	
	public BadHelicopterToEnemy(BadHelicopter badtHelicopter) {
		this.badtHelicopter = badtHelicopter;
	}

	@Override
	public void turnRight() {
		badtHelicopter.yawToRight();
		
	}

	@Override
	public void turnLeft() {
		badtHelicopter.yawToLeft();
		
	}

	@Override
	public void driveForward() {
		badtHelicopter.flyUp();
		
	}

	@Override
	public void driveBackwords() {
		badtHelicopter.flyDown();
		
	}

	@Override
	public void fireWeapon() {
		badtHelicopter.launchAMissile();		
	}
	
	

}
