package uuu.vgb.entity;

public class SpecialOffer extends Product{
	private int discount; //required, 1~90 %off
	
	public SpecialOffer() {
		super();
		// Auto-generated constructor stub
	}

	public SpecialOffer(int id, String name, double unitPrice) {
		super(id, name, unitPrice);
		// Auto-generated constructor stub
	}
	
	public SpecialOffer(int id, String name, double unitPrice, int discount) {
		super(id, name, unitPrice);
		this.setDiscount(discount);
		// Auto-generated constructor stub
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		if(discount>=1 && discount<=90) {
			this.discount = discount;
		}else {
			System.err.printf("特價品折扣(%s)必須在1~90%%之間\n", discount);
			//TODO:
		}
	}
	
	public String getDiscountString() {
		int discount = 100-this.discount;
		if(discount%10==0) {
			discount /= 10;
		}
		return discount + "折";
	}
	/**
	 * 計算折扣後售價
	 * @return
	 */
	@Override
	public double getUnitPrice() { //設計在新的方法不恰當，建議使用overriding
		double price = super.getUnitPrice();
		price = price * (100-this.discount)/100;
		return price;
	}
	
	public double getListPrice() {
		return super.getUnitPrice();
	}

	@Override
	public String toString() {
		return super.toString()
				+ "\n特價 [折扣=" + discount + "% off, 台灣表示法: " + getDiscountString()
				+ ", 售價=" + getUnitPrice() + "]";
	}
	
	
	
}
