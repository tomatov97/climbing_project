<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">    
    <link rel="stylesheet" href="../css/font.css">
    <link rel="stylesheet" href="../css/main.css">
    <!-- Font Awesome -->
    <link
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
    rel="stylesheet"
    />
    <!-- Google Fonts -->
    <link
    href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
    rel="stylesheet"
    />
    <!-- MDB -->
    <link
    href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/4.2.0/mdb.min.css"
    rel="stylesheet"
    />
    <!-- MDB -->
    <script
    type="text/javascript"
    src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/4.2.0/mdb.min.js"
    ></script>
    <title>문제 상세 보기</title>
</head>
<body id="body">
	<%@ include file="../includes/header.jsp" %>
    <div class="card">
      <div class="infoCard">
          <div class="col-md-3" id="detail-img-container">
            <img src="../images/route/img1.jpg" class="detail-img" alt="...">
          </div>
          <div class="col-md-7">
            <div class="cardBody">
              <h6 class="card-title">빨강 홀드 남색 레벨 <small class="small-txt">문제 아이디 16531</small></h6>
              <ul id="detail-info">
                <li>
                	<span class="bold">섹터</span>미드나잇 (2022.05.02 ~ 2022.06.02)
                </li>
                <li>
                    <span class="bold">맵기</span>
                    <div class="score-container">
                      <div class="progress">
                        <div class="progress-bar bg-danger gradient-level" role="progressbar" style="width: 70%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                      </div>
                    </div>                    
                </li>
                <li>
                    <span class="bold">재미</span>
                    <div class="score-container">
                      <div class="progress">
                        <div class="progress-bar bg-warning gradient-fun" role="progressbar" style="width: 80%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                      </div>
                    </div>                    
                </li>
              </ul>
              <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
            </div>
          </div>
          <div class="col-md-2 side-info">
            <p class="x-small gray">조회수<span>56</span></p>
            <p class="x-small gray"><i class="bi bi-heart"></i> 좋아요 <span>15</span></p>
          </div>
      </div>
    </div>
    <section id="review-container" class="card">
        <p class="card-title">코멘트</p>
        <ul id="comment-info">
          <li>
            <div class="card">
              <p class="username">username</p>
              <p class="review">review</p>
            </div>            
          </li>
          <li>
            <div class="card">
              <p class="username">username</p>
              <p class="review">review</p>
            </div>            
          </li>
          <li>
            <div class="card">
              <p class="username">username</p>
              <p class="review">review</p>
            </div>            
          </li>
        </ul>
    </section>
    <script src="../js/scripts.js"></script>
    <script src="../js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript">
    
    </script>
</body>
</html>