package ajbc.collections.course_organziser;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import ajbc.collections.courses.Course;

public class CourseOrganizer {
	
	protected HashMap<Long,Course> courses;
	protected Set<Map.Entry<Long, Course>> coursesEnteris;
	protected Iterator<Entry<Long, Course>> coursesIterator;
	
	public CourseOrganizer() {
		courses = new HashMap<Long,Course>();
		coursesEnteris = courses.entrySet();
	}
	
	public void addCourse(Course course) {
		courses.put(course.getCourseID(), course);
	}
	
	public float coursesAvarage() {
		coursesIterator = coursesEnteris.iterator();
		float sum = 0;
		while(coursesIterator.hasNext())
			sum += coursesIterator.next().getValue().getGrade();
		return sum/courses.size();
	}
	
	public float calculateStandardDeviation() {
		float avarage = coursesAvarage();
		float gradeAvarageDifference = 0, standardDeviation = 0.0f;
		float grade;
		coursesIterator = coursesEnteris.iterator();
		while(coursesIterator.hasNext()) {
			grade = coursesIterator.next().getValue().getGrade();
			gradeAvarageDifference += Math.pow(grade-avarage, 2);
		}
		standardDeviation = (float)Math.sqrt(gradeAvarageDifference/courses.size());
		return standardDeviation;
	}

	@Override
	public String toString() {
		return  courses + "\n" + "Avarage: " + coursesAvarage()  + "\nstandard deviation: " + calculateStandardDeviation();
	}
	
	
	
	
	

}
