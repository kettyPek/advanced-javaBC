package ajbc.factory_ex;

public class LightThemeDialog extends Dialog{

	@Override
	public Theme createTheme() {
		return new LightTheme();
	}

}
