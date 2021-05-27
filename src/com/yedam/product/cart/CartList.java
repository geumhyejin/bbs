package com.yedam.product.cart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.DbCommand;

public class CartList implements DbCommand{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
	
		return "cart/cartList.tiles";
	}

}
