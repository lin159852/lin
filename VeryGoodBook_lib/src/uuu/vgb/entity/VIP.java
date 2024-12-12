package uuu.vgb.entity;

public class VIP extends Customer {
	private int discount; //required, 1~15% off
	
	public VIP() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VIP(String id, String password, String name) {
		super(id, password, name);
		// TODO Auto-generated constructor stub
	}
	
	public VIP(String id, String password, String name, int discount) {
		super(id, password, name);
		this.setDiscount(discount);
		// TODO Auto-generated constructor stub
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		if(discount>=1 && discount<=15) {
			this.discount = discount;
		}else {
			System.err.printf("VIP折扣(%s)不正確，必須為1~15%% off之間\n", discount);
		}
	}
	
	public String getDiscountString() {
		int discount = 100-this.discount;
		if(discount%10==0) {
			discount /= 10;
		}
		return discount + "折";
	}

	@Override
	public String toString() {
		return super.toString()
				+ "\nVIP [折扣=" + discount + "% off, 台灣標示法=" + getDiscountString() + "]";
	}
	
	
}
