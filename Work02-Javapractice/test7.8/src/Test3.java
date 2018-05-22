
public class Test3 {
	private float height;
	private float width;
	public Test3(float height,float width){
		this.height=height;
		this.width=width;
	}
	public float square(){
		return height*width;
	}
	public static void main(String args[]){
		Test3 u=new Test3(3.5f,4.5f);
		System.out.println(u.square());
	}
}