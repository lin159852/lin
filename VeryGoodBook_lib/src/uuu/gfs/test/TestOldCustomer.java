package uuu.gfs.test;

import java.util.Date;
import java.util.GregorianCalendar;

import uuu.gfs.entity.OldCustomer;

public class TestOldCustomer {

	public static void main(String[] args) {
		final int i = 100; //final修飾子使常數i不可再更改
		
		OldCustomer customer = new OldCustomer(); //物件建立即賦予記憶體空間
		
		customer.id = "A123456789";
		customer.email = "test@gmail.com";
		customer.phone = "0987654321";
		customer.password = "12345;Lkj";
		customer.name = "王小明";
		customer.gender = 'F';
		//customer.birthday = new Date(2000-1900, 01-1, 12);
		customer.birthday = new GregorianCalendar(2000,01-1,12).getTime();
		
		customer.setBirthday(2000,01,12);
		
		//customer.birthday = LocalDate.of(2000,01,23);
		customer.address = "台北市松山區復興北路99號14樓";
		customer.subscribed = true;
		
		System.out.println(customer); //顯示customer的記憶體位置
		System.out.printf("%s\n", customer);
		System.out.printf("%s\n", customer.toString());
		
		System.out.printf("customer.id :　%s\n", customer.id);
		System.out.printf("customer.email :　%s\n", customer.email);
		System.out.printf("customer.phone :　%s\n", customer.phone);
		System.out.printf("customer.password :　%s\n", customer.password);
		System.out.printf("customer.name :　%s\n", customer.name);
		System.out.printf("customer.gender :　%s\n", customer.gender);
		System.out.printf("customer.birthday :　%s\n", customer.birthday);
		
		System.out.printf("customer.address :　%s\n", customer.address);
		System.out.printf("customer.subscribed :　%s\n", customer.subscribed);
		
		//計算年齡: 今年-出生日期的年份
//		LocalDate today = LocalDate.now();
//		System.out.printf("today : %s\n", today);
//		
//		int thisYear = today.getYear();
//		Month theMonth = today.getMonth();
//		int theMonthValue = today.getMonthValue();
//		System.out.printf("thisYear : %s\n", thisYear);
//		System.out.printf("theMonth : %s\n", theMonth);
//		System.out.printf("theMonthValue : %s\n", theMonthValue);
//		System.out.printf("DayOfYear : %s\n", today.getDayOfYear());
//		System.out.printf("DayOfMonth : %s\n", today.getDayOfMonth());
//		System.out.printf("DayOfWeek : %s\n", today.getDayOfWeek());
//		
//		int yearOfBirth = customer.birthday.getYear();
//		int monthOfBirth = customer.birthday.getMonthValue();
//		int dayOfBirth = customer.birthday.getDayOfMonth();
		
		int AGE = customer.getAge();
		System.out.printf("age : %s\n", AGE);
		
	}

}
