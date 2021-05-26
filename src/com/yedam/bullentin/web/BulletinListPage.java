package com.yedam.bullentin.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.bullentin.serviceImpl.BulletinServiceImpl;
import com.yedam.bullentin.vo.BulletinVO;
import com.yedam.common.DbCommand;
import com.yedam.common.Paging;

public class BulletinListPage implements DbCommand{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String page =request.getParameter("page");   //페이비번호
		
		
		if (page == null)
			page ="1";
		int pageCnt = Integer.parseInt(page);
		
		//전체건수를 위해 실핼
		BulletinServiceImpl service = new BulletinServiceImpl();
		List<BulletinVO> total = service.bulletinSelectList();   //전체카운트
		
		//현재 페이지 리스트를 위한 실행
		service = new BulletinServiceImpl();
		List<BulletinVO> list = service.bulletinListPaging(pageCnt);
		
		Paging paging = new Paging();
		paging.setPageNo(pageCnt);
		paging.setPageSize(10);
		paging.setTotalCount(total.size());
		
		request.setAttribute("bulletinList", list);
		request.setAttribute("paginf", paging);
		
		return "bulletin/bulletinListPaging.tiles";
	}

}
