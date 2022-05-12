package ajbc.factory_ex;

import java.util.Scanner;

public class Runner {

	private static Dialog dialog ;
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.println("Enter:\n1-dark theme\n2-light theme");
		int selection = scanner.nextInt();
		selectTheme(selection);
		diplayTheme();
		scanner.close();

	}
	
	public static void selectTheme(int selection) {
		if(selection==1)
			dialog = new DarkThemeDialog();
		else
			dialog = new LightThemeDialog();
	}
	
	public static void diplayTheme(){
		dialog.displayTheme();
	}


}
