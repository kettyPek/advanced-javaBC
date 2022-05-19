package ajbc.designPatterns;

public class Runner {

	// Adapter Design Pattern
	public static void main(String[] args) {
		
		BadHelicopter bedHelicopter = new BadHelicopter();
		
		Enemy bedHelicopterAsEnemy = new BadHelicopterToEnemy(bedHelicopter);
		
		bedHelicopterAsEnemy.turnRight();
		bedHelicopterAsEnemy.turnLeft();
		bedHelicopterAsEnemy.driveForward();
		bedHelicopterAsEnemy.driveBackwords();
		bedHelicopterAsEnemy.fireWeapon();

	}

}
