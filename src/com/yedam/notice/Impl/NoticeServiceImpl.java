package com.yedam.notice.Impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;
import com.yedam.notice.service.NoticeService;
import com.yedam.notice.vo.NoticeVO;

public class NoticeServiceImpl extends DAO implements NoticeService {
	PreparedStatement psmt;
	ResultSet rs;

	// 모든리스트가 page 10개씩 
	public List<NoticeVO> noticeListPaging(int page) {
		String sql = "select b.* \r\n" //
				+ "from (select rownum rn, a.* \r\n" + "         from(select * from notice order by id)a \r\n"
				+ "        )b\r\n" + "where b.rn between ? and ?";

		
		List<NoticeVO> notice = new ArrayList<>();
		int firstCnt = 0, lastCnt = 0;
		firstCnt = (page - 1) * 10 + 1;
		lastCnt = (page * 10);

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, firstCnt);
			psmt.setInt(2, lastCnt);

			rs = psmt.executeQuery();
			while (rs.next()) {
				NoticeVO vo = new NoticeVO();
				vo.setContent(rs.getString("content"));
				vo.setHit(rs.getInt("hit"));
				vo.setId(rs.getInt("id"));
				vo.setRegDate(rs.getDate("reg_date"));
				vo.setTitle(rs.getString("title"));
				notice.add(vo);
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return notice;
	}

	// 전체 리스트
	@Override
	public List<NoticeVO> noticeSelectList() {
		String sql = "select * from notice order by 1";
		List<NoticeVO> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				
				NoticeVO vo = new NoticeVO();
				vo.setId(rs.getInt("id"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setRegDate(rs.getDate("reg_date"));
				vo.setHit(rs.getInt("hit"));

				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	// 한건 조회
	@Override
	public NoticeVO noticeSelect(NoticeVO vo) {
		String sql = "select * from notice where id = ?";
		NoticeVO rvo = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getId());
			rs = psmt.executeQuery();
			if (rs.next()) {
				hitCount(vo.getId());
				rvo = new NoticeVO();
				rvo.setId(rs.getInt("id"));
				rvo.setTitle(rs.getString("title"));
				rvo.setContent(rs.getString("content"));
				rvo.setRegDate(rs.getDate("reg_date"));
				rvo.setHit(rs.getInt("hit"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return rvo;
	}

	// 한건입력
	@Override
	public int insertNotice(NoticeVO vo) {
		return 0;
	}

	// 한건 수정
	@Override
	public int updateNotice(NoticeVO vo) {
		return 0;
	}

	// 한건 삭제
	@Override
	public int deleteNotice(NoticeVO vo) {
		return 0;
	}

	public void hitCount(int id) {
		String sql = "update notice set hit = hit + 1 where id=?";
		try {
			
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			
			int n = psmt.executeUpdate();
			if(n!=0) {
				System.out.println(id +"글 조회수 증가");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 

	}

	public void close() {

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (psmt != null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
