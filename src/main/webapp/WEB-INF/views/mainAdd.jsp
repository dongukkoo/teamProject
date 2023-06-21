<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>게시물 작성</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
	integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>



	<div class="container-lg">

		<div class="row justify-content-center">
			<div class="col-1 col-md-3 col-lg-6">
				<h1>게시물 작성</h1>
				<form method="post" enctype="multipart/form-data">
					<div class="mb-3">
						<label for="categorySelect" class="form-label">카테고리 지정</label> <select id="categorySelect"
							class="form-select" name="category">
							<option value="1">패션</option>
							<option value="2">가구</option>
							<option value="3">게임</option>
							<option value="4">명품</option>
							<option value="5">전자기기</option>
						</select>
					</div>
					<div class="mb-3">
						<div class="mb-3">
							<label for="titleInput" class="form-label">제목</label> <input id="titleInput"
								class="form-control" type="text" name="title" value="${Product.title }" />
						</div>
						<div class="mb-3">
							<label for="bodyTextarea" class="form-label">내용</label>
							<textarea rows="5" id="bodyTextarea" class="form-control" name="body">${Product.body}</textarea>
						</div>

						<div class="mb-3">
							<label for="priceTextarea" class="form-label">가격</label>
							<textarea rows="1" id="priceTextarea" class="form-control" name="price">${Product.price }</textarea>
						</div>

						<div class="mb-3">
							<label for="addressTextarea" class="form-label">주소</label>
							<textarea rows="1" id="addressTextarea" class="form-control" name="address">${Product.address }</textarea>
						</div>

						<div class="mb-3">
							<label for="qtyTextarea" class="form-label">수량</label>
							<textarea rows="1" id="qtyTextarea" class="form-control" name="qty">${Product.qty }</textarea>
						</div>

						<div class="mb-3">
							<label for="fileInput" class="form-label">상품 사진</label> <input class="form-control"
								type="file" id="fileInput" name="files" accept="image/*" multiple>
							<div class="form-text">총 10MB, 하나의 파일은 1MB를 초과할 수 없습니다.</div>
						</div>

						<div class="mb-3">
							<input class="btn btn-primary" type="submit" value="등록" />
						</div>
				</form>
			</div>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js"
		integrity="sha512-pumBsjNRGGqkPzKHndZMaAG+bir374sORyzM3uulLV14lN5LyykqNk8eEeUlUkB3U0M4FApyaHraT65ihJhDpQ=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</body>
</html>
