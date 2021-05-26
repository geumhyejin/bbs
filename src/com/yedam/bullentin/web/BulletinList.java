package com.yedam.bullentin.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.bullentin.service.BulletinService;
import com.yedam.bullentin.serviceImpl.BulletinServiceImpl;
import com.yedam.bullentin.vo.BulletinVO;
import com.yedam.common.DbCommand;

public class BulletinList implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		//게시글리스트 -> bulletinlist.jsp
		BulletinService service = new BulletinServiceImpl();
		List<BulletinVO> list = service.bulletinSelectList();
		
		request.setAttribute("bulletinList", list);  
		return "bulletin/bulletinList.tiles";   //bulletinList.jsp 이름과 같아야됨!
	}

}
