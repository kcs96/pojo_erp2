<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!--*****************************************************************-->
    <link rel="stylesheet" href="./org/jquery.jOrgChart.css"/>
    <link rel="stylesheet" href="./org/custom.css"/>
    <!-- jQuery includes -->
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/jquery-ui.min.js"></script>
    <script src="jquery.jOrgChart.js"></script>
<!--*****************************************************************  -->
<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->  
<!--관리자 로그에 필요한 코드 시작=================================================================================-->
<link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"
  	  rel="stylesheet" crossorigin="anonymous" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js" crossorigin="anonymous" ></script>
<link href="../common/main.css" rel="stylesheet" />
<link href="../common/css/custom.css" rel="stylesheet" />
<!--관리자 로그에 필요한 코드 끝   =================================================================================-->
<%
	String json = (String)request.getAttribute("imsi");
%>
	<script type="text/javascript">
	var empList = <%= json %>;
	var result =JSON.stringify(empList);
	var jsonDoc = JSON.parse(result);
	</script>
	
	<script>
    jQuery(document).ready(function() {
        $("#org").jOrgChart({
            chartElement : '#chart'
        });
    });
    </script>
	<title>2RP PROGRAM</title>
	<script type="text/javascript">

		function abc(pos,name){
			$("#approveModal").modal({
			     show:true
			});
			
		 	for(var i=0;i<jsonDoc.length;i++){
				if(jsonDoc[i].EMP_POSITION==pos && jsonDoc[i].EMP_NAME==name){
					$("#emp_no").text(jsonDoc[i].EMP_NO);
					$("#emp_name").text(jsonDoc[i].EMP_NAME);
					$("#dept_name").text(jsonDoc[i].DEPT_NAME);
					$("#emp_hiredate").text(jsonDoc[i].EMP_HIREDATE);
					$("#emp_position").text(jsonDoc[i].EMP_POSITION);
					$("#emp_state").text(jsonDoc[i].EMP_STATE);
					$("#emp_gender").text(jsonDoc[i].EMP_GENDER);
					$("#emp_extend").text(jsonDoc[i].EMP_EXTEND);
					$("#emp_phone").text(jsonDoc[i].EMP_PHONE);
					$("#emp_email").text(jsonDoc[i].EMP_EMAIL);
					return;
				}else{
					$("#emp_no").text('공석');
					$("#emp_name").text('공석');
					$("#dept_name").text('공석');
					$("#emp_hiredate").text('공석');
					$("#emp_position").text('공석');
					$("#emp_state").text('공석');
					$("#emp_gender").text('공석');
					$("#emp_extend").text('공석');
					$("#emp_phone").text('공석');
					$("#emp_email").text('공석');
					$("#emp_email").text('공석');
				}
			} 
			
		}
		
		function dfg() {
			$("#approveModal").modal("hide");
		}
		
		
		function deptOpen(jsonDoc){
			$("#deptModal").modal({
			     show:true
			});
			$("#emp_no").text(jsonDoc.EMP_NO);
			$("#emp_name").text(jsonDoc.EMP_NAME);
			$("#dept_name").text(jsonDoc.DEPT_NAME);
			$("#emp_hiredate").text(jsonDoc.EMP_HIREDATE);
			$("#emp_position").text(jsonDoc.EMP_POSITION);
			$("#emp_state").text(jsonDoc.EMP_STATE);
			$("#emp_gender").text(jsonDoc.EMP_GENDER);
			$("#emp_extend").text(jsonDoc.EMP_EXTEND);
			$("#emp_phone").text(jsonDoc.EMP_PHONE);
			$("#emp_email").text(jsonDoc.EMP_EMAIL);
		}
		function deptClose() {
			$("#deptModal").modal("hide");
		}
		
	</script>
</head>

<body class="sb-nav-fixed">
<nav id="topNav"></nav>
<div id="layoutSidenav">
   <div id="layoutSidenav_nav"></div>
   <div id="layoutSidenav_content">
   	  <main id="input_div">
	  <div id="page_title" style="border-bottom: 2px solid gray; margin: 10px 30px;"><h2>회사 조직도</h2></div>
					<!-- 조직도 테이블 시작 -->
        <div class="container" style="margin-bottom:35px"></div>              
    <ul id="org" style="display:none">
    <li>
   	  <div style="box-shadow: 3px 3px 6px #adadad; border-radius: 8px;  width: 150px;  height: 70px; margin-left:-15px;" data-toggle="modal" data-target="#apporve" onmouseover="abc('회사대표','이민규')">
       <div style="background:orange; width: 150px;  height: 35px; border-radius: 8px; color:#ffffff; position: relative;"><b>대표</b></div> 
       <div style="background:white; z-index: 10;width: 150px;  height: 35px; position: relative; top: -10px; display:table-cell;vertical-align:middle;"><b>이민규</b></div> 
	</div>       
       <ul>
        <li>
   		 <div style="box-shadow: 3px 3px 6px #adadad; border-radius: 8px;  width: 150px;  height: 85px;  margin-left:-15px;">
   		     <div style="background:orange; width: 150px;  height: 35px; border-radius: 8px; color:#ffffff; position: relative;"></div> 
      		 <div style="background:white; z-index: 10;width: 150px;  height: 50px; position: relative; top: -20px; display: table-cell;vertical-align: bottom;"><img style="opacity: 0.7;" src="test1.png"/><br><b>인사부</b></div> 
		 </div> 
         	<ul>
         		<li>  
         		 <div style="box-shadow: 3px 3px 6px #adadad; border-radius: 8px;  width: 100px;  height: 70px; margin-left:10px;" data-toggle="modal" data-target="#apporve" onmouseover="abc('인사부장','수정되요')" >
      			 <div style="background: #2F9D27; width: 100px;  height: 35px; border-radius: 8px; color:#ffffff; position: relative;"><b>인사부서장</b></div> 
      			 <div style="background:white; z-index: 10;width: 100px;  height: 35px; position: relative; top: -10px; display: table-cell;vertical-align: middle;"><b>김미현</b></div> 
				   </div>  
         	<ul>
         		<li>
         			<div style="box-shadow: 3px 3px 6px #adadad; border-radius: 8px;  width: 100px;  height: 70px; margin-left:10px;" data-toggle="modal" data-target="#apporve" onmouseover="abc('인사1팀장','금동진')" >
      			 		 <div style="background: #997000; width: 100px;  height: 35px; border-radius: 8px; color:#ffffff; position: relative;"><b>인사1팀장</b></div> 
      					 <div style="background:white; z-index: 10;width: 100px;  height: 35px; position: relative; top: -10px; display: table-cell;vertical-align: middle;"><b>금동진</b></div> 
      		 		</div>
         	<ul>
         			<li> 
         				<div style="box-shadow: 3px 3px 6px #adadad; border-radius: 8px;  width: 100px;  height: 75px; margin-left:10px;" onmouseover="abc('인사1팀사원','손오공')">
      		 				 <div style="background:#F2CB61; width: 100px;  height: 35px; border-radius: 8px; color:#ffffff; position: relative;"></div> 
      			  		     <div style="background:white; z-index: 10; width: 100px;  height: 40px; position: relative; top: -20px; display: table-cell;vertical-align: bottom;"><b>인사1팀사원</b><p>손오공</p></div> 
      		 			</div>  
         			</li>
         			<li>
         				<div style="box-shadow: 3px 3px 6px #adadad; border-radius: 8px;  width: 100px;  height: 75px;  margin-left:10px;" onmouseover="abc('인사1팀사원','박진우')">
      		 				 <div style="background:#F2CB61; width: 100px;  height: 35px; border-radius: 8px; color:#ffffff; position: relative;"></div> 
      			  		     <div style="background:white; z-index: 10; width: 100px;  height: 40px; position: relative; top: -20px; display: table-cell;vertical-align: bottom;"><b>인사1팀사원</b><p>박진우</p></div> 
      		 			</div>  
         			</li>
         	</ul>
         	</li>
         	<li>
         			<div style="box-shadow: 3px 3px 6px #adadad; border-radius: 8px;  width: 100px;  height: 70px; margin-left:10px;" data-toggle="modal" data-target="#apporve" onmouseover="abc('인사2팀장','염수윤')" >
      			 		 <div style="background: #997000; width: 100px;  height: 35px; border-radius: 8px; color:#ffffff; position: relative;"><b>인사2팀장</b></div> 
      					 <div style="background:white; z-index: 10;width: 100px;  height: 35px; position: relative; top: -10px; display: table-cell;vertical-align: middle;"><b>염수윤</b></div> 
      		 		</div>
         		<ul>
         		<li>
         				 <div style="box-shadow: 3px 3px 6px #adadad; border-radius: 8px;  width: 100px;  height: 75px;  margin-left:10px;" onmouseover="abc('인사2팀사원','박창수')">
      		 				 <div style="background:#F2CB61; width: 100px;  height: 35px; border-radius: 8px; color:#ffffff; position: relative;"></div> 
      			  		     <div style="background:white; z-index: 10; width: 100px;  height: 40px; position: relative; top: -20px; display: table-cell;vertical-align: bottom;"><b>인사2팀사원</b><p>박창수</p></div> 
      		 			</div>  
         			</li>
         			<li>
         				<div style="box-shadow: 3px 3px 6px #adadad; border-radius: 8px;  width: 100px;  height: 75px;  margin-left:10px;" onmouseover="abc('인사2팀사원','이영뜸')">
      		 				 <div style="background:#F2CB61; width: 100px;  height: 35px; border-radius: 8px; color:#ffffff; position: relative;"></div> 
      			  		     <div style="background:white; z-index: 10; width: 100px;  height: 40px; position: relative; top: -20px; display: table-cell;vertical-align: bottom;"><b>인사2팀사원</b><p>이영뜸</p></div> 
      		 			</div>  
         			</li>
         		</ul>
         	</li>
         	</ul>
         	</li>
         	</ul>
         </li>
         <!--인사부 끝  -->
        <li>
        	<div style="box-shadow: 3px 3px 6px #adadad; border-radius: 8px;  width: 150px;  height: 85px;  margin-left:-15px;">
   		     	<div style="background:orange; width: 150px;  height: 35px; border-radius: 8px; color:#ffffff; position: relative;"></div> 
      		 	<div style="background:white; z-index: 10;width: 150px;  height: 50px; position: relative; top: -20px; display: table-cell;vertical-align: bottom;"><img style="opacity: 0.7;" src="test2-1.png"/><br><b>개발부</b></div> 
		 	</div> 
         	<ul>
         	<li>
         		 <div style="box-shadow: 3px 3px 6px #adadad; border-radius: 8px;  width: 100px;  height: 70px; margin-left:10px;" data-toggle="modal" data-target="#apporve" onmouseover="abc('개발부장','김충식')" >
      			 <div style="background: #2F9D27; width: 100px;  height: 35px; border-radius: 8px; color:#ffffff; position: relative;"><b>개발부서장</b></div> 
      			 <div style="background:white; z-index: 10;width: 100px;  height: 35px; position: relative; top: -10px;display: table-cell;vertical-align: middle;"><b>김충식</b></div> 
      		 	</div>
         	<ul>
         	<li>
         		  	<div style="box-shadow: 3px 3px 6px #adadad; border-radius: 8px;  width: 100px;  height: 70px; margin-left:10px;" data-toggle="modal" data-target="#apporve" onmouseover="abc('프론트1팀장','이상현')" >
      			 		 <div style="background: #997000; width: 100px;  height: 35px; border-radius: 8px; color:#ffffff; position: relative;"><b>프론트팀장</b></div> 
      					 <div style="background:white; z-index: 10;width: 100px;  height: 35px; position: relative; top: -10px; display: table-cell;vertical-align: middle;"><b>이상현</b></div> 
      		 		</div>
         		<ul>
         			<li>
         				 <div style="box-shadow: 3px 3px 6px #adadad; border-radius: 8px;  width: 100px;  height: 75px;  margin-left:10px;" onmouseover="abc('프론트1팀사원','마동석')">
      		 				 <div style="background:#F2CB61; width: 100px;  height: 35px; border-radius: 8px; color:#ffffff; position: relative;"></div> 
      			  		     <div style="background:white; z-index: 10; width: 100px;  height: 40px; position: relative; top: -20px; display: table-cell;vertical-align: bottom;"><b>프론트사원</b><p>마동석</p></div> 
      		 			</div>  
         			</li>
         			<li>
         				<div style="box-shadow: 3px 3px 6px #adadad; border-radius: 8px;  width: 100px;  height: 75px;  margin-left:10px;" onmouseover="abc('프론트2팀사원','유아인')">
      		 				 <div style="background:#F2CB61; width: 100px;  height: 35px; border-radius: 8px; color:#ffffff; position: relative;"></div> 
      			  		     <div style="background:white; z-index: 10; width: 100px;  height: 40px; position: relative; top: -20px; display: table-cell;vertical-align: bottom;"><b>프론트사원</b><p>유아인</p></div> 
      		 			</div>  
         			</li>
         		</ul>
         	</li>
         	<li>
         			<div style="box-shadow: 3px 3px 6px #adadad; border-radius: 8px;  width: 100px;  height: 70px; margin-left:10px;" data-toggle="modal" data-target="#apporve" onmouseover="abc('백엔드1팀장','이진아')" >
      			 		 <div style="background: #997000; width: 100px;  height: 35px; border-radius: 8px; color:#ffffff; position: relative;"><b>백엔드팀장</b></div> 
      					 <div style="background:white; z-index: 10;width: 100px;  height: 35px; position: relative; top: -10px; display: table-cell;vertical-align: middle;"><b>이진아</b></div> 
      		 		</div>
         		<ul>
         			<li>
         				 <div style="box-shadow: 3px 3px 6px #adadad; border-radius: 8px;  width: 100px;  height: 75px;  margin-left:10px;" onmouseover="abc('백엔드1팀사원','김정철')">
      		 				 <div style="background:#F2CB61; width: 100px;  height: 35px; border-radius: 8px; color:#ffffff; position: relative;"></div> 
      			  		     <div style="background:white; z-index: 10; width: 100px;  height: 40px; position: relative; top: -20px; display: table-cell;vertical-align: bottom;"><b>백엔드사원</b><p>김정철</p></div> 
      		 			</div>  
         			</li>
         			<li>
         				 <div style="box-shadow: 3px 3px 6px #adadad; border-radius: 8px;  width: 100px;  height: 75px;  margin-left:10px;" onmouseover="abc('백엔드1팀사원','도준혁')">
      		 				 <div style="background:#F2CB61; width: 100px;  height: 35px; border-radius: 8px; color:#ffffff; position: relative;"></div> 
      			  		     <div style="background:white; z-index: 10; width: 100px;  height: 40px; position: relative; top: -20px; display: table-cell;vertical-align: bottom;"><b>백엔드사원</b><p>도준혁</p></div> 
      		 			</div>  
         			</li>
         		</ul>
         	</li>
         	</ul>
         	</li>
         	</ul>
         </li>
         <!-- 개발부 끝 -->
         <li>
    		<div style="box-shadow: 3px 3px 6px #adadad; border-radius: 8px;  width: 150px;  height: 85px;  margin-left:-15px;">
   		     	<div style="background:orange; width: 150px;  height: 35px; border-radius: 8px; color:#ffffff; position: relative;"></div> 
      		 	<div style="background:white; z-index: 10;width: 150px;  height: 50px; position: relative; top: -20px; display: table-cell;vertical-align: bottom;"><img style="opacity: 0.5;" src="test3.png"/><br><b>품질관리부</b></div> 
		 	</div>   
         	<ul>
         	<li>
         		 <div style="box-shadow: 3px 3px 6px #adadad; border-radius: 8px;  width: 100px;  height: 70px; margin-left:10px;" data-toggle="modal" data-target="#apporve" onmouseover="abc('품질관리부장','남이준')" >
      			 <div style="background: #2F9D27; width: 100px;  height: 35px; border-radius: 8px; color:#ffffff; position: relative;"><b>품질부서장</b></div> 
      			 <div style="background:white; z-index: 10;width: 100px;  height: 35px; position: relative; top: -10px; display: table-cell;vertical-align: middle;"><b>남이준</b></div> 
      		 	</div>
         	<ul>
         	<li>
         		<div style="box-shadow: 3px 3px 6px #adadad; border-radius: 8px;  width: 100px;  height: 70px; margin-left:10px;" data-toggle="modal" data-target="#apporve" onmouseover="abc('품질관리팀장','도준오')" >
      			 		 <div style="background: #997000; width: 100px;  height: 35px; border-radius: 8px; color:#ffffff; position: relative;"><b>품질1팀장</b></div> 
      					 <div style="background:white; z-index: 10;width: 100px;  height: 35px; position: relative; top: -10px; display: table-cell;vertical-align: middle;"><b>도준오</b></div> 
      		 		</div>
         		<ul>
         			<li>
         				  <div style="box-shadow: 3px 3px 6px #adadad; border-radius: 8px;  width: 100px;  height: 75px;  margin-left:10px;" onmouseover="abc('품질관리사원','감강찬')">
      		 				 <div style="background:#F2CB61; width: 100px;  height: 35px; border-radius: 8px; color:#ffffff; position: relative;"></div> 
      			  		     <div style="background:white; z-index: 10; width: 100px;  height: 40px; position: relative; top: -20px; display: table-cell;vertical-align: bottom; "><b>품질1팀사원</b><p>감강찬</p></div> 
      		 			</div>  
         			</li>
         			<li> 
         				 <div style="box-shadow: 3px 3px 6px #adadad; border-radius: 8px;  width: 100px;  height: 75px;  margin-left:10px;" onmouseover="abc('품질관리사원','유준호')">
      		 				 <div style="background:#F2CB61; width: 100px;  height: 35px; border-radius: 8px; color:#ffffff; position: relative;"></div> 
      			  		     <div style="background:white; z-index: 10; width: 100px;  height: 40px; position: relative; top: -20px; display: table-cell;vertical-align: bottom;"><b>품질1팀사원</b><p>유준호</p></div> 
      		 			</div>  
         			</li>
         		</ul>
         	</li>
         	<li>
         			<div style="box-shadow: 3px 3px 6px #adadad; border-radius: 8px;  width: 100px;  height: 70px; margin-left:10px;" data-toggle="modal" data-target="#apporve" onmouseover="abc('','')" >
      			 		 <div style="background: #997000; width: 100px;  height: 35px; border-radius: 8px; color:#ffffff; position: relative;"><b>품질2팀장</b></div> 
      					 <div style="background:white; z-index: 10;width: 100px;  height: 35px; position: relative; top: -10px; display: table-cell;vertical-align: middle;"><b>공석</b></div> 
      		 		</div>
         		<ul>
         			<li>
         				 <div style="box-shadow: 3px 3px 6px #adadad; border-radius: 8px;  width: 100px;  height: 75px;  margin-left:10px;" onmouseover="abc('','')">
      		 				 <div style="background:#F2CB61; width: 100px;  height: 35px; border-radius: 8px; color:#ffffff; position: relative;"></div> 
      			  		     <div style="background:white; z-index: 10; width: 100px;  height: 40px; position: relative; top: -20px; display: table-cell;vertical-align: bottom;"><b>품질2팀사원</b><p>공석</p></div> 
      		 			</div>  
         			</li>
         			<li>
         				 <div style="box-shadow: 3px 3px 6px #adadad; border-radius: 8px;  width: 100px;  height: 75px;  margin-left:10px;" onmouseover="abc('','')">
      		 				 <div style="background:#F2CB61; width: 100px;  height: 35px; border-radius: 8px; color:#ffffff; position: relative;"></div> 
      			  		     <div style="background:white; z-index: 10; width: 100px;  height: 40px; position: relative; top: -20px; display: table-cell;vertical-align: bottom;"><b>품질2팀사원</b><p>공석</p></div> 
      		 			</div>  
         			</li>
         		</ul>
         	</li>
         	</ul>
         	</li>
         	</ul>
         </li>
         <!-- 품질관리부 끝  -->
       </ul>
     </li>
   </ul>      
    <div id="chart" class="orgChart"></div>
					<!-- 조직도 테이블 끝 -->
					<!-- 컨텐츠 들어갈내용 끝   -->
	
	<div class="modal fade" id="approveModal" role="dialog" onmouseout="dfg()">
         <div class="modal-dialog">
            Modal content
            <div class="modal-content">
               <div class="modal-header">
           		 사원 상세 정보
                  <button type="button" class="close" data-dismiss="modal">&times;</button>
               </div>
               		<div class="modal-body">
               <table>
               	<tr>
               <td>
               	   		<img src="test.gif" style="width:130px; height:150px;" id="emp_photo"/>
               </td>
               <td>	<div>
                 &nbsp;&nbsp; <span> <b>사원명 |</b></span> <span id="emp_name"></span>&nbsp;&nbsp;&nbsp;&nbsp;
                  <span><b>입사일 |</b></span> <span id="emp_hiredate"></span><br><br>
                 &nbsp;&nbsp; <span><b>부서명 | </b></span> <span id="dept_name"></span>&nbsp;&nbsp;&nbsp;&nbsp;
                  <span><b>직&nbsp;&nbsp;&nbsp;책 |</b></span> <span id="emp_position" style="font-size:15px"></span><br>
                 </div></td>
               </tr>
              
                </table>
               </div>
               <table class="table table-boardered">
				 <tr>
                 	<td align="right" width="130px"><b>사원번호 |</b></td> <td><span id="emp_no"></span></td>
                 </tr>
                 <tr>
                    <td align="right"><b>상태 |</b></td> <td> <span id="emp_state" ></span> </td>
                 </tr>
                 <tr>
                 	<td align="right"><b>성별 |</b></td> <td><span id="emp_gender"></span></td>
                 </tr>
                 <tr>
                 	 <td align="right"><b>이메일 |</b></td> <td> <span id="emp_email"></span></td>
                 </tr>
                 <tr>
                 	 <td align="right"><b>내선번호 |</b></td> <td><span id="emp_extend"></span></td>
                 </tr>
                 <tr>
                 	 <td align="right"><b>이동번호 |</b></td> <td><span id="emp_phone"></span></td>
                 </tr>
                  </table>
               <div class="modal-footer">
                  <button id="btn_close" type="button" class="btn btn-secondary " data-dismiss="modal">닫기</button>
               </div>
            </div>
         </div>
      </div>
      
      
		</main>
	</div>
</div>
<!-- 슬라이드바 사용할때 필요 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="https://unpkg.com/bootstrap-table@1.16.0/dist/bootstrap-table.min.js"></script>
    <script>
        jQuery(document).ready(function() {
            
            /* Custom jQuery for the example */
            $("#show-list").click(function(e){
                e.preventDefault();
                
                $('#list-html').toggle('fast', function(){
                    if($(this).is(':visible')){
                        $('#show-list').text('Hide underlying list.');
                        $(".topbar").fadeTo('fast',0.9);
                    }else{
                        $('#show-list').text('Show underlying list.');
                        $(".topbar").fadeTo('fast',1);                  
                    }
                });
            });
            
            $('#list-html').text($('#org').html());
            
            $("#org").bind("DOMSubtreeModified", function() {
                $('#list-html').text('');
                $('#list-html').text($('#org').html());
                prettyPrint();                
            });
        });
    </script>
<!-- 탑메뉴 사용 -->
<script src="../common/js/topNav.js"></script>
<!-- 사이드 메뉴 사용 -->
<script src="../common/js/sideNav.js"></script>
<!-- 버거 메뉴 활성화 -->
<script src="../common/scripts.js"></script>
</body>
</html>
