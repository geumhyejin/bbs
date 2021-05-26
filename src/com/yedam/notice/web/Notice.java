package com.yedam.notice.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.DbCommand;
import com.yedam.notice.Impl.NoticeServiceImpl;
import com.yedam.notice.service.NoticeService;
import com.yedam.notice.vo.NoticeVO;

public class Notice implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 한건조회
		// serviceImpl 구현
		String id = request.getParameter("id");
		NoticeVO vo = new NoticeVO();
		vo.setId(Integer.parseInt(id));
		
		NoticeService service = new NoticeServiceImpl();
		NoticeVO rvo = service.noticeSelect(vo);
		// 여러분의 구현
		request.setAttribute("notice", rvo);
		return "notice/notice.tiles";
	}

}
