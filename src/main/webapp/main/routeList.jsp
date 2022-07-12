<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
<link rel="stylesheet" href="../css/font.css">
<link rel="stylesheet" href="../css/main.css">
<meta charset="UTF-8">
<title>문제 리스트</title>
</head>
<body>
	<%@ include file="../includes/header.jsp" %>
	<main>
		<h3 id="gym-name">웨이브락 부산대점</h3>
		<h3 id="go-to-search"><a data-bs-toggle="offcanvas" href="#gym-search-container" role="button"><i class="bi bi-arrow-repeat small"></i></a></h3>
		<div class="offcanvas offcanvas-start" tabindex="-1" id="gym-search-container" aria-labelledby="offcanvasExampleLabel">
		  <div class="offcanvas-header">
		    <h5 class="offcanvas-title" id="gym-search-title">클라이밍장 검색</h5>
		    <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
		  </div>
		  <div class="offcanvas-body">
		    <div class="input-group">
			  <input type="text" class="form-control" id="search-blank" placeholder="클라이밍장 이름">
			  <button class="btn btn-outline-secondary" type="button" id="gym-search">검색</button>			  
			</div>
			<div>
				<ul id="find-gyms"></ul>
			</div>
		  </div>
		</div>
		<section id="filter-container">
			<div class="filter">
				<p>섹터</p>
				<select class="form-select form-select-sm mb-3" id="sector-select" aria-label=".form-select-lg example">
					<option value="all" selected>전체</option>
					<option value="1">아이스버그</option>
					<option value="2">버터밀크</option>
					<option value="3">비숍</option>
				  </select>
			</div>
			<div class="filter">
				<p>홀드</p>
				<select class="form-select form-select-sm mb-3" id="hold-select" aria-label=".form-select-lg example">
					<option value="all" selected>전체</option>
					<option value="빨강">빨강</option>
					<option value="주황">주황</option>
					<option value="노랑">노랑</option>
					<option value="연두">연두</option>
					<option value="초록">초록</option>
					<option value="민트">민트</option>
					<option value="하늘">하늘</option>
				  </select>
			</div>
			<div class="filter">
				<p>레벨</p>
				<select class="form-select form-select-sm mb-3" id="level-select" aria-label=".form-select-lg example">
					<option value="all" selected>전체</option>
					<option value="빨강">빨강</option>
					<option value="주황">주황</option>
					<option value="노랑">노랑</option>
					<option value="연두">연두</option>
					<option value="초록">초록</option>
					<option value="민트">민트</option>
					<option value="하늘">하늘</option>
				  </select>
			</div>
			<div class="filter">
				<p>날짜</p>
				<select class="form-select form-select-sm mb-3" id="date-select" aria-label=".form-select-lg example">
					<option value="all" selected>오늘</option>
					<option value="1">One</option>
					<option value="2">Two</option>
					<option value="3">Three</option>
				  </select>
			</div>
			<div class="filter order">
				<p>정렬</p>
				<select class="form-select form-select-sm mb-3" id="order-select" name="order" aria-label=".form-select-lg example">
					<option value="levelScore-avg_ASC" selected>물문제 순</option>
					<option value="levelScore-avg_DESC">불문제 순</option>
					<option value="funScore-avg_ASC">낮은 재미 순</option>
					<option value="funScore-avg_DESC">높은 재미 순</option>
				  </select>
			</div>
			<div class="filter search">
				<p>아이디로 검색</p>
				<div class="input-group mb-3">					
				  	<input type="text" class="form-control" placeholder="문제 아이디">
				</div>
			</div>
		</section>
		<section id="route-list">
			<ul id="list-container"></ul>
		</section>
		<nav id="pagination_wrapper" aria-label="Page navigation">
			<ul class="pagination pagination-md">
				<li class="page-item">
				    <a class="page-link" href="#" aria-label="Previous">
				       <span aria-hidden="true">&laquo;</span>
				    </a>
				</li>
			</ul>
		</nav>
		<section>
			<a tabindex="0" href="../route/add?gymId=${param.gymId}" id="add-button" data-bs-toggle="tooltip" data-bs-placement="top" title="새로운 문제 추가하기"><i class="bi bi-patch-plus-fill"></i></a>
		</section>

	</main>
	<script src="../js/scripts.js"></script>
    <script src="../js/jquery-3.6.0.min.js"></script>
	<script>
	var tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'))
	var tooltipList = tooltipTriggerList.map(function (tooltipTriggerEl) {
	  return new bootstrap.Tooltip(tooltipTriggerEl)
	})	
	</script>
	<script type="text/javascript">
		let pageNumber=1;
		console.log("스크립트 시작");
		
		let parameters = location.search;
		parameters = parameters.substr(1);
		parameters = parameters.split("&");
		
		let pageNumberParam = parameters[0];
		pageNumberParam = pageNumberParam.split("=");
		
		pageNumber = pageNumberParam[1];
		
		let gymId = "${param.gymId}";
		<!-- 필터 표시 -->
		$.ajax({
			url: "http://localhost/rockmate/sector/search",
    		type: "get",
    		data: "gymId="+gymId,
    		datatype: "json",
    		success: function(response){
    			$("#sector-select").empty();
    			$("#sector-select").append("<option value=\"all\" selected>전체</option>");
    			let sectors = response.sectorList;
    			let tag = "<option value=\"(1)\">(2)</option>";
					for (let i=0; i<sectors.length; i++) {
						let nthSector = sectors[i];
						let nthTag = tag.replace("(1)", nthSector.sectorId);
						nthTag = nthTag.replace("(2)", nthSector.name);
						
						$("#sector-select").append(nthTag);
					}
    		},
    		error: function(){
    			
    		}			
		})
		
		<!-- 리스트 표시 -->
		let filterData = "pageNumber=(1)&gymId=(2)&sectorId=(3)&holdColor=(4)&levelColor=(5)&"
		 +"fromDate=(6)&toDate=(7)&order=(8)";
		
		filterData = filterData.replace("(1)", pageNumber);
		filterData = filterData.replace("(2)", gymId);
		filterData = filterData.replace("(3)", $("#sector-select").val());
		filterData = filterData.replace("(4)", $("#hold-select").val());
		filterData = filterData.replace("(5)", $("#level-select").val());
		filterData = filterData.replace("(6)", null);
		filterData = filterData.replace("(7)", null);
		filterData = filterData.replace("(8)", $("#order-select").val());
		
		$.ajax({
    		url: "http://localhost/rockmate/list",
    		type: "get",
    		data: filterData,
    		datatype: "json",
    		success: function(routes){
    			let gymName = routes.gymName;
    			$("#gym-name").text(gymName);
    			
    			let amount = routes.amount;
    			let routeList = routes.routeList;
    			
    			// 페이지네이션
    			let pageCount = Math.ceil(amount/10);
    			for(let count=1; count<=pageCount; count++) {
    				$("ul.pagination").append("<li class=\"page-item\"><a class=\"page-link\" href=\"/rockmate/main/routeList.jsp?pageNumber="+count+"\">"+count+"</a></li>");
    			}
    			$("ul.pagination").append("<li class=\"page-item\">"
    				    + "<a class=\"page-link\" href=\"#\" aria-label=\"Next\">"
			       			+"<span aria-hidden=\"true\">&raquo;</span>"
			    		+ "</a></li>");
    			
    			
    			// 문제 목록
    			let tag = "<li>"
					+"<div class=\"card row-flex\" onclick=\"goDetail((6))\">"
						+"<div class=\"icon\">"
							+"<div class=\"tape\"><img src=\"../images/icon/tape/(8).png\" alt=\"(1) 테이프 이미지\">"
							+"<div class=\"hold\"><img src=\"../images/icon/hold/(9).png\" alt=\"(2) 홀드 이미지\"></div>"
						+"</div>"                                        
					+"</div>"
					+"<div class=\"route-info\">"
						+"<p class=\"large bold\">(3)</p>"
						+"<p class=\"small\">(4)((5))</p>"
						+"<p class=\"small gray\">문제 아이디 <span>(6)</span></p>"
					+"</div>"
					+"<div class=\"route-img\">"
						+"<img src=\"/rockmate/images/route/(7)\" alt=\"클라이밍 문제 이미지\">"
					+"</div>"
				+"</div>"
			+"</li>";
			
				for (let i=0; i<routeList.length; i++) {
					let nthRoute = routeList[i];
					
					let nthTag = tag.replace("(1)", nthRoute.levelColor);
					nthTag = nthTag.replace("(2)", nthRoute.holdColor);
					nthTag = nthTag.replace("(3)", nthRoute.routeName);
					nthTag = nthTag.replace("(4)", nthRoute.sectorName);
					nthTag = nthTag.replace("(5)", nthRoute.settingDate);
					nthTag = nthTag.replaceAll("(6)", nthRoute.routeId);
					nthTag = nthTag.replace("(7)", nthRoute.img);
					nthTag = nthTag.replace("(8)", nthRoute.levelEng);
					nthTag = nthTag.replace("(9)", nthRoute.holdEng);
					
					$("#list-container").append(nthTag);
				}
    		},
    		error: function(request, status, error){ 
    			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);  
    		}
    		
    	})
    	
    	function goDetail(routeId){
        			location.href="/rockmate/main/routeDetail.jsp?routeId="+routeId;
        		}
		
		$("#gym-search").click(function(){
			var gymKeywrd = $(".offcanvas-body input").val();
			if (gymKeywrd != "") {
				$("#find-gyms").empty();
				$.ajax({
		    		url: "http://localhost/rockmate/gym/search",
		    		type: "get",
		    		data: "gymKeywrd="+gymKeywrd,
		    		datatype: "json",
		    		success: function(response) {
						let list = response.gymList;
						if (list.length == 0) {
							$("#find-gyms").append("<p>일치하는 정보가 없습니다.</p>");
						} else {
							let tag = "<li class=\"column-flex card\" onclick=\"changeGym((1))\">"
						  		+"<h6 class=\"bold\">(2)</h6>"
						  		+"<p class=\"gray\">(3)</p>"
						  		+"</li>";
								for (let i=0; i<list.length; i++) {
									let nthGym = list[i];
									console.log(nthGym);
									let nthTag = tag.replace("(1)", nthGym.gymId);
									nthTag = nthTag.replace("(2)", nthGym.name);
									nthTag = nthTag.replace("(3)", nthGym.addr);
									
									$("#find-gyms").append(nthTag);
								}
						}												
		    		},
		    		error: function(request, status, error) {
		    			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		    			}
				})
			}			
		})
		
		function changeGym(gymId) {
			location.href="/rockmate/main/routeList.jsp?pageNumber=1&gymId="+gymId;
		}
	</script>
</body>
</html>