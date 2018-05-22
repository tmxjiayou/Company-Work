import java.io.*;

import javax.swing.*;

public class Text1 {
	public static void main(String[] temp) {
		byte a[] = new byte[2];
		try{
			FileInputStream file = new FileInputStream("text22.txt");
			ProgressMonitorInputStream in = 
				new ProgressMonitorInputStream(null,"¶ÁÈ¡ÎÄ¼þ",file);
			ProgressMonitor p = in.getProgressMonitor();
		   while(in.read(a)!=-1){
			   String c = new String(a);
			   System.out.print(c);
			   Thread.sleep(100);
		   }
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
