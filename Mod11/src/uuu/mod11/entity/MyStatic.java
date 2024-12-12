package uuu.mod11.entity;

public class MyStatic {
	private static int i; //static屬性
	private int j;        //non-static屬性
	
	public static int getI() {
		return i;
	}
	public static void setI(int i) {
		MyStatic.i = i;
	}
	public int getJ() {
		return j;
	}
	public void setJ(int j) {
		this.j = j;
	}
	
}
