/** SYSC 2101 - Prof-Student-TA Example
 * 
 *
 */

import java.util.Date;

public class Student implements CourseListener{
	private String name;
	private Date midterm;

	public Student(String aName) {
		this.name = aName;
	}

	public String getName() {
		return this.name;
	}


	@Override
	public void midtermAnnounced(CourseEvent e) {
		// TODO Auto-generated method stub
		this.midterm = ((Prof) e.getSource()).getMidterm();
		System.out.println(name + " : Doh! I have to study hard for my midterm on " + this.midterm);
	}

	@Override
	public void midtermPostponed(CourseEvent e) {
		// TODO Auto-generated method stub
		this.midterm = ((Prof) e.getSource()).getMidterm();
		System.out.println(name + " : Alright! I get to party since my midterm isn't until " + this.midterm);
	}
}