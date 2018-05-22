
public class Test2 {
	public static void main(String[] args) { // 主方法
		String str1 = new String("Java");
		String str2 = new String("Hello Java");
		String str_1 = str1.substring(1,3);
		String str_2 = str2.substring(1,3);
		if(str_1.equalsIgnoreCase(str_2)){
			System.out.println("两个字符相同");
		}
		else{
			System.out.println("两个字符不相同");
		}
		}
}
