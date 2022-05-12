package liskov_substitution;

public class UnitUpgrader {
	
    
    public void ugradeSquareFootage(UpgradeableSquareFootage upgradeableSquareFootage) {
    	upgradeableSquareFootage.upgradeSquareFootage();
    }
    
    public void upgradeBedroomsNumber(UpgradeableBedrooms upgradeableBedrooms) {
    	upgradeableBedrooms.upgradeBedrooms();
    }
}
