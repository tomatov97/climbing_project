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
	<main class="container-md">
		<h3>웨이브락 부산대점 
		<a href="#" target=""><i class="bi bi-arrow-repeat small"></i></a>
		</h3>
		<section id="filter-container">
			<div class="filter">
				<p>섹터</p>
				<select class="form-select form-select-sm mb-3" id="sector-select" aria-label=".form-select-lg example">
					<option value=null selected>전체</option>
					<option value="1">아이스버그</option>
					<option value="2">버터밀크</option>
					<option value="3">비숍</option>
				  </select>
			</div>
			<div class="filter">
				<p>홀드</p>
				<select class="form-select form-select-sm mb-3" id="hold-select" aria-label=".form-select-lg example">
					<option selected>전체</option>
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
					<option selected>전체</option>
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
					<option value=null selected>오늘</option>
					<option value="1">One</option>
					<option value="2">Two</option>
					<option value="3">Three</option>
				  </select>
			</div>
			<div class="filter order">
				<p>정렬</p>
				<select class="form-select form-select-sm mb-3" id="order-select" aria-label=".form-select-lg example">
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
			<ul id="list-container">
				<li>
					<div class="card" id="simple-route-info">
                		<div class="icon">
                    		<div class="tape"><img src="../images/icon/tape/navy_tape.png" alt="남색 테이프 이미지">
                        		<div class="hold"><img src="../images/icon/hold/yellow_hold.png" alt="노랑 홀드 이미지"></div>
                    		</div>                                        
                		</div>
						<div class="route-info">
							<p class="bold">노랑 홀드 남색 레벨</p>
							<p class="small">버터밀크(2022.06.01~2022.07.17)</p>
							<p class="small gray">문제 아이디 <span>38273</span></p>
						</div>
						<div class="route-img">
							<img src="../images/route/img1.jpg" alt="">
						</div>
					</div>
				</li>
				<li>
					<div class="card" id="simple-route-info">
						<div class="icon">
							<div class="tape"><img src="../images/icon/tape/skyblue.png" alt="하늘 테이프 이미지">
								<div class="hold"><img src="../images/icon/hold/blue.png" alt="파랑 홀드 이미지"></div>
							</div>                                        
						</div>
						<div class="route-info">
							<p class="large bold">파랑 홀드 하늘 레벨</p>
							<p class="small">버터밀크(2022.06.01~2022.07.17)</p>
							<p class="small gray">문제 아이디 <span>45642</span></p>
						</div>
						<div class="route-img">
							<img src="https://i.ytimg.com/vi/so5s21EqB6M/maxresdefault.jpg" alt="">
						</div>
					</div>					
				</li>
				<li>
					<div class="card" id="simple-route-info">
						<div class="icon">
							<div class="tape"><img src="../images/icon/tape/yellow.png" alt="노랑 테이프 이미지">
								<div class="hold"><img src="../images/icon/hold/white.png" alt="하양 홀드 이미지"></div>
							</div>                                        
						</div>
						<div class="route-info">
							<p class="bold">하양 홀드 노랑 레벨</p>
							<p class="small">아이스버그(2022.05.11~2022.07.31)</p>
							<p class="small gray">문제 아이디 <span>13982</span></p>
						</div>
						<div class="route-img">
							<img src="https://lh3.googleusercontent.com/p/AF1QipPEQmed9miR8U-9gVbvRAvq6BlOVXhzBLqsFaPr=w768-h768-n-o-k-v1" alt="">
						</div>
					</div>				
				</li>
				<li>
					<div class="card" id="simple-route-info">
						<div class="icon">
							<div class="tape"><img src="../images/icon/tape/skyblue.png" alt="하늘 테이프 이미지">
								<div class="hold"><img src="../images/icon/hold/blue.png" alt="파랑 홀드 이미지"></div>
							</div>                                        
						</div>
						<div class="route-info">
							<p class="large bold">파랑 홀드 하늘 레벨 2</p>
							<p class="small">버터밀크(2022.06.01~2022.07.17)</p>
							<p class="small gray">문제 아이디 <span>26586</span></p>
						</div>
						<div class="route-img">
							<img src="https://i.ytimg.com/vi/so5s21EqB6M/maxresdefault.jpg" alt="">
						</div>
					</div>
				</li>
				<li>
					<div class="card" id="simple-route-info">
						<div class="icon">
							<div class="tape"><img src="../images/icon/tape/purple.png" alt="보라 테이프 이미지">
								<div class="hold"><img src="../images/icon/hold/orange.png" alt="주황 홀드 이미지"></div>
							</div>                                        
						</div>
						<div class="route-info">
							<p class="bold">주황 홀드 보라 레벨</p>
							<p class="small">비숍(2022.04.20~2022.06.26)</p>
							<p class="small gray">문제 아이디 <span>89430</span></p>
						</div>
						<div class="route-img">
							<img src="https://cdn.imweb.me/upload/S2021011502a2f4eeeb339/8f368d6bd96b6.jpg" alt="">
						</div>
					</div>
				</li>
			</ul>
		</section>
		<nav id="pagination_wrapper" aria-label="Page navigation example">
			<ul class="pagination pagination-md">
				<li class="page-item">
				    <a class="page-link" href="#" aria-label="Previous">
				       <span aria-hidden="true">&laquo;</span>
				    </a>
				</li>
				<li class="page-item">
				    <a class="page-link" href="#" aria-label="Next">
				       <span aria-hidden="true">&raquo;</span>
				    </a>
				</li>
			</ul>
		</nav>
		<section>
			<a tabindex="0" href="#" id="add-button" data-bs-toggle="tooltip" data-bs-placement="top" title="새로운 문제 추가하기"><i class="bi bi-patch-plus-fill"></i></a>
		</section>

	</main>
	<script>
	var tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'))
	var tooltipList = tooltipTriggerList.map(function (tooltipTriggerEl) {
	  return new bootstrap.Tooltip(tooltipTriggerEl)
	})	
	</script>
	<script type="text/javascript">
		let pageNumber=1;
		
		let parameters = location.search;
		parameters = parameters.substr(1);
		parameters = parameters.split("&");
		
		let pageNumberParam = parameters[1];
		pageNumberParam = pageNumberParam.split("=");
		
		pageNumber = pageNumberParam[1];
		
		let gymId = "${sessionScope.gym.id}";
		<!-- 필터 표시 -->
		
		
		<!-- 리스트 표시 -->
		let filterData = "pageNumber=(1)&gymId=(2)&sectorId=(3)&holdColor=(4)&levelColor=(5)&"
		 +"fromDate=(6)&toDate=(7)&order=(8)";
		
		filterData = filterData.replace("(1)", pageNumber);
		filterData = filterData.replace("(2)", "2");
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
    			$("h3").val(gymName);
    			
    			let amount = routes.amount;
    			let routeList = routes.routeList;
    			
    			// 페이지네이션
    			let pageCount = Math.ceil(amount/10);
    			for(let count=1; count<=pageCount; count++) {
    				$("ul.pagination").append("<li class=\"page-item\"><a class=\"page-link\" href=\"/rockmate/main/routeList.jsp?pageNumber="+count+"\">"+count+"</a></li>");
    			}
    			
    			// 문제 목록
    			let tag = "<li>"
					+"<div class=\"card\" id=\"simple-route-info\">"
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
						+"<img src=\"(7)\" alt=\"클라이밍 문제 이미지\">"
					+"</div>"
				+"</div>"
			+"</li>";
				for (let i=0; i<routeList.length; i++) {
					let nthRoute = routeList[i];
					console.log(nthRoute);
					
					let nthTag = tag.replace("(1)", nthRoute.levelColor);
					nthTag = nthTag.replace("(2)", nthRoute.holdColor);
					nthTag = nthTag.replace("(3)", nthRoute.routeName);
					nthTag = nthTag.replace("(4)", nthRoute.sectorName);
					nthTag = nthTag.replace("(5)", nthRoute.settingDate);
					nthTag = nthTag.replace("(6)", nthRoute.routeId);
					nthTag = nthTag.replace("(7)", nthRoute.img);
					nthTag = nthTag.replace("(8)", nthRoute.img);
					nthTag = nthTag.replace("(9)", nthRoute.img);
					
					$("#list-container").append(nthTag);
				}
    		},
    		error: function(){
    			alert("에러발생!");
    		}
    		
    	})
	</script>
</body>
</html>