package com.yedam.member.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.yedam.common.DAO;
import com.yedam.member.service.MemberService;
import com.yedam.member.vo.MemberVO;

public class MemberServiceImpl extends DAO implements MemberService {

	PreparedStatement psmt;
	ResultSet rs;
	
	//id를 중복인지 체크해주는 메소드/ 중복존재하면 true/ 아니면 false
	public boolean idCheck(String id) {
		
			
		}
		try {
			boolean exist = false;
			String sql = "select id from member where id=?";
			psmt = conn.prepareStatment(sql);
			rs = psmt.executeQuery();
			if(rs.next()) {
				exist = true;
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<MemberVO> selectMemberList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO selectMember() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertMember (MemberVO vo) {
		
		try {
		String sql = " insert into member (id, name, passwd, address) values(?,?,?,?)";
		psmt = conn.PreparedStatement(sql);
		// 각각 ?,?,?,?
		psmt.setString(1, vo.getId());
		psmt.setString(2, vo.getName());
		psmt.setString(3, vo.getPwd());
		psmt.setString(4, vo.getAddr());
		r = psmt.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return r;
	}

	@Override
	public int updatetMember() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember() {
		// TODO Auto-generated method stub
		return 0;
	}

	private void close() {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public int insertMember() {
		// TODO Auto-generated method stub
		return 0;
	}


}
