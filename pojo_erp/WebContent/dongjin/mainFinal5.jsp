<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
      <script type="text/javascript" src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
        <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet" crossorigin="anonymous" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js" crossorigin="anonymous"></script>
        <link href="main.css?after" rel="stylesheet" />

<title>2RP PROGRAM</title>

<script type="text/javascript">
	function empSal(){
	        $.ajax({
	         url:"layout2.jsp"
	         ,success:function(data){
	            alert("data:"+data);
	            $("#input_div").html(data);
	         }
	      });
	}
	function Sal(){
        $.ajax({
         url:"layout3.jsp"
         ,success:function(data){
            alert("data:"+data);
            $("#input_div").html(data);
         }
      });
}
</script>
</head>
   <body class="sb-nav-fixed">
        <nav class="sb-topnav navbar navbar-expand navbar-dark" style="background-color:#282828; text-align: center;">
           <!-- 버거바 -->
            <button class="btn btn-link btn-sm order-1 order-lg-0" id="sidebarToggle" href="#"><i class="fas fa-bars"></i></button>
            <!-- 메인 이름 -->
            <a class="navbar-brand" href="1.jsp" style="width:100%;" >2RP PROGRAM</a>
            <!-- 홈버튼 위치 -->
            
      </nav>
       <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion" style="background-color:#323232 ">
                
                    <div class="sb-sidenav-footer" style="background-color:#323232; margin-top:10px;">
                       <div class="container">
                          <div class="row">
                              <div class="col" style="width:40%; margin-left:-5px;"><img class="rounded-circle" alt="사원얼굴" src="1.jpg" style="width:60px; height:60px;"></div>
                              <div class="col" style="width:60%; margin-left:-50px;text-align:center; padding: 20px 0px;">개구리 사원</div>
                           </div>
                           <div class="row">
                              <div style="width:50%; padding: 5px 3px;"><button class="bg-dark">회원수정</button></div>
                              <div style="width:50%; padding: 5px 3px;"><button class="bg-white">로그아웃</button></div>
                           </div>
                       </div>
                    </div>
                    
                    
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                         <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                            <div class="sb-nav-link-icon"><i class="fas fa-user"></i></div>
                                 My Service
                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div></a>
                            
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-parent="#sidenavAccordion">
                               <nav class="sb-sidenav-menu-nested nav">
                              <!--  <a class="nav-link" href="javascript:nextClick()">출|퇴관리</a> -->
                              <a class="nav-link" href="#">출|퇴관리</a>
                               <a class="nav-link" onclick="empSal()">급여관리</a>
                               <a class="nav-link" href="layout-sidenav-light.html">개인일정</a>
                               </nav>
                            </div>
               
                          <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                            <div class="sb-nav-link-icon"><i class="fas fa-edit"></i></div>
                               Work    
                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div></a>
                            <div class="collapse" id="collapsePages" aria-labelledby="headingTwo" data-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#pagesCollapseAuth" aria-expanded="false" aria-controls="pagesCollapseAuth">
                     		                     전자결제
                                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div></a>
                                    <div class="collapse" id="pagesCollapseAuth" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
                                        <nav class="sb-sidenav-menu-nested nav">
                                        <a class="nav-link" href="login.html">내 결제함</a>
                                        <a class="nav-link" href="register.html">결제양식</a>
                                        <a class="nav-link" href="password.html">결제신청</a>
                                        </nav>
                                    </div>
                                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#pagesCollapseError" aria-expanded="false" aria-controls="pagesCollapseError">
                                 		      인사
                                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div></a>
                                    <div class="collapse" id="pagesCollapseError" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
                                        <nav class="sb-sidenav-menu-nested nav">
                                        <a class="nav-link" href="401.html">조직도</a>
                                        <a class="nav-link" href="404.html">사원관리</a>
                                        <a class="nav-link" href="500.html">파견사원</a>
                                        </nav>
                                    </div>
                                     <a class="nav-link" href="#" data-target="#pagesCollapseError" aria-expanded="false" aria-controls="pagesCollapseError">
                                      	 부서일정
                                     <div class="sb-sidenav-collapse-arrow"></div></a>
                                     <a class="nav-link" href="#" data-target="#pagesCollapseError" aria-expanded="false" aria-controls="pagesCollapseError">
                                 		     관리자
                                     <div class="sb-sidenav-collapse-arrow"></div></a>
                                </nav>
                            </div>
                            
                            <a class="nav-link" href="charts.html"
                                ><div class="sb-nav-link-icon"><i class="fas fa-calendar"></i></div>
                               Conference</a
                            ><a class="nav-link" href="tables.html"
                                ><div class="sb-nav-link-icon"><i class="fas fa-comments"></i></div>
                                Chat</a>
                        </div>
                    </div>
                </nav>
            </div>
            <div id="layoutSidenav_content">
                <main id="input_div" >
                <!-- insert here -->
                <!-- <script src="/js/react/cfTableContainer.bundle.js"></script> -->
                </main>
            </div>
        </div>
        <!-- 슬라이드바 사용할때 필요 -->
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
       
       	    <script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
        <script src="scripts.js"></script>
       <!-- 버거 메뉴 활성화 -->
         <script src="js/scripts.js"></script>
         
</body>
</html>