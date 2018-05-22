import java.util.*;
public class Test2 {
	public static void main(String[] args) {
        Set set = new HashSet();  //HashSet是Set的子接口
        set.add("a");
        set.add("a");
        set.add("A");
        set.add("c"); 
        set.add("C");
        List list = new ArrayList();
        list.add("a");
        list.add("a");
        list.add("A");
        list.add("c"); 
        list.add("C");
        System.out.println(set);
       System.out.println(list);
	}
}
