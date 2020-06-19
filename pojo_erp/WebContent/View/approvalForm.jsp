<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     
<link href="https://unpkg.com/bootstrap-table@1.16.0/dist/bootstrap-table.min.css" rel="stylesheet">
<script src="https://unpkg.com/bootstrap-table@1.16.0/dist/bootstrap-table.min.js"></script>
         
<div id="frame_div" style="border: 1px solid black;">
   <div id="page_title" style="border: 1px solid red; margin: 10px 30px;"><h2> 결재 양식 </h2></div>
  	 <div id="page_contents" style="border: 1px solid yellow; margin: 50px 50px;">
         
  <div class="table-responsive">
               <table id="testTable"
                     class="table table-hover"
                     data-toggle="table"
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
             </div>
             
        <div class="table-responsive;	margin: 10px 30px;">
               <table id="testTable"
                     class="table table-hover"
                     data-toggle="table"
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
             </div>
</div>
