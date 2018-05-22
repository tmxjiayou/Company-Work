import java.util.*;
public class Test1 {
	public static void main(String[] args) {
		List list = new LinkedList();
		for(int i = 1 ;i<=100;i++){
			list.add(new Integer(i));
			}
		list.remove(list.get(10));
		System.out.println("ok");
	}
}
