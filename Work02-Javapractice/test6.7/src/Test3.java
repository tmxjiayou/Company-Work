import java.util.*;
public class Test3 {
	public static void main(String[] args) {
		String arr[] = new String[] { "aa", "bb", "cc", "dd" };
		System.out.println("Ìæ»»Ç°£º");
		for (String str : arr) {
			System.out.print(str+"\t");
		}
		Arrays.fill(arr, 2, 3, "bb");
		System.out.println("\nÌæ»»ºó£º");
		for (String str2 : arr) {
			System.out.print(str2+"\t");
		}
	}
}
