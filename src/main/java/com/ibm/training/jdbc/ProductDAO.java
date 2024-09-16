package com.ibm.training.jdbc;
import java.sql.*;

public class ProductDAO {
	
	public int save(Product p) {
		int id = 0;
		try {
			//insert into product(product_name,product_price,product_qoh) values('nameval',2323,10)
			Connection c = ConnectionUtil.getConnection();
			Statement stmt = c.createStatement();
			String sql = "insert into product(product_name,product_price,product_qoh) values('"+p.getName()+"',"+p.getPrice()+","+p.getQoh()+")";
			stmt.executeUpdate(sql);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}
	
	public Product findById(int id) {
		Product p = new Product();
		try {
			Connection c = ConnectionUtil.getConnection();
			Statement stmt = c.createStatement();
			String sql = "select * from product where product_id="+id;
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				p.id = rs.getInt(1);
				p.name = rs.getString(2);
				p.price = rs.getFloat(3);
				p.qoh = rs.getInt(4);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

}
