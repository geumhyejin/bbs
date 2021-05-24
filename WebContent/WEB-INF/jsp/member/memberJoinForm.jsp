<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<script>
		function formCheck(){
			if(frm.memberId.value == ""){
				alert("아이디를 입력하세요.")
				frm.memberId.focus();
				return false;
			}
			if(frm.memberPwd.value == ""){
				alert("비밀번호를 입력하세요.")
				frm.memberPwd.focus();
				return false;
			}
			frm.submit();
		}
	</script>
<div align="center">
	<div>
		<h1>회원가입</h1>
	</div>
	<div>
		<form id="frm" action="memberJoin.do" method="post">
			<div>
				<table border="1">
					<tr>
						<th width="150">아이디</th>
						<td width="300"><input type="text" id="memberId" name="memberId"></td>
					</tr>
					<tr>
						<th width="150">비밀번호</th>
						<td width="300"><input type="password" id="memberPwd" name="memberPwd"></td>
					</tr>
					<tr>
						<th width="150">이름</th>
						<td width="300"><input type="text" id="memberName" name="memberName"></td>
					</tr>
					<tr>
						<th width="150">주소</th>
						<td width="300"><input type="text" id="memberAddr" name="memberAddr"></td>
					</tr>
				</table>
			</div>
			<div>
				<button type = "button" onclick ="formCheck()">회원가입</button>
				<button type = "reset">취소</button>
				<button type = "button" onclick ="location.href='main.do'">메인으로</button>
			</div>
		</form>
	</div>
</div>