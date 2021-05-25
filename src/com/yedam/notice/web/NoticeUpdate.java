package com.yedam.notice.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.DbCommand;
import com.yedam.notice.Impl.NoticeServiceImpl;
import com.yedam.notice.service.NoticeService;
import com.yedam.notice.vo.NoticeVO;

public class NoticeUpdate implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		//파라메타로 넘겨준 (id, title, content)
		//serviceImpl -> update기능작성
		//공지사항 리스트로 페이지 호출
		NoticeVO vo= new NoticeVO();
		NoticeServiceImpl impl = new NoticeServiceImpl();
	 int hit = request.getParameter(hit);
	 for (hit= 0; hit)
		
		//NoticeList commad = new NoticeList();
		//String path = commad.execute(request, response);
		
		//List<NoticeVO> list = (List<NoticeVO>) request.getAttribute(path);
		
		
		
		return "notice/noticeList.tiles";
	}

}
