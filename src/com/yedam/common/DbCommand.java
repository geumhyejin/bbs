package com.yedam.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface DbCommand {
	public String execute(HttpServletRequest request, HttpServletResponse response);
//컨트롤러 만들기위해서 사용됨

}
