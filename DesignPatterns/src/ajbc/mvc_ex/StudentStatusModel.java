package ajbc.mvc_ex;

import java.util.List;

public class StudentStatusModel {
	
	private String firstName;
	private String lastName;
	private long id;
	private List<Double> grades;
	private String status;
	
	public StudentStatusModel(String firstName, String lastName, long id, List<Double> grades) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.grades = grades;
	}

	public void statusCalulator() {
		double gradesSum = 0;
		for(var grade : grades)
			gradesSum += grade;
		status = (gradesSum/grades.size()>=90) ? "an excellent student" : "a great student";
	}
	
	public String getStatus() {
		return status;
	}
	

}
