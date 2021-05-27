package com.yedam.product.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import com.yedam.common.DAO;
import com.yedam.product.ProductVO;
import com.yedam.product.service.ProductService;

public class ProductServiceImpl extends DAO	implements ProductService{
	
	PreparedStatement psmt;
	ResultSet rs;
	String sql;
	
	//카트에 상품추가
	public void addCart(String id, String item, int qty) {
		sql ="insert into cart values(?,?,?)";
				
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, item);
			psmt.setInt(3, qty);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	//회사별 장바구니 상품갯수
	public int getCountCart(String id) {
		sql = "select count(*) from cart where user_id=?";
		int rCnt =0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				rCnt = rs.getInt(1);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close();
		}
		return rCnt;
	}
	
	@Override
	public List<ProductVO> productSelectList() {
		List<ProductVO> list = new ArrayList<>();
		sql = "select * from product order by 1";
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
		
			while (rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setItemCode(rs.getString("item_code"));  
				vo.setItemName(rs.getString("item_name"));
				vo.setItemImage(rs.getString("item_image"));
				vo.setPrice(rs.getInt("price"));
				vo.setItemDesc(rs.getString("item_desc"));
				vo.setLikeIt(rs.getInt("like_it"));
				vo.setSale(rs.getString("sale"));
				vo.setSalePrice(rs.getInt("sale_price"));
				list.add(vo);
		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	
		return list;
	}
	private void close() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (psmt != null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	@Override
	public ProductVO productSelect(ProductVO vo) {
		
		return null;
	}
	@Override
	public int insertProduct(ProductVO vo) {
		
		return 0;
	}
	@Override
	public int updateProduct(ProductVO vo) {
		
		return 0;
	}
	@Override
	public int deleteProduct(ProductVO vo) {
	
		return 0;
	}
	
}
