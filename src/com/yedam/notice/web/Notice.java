package com.yedam.notice.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.DbCommand;
import com.yedam.notice.vo.NoticeVO;

public class Notice implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 한건조회
		// serviceImpl 구현
		String id = request.getParameter("id");
		
		// 여러분의 구현
		NoticeVO vo = new NoticeVO();
		request.setAttribute("notice", vo);
		return "notice/notice.tiles";
	}

}
