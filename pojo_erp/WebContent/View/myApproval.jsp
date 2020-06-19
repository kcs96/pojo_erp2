<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<link href="https://unpkg.com/bootstrap-table@1.16.0/dist/bootstrap-table.min.css" rel="stylesheet">
<script src="https://unpkg.com/bootstrap-table@1.16.0/dist/bootstrap-table.min.js"></script>
<<script type="text/javascript">

</script>
   
<div id="frame_div" style="border: 1px solid black;">
   <div id="page_title" style="border: 1px solid red; margin: 100px 30px;"><h2>내 결재함</h2></div>
   <div id="page_contents" style="border: 1px solid yellow; margin: 50px 30px;">
   	 
	<div class="table-responsive">	<!-- 결재양식 테이블 시작 -->
               <table id="testTable"
               		  id="table"
  				data-toggle="table"
  				data-height="650"
  				data-search="true"
  				data-show-columns="true"
 				data-method="get"
  				data-pagination="true"
   	            data-url="./member.json">
                    <thead class="thead-light">
                        <tr>
                            <th data-field="app_no">번호</th>
                            <th data-field="app_name">제목</th>
                            <th data-field="app_write">작성</th>
                            <th data-field="app_print">인쇄</th>
                        </tr>
                    </thead>
                </table>
             </div>	 	<!-- 결재양식 테이블 끝 -->
             
        </div>
	

