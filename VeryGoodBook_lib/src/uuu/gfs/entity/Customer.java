package uuu.gfs.entity;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import uuu.gfs.exception.VGBDataInvalidException;

public class Customer {
	private String id;          // PKey, ROC ID
	private String email;       // required, UNIQUE INDEX, 必須符合email格式(用RegExp檢查)
	private String phone;       // required, UNIQUE INDEX, 必須符合手機格式(用RegExp檢查)
	private String password;    // required, 6~20個英數字字元(大小寫有別)
	private String name;        // required, 2~20個中英數字元
	private char gender;        // required, F:女, M:男, O:不願透露
	private LocalDate birthday; // required, 年滿12歲

	private String address;     // optional
	private boolean subscribed; // optional
	/*-------------------------------------------------------------------------------*/
	public Customer() {
		//super();
	}
	public Customer(String id, String password, String name) {
		//super();
		this.id = id;
		this.password = password;
		this.name = name;
	}
	public Customer(String id, String password, String name, String email) {
		//super();
		this(id, password, name);
		this.email = email;
	}
	/*-------------------------------------------------------------------------------*/
	public String getId() {
		return id;
	}

	/**
	 * 身分證字號檢驗規則
	 * 
	 * @param id
	 * @return boolean型別，符合身分證字號檢驗規則的話回傳true否則為false
	 */
	public boolean checkId(String id) {
		if (id != null && id.matches("[A-Z][1289][0-9]{8}")) {
			// 依據身分證字號檢查規則
			// 1. 取出id中的第一個字元並轉成對應的整數
			char firstChar = id.charAt(0);
			int a1a2 = 0;
			if (firstChar == 'A') {
				a1a2 = 10;
			} else if (firstChar == 'B') {
				a1a2 = 11;
			} else if (firstChar == 'C') {
				a1a2 = 12;
			} else if (firstChar == 'D') {
				a1a2 = 13;
			} else if (firstChar == 'E') {
				a1a2 = 14;
			} else if (firstChar == 'F') {
				a1a2 = 15;
			} else if (firstChar == 'G') {
				a1a2 = 16;
			} else if (firstChar == 'H') {
				a1a2 = 17;
			} else if (firstChar == 'I') {
				a1a2 = 34;
			} else if (firstChar == 'J') {
				a1a2 = 18;
			} else if (firstChar == 'K') {
				a1a2 = 19;
			} else if (firstChar == 'L') {
				a1a2 = 20;
			} else if (firstChar == 'M') {
				a1a2 = 21;
			} else if (firstChar == 'N') {
				a1a2 = 22;
			} else if (firstChar == 'O') {
				a1a2 = 35;
			} else if (firstChar == 'P') {
				a1a2 = 23;
			} else if (firstChar == 'Q') {
				a1a2 = 24;
			} else if (firstChar == 'R') {
				a1a2 = 25;
			} else if (firstChar == 'S') {
				a1a2 = 26;
			} else if (firstChar == 'T') {
				a1a2 = 27;
			} else if (firstChar == 'U') {
				a1a2 = 28;
			} else if (firstChar == 'V') {
				a1a2 = 29;
			} else if (firstChar == 'W') {
				a1a2 = 32;
			} else if (firstChar == 'X') {
				a1a2 = 30;
			} else if (firstChar == 'Y') {
				a1a2 = 31;
			} else if (firstChar == 'Z') {
				a1a2 = 33;
			}

			int a1;
			int a2;
			a1 = a1a2 / 10;
			a2 = a1a2 % 10;

			int e1;
			e1 = (a1 * 1 + a2 * 9) % 10;
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
				sum += ( i < 9 ? 9 - i : 1 ) * (id.charAt(i) - '0');
			}
			sum += e1;
			// 3. 加總後的結果為10的倍數就是正確的，否則不正確
			if (sum % 10 == 0)
				return true;
		}
		return false;
	}

	public void setId(String id) {
		if (checkId(id)) {
			this.id = id;
		} else {
			//System.err.printf("你輸入的身份證字號不正確: %s\n", id);
			// 要改成 throw new XxxException
			String errMsg = String.format("你輸入的身份證字號不正確: %s\n", id);
			throw new VGBDataInvalidException(errMsg);
		}
	}

	public String getEmail() {
		return email;
	}

	public static final String EMAIL_PATTERN="^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
	public void setEmail(String email) {
		// ^\w{1,63}@[a-zA-Z0-9]{2,63}\.[a-zA-Z]{2,63}(\.[a-zA-Z]{2,63})?$
		// ^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$
		if (email != null && email.matches(EMAIL_PATTERN)) {
			this.email = email;
		} else {
			//System.err.printf("你輸入的Email不正確: %s\n", email);
			// 要改成 throw new XxxException
			String errMsg = String.format("你輸入的Email不正確: %s\n", email);
			throw new VGBDataInvalidException(errMsg);
		}
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		if (phone != null && phone.length() == 10 && phone.matches("[0][9]\\d{8}")) {
			this.phone = phone;
		} else {
			//System.err.println("電話號碼不正確，須為09開頭的10位數字");
			// 要改成 throw new XxxException
			String errMsg = String.format("電話號碼%s不正確，須為09開頭的10位數字", phone);
			throw new VGBDataInvalidException(errMsg);
		}
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String pwd) {
		if (pwd != null && pwd.length() >= 6 && pwd.length() <= 20) {
			this.password = pwd;
		} else {
			//System.err.println("密碼不正確，須為6~20個字元");
			// 要改成 throw new XxxException
			String errMsg = String.format("密碼%s不正確，須為6~20個字元", pwd);
			throw new VGBDataInvalidException(errMsg);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name != null && name.length() >= 2 && name.length() <= 20) {
			this.name = name;
		} else {
			//System.err.println("會員姓名必須2~20個字元");
			// 要改成 throw new XxxException
			String errMsg = String.format("會員姓名%s必須2~20個字元", name);
			throw new VGBDataInvalidException(errMsg);
		}
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		if (gender == 'M' || gender == 'F' || gender == 'O') {
			this.gender = gender;
		} else {
			//System.err.println("輸入性別不正確，請在男性、女性、不願透露中擇一");
			// 要改成 throw new XxxException
			String errMsg = String.format("您輸入了%s，請在Male, Female或Other中擇一", gender);
			throw new VGBDataInvalidException(errMsg);
		}
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	/**
	 * 符合屬性型別的標準setter寫法，從其他setBirthday傳來的date物件重新命名為參數birthday並代入，檢查是否年滿12歲
	 * 
	 * @param birthday
	 */
	public void setBirthday(LocalDate birthday) {
		if (birthday != null && LocalDate.now().getYear() - birthday.getYear() >= 12) {
			this.birthday = birthday;
		} else {
			//System.err.println("會員必須年滿12歲");
			//  throw new RuntimeException 用於使用者輸入錯誤時告知使用者, 可用程式技巧防範
			String errMsg = String.format("會員必須年滿12歲, 生日%s不符合規則", birthday);
			throw new VGBDataInvalidException(errMsg);
		}
	}

	/**
	 * 將年月日的int型別參數轉換成LocalDate型別物件date再傳到真正的setter
	 * 
	 * @param year
	 * @param month
	 * @param day
	 */
	public void setBirthday(int year, int month, int day) {
		try {
			LocalDate date = LocalDate.of(year, month, day);
			this.setBirthday(date);
		} catch (DateTimeException e) {
			String errMsg = String.format("生日%s年%s月%s日格式不正確", year, month, day);
			throw new VGBDataInvalidException(errMsg);
		}
	}

	/**
	 * 將String型別且符合ISO-8601的dateString參數轉換成LocalDate型別物件date再傳到真正的setter
	 * 
	 * @param dateString
	 */
	public void setBirthday(String dateString) {
		try {
			LocalDate date = LocalDate.parse(dateString);
			this.setBirthday(date);
		} catch (DateTimeParseException | NullPointerException e) {
			String errMsg = String.format("生日%s格式需符合ISO-8601且不為null", dateString);
			throw new VGBDataInvalidException(errMsg);
		}
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isSubscribed() {
		return subscribed;
	}

	public void setSubscribed(boolean subscribed) {
		this.subscribed = subscribed;
	}

	/**
	 * 根據客戶的birthday屬性值來計算年齡: 今年-出生日期的年份
	 * 
	 * @return int型態的客戶年齡
	 */
	public int getAge() {
		// 計算年齡
		// 以下參數由系統及上面birthday取得，無須外部輸入因此()可為空
		LocalDate today = LocalDate.now();
		//System.out.printf("today : %s\n", today);

		int thisYear = today.getYear();
		int theMonthValue = today.getMonthValue();
		int theDayValue = today.getDayOfMonth();

		if (this.birthday != null) {
			int yearOfBirth = this.birthday.getYear(); // 在這裡使用Customer類別，是此類別自己，因此用this
			int monthOfBirth = this.birthday.getMonthValue();
			int dayOfBirth = this.birthday.getDayOfMonth();

			int age = thisYear - yearOfBirth;
			if (theMonthValue < monthOfBirth) {
				age--;
			} else if (theMonthValue == monthOfBirth & theDayValue < dayOfBirth) {
				age--;
			}
			return age;
		} else {
			//throw new VGBDataInvalidException
			String errMsg = String.format("年齡低於12歲，無法使用本服務！");
			throw new VGBDataInvalidException(errMsg);
		}
		
	}
	@Override
	public String toString() {
		return "客戶 [身份證字號=" + id + ", 電子郵件=" + email + ", 電話手機=" + phone + ", 密碼=" + password + ", 客戶姓名="
				+ name + ", 性別=" + gender + ", 生日=" + birthday + ", 年齡=" + this.getAge() + (birthday!=null?"歲":"年齡無法計算") + ", 住址=" + address + ", 是否訂閱="
				+ subscribed + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Customer))
			return false;
		Customer other = (Customer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
//	@Override
//	public boolean equals(Object obj) {
//		if(this==obj) {
//			return true;
//		}else if (obj instanceof Customer) {
//			boolean rtn = this.id!=null && this.id == ((Customer)obj).id;
//			return rtn;
//		}
//		return false;
//	}

//	@Override
//	public int hashCode() {
//		return id!=null?id.hashCode():0;
//	}
	
}
