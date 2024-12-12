package uuu.vgb.test;

public class TestROCID {
	
	public boolean checkId(String id) {
		if (id != null && id.matches("[A-Z][1289][0-9]{8}")) {
			// TODO: 依據身分證字號檢查規則
			// 1.1 取出id中的第一個字元並轉成對應的整數
			char firstChar = id.charAt(0);
			int e1;
//			if (firstChar == 'B' || firstChar == 'N' || firstChar == 'Z') {
//				e1 = 0;
//			} else if (firstChar == 'A' || firstChar == 'M' || firstChar == 'W') {
//				e1 = 1;
//			} else if (firstChar == 'K' || firstChar == 'L' || firstChar == 'Y') {
//				e1 = 2;
//			} else if (firstChar == 'J' || firstChar == 'V' || firstChar == 'X') {
//				e1 = 3;
//			} else if (firstChar == 'H' || firstChar == 'U') {
//				e1 = 4;
//			} else if (firstChar == 'G' || firstChar == 'T') {
//				e1 = 5;
//			} else if (firstChar == 'F' || firstChar == 'S') {
//				e1 = 6;
//			} else if (firstChar == 'E' || firstChar == 'R') {
//				e1 = 7;
//			} else if (firstChar == 'D' || firstChar == 'O' || firstChar == 'Q') {
//				e1 = 8;
//			} else {    // C, I, P
//				e1 = 9;
//			}
			// 1.2 取出id中的第一個字元並轉成對應的整數
			
			switch(firstChar) {
				case 'B':
				case 'N':
				case 'Z':
					e1 = 0;
					break;
				case 'A':
				case 'M':
				case 'W':
					e1 = 1;
					break;
				case 'K':
				case 'L':
				case 'Y':
					e1 = 2;
				case 'J':
				case 'V':
				case 'X':
					e1 = 3;
					break;
				case 'H':
				case 'U':
					e1 = 4;
					break;
				case 'G':
				case 'T':
					e1 = 5;
					break;
				case 'F':
				case 'S':
					e1 = 6;
					break;
				case 'E':
				case 'R':
					e1 = 7;
					break;
				case 'D':
				case 'O':
				case 'Q':
					e1 = 8;
					break;
				default:    // C, I, P
					e1 = 9;
					//break;
			}
			
			
			
			// 2. 加總
//			int n1 = id.charAt(1)-'0'; //減掉0字元ASCII碼48也可
//			int n2 = id.charAt(2)-'0';
//			int n3 = id.charAt(3)-'0';
//			int n4 = id.charAt(4)-'0';
//			int n5 = id.charAt(5)-'0';
//			int n6 = id.charAt(6)-'0';
//			int n7 = id.charAt(7)-'0';
//			int n8 = id.charAt(8)-'0';
//			int n9 = id.charAt(9)-'0';
//			int sum = e1 + n1*8 +n2*7 + n3*6 + n4*5 + n5*4 + n6*3 + n7*2 + n8*1 + n9*1;
			
			int sum = 0;
//			for (int i = 8, j = 1; i > 0 & j < 9; i--, j++) {
//				N += i * (id.charAt(j) - '0');
//				sum = e1 + N + (id.charAt(9) - '0') * 1;
//			}
			for (int i = 1; i <= 9 ; i++) {
				sum += (id.charAt(i) - '0') * ( i < 9 ? 9 - i : 1 ); //因應最後n9的部分，採用三元運算子將for循環和n9分開
			}
			sum += e1;
			// 3. 加總後的結果為10的倍數就是正確的，否則不正確
			if (sum % 10 == 0)
				return true;
		}
		return false;
	}
	
}
