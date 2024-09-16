package com.ibm.training.jdbc;

public class ProductApp {

	public static void main(String[] args) {
		ProductDAO dao = new ProductDAO();
//		Product p = new Product();
//		p.setName("java prod2");
//		p.setPrice(9999);
//		p.setQoh(10);
//		dao.save(p);
//		
//		System.out.println("Finished...check in DB...");
		
		Product fromDB = dao.findById(1);
		
		System.out.println(fromDB);
	}

}
