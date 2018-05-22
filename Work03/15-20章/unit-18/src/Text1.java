

public class Text1 extends Thread {
	int index=0;
	String[] str={"1","2","3","4","5","¥ÛΩ–∫√£¨Œ“Ω–‚’√œŒı"};
	public void run() {
		while (true) {
			System.out.println(str[index++%6]);
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new Text1().start();
	}
}
