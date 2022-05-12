package ajbc.collections.runner;

import ajbc.collections.course_organziser.CourseOrganizer;
import ajbc.collections.courses.Course;

public class Runner {

	public static void main(String[] args) {
		
		Course course1 = new Course("Java",123456,"Experis",100);
		Course course2 = new Course("Python",456789,"Experis",98);
		Course course3 = new Course("C",546879,"Experis",80);
		Course course4 = new Course("C++",745621,"Experis",75);
		
		CourseOrganizer organizer = new CourseOrganizer();
		
		organizer.addCourse(course1);
		organizer.addCourse(course2);
		organizer.addCourse(course3);
		organizer.addCourse(course4);
		
		System.out.println(organizer);

	}

}
