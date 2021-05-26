package com.yedam.bullentin.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.bullentin.service.BulletinService;
import com.yedam.bullentin.vo.BulletinVO;
import com.yedam.common.DAO;

public class BulletinServiceImpl extends DAO implements BulletinService {

	PreparedStatement psmt;
	ResultSet rs;
	String sql;

	@Override
	public List<BulletinVO> bulletinSelectList() {

		String sql = "select * from bulletin order by 1";
		List<BulletinVO> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				BulletinVO vo = new BulletinVO();
				vo.setContent(rs.getString("content"));
				vo.setHit(rs.getInt("hit"));
				vo.setId(rs.getInt("id"));
				vo.setRegDate(rs.getString("reg_date"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));

				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list; // 전체끝부분
	}

	// 한건 조회  (한건조회기능에 조회수를 넣어줌hitCount(vo.getId());)
	public BulletinVO bulletinSelect(BulletinVO vo) {
		// 입력기능 구현
		sql = "select *from bulletin where id=?";
		BulletinVO vo1 = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getId());

			rs = psmt.executeQuery();
			if (rs.next()) {
				hitCount(vo.getId());
				vo1 = new BulletinVO();
				vo1.setContent(rs.getString("content"));
				vo1.setHit(rs.getInt("hit"));
				vo1.setRegDate(rs.getString("reg_date"));
				vo1.setTitle(rs.getString("title"));
				vo1.setWriter(rs.getString("writer"));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close();
		}
		return vo;

	}

	// 게시글등록
	@Override
	public int insertBulletin(BulletinVO vo) {
		String sql = "insert into bulletin (id, title, content, writer,sysDate ,hit) values(?,?,?,?,?,?);";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getId());
			psmt.setString(2, vo.getTitle());
			psmt.setString(3, vo.getContent());
			psmt.setString(4, vo.getWriter());
			psmt.setString(5, vo.getRegDate());
			psmt.setInt(6, vo.getHit());

			r = psmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close();
		}
		return r;
	}

	@Override
	public int updateBulletin(BulletinVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBulletin(BulletinVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void hitCount(int id) {
		String sql = "update bulletin set hit = hit + 1 where id=?";
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

	public List<BulletinVO> bulletinListPaging(int pageCnt) {
		// TODO Auto-generated method stub
		return null;
	}

}
