<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<link href="https://unpkg.com/bootstrap-table@1.16.0/dist/bootstrap-table.min.css" rel="stylesheet">
<script src="https://unpkg.com/bootstrap-table@1.16.0/dist/bootstrap-table.min.js"></script>
<<script type="text/javascript">

</script>

 <div id="toolbar">
  <div class="form-inline" role="form">
    <div class="form-group">
      <span>Offset: </span>
      <input name="offset" class="form-control w70" type="number" value="0">
    </div>
    <div class="form-group">
      <span>Limit: </span>
      <input name="limit" class="form-control w70" type="number" value="5">
    </div>
    <div class="form-group">
      <input name="search" class="form-control" type="text" placeholder="Search">
    </div>
    <button id="ok" type="submit" class="btn btn-primary">OK</button>
  </div>
</div>

<div id="frame_div" style="border: 1px solid black;">
   <div id="page_title" style="border: 1px solid red; margin: 10px 10px;"><h2>내 결재함</h2></div>
   <div id="page_contents" style="border: 1px solid yellow; margin: 10px 10px;">
   	 
	<div class="table-responsive">	<!-- 결재양식 테이블 시작 -->
               <table  
               	id="testTable"
               	id="table"
  				data-toggle="table"
  				data-height="750"
  				data-search="true"
  				data-show-columns="true"
 				data-method="get"
  				data-pagination="true"
   	            data-url="member.json">
                    <thead class="thead-light">
                        <tr>
                            <th data-field="app_no">번호</th>
                            <th data-field="app_name">제목</th>
                            <th data-field="app_write">작성</th>
                            <th data-field="app_print">인쇄</th>
                            <th data-field="operate" data-formatter="operateFormatter" data-events="operateEvents" width="300">Item Price</th>
                            <th data-field="operate" data-formatter="operateFormatter" data-events="operateEvents" width="300">Item Price</th>
                        </tr>
                    </thead>
                </table>
             </div>	 	<!-- 결재양식 테이블 끝 -->
             
        </div>
	<script>
	 var $table = $('#table')

	  function operateFormatter(value, row) {
	    return [
	      '<a class="button" href="javascript:void(0)" title="button">',
	      '<button style="font-size:15px">사원조회</button>',
	      '</a>  ',
	    ].join('')
	  }

	  window.operateEvents = {
	    'click .button': function (e, value, row, index) {
	      alert('You click like action, row: ' + JSON.stringify(row))
	    }
	  }
</script>

