package ajbc.tshirts;

public class Tshirt {

	private static final double MIN_DEMAND_FACTOR;
	private static final double MAX_DEMAND_FACTOR;
	private static final double MIN_BASE_PRICE;
	private static final double EXPENSIVE_PRICE;
	protected Sizes size;
	protected Design design;
	protected double demandFactor ;
	protected double basePrice ;
	
	static {
		MIN_DEMAND_FACTOR = 0.1;
		MAX_DEMAND_FACTOR = 1;
		MIN_BASE_PRICE = 3;
		EXPENSIVE_PRICE = 10000;
	}
	
	public Tshirt() {
		setSize(Sizes.S);
		setDesign(new Design());
		setDemandFactor(MIN_DEMAND_FACTOR);
		setBasePrise(MIN_BASE_PRICE);
	}
	
	public Tshirt(Sizes size,Design design,double demandFactor,double basePrice) {
			setSize(size);
			setDesign(design);
			setDemandFactor(demandFactor);
			setBasePrise(basePrice);
		}
	
	//
	protected void setSize(Sizes size) {
		if(size==null)
			this.size = Sizes.S;
		else
			this.size = size;
	}
	
	protected void setDesign(Design design) {
		if(design==null)
			this.design = new Design();
		else
			this.design = design;
	}
	
	protected void setDemandFactor(double demanFactor) {
		if(demanFactor>=MIN_DEMAND_FACTOR && demanFactor<=MAX_DEMAND_FACTOR)
			this.demandFactor = demanFactor;
		else
			this.demandFactor = MIN_DEMAND_FACTOR;
	}
	
	protected void setBasePrise(double basePrice) {
		if(basePrice>=MIN_BASE_PRICE)
			this.basePrice = basePrice;
		else
			this.basePrice = MIN_BASE_PRICE;
	}
	
	@Override
	public String toString() {
		return "Tshirt [size=" + size + ", design=" + design + ", demandFactor=" + demandFactor + ", basePrice="
				+ basePrice + "]";
	}

	//
	public double calculateFinalPrice() {
		return (basePrice + design.complexity)*design.calculateArea()/demandFactor;
	}
	
	public boolean isExpensive() {
		return calculateFinalPrice()>=EXPENSIVE_PRICE;
	}
 

	protected enum Sizes{
		XS,S,M,L,XL;
	}
	
}
