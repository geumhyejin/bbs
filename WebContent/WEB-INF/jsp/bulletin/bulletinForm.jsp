<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bulletinForm.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="//cdn.ckeditor.com/4.16.1/standard/ckeditor.js"></script>
<script>
	$(function(){
		CKEDITOR.replace('content', {
			filebrowserUploadUrl: '${pageContext.request.ContextPath }/fileUpload'
			height:'600px'
			width:'800px'
		});
	})
	function formCheck() {
		if(frm.title.value == ""){
			alert("제목 입력하세요.");
			frm.title.focus();
			return false;
		}
	
		frm.submit();
	}
</script>
</head>
<body>
<div align="center">
	<div>
		<h1>게시글 등록</h1>
	</div>
	<div>
		<form id="frm" action="bulletinInsert.do" method="post">
		<input type = "hidden" name ="id" value="${id }">
			<div>
				<table border="1">
					<tr>
						<th width="150">제목</th>
						<td width="300"><input type="text" id="title" name="title">
						
						</td>
					</tr>
					<tr>
						<th width="150">내용</th>
						<td width="300">
							<textarea id="contect" name="contect"></textarea>
						</td>
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
</body>
</html>