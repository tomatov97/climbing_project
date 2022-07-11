<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
<link rel="stylesheet" href="../css/main.css">
<link rel="stylesheet" href="../css/header.css">
<link rel="stylesheet" href="../css/font.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
	<%@ include file="../includes/header.jsp" %>
    <main>
        <div class="page-title">
          <h3>회원 가입</h3>
          <hr>
        </div>    
            <form class="needs-validation" novalidate="" action="/rockmate/member/join" method="post">
              <div class="row g-3">    
                <div class="col-sm-6">
                  <label for="name" class="form-label">이름</label>
                  <input type="text" class="form-control" id="name" name="name" placeholder="이름" value="" required="">
                  <div class="invalid-feedback">
                    이름을 입력하세요.
                  </div>
                </div>
    
                <div class="col-12">
                  <label for="username" class="form-label">아이디</label>
                  <div class="input-group has-validation">
                    <input type="text" class="form-control" id="username" name="id"placeholder="아이디" required="">
                    <div class="invalid-feedback">
                      아이디를 입력하세요.
                    </div>
                  </div>
                </div>

                <div class="col-12">
                  <label for="password" class="form-label">비밀번호</label>
                  <div class="input-group has-validation">
                    <input type="password" class="form-control" id="password" name="pw" placeholder="비밀번호" required="">
                    <div class="invalid-feedback">
                      비밀번호를 입력하세요.
                    </div>
                  </div>
                  <label for="passwordChk" class="form-label">비밀번호 확인</label>
                  <div class="input-group has-validation">
                    <input type="password" class="form-control" id="passwordChk" name="pwChk" placeholder="비밀번호 확인" required="">
                    <div class="invalid-feedback">
                      비밀번호 확인을 입력하세요.
                    </div>
                  </div>
                </div>
    
                <div class="col-12">
                  <label for="email" class="form-label">이메일</label>
                  <input type="email" class="form-control" id="email" name="email" placeholder="abcd@example.com">
                  <div class="invalid-feedback">
                    이메일을 입력하세요.
                  </div>
                </div>

                <input type="submit" value="회원가입"></input>
              </div>
            </form>
        </main>
</body>
</html>