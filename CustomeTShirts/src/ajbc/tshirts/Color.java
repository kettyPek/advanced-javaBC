package ajbc.tshirts;

public class Color {
	
	private static final short MIN_RGB;
	private static final short MAX_RGB;
	protected short red;
	protected short green;
	protected short blue;
	
	static {
		MIN_RGB = 0;
		MAX_RGB = 255;
	}
	
	public Color() {
		this(MIN_RGB,MIN_RGB,MIN_RGB);
	}
	
	public Color(short red, short green,short blue) {
		setRed(red);
		setGreen(green);
		setBlue(blue);
	}
	
	
	public void setRed(short red ) {
		if(Utils.valueInRange(red,MIN_RGB,MAX_RGB))
				this.red = red;
	}
	
	protected void setBlue(short blue ) {
		if(Utils.valueInRange(blue,MIN_RGB,MAX_RGB))
				this.blue = blue;
	}
	
	protected void setGreen(short green ) {
		if(Utils.valueInRange(green,MIN_RGB,MAX_RGB))
				this.green = green;
	}
	
	public short getRed() {
		return red;
	}
	
	public short getGreen() {
		return green;
	}
	
	public short getBlue() {
		return blue;
	}
	


	@Override
	public String toString() {
		return "Color [red=" + red + ", blue=" + blue + ", green=" + green + "]";
	}
	
	public String getDiminant() {
		String dominant = "Red";
		if(blue>red && blue>green)
			dominant = "Blue";
		else 
			if(green>blue && green>red)
				dominant = "green";
		return dominant;
	}
	
	public float [] normalized() {
		float [] normalizedaRGB = new float [3];
		normalizedaRGB[0] = red/MAX_RGB;
		normalizedaRGB[1] = green/MAX_RGB;
		normalizedaRGB[2] = blue/MAX_RGB;
		return normalizedaRGB;
		
	}
	

}
