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
<title>새로운 클라이밍장 등록</title>
</head>
<body>
	<%@ include file="../includes/header.jsp" %>
    <main>
        <div class="page-title">
          <h2>새로운 클라이밍장 등록</h2>
          <hr>
        </div>
    
        <div class="row g-5">
          <div class="col-md-7 col-lg-8">
            <form class="needs-validation" novalidate="">
              <div class="row g-3">    
                <div class="col-sm-6">
                  <label for="name" class="form-label">클라이밍장 이름</label>
                  <input type="text" class="form-control" name="name" value="" required="">
                  <div class="invalid-feedback">
                    클라이밍장 이름을 입력하세요.
                  </div>
                </div>
    
                <div class="col-12">
                  <label for="tel" class="form-label">대표 전화번호</label>
                  <input type="tel" name="tel">-
                  <input type="tel" name="tel">-
                  <input type="tel" name="tel">
                  <div class="invalid-feedback">
                    대표 전화번호를 입력하세요.
                  </div>
                </div>
    
                <div class="col-12">        
                  <label for="email" class="form-label">클라이밍장 주소</label>   
                  <input type="text" id="sample3_postcode" class="d_form mini" placeholder="우편번호">
                  <input type="button" onclick="sample3_execDaumPostcode()" value="우편번호 찾기" class="d_btn">
                  <br>
                  <input type="text" id="sample3_address" class="d_form large" placeholder="주소">
                  <br>
                  <input type="text" id="sample3_detailAddress" class="d_form" placeholder="상세주소">
                  <input type="text" id="sample3_extraAddress" class="d_form" placeholder="참고항목">
                </div>
                <div id="wrap" style="display:none;border:1px solid;width:500px;height:300px;margin:5px 0;position:relative">
                  <img src="//t1.daumcdn.net/postcode/resource/images/close.png" id="btnFoldWrap" style="cursor:pointer;position:absolute;right:0px;top:-1px;z-index:1" onclick="foldDaumPostcode()" alt="접기 버튼">
                </div>
    
              <button class="w-100 btn btn-primary btn-lg" type="submit">클라이밍장 정보 등록</button>
              </div>
            </form>
          </div>
        </div>
      </main>
      <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
      <script>
        // 우편번호 찾기 찾기 화면을 넣을 element
        var element_wrap = document.getElementById('wrap');

        function foldDaumPostcode() {
            // iframe을 넣은 element를 안보이게 한다.
            element_wrap.style.display = 'none';
        }

        function sample3_execDaumPostcode() {
            // 현재 scroll 위치를 저장해놓는다.
            var currentScroll = Math.max(document.body.scrollTop, document.documentElement.scrollTop);
            new daum.Postcode({
                oncomplete: function(data) {
                    // 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                    // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                    // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                    var addr = ''; // 주소 변수
                    var extraAddr = ''; // 참고항목 변수

                    //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                    if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                        addr = data.roadAddress;
                    } else { // 사용자가 지번 주소를 선택했을 경우(J)
                        addr = data.jibunAddress;
                    }

                    // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                    if(data.userSelectedType === 'R'){
                        // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                        // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                        if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                            extraAddr += data.bname;
                        }
                        // 건물명이 있고, 공동주택일 경우 추가한다.
                        if(data.buildingName !== '' && data.apartment === 'Y'){
                            extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                        }
                        // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                        if(extraAddr !== ''){
                            extraAddr = ' (' + extraAddr + ')';
                        }
                        // 조합된 참고항목을 해당 필드에 넣는다.
                        document.getElementById("sample3_extraAddress").value = extraAddr;
                    
                    } else {
                        document.getElementById("sample3_extraAddress").value = '';
                    }

                    // 우편번호와 주소 정보를 해당 필드에 넣는다.
                    document.getElementById('sample3_postcode').value = data.zonecode;
                    document.getElementById("sample3_address").value = addr;
                    // 커서를 상세주소 필드로 이동한다.
                    document.getElementById("sample3_detailAddress").focus();

                    // iframe을 넣은 element를 안보이게 한다.
                    element_wrap.style.display = 'none';

                    // 우편번호 찾기 화면이 보이기 이전으로 scroll 위치를 되돌린다.
                    document.body.scrollTop = currentScroll;
                },
                // 우편번호 찾기 화면 크기가 조정되었을때 실행할 코드를 작성하는 부분. iframe을 넣은 element의 높이값을 조정한다.
                onresize : function(size) {
                    element_wrap.style.height = size.height+'px';
                },
                width : '100%',
                height : '100%'
            }).embed(element_wrap);

            // iframe을 넣은 element를 보이게 한다.
            element_wrap.style.display = 'block';
        }
    </script>
</body>
</html>