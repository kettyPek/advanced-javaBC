package ajbc.mvc_ex;

public class Runner {

	public static void main(String[] args) {
		
		StudentStatusView view = new StudentStatusView();
		StudentStatusController controller = new StudentStatusController(view);
		
		controller.checkStatus();

	}

}
