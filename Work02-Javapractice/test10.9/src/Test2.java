
public class Test2 {
	public void doSomething(){
		System.out.println("����.doSomething()");
	}
	public void doAnything(){
		System.out.println("����.doAnything()");
	}
	public static void main(String args[]){
		Test2 u=new sub();
		u.doSomething();
		u.doAnything();
	}
}

class sub extends Test2{
	public void doAnything(){
		System.out.println("����.doAnything()");
	}
}