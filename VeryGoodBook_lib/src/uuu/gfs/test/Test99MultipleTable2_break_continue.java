package uuu.gfs.test;

import java.time.LocalDate;
import java.util.Scanner;

public class Test99MultipleTable2_break_continue {

	public static void main(String[] args) {
		// 利用for迴圈做99乘法表
//		for (int i = 1; i < 10; i++) {
//			for (int j = 1; j < 10; j++) {
//				System.out.printf("%s*%s=%s%s", i, j, i * j, "\t");
//			}
//			System.out.printf("\n");
//		}

		// 利用while迴圈做99乘法表
//		int i = 1, j = 1;
//		while (i < 10) {
//			while (j < 10) {
//				int k = i * j;
//				System.out.printf("%s*%s=%s\t", i, j, k);
//				j++;
//			}
//			j = 1;
//			System.out.println();
//			i++;
//		}

		// 利用do while迴圈做99乘法表
//		int a = 1, b = 1;
//		do {
//			do {
//				int c = a * b;
//				System.out.printf("%s*%s=%s\t", a, b, c);
//				b++;
//			} while (b < 10);
//			a++;
//			b = 1;
//			System.out.println();
//		} while (a < 10);

		// 利用for迴圈與break畫下三角
//		for (int i = 1; i < 10; i++) {          //解法1
//			for (int j = 1; j <= i; j++) {
//				System.out.printf("%s*%s=%s%s", i, j, i * j, "\t");
//			}
//			System.out.printf("\n");
//		}
//		for (int i = 1; i < 10; i++) {          //解法2
//			for (int j = 1; j < 10; j++) {
//				System.out.printf("%s*%s=%s%s", i, j, i * j, "\t");
//				if (j == i)
//					break;
//			}
//			System.out.printf("\n");
//		}

		// 畫三角形
//		for (int i = 0; i < 5; i++) {
//			for (int j = 1; j < 10; j++) {
//				if (5 - i <= j & j <= 5 + i) {
//					System.out.print("▲");
//				} else {
//					System.out.print(" ");
//				}
//			}
//			System.out.println();
//		}

		// 畫倒三角形
//		for (int i = 0; i < 5; i++) {
//			for (int j = 1; j < 10; j++) {
//				if (j - i > 0 & j + i < 10) {
//					System.out.print("▼");
//				} else
//					System.out.print(" ");
//			}
//			System.out.println();
//		}

		// continue練習99乘法表
//		for (int i = 1; i < 10; i++) {
//			for (int j = 1; j < 10; j++) {
//				System.out.printf("%s*%s=%s%s", i, j, i * j, "\t");
//				if (j == i)
//					continue;
//			}
//			System.out.printf("\n");
//		}

		// 畫沙漏
//		for (int i = 0; i < 5; i++) {
//			for (int j = 1; j < 10; j++) {
//				if ((5 - i <= j & j <= 5 + i) | (j - i > 0 & j + i < 10)) {
//					System.out.print("▲");
//				} else
//					System.out.print(" ");
//			}
//			System.out.println();
//		}

		// 畫菱形
//		for (int i = 0; i < 5; i++) {
//			for (int j = 1; j < 10; j++) {
//				if ((5 - i <= j & j <= 5 + i) & (j - i > 0 & j + i < 10)) {
//					System.out.print("▲");
//				} else
//					System.out.print(" ");
//			}
//			System.out.println();
//		}

		// 畫六芒星
//		int i, j;
//		for (i = 1; i <= 7; i++) {
//			if (i == 1 | i == 2 | i == 4 | i == 5) {
//				for (j = 1; j <= 9; j++) {
//					if (6 - i <= j & j <= 4 + i)
//						System.out.print("▲");
//					else
//						System.out.print(" ");
//				}
//				System.out.println();
//			} if (i == 3 | i == 6 | i == 7) {
//				for (j = 1; j <= 9; j++) {
//					if (j - i > -3 & j + i < 13)
//						System.out.print("▼");
//					else
//						System.out.print(" ");
//				}
//				System.out.println();
//			}
//		}
		
		//指定數字與0之間哪些是質數
		Scanner scan = new Scanner(System.in);
		int prime = scan.nextInt();
		scan.close();
		//System.out.println(prime);
		int i, j;
		for(i=1 ; i<=prime/2 ; i++) {
			for(j=1 ; j<=i ; j++) {
				if(i%j!=0 & i/j==1) {
					System.out.printf("%d\n", i);
				}
			}
		}
		
		
		
	}
}
