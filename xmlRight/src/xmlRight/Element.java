package xmlRight;

public class Element extends ElementsComponent{
String a;
String b;
public void setName(String a, String b){
this.a=a;
this.b=b;
}
public String getName(){
	return "<"+a+">"+b+"</"+a+">";
}
public void DisplayInfo(){
	System.out.println(getName());
}
}
