package uuu.gfs.test;

import java.time.LocalDate;

import uuu.gfs.entity.Product;
import uuu.gfs.entity.SpecialOffer;

public class TestSpecialOffer {
	
	public static void main(String[] args) {
		int i = 1;
		String s = "Hello";
		
		SpecialOffer sp = new SpecialOffer();
		sp.setId(1);
		sp.setName("ZGMF-X10A 自由鋼彈");
		sp.setUnitPrice(1000);
		sp.setStock(10);
		sp.setPhotoUrl("https://www.amuzinc.com/Uploads/Product/p060021996032.jpg");
		sp.setCategory("模型玩具");
		sp.setDescription("◆內容規格："
				+ "◇品牌：BANDAI"
				+ "◇材質：ABS樹脂、聚苯乙烯、聚乙烯、聚丙烯"
				+ "◇外盒尺寸：長31x寬19x高8cm"
				+ "◇年齡：8歲以上"
				+ "◇產地：日本"
				+ "◇內附組裝說明書"
				+ "◇模型全系列產品享有7天猶豫期，內袋一經拆封、外盒壓損，將導致商品無法再次販售，鑑賞前請先確認"
				+ "◇商品經拆封後，如有發生缺件憾事，請撥打萬代客服專線(02)2521-4368");
		sp.setReleaseDate(LocalDate.parse("2024-06-30"));
		sp.setDiscount(21);
		
		System.out.printf("編號：%s\n", sp.getId());
		System.out.printf("名稱：%s\n", sp.getName());
		System.out.printf("單價：%s\n", sp.getUnitPrice());
		System.out.printf("庫存：%s\n", sp.getStock());
		System.out.printf("圖片網址：%s\n", sp.getPhotoUrl());
		System.out.printf("分類：%s\n", sp.getCategory());
		System.out.printf("介紹說明：%s\n", sp.getDescription());
		System.out.printf("上架日期：%s\n", sp.getReleaseDate());
		System.out.printf("特價折扣：%s%%\n", sp.getDiscount());
		System.out.printf("TW特價折扣：%s\n", sp.getDiscountString());
		
		//計算售價
		double price = sp.getUnitPrice();
		double dc = (100 - sp.getDiscount())/100;
		double sellPrice = price * dc;
		System.out.printf("沒注意型別的話錯誤計算為: %s\n", sellPrice);
		System.out.printf("打折後售價為: %s\n", sp.getUnitPrice());
		System.out.printf("sp.toString: %s\n", sp); //toString已經被Override覆蓋新方法了，不加toString也可以
	}

}
