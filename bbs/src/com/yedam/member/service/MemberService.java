package com.yedam.member.service;

import java.util.List;

import com.yedam.member.vo.MemberVO;

public interface MemberService {
	//전체조회 , 한건조회, 입력 , 수덜, 삭제
	List<MemberVO> selectMemberList();
	MemberVO selectMember();
	public int insertMember();
	public int updatetMember();
	public int deleteMember();
	
	
	
	void insertMember(MemberVO vo);
	boolean idCheck(String id);

	
}
