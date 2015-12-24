
/** SYSC 2101 - Prof-Student-TA Example
 * 
 *
 */

import java.util.Date;

public class TeachingAssistant implements CourseListener{
	private String name;
	private Date midterm;

	public TeachingAssistant(String aName) {
		this.name = aName;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public void midtermAnnounced(CourseEvent e) {
		// TODO Auto-generated method stub
		this.midterm = ((Prof) e.getSource()).getMidterm();
		System.out.println(name + " : I have to proctor a midterm on " + this.midterm);
	}

	@Override
	public void midtermPostponed(CourseEvent e) {
		// TODO Auto-generated method stub
		
		this.midterm = ((Prof) e.getSource()).getMidterm();
		System.out.println(name + " : Now the midterm is on " + this.midterm);
	}
}