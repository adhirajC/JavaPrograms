package xmlRight;

public class XMLDocument {
	
	
	public static void main(String[] args) {
		ElemetGroup a=new ElemetGroup();
		a.setName("Course");
		Element code=new Element();
		code.setName("Code","Sysc 3110");
		Element babak=new Element();
		babak.setName("Prof","Babak");
		a.add(code);
		a.add(babak);
		ElemetGroup b=new ElemetGroup();
		b.setName("Class");
		a.add(b);
		Element athu=new Element();
		athu.setName("Student","Athu");
		Element homie=new Element();
		homie.setName("Student","Athu");
		b.add(athu);
		b.add(homie);
		a.DisplayInfo();
	}
}
