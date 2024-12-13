package uuu.gfs.test;

import uuu.gfs.entity.Customer;

public class TestWrapperClasses {

	public static void main(String[] args) {
		String subscribedString = "true";
		String yearOfBirth = "2000";
		String monthOfBirth = "2";
		String dyaOfBirth = "20";
		
		boolean subscribed = Boolean.parseBoolean(subscribedString);
		int year = Integer.parseInt(yearOfBirth);
		int month = Integer.parseInt(monthOfBirth);
		int day = Integer.parseInt(dyaOfBirth);
		
		String gender = "M";
		char g = gender.charAt(0);
		Customer c = new Customer();
		c.setId("A123456789");
		c.setName("王小明");
		c.setBirthday(year, month, day);
		c.setGender(g);
		
		String quantity = "5";
		String sizeName = "10.5";
		byte q = Byte.parseByte(quantity);
		double size = Double.parseDouble(sizeName);
		
		//把基本型別轉成對應的包裝類別物件
		byte a = 1;
		Byte theA = new Byte(a); //boxing
		int b = 2;
		Integer theB = new Integer(b); //boxing
		
		int d = 3;
		Integer theD = d; //auto-boxing
		
		double price = 3.5;
		Double thePrice1 = new Double(price); //boxing
		Double thePrice2 = price; //auto-boxing
		
		//把包裝類別物件轉成對應的基本型別，unboxing
		double data = thePrice1.doubleValue()*q + theD.intValue();
		double data1 = thePrice1*q + theD;
		Boolean theSubscribed = Boolean.parseBoolean(subscribedString);
		System.out.printf("theSubscribed: %s\n", theSubscribed.booleanValue());
		
	}

}
