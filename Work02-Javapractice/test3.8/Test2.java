
public class Test2 {
	static int age = 23; // 声明的类变量。
		
	public static void t1() {
		age = 30;
		String name = "tmx";
		System.out.println("年龄是："+age); 
	}
		
	public static void main(String[] args) { // 主方法
		System.out.println("年龄是："+age); 
		t1();
	}
}
/*
 *成员变量：
 *		在类体里面定义的变量叫做成员变量；
 * 		如果在变量有static关键字修饰，就叫作静态变量或类变量；
 * 		如果该变量没有static关键字修饰，就叫作非静态变量或实例变量；
 * 
 * 局部变量：
 * 		在方法内定义的变量、形参、代码块中定义的变量都叫做局部变量；
 * 
 * 		另外，成员变量可以不显式初始化，它们可以由系统设定默认值；局部变量没有默认值，
 * 所以必须设定初始赋值。还有，在内存中的位置也不一样。成员变量在所在类被实例化后，
 * 存在堆内存中；局部变量在所在方法调用时，存在栈内存空间中。
*/