<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
  <link rel="stylesheet" href="../css/main.css">
  <link rel="stylesheet" href="../css/add.css">
  <link rel="stylesheet" href="../css/header.css">
  <link rel="stylesheet" href="../css/font.css">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
    crossorigin="anonymous"></script>
  <meta charset="UTF-8">
  <title>새로운 문제 등록</title>
</head>

<body>
<%@ include file="../includes/header.jsp" %>
<main class="column-flex">
  <div>
    <h3>새로운 문제 등록</h3>
    <hr>
  </div>
  
    <form class="needs-validation" action="/rockmate/route/add" method="post">
      <section id="select-container" class="row-flex">
        <div class="row-flex">
          <p class="center">섹터</p>
          <select class="form-select form-select-sm" id="sector-select" aria-label=".form-select-lg example">
            <option selected>선택</option>
            <option value="1">아이스버그</option>
            <option value="2">버터밀크</option>
            <option value="3">비숍</option>
          </select>
        </div>

        <div class="row-flex">
          <p class="center">세팅 날짜</p>
          <input type="text" class="form-control" id="date-info" readonly>
          <select class="form-select form-select-sm" id="setting-select" aria-label=".form-select-lg example">
            <option value="1" selected>가장 최근</option>
            <option value="4">아이스버그</option>
            <option value="2">버터밀크</option>
            <option value="3">비숍</option>
          </select>
        </div>
      </section>

      <section id="color-select-container" class="column-flex flex-center">
        <div id="new-hold-color" class="row-flex">
          <p>홀드색</p>
          <div class="row-flex flex-between color-buttons">
            <input type="radio" name="holdColor" id="pink-hold" value="분홍" /> <label for="pink-hold" class="pink-button"></label>
            <input type="radio" name="holdColor" id="red-hold" value="빨강" /> <label for="red-hold" class="red-button"></label>
            <input type="radio" name="holdColor" id="orange-hold" value="주황" /> <label for="orange-hold"
              class="orange-button"></label>
            <input type="radio" name="holdColor" id="yellow-hold" value="노랑" /> <label for="yellow-hold"
              class="yellow-button"></label>
            <input type="radio" name="holdColor" id="yellowgreen-hold" value="연두" /> <label for="yellowgreen-hold"
              class="yellowgreen-button"></label>
            <input type="radio" name="holdColor" id="green-hold" value="초록" /> <label for="green-hold"
              class="green-button"></label>
            <input type="radio" name="holdColor" id="mint-hold" value="민트" /> <label for="mint-hold" class="mint-button"></label>
            <input type="radio" name="holdColor" id="skyblue-hold" value="하늘" /> <label for="skyblue-hold"
              class="skyblue-button"></label>
            <input type="radio" name="holdColor" id="blue-hold" value="파랑" /> <label for="blue-hold" class="blue-button"></label>
            <input type="radio" name="holdColor" id="purple-hold" value="보라" /> <label for="purple-hold"
              class="purple-button"></label>
            <input type="radio" name="holdColor" id="white-hold" value="흰색" /> <label for="white-hold"
              class="white-button"></label>
            <input type="radio" name="holdColor" id="gray-hold" value="회색" /> <label for="gray-hold" class="gray-button"></label>
            <input type="radio" name="holdColor" id="black-hold" value="검정" /> <label for="black-hold"
              class="black-button"></label>
          </div>
          <span id="hold-name"></span>
        </div>

        <div id="new-level-color" class="row-flex">
          <p>레벨색</p>
          <div class="row-flex flex-between color-buttons">
            <input type="radio" name="levelColor" id="pink-level" value="분홍" /> <label for="pink-level" class="pink-button"></label>
            <input type="radio" name="levelColor" id="red-level" value="빨강" /> <label for="red-level" class="red-button"></label>
            <input type="radio" name="levelColor" id="orange-level" value="주황" /> <label for="orange-level"
              class="orange-button"></label>
            <input type="radio" name="levelColor" id="yellow-level" value="노랑" /> <label for="yellow-level"
              class="yellow-button"></label>
            <input type="radio" name="levelColor" id="green-level" value="초록" /> <label for="green-level"
              class="green-button"></label>
            <input type="radio" name="levelColor" id="skyblue-level" value="하늘" /> <label for="skyblue-level"
              class="skyblue-button"></label>
            <input type="radio" name="levelColor" id="navy-level" value="남색" /> <label for="navy-level" class="navy-button"></label>
            <input type="radio" name="levelColor" id="purple-level" value="보라" /> <label for="purple-level"
              class="purple-button"></label>
            <input type="radio" name="levelColor" id="white-level" value="흰색" /> <label for="white-level"
              class="white-button"></label>
            <input type="radio" name="levelColor" id="gray-level" value="회색" /> <label for="gray-level" class="gray-button"></label>
            <input type="radio" name="levelColor" id="black-level" value="검정" /> <label for="black-level"
              class="black-button"></label>
          </div>
          <span id="level-name"></span><span id="route-number"></span>
        </div>

        <p class="pink-txt">* 해당 섹터에 같은 색 홀드, 같은 레벨의 문제가 <span id="same-route-amt">0</span>개 있어요!</p>
      </section>

      <hr class="gray">

      <section id="comment-img-container">
        <div class="row-flex">
          <label for="formFileSm" class="form-label">사진 첨부</label>
          <input class="form-control form-control-sm" id="formFileSm" type="file">
          <span></span>
        </div>

        <div class="mb-3 row-flex">
          <label for="comment-input" class="form-label">기타 설명</label>
          <textarea class="form-control" id="comment-input" rows="3" 
          placeholder="대략적인 위치 (오른쪽, 왼쪽), 홀드 모양 등 참고할 만한 정보들을 적어 주시면 문제 찾기가 더 쉬워져요!"></textarea>
          <span></span>
        </div>        
      </section>
      <div class="row-flex flex-end">
        <input type="button" value="등록"></input>
      </div>
    </form>
</main>
<script src="../js/scripts.js"></script>
<script src="../js/jquery-3.6.0.min.js"></script>
<script>
    var holdColor = undefined;
    var levelColor = undefined;
    $("input[name='holdColor']:radio").change(function () {
        holdColor = this.value;                        
        $("#hold-name").text(holdColor+" 홀드");
        if(holdColor!=undefined && levelColor!=undefined) {
        	amountOfSameColors(holdColor, levelColor);
        }
    });

    $("input[name='levelColor']:radio").change(function () {
        levelColor = this.value;                        
        $("#level-name").text(levelColor+" 레벨");  
        if(holdColor!=undefined && levelColor!=undefined) {
        	amountOfSameColors(holdColor, levelColor);
        }
    });

    function amountOfSameColors(holdColor, levelColor) {
        $.ajax({
        	url: "http://localhost/rockmate/route/add",
    		type: "get",
    		data: "settingId="+$("#setting-select").val()+"&holdColor="+holdColor+"&levelColor="+levelColor,
    		datatype: "json",
    		success: function(amount){
    			var count = amount.count;
    			$("#same-route-amt").text(count);
    			if(parseInt(count)>1) {	$("#route-number").text(" "+ (parseInt(count)+1));}
    			else {$("#route-number").text(" ");}
    		},
    		error: function(request, status, error){ 
    			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);  
    		}
        })
      }

  </script>
</body>

</html>