package com.yedam.bullentin.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.bullentin.service.BulletinService;
import com.yedam.bullentin.serviceImpl.BulletinServiceImpl;
import com.yedam.bullentin.vo.BulletinVO;
import com.yedam.common.DbCommand;

public class Bulletin implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		//한전조회 해서 bulletin.jsp
		String id = request.getParameter("id");
		BulletinVO vo = new BulletinVO();
		vo.setId(Integer.parseInt(id));
		
		
		BulletinService service = new BulletinServiceImpl();
		BulletinVO vo1 = service.bulletinSelect(vo);
	
		//request 단위 공유

		request.setAttribute("bulletin", vo1);
		
		return "bulletin/bulletin.tiles";
	}

}
