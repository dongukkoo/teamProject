<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="current" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

	<div style="display: flex; justify-content: space-between;">
					<div>
					<a href="/mainhompage">메인으로 이동</a>
					</div>
					<div >
					<form action="/freeboard/freelist" role="search">
						<select name="type" style="width: 120px;">
							<option ="all">전체</option>
							<option value="title"${param.type eq 'title' ? 'selected' : '' }>제목</option>
							<option value="body"${param.type eq 'body' ? 'selected' : '' }>본문</option>
							<option value="writer"${param.type eq 'writer' ? 'selected' : '' }>작성자</option>
						</select>
						<input type="search" name="search" placeholder="키워드를 입력해주세요" aria-label="Search" value="${param.search }" style="width: 420px;"/>
						<button><i class="fa-solid fa-magnifying-glass"></i></button>
					</form>
					</div>
					<div>
						<a href="/member/signup">로그인</a>
					</div>
				</div>