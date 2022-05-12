package liskov_substitution;

public class Studio extends Apartment implements UpgradeableSquareFootage{
	
    public Studio() {
        this.numberOfBedrooms = 0;
    }

    public void setSquareFootage(int sqft) {
        this.squareFootage = sqft;
    }

	@Override
	public void upgradeSquareFootage() {
		this.squareFootage += 40;
		
	}
}
