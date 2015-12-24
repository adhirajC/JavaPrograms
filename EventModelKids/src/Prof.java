/** SYSC 2101 - Prof-Student-TA Example
 * 
 *
 */

import java.util.ArrayList;
import java.util.Date;

public class Prof {
	private String name;
	private Date midtermDate;
	private ArrayList<Student> students;
	private TeachingAssistant ta;
	private ArrayList<CourseListener>courselisteners;
	public Prof(String aName) {
		this.name = aName;
		this.students = new ArrayList<Student>();
		this.courselisteners=new ArrayList<CourseListener>();
	}

	public Date getMidterm() {
		return this.midtermDate;
	}

	public String getName() {
		return this.name;
	}

	public void setMidterm(Date date) {
		this.midtermDate = date;
		CourseEvent e=new CourseEvent(this);
		for (CourseListener cl:courselisteners){
			cl.midtermAnnounced(e);
		}
		
	}
	
	public void postponeMidterm(Date date){
		this.midtermDate = date;
		CourseEvent b=new CourseEvent(this);
		for (CourseListener cl:courselisteners){
			cl.midtermPostponed(b);
		}
	}
	
	public void setTA(TeachingAssistant theTA){
		this.ta = theTA;
	}
	
	public void addStudent(Student s){
		this.students.add(s);
	}

	public synchronized void addCourseListener(CourseListener cl){
		courselisteners.add(cl);
	}
	public synchronized void removeCourseListener(CourseListener cl){
		courselisteners.remove(cl);
	}
	public static void main(String[] args) {

		Prof p = new Prof("Babak");
		Student s = new Student("Homer");
		Student s2 = new Student("Bart");
		TeachingAssistant ta = new TeachingAssistant("Michael");
	
	
		p.addCourseListener(s);
		p.addCourseListener(s2);
		p.addCourseListener(ta);
	
	
		Date midterm = new Date();
		p.setMidterm(midterm);
	
		p.postponeMidterm(new Date(midterm.getTime() + 1000000000));
	}

}