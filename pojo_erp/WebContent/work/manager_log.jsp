<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>2RP PROGRAM</title>
    <link href="../mihyun_main/main.css" rel="stylesheet" />
    <link
      href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"
      rel="stylesheet"
      crossorigin="anonymous"
    />
    <script
      src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js"
      crossorigin="anonymous"
    ></script>
    
    <link href="../common/css/custom.css" rel="stylesheet" />
		<script type="text/javascript">
		function manager_log_content(){
			$.ajax({
				url : "manager_log_content.jsp",
				success : function(data) {
					alert("data:" + data);
					$("#log_content").html(data);
				}
			});
		}	
		</script>
  </head>
  
  <body class="sb-nav-fixed">
    <nav id="topNav"></nav>
    <div id="layoutSidenav">
      <div id="layoutSidenav_nav"></div>
      <div id="layoutSidenav_content">
        <main id="input_div">
        	<div id="frame_div" style="border: 1px solid black;">
				<div id="page_title" style="border: 1px solid red; margin: 10px 30px;"><h2>관리자 로그</h2></div>
				<div id="page_contents" style="max-width: 1730px; border: 1px solid yellow; margin: 50px 50px;">
          		<!-- 컨텐츠 들어갈내용 시작-->
		            <ol class="breadcrumb mb-4">
		              <li class="breadcrumb-item">
		                <a href="main.jsp">main</a>
		              </li>
		              <li class="breadcrumb-item active">관리자 로그</li>
		            </ol>
		             <div class="card-header">
		                <i class="fas fa-table mr-1"></i><input type="button" id="b" value="로그 조회" onClick="manager_log_content()">
		                <button type="button" class="btn btn-info float-right" style="border: 3px solid white; border-radius: 10px; padding-bottom: 5px; margin-bottom: 15px;"onClick="window.print()">출력</button>
		              </div>
		              
					<div id="log_content">
					</div>

          		<!-- 컨텐츠 들어갈내용 끝   -->
          		</div>
          	</div>
        </main>
      </div>
    </div>
    
        <script
      src="https://code.jquery.com/jquery-3.4.1.min.js"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"
      crossorigin="anonymous"
    ></script>
    <script src="../dist/js/scripts.js"></script>
    <script
      src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"
      crossorigin="anonymous"
    ></script>
    <script src="../dist/assets/demo/datatables-demo.js"></script>
    

    <!-- 탑메뉴 사용 -->
    <script src="../common/js/topNav.js"></script>
    <!-- 사이드 메뉴 사용 -->
    <script src="../common/js/sideNav.js"></script>
    
    <script src="../common/scripts.js"></script>
    
<script src="https://unpkg.com/bootstrap-table@1.16.0/dist/bootstrap-table.min.js"></script>
  </body>
</html>
