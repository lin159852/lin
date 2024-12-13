package uuu.gfs.test;

public class TestLocalVar {

	public static void main(String[] args) {
		int i,j=0;
		if(j>0) {
			i=1;
		//}else if(j<0) {     //課本用這行
		}else {
			i=2;
		}
		
		System.out.println(i); //就會編譯失敗
		
		int a;
		System.out.println(a=100);
		System.out.println(a+11);
		System.out.println(a);
		System.out.println(a=a+11);
		System.out.println(a);
		
	}

}
