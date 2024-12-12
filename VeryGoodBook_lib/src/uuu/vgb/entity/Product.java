package uuu.vgb.entity;

import java.time.LocalDate;

public class Product {
	private int id;                //PKey, AutoIncrement
	private String name;           //required, unique index, 1~60個字元
	private double unitPrice;      //required, >0
	private int stock;             //required, >=0
	private String photoUrl;       //optional
	private String category;       //required, 至少1個字元
	private String description;    //optional
	private LocalDate releaseDate; //required
	
	public Product() {} //其實需要這個constructor，但不寫compiler會幫我做一隻。但如果自行編寫constructor的話compiler就不會給了，必須自己default回來
	/**
	 * 只能測試用
	 * @param id
	 * @param name
	 * @param unitPrice double型態
	 */
	public Product(int id, String name, double unitPrice) {
		//this.id = id;
		//this.name = name;
		//this.unitPrice = unitPrice;
		this.setId(id);
		this.setName(name);
		this.setUnitPrice(unitPrice);
	}
	/**
	 * 只能測試用
	 * @param id
	 * @param name
	 * @param unitPrice double型態
	 * @param stock
	 */
	public Product(int id, String name, double unitPrice, int stock) {
		//this.setId(id);
		//this.setName(name);
		//this.setUnitPrice(unitPrice);
		this(id, name, unitPrice);
		this.setStock(stock);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		if (id>0) {
			this.id = id;
		} else {
			System.err.printf("你輸入的產品編號不正確: %s\n", id);
			// TODO: 第13章要改成 throw new XxxException
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) { // name的trim方法可以剔除輸入的空白，name物件屬於immutable所以trim完要再指派回給自己
		if(name!=null && (name=name.trim()).length()>0 && (name=name.trim()).length()<=60) {
			this.name = name;
		}else {
			System.err.printf("你輸入的產品名稱不正確: %s\n", name, (name=name.trim()).length());
			// TODO: 第13章要改成 throw new XxxException
		}
	}
	/**
	 * 查詢售價(即為定價)
	 * @return double型態的價格
	 */
	public double getUnitPrice() {
		return unitPrice;
	}
	/**
	 * 設定定價(即為售價)
	 * @param unitPrice
	 */
	public void setUnitPrice(double unitPrice) {
		if(unitPrice>0) {
			this.unitPrice = unitPrice;
		}else {
			System.err.printf("產品定價必須大於0: %s\n", unitPrice);
			//TODO throw new XxxException
		}
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		if(stock>5) {
			this.stock = stock;
		}else {
			System.err.printf("產品庫存必須大於5: %s\n", stock);
			//TODO throw new XxxException
		}
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(LocalDate releaseDate) {
		if (releaseDate != null) {
			this.releaseDate = releaseDate;
		} else {
			System.err.println("必須指定上架日期");
			// TODO: 第13章要改成 throw new XxxException
		}
	}
	public void setReleaseDate(int year, int month, int day) {
		LocalDate date = LocalDate.of(year, month, day);
		this.setReleaseDate(date);
	}
	public void setReleaseDate(String dateString) {
		LocalDate date = LocalDate.parse(dateString);
		this.setReleaseDate(date);
	}
	@Override
	public String toString() {
		return this.getClass().getName()
				+ "產品 [編號=" + id + ", 名稱=" + name + ", 單價=" + unitPrice + ", 庫存=" + stock + ", 圖片網址="
				+ photoUrl + ", 分類=" + category + ", 介紹說明=" + description + ", 上架日期=" + releaseDate
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public Product clone() {
		Product p = new Product();
		p.id = this.id;
		p.name = this.name;
		
		return p;
	}
//	@Override
//	public String toString() {
//		return "編號:" + id + ", 名稱:" + name + ", 定價:" + unitPrice;
//	}
}
