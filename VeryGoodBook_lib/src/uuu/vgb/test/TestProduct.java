package uuu.vgb.test;

import java.time.LocalDate;

import uuu.vgb.entity.Product;

public class TestProduct {
	public TestProduct() {
		System.out.println("TestProduct建立起來");
	}
	public static void main(String[] args) {
		int i = 1;
		String s = "Hello";
		
		Product p = new Product();
		p.setId(1);
		p.setName("組裝模型 RG 1/144 機動戰士鋼彈 GUNDAM ZGMF-X10A 自由鋼彈");
		p.setUnitPrice(1000);
		p.setStock(10);
		p.setPhotoUrl("https://www.amuzinc.com/Uploads/Product/p060021996032.jpg");
		p.setCategory("模型玩具");
		p.setDescription("◆內容規格："
				+ "◇品牌：BANDAI"
				+ "◇材質：ABS樹脂、聚苯乙烯、聚乙烯、聚丙烯"
				+ "◇外盒尺寸：長31x寬19x高8cm"
				+ "◇年齡：8歲以上"
				+ "◇產地：日本"
				+ "◇內附組裝說明書"
				+ "◇模型全系列產品享有7天猶豫期，內袋一經拆封、外盒壓損，將導致商品無法再次販售，鑑賞前請先確認"
				+ "◇商品經拆封後，如有發生缺件憾事，請撥打萬代客服專線(02)2521-4368");
		p.setReleaseDate(LocalDate.parse("2024-06-30"));
		
//		System.out.printf("編號：%s\n", p.getId());
//		System.out.printf("名稱：%s\n", p.getName());
//		System.out.printf("單價：%s\n", p.getUnitPrice());
//		System.out.printf("庫存：%s\n", p.getStock());
//		System.out.printf("圖片網址：%s\n", p.getPhotoUrl());
//		System.out.printf("分類：%s\n", p.getCategory());
//		System.out.printf("介紹說明：%s\n", p.getDescription());
//		System.out.printf("上架日期：%s\n", p.getReleaseDate());
		Product p2 = new Product();
		p2.setId(2);
		p2.setName(p.getName() + "Light");
		p2.setUnitPrice(880);
	}

}
