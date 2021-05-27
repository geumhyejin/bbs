package com.yedam.product.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.DbCommand;
import com.yedam.product.ProductVO;
import com.yedam.product.service.ProductService;
import com.yedam.product.serviceImpl.ProductServiceImpl;

public class ProductList implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ProductService service = new ProductServiceImpl();		
		List<ProductVO> list = service.productSelectList();
		
		request.setAttribute("id", "user1");
		request.setAttribute("list", list);   //보내주는 값이 list로 되있기때문에 받을때로 같은이름 list 로 받아야됨. 
		
		return "product/productList.tiles";
	}

}
