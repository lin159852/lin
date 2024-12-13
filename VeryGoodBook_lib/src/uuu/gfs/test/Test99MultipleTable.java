package uuu.gfs.test;

public class Test99MultipleTable {

	public static void main(String[] args) {
		//for(;;) {                   中間條件式恆真
		//	System.out.println(10);   無窮迴圈
		//}
		
		for(int i=1;i<10;i++) {
			for(int j=1;j<10;j++) {
				System.out.printf("%s * %s = %s%s", i, j, i*j, (j==9?"\n":"\t"));
			}
		}
		
		//System.out.printf("1 * 2 = %s\t", 1*2);
		//System.out.printf("1 * 3 = %s\n", 1*3);
		
		//System.out.printf("2 * 1 = %s\t", 2*1);
		//System.out.printf("2 * 2 = %s\t", 2*2);
		//System.out.printf("2 * 3 = %s\n", 2*3);
		
		//System.out.printf("3 * 1 = %s\t", 3*1);
		//System.out.printf("3 * 2 = %s\t", 3*2);
		//System.out.printf("3 * 3 = %s\n", 3*3);
	}
	
}
