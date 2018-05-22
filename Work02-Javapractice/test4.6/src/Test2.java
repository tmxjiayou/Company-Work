
public class Test2 {
	public static void main(String args[]){			
		for(int i=1;i<=7;i+=2){
			for(int k=7;k>i-1;k--){
				System.out.print(" ");
			}
			for(int x=1;x<=i;x++){
				System.out.print("* ");
			}
		       System.out.println();
		}
		for(int j=1;j<=5;j+=2){
				for(int k1=1;k1<j+3;k1++){
					System.out.print(" ");
				}
				for(int x1=5;x1>=j;x1--){
					System.out.print("* ");
				}
			System.out.println();
		}
    }
}
