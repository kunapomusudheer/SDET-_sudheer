package practice;

 public class Singletonclass {

	String name;
	private  Singletonclass (String name){
		this.name=name;
	 System.out.println(name);
	 }
	public  void add(int i,int b) {
		System.out.println(i+b);
}
public static Singletonclass accessclass() {	
	Singletonclass s=new Singletonclass("k");
	return s;
 }
}