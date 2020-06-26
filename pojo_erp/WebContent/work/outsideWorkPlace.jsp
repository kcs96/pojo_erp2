<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->  
<!--관리자 로그에 필요한 코드 시작=================================================================================-->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
<link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"
  	  rel="stylesheet" crossorigin="anonymous" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js" crossorigin="anonymous" ></script>
<link href="../common/main.css" rel="stylesheet" />
<link href="../common/css/custom.css" rel="stylesheet" />
<!--관리자 로그에 필요한 코드 끝   =================================================================================-->
	
	<title>2RP PROGRAM</title>

<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=39e05403ed4b21e961251256b8fff8ed&libraries=services"></script>

</head>
<body class="sb-nav-fixed">
<nav id="topNav"></nav>
<div id="layoutSidenav">
   <div id="layoutSidenav_nav"></div>
   <div id="layoutSidenav_content">
		<main id="input_div">
			<div id="frame_div" style="border: 1px solid black;">
				<div id="page_title" style="border: 1px solid red; margin: 10px 30px;"><h2>main page</h2></div>
				<div id="page_contents" style="max-width: 1730px; border: 1px solid yellow; margin: 50px 50px;">
     			<!-- 컨텐츠 들어갈내용 시작-->


						<div class="row">
							<div class="col-6">
								<div class="text-center" style="float: left; padding: 5px">
									<button class="btn btn-secondary" style="width: 150px"
										onClick="location.href='outsideWorker.jsp'">파견사원관리</button>
								</div>
							</div>
						</div>
						<table class="table table-bordered">
							<thead>
								<tr>
									<th style="width: 5%">No.</th>
									<th style="width: 10%">회사명</th>
									<th style="width: 10%">전화번호</th>
									<th style="width: 15%">주소</th>
									<th style="width: 15%">싱세주소</th>
									<th style="width: 15%">위도|경도</th>
									<th style="width: 10%">지사</th>
									<th style="width: 25%">비고</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>1</td>
									<td>(주)부산IT</td>
									<td>051-345-6736</td>
									<td>부산시 해운대구 우동 352-1</td>
									<td>부산시 해운대구 우동 352-1</td>
									<td>lat:35.5 long:127.5</td>
									<td>[대구지사]부산IT</td>
									<td></td>
								</tr>
								<tr>
									<td>1</td>
									<td>(주)부산IT</td>
									<td>051-345-6736</td>
									<td>부산시 해운대구 우동 352-1</td>
									<td>부산시 해운대구 우동 352-1</td>
									<td>lat:35.5 long:127.5</td>
									<td>[대구지사]부산IT</td>
									<td></td>
								</tr>
								<tr>
									<td>1</td>
									<td>(주)부산IT</td>
									<td>051-345-6736</td>
									<td>부산시 해운대구 우동 352-1</td>
									<td>부산시 해운대구 우동 352-1</td>
									<td>lat:35.5 long:127.5</td>
									<td>[대구지사]부산IT</td>
									<td></td>
								</tr>
								<tr>
									<td>1</td>
									<td>(주)부산IT</td>
									<td>051-345-6736</td>
									<td>부산시 해운대구 우동 352-1</td>
									<td>부산시 해운대구 우동 352-1</td>
									<td>lat:35.5 long:127.5</td>
									<td>[대구지사]부산IT</td>
									<td></td>
								</tr>
								<tr>
									<td>1</td>
									<td>(주)부산IT</td>
									<td>051-345-6736</td>
									<td>부산시 해운대구 우동 352-1</td>
									<td>부산시 해운대구 우동 352-1</td>
									<td>lat:35.5 long:127.5</td>
									<td>[대구지사]부산IT</td>
									<td></td>
								</tr>

							</tbody>
						</table>
						<div class="text-center">
							<div class="text-center" align="center">
								<ul class="pagination justify-content-center">
									<li class="page-item"><a class="page-link" href="#">&laquo;</a></li>
									<li class="page-item"><a class="page-link" href="#">1</a></li>
									<li class="page-item"><a class="page-link" href="#">2</a></li>
									<li class="page-item"><a class="page-link" href="#">3</a></li>
									<li class="page-item"><a class="page-link" href="#">&raquo;</a></li>
								</ul>
							</div>
						</div>


						<!-- 컨텐츠 들어갈내용 끝   -->
     			</div>
			</div>
		</main>
	</div>
</div>
<!-- 슬라이드바 사용할때 필요 -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<!-- 탑메뉴 사용 -->
<script src="../common/js/topNav.js"></script>
<!-- 사이드 메뉴 사용 -->
<script src="../common//js/sideNav.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous" ></script>
<script src="../common/scripts.js"></script>
<!-- 버거 메뉴 활성화 -->


</body>
</html>
