
import java.lang.reflect.Array;

public class Text1 {

	public static void main(String[] args) {

		Test test = new Test();

		test.print();

		test.a = (int[]) addArrayLength(test.a, 10);
		test.b = (String[]) addArrayLength(test.b, 10);

		test.print();

	}

	public static Object addArrayLength(Object array, int newLength) {
		Object newArray = null;
		Class componentType = array.getClass().getComponentType();
		newArray = Array.newInstance(componentType, newLength);
		System.arraycopy(array, 0, newArray, 0, Array.getLength(array));
		return newArray;
	}
}

class Test {

	public int[] a = { 1, 2, 3 };

	public String[] b = { "AA", "BB", "CC" };

	public void print() {

		for (int index = 0; index < a.length; index++) {
			System.out.println("a[" + index + "]=" + a[index]);
		}

		System.out.println();

		for (int index = 0; index < b.length; index++) {
			System.out.println("b[" + index + "]=" + b[index]);
		}

		System.out.println();

	}

}