<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="paginate">
		<a href="javascript:goPage(${paging.firstPageNo})" class="first">처음
			페이지</a> <a href="javascript:goPage(${paging.prevPageNo})" class="prev">이전
			페이지</a> <span> <c:forEach var="i" begin="${paging.startPageNo}"
				end="${paging.endPageNo}" step="1">
				<c:choose>
					<c:when test="${i eq paging.pageNo}">
						<a href="javascript:goPage(${i})" class="active">${i}</a>
					</c:when>
					<c:otherwise>
						<a href="javascript:goPage(${i})">${i}</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</span> <a href="javascript:goPage(${paging.nextPageNo})" class="next">다음
			페이지</a> <a href="javascript:goPage(${paging.finalPageNo})" class="last">마지막
			페이지</a>

		<div>
			<button type="button" onclick="location.href='main.do'">
				첫페이지</button>
			<c:if test="${id eq 'admin' }">
				<button type="button" onclick="location.href='noticeForm.do'">등록</button>
			</c:if>
		</div>
		<jsp:include page="paging.jsp" flush="true">
			<jsp:param name="firstPageNo" value="${paging.firstPageNo}" />
			<jsp:param name="prevPageNo" value="${paging.prevPageNo}" />
			<jsp:param name="startPageNo" value="${paging.startPageNo}" />
			<jsp:param name="pageNo" value="${paging.pageNo}" />
			<jsp:param name="endPageNo" value="${paging.endPageNo}" />
			<jsp:param name="nextPageNo" value="${paging.nextPageNo}" />
			<jsp:param name="finalPageNo" value="${paging.finalPageNo}" />
		</jsp:include>

	</div>

</body>
</html>