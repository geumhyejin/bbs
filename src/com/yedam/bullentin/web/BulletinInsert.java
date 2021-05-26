package com.yedam.bullentin.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.bullentin.vo.BulletinVO;
import com.yedam.common.DbCommand;

public class BulletinInsert implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		//입력값을 db인설트 후 -> Bulletinlist.jsp
		String writer =  request.getParameter("id");
		String title =  request.getParameter("title");
		String content =  request.getParameter("content");
		
		BulletinVO vo = new BulletinVO();
		vo.setContent(content);
		vo.setTitle(title);
		vo.setWriter(writer);
		
		request.setAttribute("bulletinInsert", vo);
		return "bulletin/bulletinInsert.tiles";
	}

}
