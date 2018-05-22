
public class Test3 {
	public static void main(String[] args) { // 主方法
		String reg = "1[35]\\d{9}";
		String num = "13297967119";
		if (num.matches(reg)) {
			System.out.println(num + "是合法的手机号");
		}
	}
}
