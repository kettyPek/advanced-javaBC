package liskov_substitution;

public class PenthouseSuite extends Apartment implements UpgradeableSquareFootage, UpgradeableBedrooms{
	
    public PenthouseSuite() {
        this.numberOfBedrooms = 4;
    }

    public void setSquareFootage(int sqft) {
        this.squareFootage = sqft;
    }

	@Override
	public void upgradeSquareFootage() {
		this.squareFootage += 40;
		
	}

	@Override
	public void upgradeBedrooms() {
		this.numberOfBedrooms += 1;
		
	}
}
