package ajbc.factory_ex;

public abstract class Dialog {
	
	public abstract Theme createTheme();
	
	public void displayTheme() {
		Theme theme = createTheme();
		theme.setTheme();
	}

}
