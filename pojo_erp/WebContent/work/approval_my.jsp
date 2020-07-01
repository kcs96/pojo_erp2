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

</head>
<body class="sb-nav-fixed">
<nav id="topNav"></nav>
<div id="layoutSidenav">
   <div id="layoutSidenav_nav"></div>
   <div id="layoutSidenav_content">
		<main id="input_div">
			<div id="frame_div" style="border: 1px solid black;">
				<div id="page_title" style="border-bottom: 2px solid gray; margin: 50px 30px;"><h2>내 결재함</h2></div>
				<div id="page_contents" style="max-width: 1730px; margin: 10px 100px;">
     			<!-- 컨텐츠 들어갈내용 시작-->
				
		  		<!-- 받은 결재함 테이블 -->
		  		<button id="del" class="btn btn-danger" style="margin-bottom: 15px;">삭제</button>	
				<table id="table" 
					data-show-columns="true" 
					data-pagination="true"
					data-search="true" 
					data-advanced-search="true"
					data-select-item-name="selectItemName"
					data-toolbar="#del"
					data-url="../juno/member.json">
					<thead>
						<tr>
						<center>  		
		  					<h3>[ 받은 결재함 ]</h3>
		  				</center>
							<th data-field="state" data-checkbox="true" data-width="30%;"></th>
							<th data-field="app_no"  data-align="center" data-width="80%;" data-sortable="true">순번</th>
							<th data-field="app_name" data-align="center" data-width="300%%;">제목</th>
							<th data-field="app_write" data-align="center" data-width="150%;">작성자</th>
							<th data-field="app_print"data-align="center" data-width="200%;">결재 기한</th>
							<th data-field="app_print"data-align="center" data-width="150%;">결재 상태</th>
							<th data-field="operate" data-formatter="operateFormatter" data-width="100px" data-events="operateEvents" data-align="center" data-width="150%;">보기</th>
						</tr>
					</thead>
				</table>
				<!-- 받은 결재함 테이블 끝 -->
				
				<div id="page_contents2" style ="margin: 70px 0px;">
				<hr style="border: 1px solid black;">
		  		 <!-- 보낸 결재함 테이블 -->
		  		 <div id="page_contents2" style ="margin: 70px 0px;">
		  		<button id="del2" class="btn btn-danger" style="margin-bottom: 15px;">삭제</button>
				<table id="table2" 
					data-show-columns="true" 
					data-pagination="true"
					data-search="true" 
					data-advanced-search="true"
					data-select-item-name="selectItemName"
					data-toolbar="#del2"
					data-url="../juno/member2.json">
					<thead>
						<tr>
						<center>  		
		  					<h3>[ 보낸 결재함 ]</h3>
		  				</center>
		  					<th data-field="state" data-checkbox="true" data-width="30%;"></th>
							<th data-field="app_no"  data-align="center" data-width="80%;" data-sortable="true">순번</th>
							<th data-field="app_name" data-align="center" data-width="300%%;">제목</th>
							<th data-field="app_write" data-align="center" data-width="150%;">작성자</th>
							<th data-field="app_print"data-align="center" data-width="200%;">보낸 날짜</th>
							<th data-field="app_print"data-align="center" data-width="150%;">결재 상태</th>
							<th data-field="operate" data-formatter="operateFormatter" data-width="100px" data-events="operateEvents" data-align="center" data-width="150%;">확인</th>
						</tr>
					</thead>
				</table>
				<!-- 보낸 결재함 테이블 끝 -->
					</div>
				</div>
				<!-- 컨텐츠 들어갈내용 끝   -->
     			</div>
			</div>
		</main>
	</div>
</div>
<!-- 슬라이드바 사용할때 필요 -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="https://unpkg.com/bootstrap-table@1.16.0/dist/bootstrap-table.min.js"></script>


<script>
/* ========================== 받은 결재함 ============================= */
	$(function() {
		$('#table').bootstrapTable() //부트스트랩 테이블이라고 선언
	})
	
	/*	받은 결재함 테이블에 들어가는 버튼 생성  */
	function operateFormatter(value, row) {
		return [
	          '<a class="button" href="javascript:void(0)" title="button">',
	          '<button type="button" class="btn btn-info" style="border: 1px solid white; border-radius: 10px; font-size:12px" align="center">보기</button>',
	          "</a>  ", ]
				.join('')
	}
	/*	받은 결재함 테이블에 들어가는 버튼 생성  끝 */
	
	/* 받은 결재함 버튼 이벤트 처리  */
	$(function() {
		$('#del').click(function() {
			var index = []
			$('input[name="selectItemName"]:checked').each(function() {
				index.push($(this).data('index'))
			})
			alert('받은 결재함 삭제버튼 Checked row index: ' + index.join(', '))
		})
	})
	/* 승인 버튼 이벤트 처리  끝 */
	/* ========================== 받은 결재함 끝 ============================= */
	
	/* ========================== 보낸 결재함 =============================== */
	$(function() {
		$('#table2').bootstrapTable() //부트스트랩 테이블이라고 선언
	})
	
	/* 보낸 결재함 테이블에 들어가는 버튼 생성 */
	function operateFormatter2(value, row) {
		return [
			 '<a class="button" href="javascript:void(0)" title="button">',
	          '<button type="button" class="btn btn-info" style="border: 1px solid white; border-radius: 10px; font-size:12px" align="center">확인</button>',
	          "</a>  ", ]
				.join('')
	}
	/* 보낸 결재함 테이블에 들어가는 버튼 생성 끝 */
	
	/* 보낸 결재함 삭제 버튼 이벤트 처리 */
	$(function() {
		$('#del2').click(function() {
			var index = []
			$('input[name="selectItemName"]:checked').each(function() {
				index.push($(this).data('index'))
			})
			alert('보낸 결재함 삭제버튼 Checked row index: ' + index.join(', '))
		})
	})
	/* 읽기 버튼 이벤트 처리  끝 */
	/* ========================== 보낸 결재함  끝 =============================== */
	
		 /* 테이블 버튼 이벤트 처리 부분  */
	window.operateEvents = {
   	'click .button': function (e, value, row, index) {
    		alert('버튼 클릭 row값 : ' + JSON.stringify(row))
     		alert('버튼 클릭 index값 : ' + JSON.stringify(index))
    }
 }
 /* 테이블 버튼 이벤트  처리 끝 */

</script>


<!-- 탑메뉴 사용 -->
<script src="../common/js/topNav.js"></script>
<!-- 사이드 메뉴 사용 -->
<script src="../common//js/sideNav.js?ver=2"></script>
<!-- 버거 메뉴 활성화 -->
<script src="../common/scripts.js"></script>
</body>
</html>
