package ajbc.mvc_ex;

import java.util.List;

public class StudentStatusController {
	
	private StudentStatusModel model;
	private StudentStatusView view;
	
	public StudentStatusController(StudentStatusView view) {
		this.view = view;
	}
	
	public void checkStatus() {
		String firstName = view.receiveFirstName();
		String lastName = view.receiveLastName();
		long id = view.receiveID();
		List<Double> grades = view.receiveGrades();
		model = new StudentStatusModel(firstName,lastName,id,grades);
		model.statusCalulator();
		String status  = model.getStatus();
		view.displayStatus(status);
	}
	
	

}
