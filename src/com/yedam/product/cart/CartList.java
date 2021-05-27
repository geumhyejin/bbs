package com.yedam.product.cart;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.DbCommand;
import com.yedam.product.ProductVO;
import com.yedam.product.service.ProductService;
import com.yedam.product.serviceImpl.ProductServiceImpl;

public class CartList implements DbCommand{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
	
		ProductService service = new ProductServiceImpl();
		List<ProductVO> list = service.productSelectList();
		
		//request.setAttribute();
		return "cart/cartList.tiles";
	}

}
