package xmlRight;

import java.util.ArrayList;

public class ElemetGroup extends ElementsComponent{
String elementGroup;
ArrayList<ElementsComponent> elements=new ArrayList<ElementsComponent>();
	public void setName(String a){
		this.elementGroup=a;;
	}
	public String getName(){
		return elementGroup;
	}
	public void add(ElementsComponent element){
		elements.add(element);
	}
	public void remove(ElementsComponent element){
		elements.remove(element);
	}
	public void DisplayInfo(){
		System.out.println("<"+elementGroup+">");
		for (ElementsComponent e: elements){
			e.DisplayInfo();
		}
		System.out.println("</"+elementGroup+">");
	}
}
