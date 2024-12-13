package uuu.gfs.entity;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class OldCustomer {
	public String id ;         //PKey, ROC ID
	public String email;       //required, UNIQUE INDEX, 必須符合email格式(用RegExp檢查)
	public String phone;       //required, UNIQUE INDEX, 必須符合手機格式(用RegExp檢查)
	public String password;    //required, 6~20個英數字字元(大小寫有別)
	public String name;        //required, 2~20個中英數字元
	public char gender;        //required, F:女, M:男, O:不願透露
	public Date birthday;      //required, 年滿12歲, 模擬JDK7以下版本
	
	public String address;     //optional
	public boolean subscribed; //optional
	
	public void setBirthday(int year, int month, int day) {
		this.birthday = new GregorianCalendar(year,month-1,day).getTime();
	}
	
	/**
	 * 根據客戶的birthday屬性值來計算年齡: 今年-出生日期的年份
	 * @return int型態的客戶年齡
	 */
	public int getAge() {
		//計算年齡: 今年-出生日期的年份(老版)
		Calendar theCalendar = Calendar.getInstance();
		int thisYear = Calendar.getInstance().get(Calendar.YEAR);
		System.out.printf("thisYear : %s\n", thisYear);
		
		theCalendar.setTime(birthday);
		int yearOfBirth = theCalendar.get(Calendar.YEAR);
		System.out.printf("yearOfBirth : %s\n", yearOfBirth);
		
		int age = thisYear-yearOfBirth;
		
		return age;
	}
}
