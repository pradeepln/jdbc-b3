package com.ibm.training.jdbc;
import java.sql.*;
import java.util.*;



public class ProductDAO {
	
	public int save(Product p) {
		int id = 0;
		try {
			//insert into product(product_name,product_price,product_qoh) values('nameval',2323,10)
			Connection c = ConnectionUtil.getConnection();
//			Statement stmt = c.createStatement();
//			String sql = "insert into product(product_name,product_price,product_qoh) values('"+p.getName()+"',"+p.getPrice()+","+p.getQoh()+")";
			
			String sql = "insert into product(product_name,product_price,product_qoh) values(?,?,?)";
			PreparedStatement pStmt = c.prepareStatement(sql);
			pStmt.setString(1, p.getName());
			pStmt.setFloat(2, p.getPrice());
			pStmt.setInt(3, p.getQoh());
			
			pStmt.executeUpdate();
			//stmt.executeUpdate(sql);
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
	
	public List<Product> findAll(){
		List<Product> all = new ArrayList<>();
		try {
			Connection c = ConnectionUtil.getConnection();
			Statement stmt = c.createStatement();
			String sql = "select * from product";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Product p = new Product();
				p.id = rs.getInt(1);
				p.name = rs.getString(2);
				p.price = rs.getFloat(3);
				p.qoh = rs.getInt(4);
				all.add(p);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return all;
	}

	public void deleteById(int id) {
		//TBD
	}
	public void updateRow(Product fromObj) {
		//TBD
	}
	
}
