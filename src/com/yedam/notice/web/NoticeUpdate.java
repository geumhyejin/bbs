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
		// 파라메타로 넘겨준 (id, title, content)
		// serviceImpl -> update기능작성
		// 공지사항 리스트로 페이지 호출

		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String regDate = request.getParameter("regDate");
		String hit = request.getParameter("hit");

//		NoticeVO vo = new NoticeVO();
//		vo.setId(id);
//		vo.setTitle(title);
//		vo.setContent(content);
//		vo.setRegDate(regDate);
//		vo.setHit(hit);

		// NoticeList commad = new NoticeList();
		// String path = commad.execute(request, response);

		// List<NoticeVO> list = (List<NoticeVO>) request.getAttribute(path);

		return "notice/noticeList.tiles";
	}

}
