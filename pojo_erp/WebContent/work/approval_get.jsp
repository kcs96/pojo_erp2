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
<link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet" crossorigin="anonymous"/>
<link rel="stylesheet" href="https://unpkg.com/bootstrap-table@1.16.0/dist/bootstrap-table.min.css" />
<link href="../common/main.css" rel="stylesheet" />
<link href="../common/css/custom.css" rel="stylesheet" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js" crossorigin="anonymous"></script>
<!--관리자 로그에 필요한 코드 끝   =================================================================================-->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
<link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"
      	  rel="stylesheet" crossorigin="anonymous" />
<link href="../common/main.css" rel="stylesheet" />
<link href="../common/css/custom.css" rel="stylesheet" />
   
   <title>2RP PROGRAM</title>
<!-- 파라미터 받기  -->
 <%
	request.setCharacterEncoding("UTF-8");
 	String ap_reporter = request.getParameter("ap_reporter"); //이름 채번
 	String no  = request.getParameter("no"); //번호  채번
 	String fr_no  = request.getParameter("fr_no"); //양식 채번
 	String ap_title  = request.getParameter("ap_title"); //제목 채번
 	String ap_prosessingdate  = request.getParameter("ap_prosessingdate"); //기한 채번
 	String ap_dname  = request.getParameter("ap_dname"); //부서 채번
 	String ap_content  = request.getParameter("ap_content"); //문서 내용 채번
 	String ap_contact = request.getParameter("ap_contact"); //사원 번호 채번
 	String ap_bego = request.getParameter("ap_bego"); //비고 
 	String ap_instructions = request.getParameter("ap_instructions"); //특이사항
 	String ap_appdate = request.getParameter("ap_appdate"); //작성일자
 	String ap_appdate_1 = request.getParameter("ap_appdate_1"); //년
 	String ap_appdate_2 = request.getParameter("ap_appdate_2"); //월
 	String ap_appdate_3 = request.getParameter("ap_appdate_3"); //일
 	String ap_no = request.getParameter("ap_no"); //문서 고유번호
 	
 	String null_check = "undefined"; //null체크
 	
 	if(ap_reporter.equals(null_check)){
 		ap_reporter = "";
 	}
 	if(no.equals(null_check)){
 		no = "";
 	}
 	if(fr_no.equals(null_check)){
 		fr_no = "";
 	}
 	if(ap_title.equals(null_check)){
 		ap_title = "";
 	}
 	if(ap_prosessingdate.equals(null_check)){
 		ap_prosessingdate = "";
 	}
 	if(ap_dname.equals(null_check)){
 		ap_dname = "";
 	}
 	if(ap_content.equals(null_check)){
 		ap_content = "";
 	}
 	if(ap_contact.equals(null_check)){
 		ap_contact = "";
 	}
 	if(ap_bego.equals(null_check)){
 		ap_bego = "";
 	}
 	if(ap_instructions.equals(null_check)){
 		ap_instructions = "";
 	}
 	if(ap_appdate.equals(null_check)){
 		ap_appdate = "";
 	}
 	if(ap_appdate_1.equals(null_check)){
 		ap_appdate_1 = "";
 	}
 	if(ap_appdate_2.equals(null_check)){
 		ap_appdate_2 = "";
 	}
 	if(ap_appdate_3.equals(null_check)){
 		ap_appdate_3 = "";
 	}
 	if(ap_no.equals(null_check)){
 		ap_no = "";
 	}
%>
<!-- 파라미터 받기 끝 -->

<script type="text/javascript">
	function approval(){
		ap_no = <%=ap_no%>
		location.href="http://localhost:5000/work/workAgree.erp?ap_no="+ ap_no
	}

	function dismissal(){
		ap_no = <%=ap_no%>
		alert("기각 버튼 호출 성공");
		$("#f_gigag").attr("method","get");
		$("#f_gigag").attr("action","workDeny.erp");
		$("#f_gigag").submit();
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
  <div id="page_title" style="border-bottom: 2px solid gray; margin: 50px 30px;"><h2>받은 결재</h2></div>
  	 <div id="page_contents" style="border: 1px solid black; max-width: 1730px; margin: 10px 100px;">
  	 
  	 
  	 <div class="row"><!--승인 기각버튼  -->
  	 <div  class="col-1"></div>
	    <div style="margin-top:15px;"class="col-5">
	    	<button   style="margin-right:5px;"class="btn btn-info" data-toggle="modal" data-target="#myModal">승인</button>
	        <button   style="margin-right:5px;"class="btn btn-info" data-toggle="modal" data-target="#myModal1">기각</button>
	 
	       <!-- 드랍다운 -->

			</div> <!--드랍다운 끝  -->
			</div>
        <hr style="border: solid 1px black;">
  	<div class="row">
  	  <div class="col-1"></div>
  	 	<div class="col-10">
  	 	<br>
			<table class="table">
				 <tr>
				   <td style="padding:5px;text-align:center;">보낸사람</td>
				   <td><%= ap_reporter %></td>	<!-- 보낸사람 이름  -->
				   <td style="padding-right:5px;text-align:center;">기안부서</td>
				   <td><%= ap_dname %></td> <!-- 부서 이름  -->
				 </tr>
				 <tr>
				   <td style="width:20%;text-align:center;">번호</td>
				   <td><%= ap_contact %></td><!-- 사원 전화번호  -->
				   <td style="padding:5px;\text-align:center;"></td>
				   <td></td>
				 </tr>
				 <tr>
				   <td style="text-align:center;">제목</td>
				   <td><%= ap_title %></td>	<!-- 제목  -->
				   <td style="padding:5px;\text-align:center;"></td>
				   <td></td>
				 </tr>
				 <tr>
				   <td style="width:20%;text-align:center;">기한</td>
				   <td><%= ap_prosessingdate %></td> <!-- 기한 -->
				   <td style="padding:5px;width:20%;text-align:center;"></td>
				   <td></td>
				 </tr>
			</table>
  	 	</div>
  	 </div>
		<hr style="border: solid 1px black;">
	<div class="row">
		<div class="col-1"></div>
			<div style=" border:2px solid black;"class="col-10"id="test"></div>
	</div>
		<div class="col-1"></div>
<!-- 	<!-- 이전꺼 보여주는 거 -->\
	  <div class="row">
		<div class="col-1"></div>
		<div class="col-10"></div>
	  </div>
	<div class="col-1"></div> -->
	</div>
	</div>
	  	<!--	페이지 나누기	  -->
	  	 <script type="text/javascript">
				page = <%=fr_no%>
	  	 		if(page===1){	//사원 페이지
	  	 			$(document).ready(function(){
						$.ajax({
							url:"../sanghyun2/huga.jsp"
							,success:function(data){
								$("#test").html(data);
								$("#ap_reporter").val("<%=ap_reporter%>");
								$("#ap_dname").val("<%=ap_dname%>");
								$("#ap_prosessingdate").val("<%=ap_prosessingdate%>");
								$("#ap_content").val("<%=ap_content%>");
								$("#ap_contact").val("<%=ap_contact%>");
								$("#ap_year").val("<%=ap_appdate_1%>");
								$("#ap_month").val("<%=ap_appdate_2%>");
								$("#ap_today").val("<%=ap_appdate_3%>");
								$("#ap_namein").val("<%=ap_reporter%>"); 
								
							}
						})
					});	
				}
				else if(page===2){	//파견 페이지 
	  	 			$(document).ready(function(){
						$.ajax({
							url:"../sanghyun2/paguns.jsp"
							,success:function(data){
								$("#test").html(data);
								$("#ap_reporter").val("<%=ap_reporter%>");
								$("#ap_dname").val("<%=ap_dname%>");
								$("#ap_prosessingdate").val("<%=ap_prosessingdate%>");
								$("#ap_content").val("<%=ap_content%>");
								$("#ap_contact").val("<%=ap_contact%>");
								$("#ap_year").val("<%=ap_appdate_1%>");
								$("#ap_month").val("<%=ap_appdate_2%>");
								$("#ap_today").val("<%=ap_appdate_3%>");
								$("#ap_namein").val("<%=ap_reporter%>"); 
							}
						})
					});	
				}
				if(page===3){	//업무보고서 
	  	 			$(document).ready(function(){
						$.ajax({
							url:"../sanghyun2/upmo.jsp"
							,success:function(data){
								$("#test").html(data);
								$("#ap_reporter").val("<%=ap_reporter%>");
								$("#ap_appdate").val("<%=ap_appdate%>");
								$("#ap_content").val("<%=ap_content%>");
								$("#ap_bego").val("<%=ap_bego%>");
								$("#ap_instructions").val("<%=ap_instructions%>");
							}
						})
					});	
				}
				if(page===4){	//사직서 
	  	 			$(document).ready(function(){
						$.ajax({
							url:"../sanghyun2/sagi.jsp"
							,success:function(data){
								$("#test").html(data);
								$("#ap_reporter").val("<%=ap_reporter%>");
								$("#ap_dname").val("<%=ap_dname%>");
								$("#ap_prosessingdate").val("<%=ap_prosessingdate%>");
								$("#ap_content").val("<%=ap_content%>");
								$("#ap_contact").val("<%=ap_contact%>");
								$("#ap_year").val("<%=ap_appdate_1%>");
								$("#ap_month").val("<%=ap_appdate_2%>");
								$("#ap_today").val("<%=ap_appdate_3%>");
								$("#ap_namein").val("<%=ap_reporter%>"); 
							}
						})
					});	
				}
			</script> 
			<!--	페이지 나누기 끝	  -->
		
<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header ">
     		 받은 결재
          <button type="button"  class="close" data-dismiss="modal">&times;</button>	
        </div>
        <div class="modal-body">
	        <br>
	      	승인 하시겠습니까?
	        <br>
	        <br>
        </div>
        <div class="modal-footer">
          <button type="button" name = "workAgree" onclick="approval()" class="btn btn-info" data-dismiss="modal">승인</button> <!--  승인 버튼  -->
          <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
        </div>
      </div>
    </div>
</div>  
  <!-- 기각 모달 -->
  <div class="modal fade" id="myModal1" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
     		  <h5>기각 하시겠습니까?</h5>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        <div class="modal-body">
		<h6>기각사유</h6>
		<form id="f_gigag">
		<div class="row">
		<div class="col-12" style="margin-top:12px;">
		 <textarea id="text_gigag" name="ap_reason" class="form-control" style="width:100%;"id="exampleFormControlTextarea1" rows="10"></textarea>
		 <br>
		 <br>
		</div>
        </div>
        <input name="ap_no" type="hidden" value=<%=ap_no%> />
        </form>
        <div class="modal-footer">
          <!--  기각 버튼  -->
          <button type="button" onclick="dismissal()" class="btn btn-info " data-dismiss="modal">기각</button>	 
          <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
        </div>
      </div>
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

	
<!-- 탑메뉴 사용 -->
<script src="../common/js/topNav.js"></script>
<!-- 사이드 메뉴 사용 -->
<script src="../common//js/sideNav.js"></script>
<script src="../common/scripts.js"></script>
<!-- 버거 메뉴 활성화 -->
</body>
</html>