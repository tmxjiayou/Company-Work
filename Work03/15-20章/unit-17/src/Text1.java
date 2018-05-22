import java.util.Scanner;
import java.io.File;
import java.io.OutputStream;
import java.io.FileOutputStream;

public class Text1{
	public static void main(String[] args) throws Exception{
			Scanner scan=new Scanner(System.in);
			
			System.out.println("«Î ‰»Îƒ⁄»›£∫");
			
			File f=new File("E:"+File.separator+"text1.txt");
			
			OutputStream out=new FileOutputStream(f);
			
			String str=scan.next();
			
			byte b[]=str.getBytes();
			
			out.write(b);
			
			out.close();
	}
}