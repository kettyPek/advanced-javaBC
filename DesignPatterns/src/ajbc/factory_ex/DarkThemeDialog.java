package ajbc.factory_ex;

public class DarkThemeDialog extends Dialog{

	@Override
	public Theme createTheme() {
		return new DarkTheme();
		
	}	

}
