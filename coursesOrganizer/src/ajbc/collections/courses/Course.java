package ajbc.collections.courses;

public class Course {
	
	protected final String NAME;
	protected final long COURSE_ID;
	protected final String SCHOOL_NAME;
	protected float grade;
	
	public Course(String name, long number, String schoolName,float grade) {
		this.NAME = name;
		this.COURSE_ID  = number;
		this.SCHOOL_NAME = schoolName;
		this.grade = grade;
	}

	public Long getCourseID() {
		return COURSE_ID;
	}

	public float getGrade() {
		return grade;
	}
	
	@Override
	public String toString() {
		return "Course [name = " + NAME + ", course ID = " + COURSE_ID + ", school name = " + SCHOOL_NAME + ", grade = " + grade
				+ "]\n";
	}
	

}
