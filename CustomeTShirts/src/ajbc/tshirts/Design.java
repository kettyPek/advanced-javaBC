package ajbc.tshirts;

public class Design {
	private static final double MIN_WIDTH;
	private static final double MAX_WIDTH ;
	private static final double MIN_HEIGHT;
	private static final double MAX_HEIGHT;
	private static final double MIN_COPLEXITY;
	private static final double MAX_COPLEXITY;
	protected double width;
	protected double height;
	protected String slogan;
	protected Color color;
	protected double complexity;
	
	static {
		MIN_WIDTH = 20;
		MAX_WIDTH = 30;
		MIN_HEIGHT = 10;
		MAX_HEIGHT = 25;
		MIN_COPLEXITY = 1;
		MAX_COPLEXITY = 100;
	}
	
	public Design() {
		this(MIN_WIDTH,MIN_HEIGHT,"",new Color(),MIN_COPLEXITY);
	}
	
	public Design(double width,double height,String slogan,Color color,double complexity) {
		setWidth(width);
		setHeight(height);
		setComplexity(complexity);
		setColor(color);
		setSlogan(slogan);
	}
	
	protected void setWidth(double width) {
		if(Utils.valueInRange(width,MIN_WIDTH,MAX_WIDTH))
			this.width = width;
	}
	
	protected void setHeight(double height) {
		if(Utils.valueInRange(height,MIN_HEIGHT,MAX_HEIGHT))
			this.height = height;
		else
			this.height = MIN_HEIGHT;
	}
	
	protected void setComplexity(double complexity) {
		if(Utils.valueInRange(complexity,MIN_COPLEXITY,MAX_COPLEXITY))
			this.complexity = complexity;
		else
			this.complexity = MIN_COPLEXITY;
	}
	
	protected void setColor(Color color) {
		this.color = color;
	}
	
	protected void setSlogan(String slogan) {
		if(sloganIsValid(slogan))
			this.slogan = slogan;
		else
			this.slogan = "";
	}
	
	
	private boolean sloganIsValid(String slogan) {
		if(slogan == null)
			return false;
		slogan.replace(" ","");
		char ch ;
		for(int i=0; i<slogan.length(); i++) { 
			ch = slogan .charAt(i);
			if(ch<'0'||ch>'9' )
				if( ch<'a'|| ch>'z')
					if(ch<'A'|| ch>'B')
						return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Design [width=" + width + ", height=" + height + ", slogan=" + slogan + ", color=" + color
				+ ", complexity=" + complexity + "]";
	}
	
	public double calculateArea() {
		double area = width*height;
		return area;
	}

}
