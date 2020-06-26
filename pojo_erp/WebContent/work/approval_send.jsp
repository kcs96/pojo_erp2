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
<link
	href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"
	rel="stylesheet" crossorigin="anonymous" />
<link rel="stylesheet"
	href="https://unpkg.com/bootstrap-table@1.16.0/dist/bootstrap-table.min.css" />
<link href="../common/main.css" rel="stylesheet" />
<link href="../common/css/custom.css" rel="stylesheet" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js"
	crossorigin="anonymous"></script>
<!--관리자 로그에 필요한 코드 끝   =================================================================================-->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.9.1.min.js"></script>

<title>2RP PROGRAM</title>
<script type="text/javascript">
	function test(res) {
		var imsi = res;
		var url;
		alert("res:" + imsi);
		if (res == "휴가양식") {
			url = "../sanghyun2/huga.jsp"
		} else if (res == "업무보고서") {
			url = "../sanghyun2/upmo.jsp"
		} else if (res == "파견양식") {
			url = "../sanghyun2/paguns.jsp"
		} else if (res == "사직양식") {
			url = "sagi.jsp"
		}
		$.ajax({
			url : url,
			success : function(data) {
				$("#test").html(data);
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
					<div id="page_title" style="border-bottom: 2px solid gray; margin: 50px 30px;">
						<h2>결재신청</h2>
					</div>
					<div id="page_contents" style="border: 1px solid black; max-width: 1730px; margin: 10px 100px;">
						<!-- 컨텐츠 들어갈내용 시작-->

						<div class="row">
							<div class="col-1"></div>
							<div class="col-10">
								<table class="table table-bordered">
									<tbody>
										<tr>
											<th scope="row"
												style="background: #EAEAEA; text-align: center;">문서번호</th>
											<td>20112344</td>
											<th style="background: #EAEAEA; text-align: center;">직위


											
											</td>
											<td>사원</td>
											<th style="background: #EAEAEA; text-align: center;">보안


											
											</td>
											<td>일반</td>
										</tr>
										<tr>
											<th scope="row"
												style="background: #EAEAEA; text-align: center;">작성자</th>
											<td>이상현</td>
											<th style="background: #EAEAEA; text-align: center;">작성일자


											
											</td>
											<td>2020-06-21</td>
											<th style="background: #EAEAEA; text-align: center;">보존기간


											
											</td>
											<td>1년</td>
										</tr>
										<!-- <tr>
		      <th scope="row">3</th>
		      <td >Larry the Bird</td>
		      <td>@twitter</td>
		    </tr> -->
									</tbody>
								</table>
							</div>
						</div>
						<div class="row">
							<div class="col-1"></div>
							<div class="col-10">
								<table class="table table-bordered">
									<tbody>
										<th scope="row"
											style="width: 200px; padding: 1px; padding-top: 14px; background: #EAEAEA; text-align: center;">제목</th>
										<td colspan="6">
										<input
											style="width: 100%; height: 100%; border: 0px;" type="text"
											class="form-control" id="exampleInputEmail1"
											placeholder="제목을 입력하세요."></td>
										</tr>
										<!-- 결재자 -->
										<tr>
											<th scope="row"
												style="padding-right: 10px; padding-top: 14px; background: #EAEAEA; text-align: center;">
												결재자</th>
											<th style="width: 100px;">
												<button style="margin-left: 40px;" class="btn btn-info "
													data-toggle="modal" data-target="#apporve">결재자</button>
											</th>
											<td style="width: 250px;" id="rank1">[회사]이길동 사장</td>
											<td style="width: 250px;" id="rank2">[인사부]홍길동 팀장</td>
											<td style="width: 250px;" id="rank3">[영업부]올챙이 부장</td>
											<td style="width: 250px;" id="rank4">[인사부]두꺼비 부장</td>
										</tr>
										<tr>
											<th scope="row"
												style="background: #EAEAEA; text-align: center;">결재양식</th>
											<td><select id="i_form" style="margin-left: 25px;">
													<option value="업무보고서">업무보고서</option>
													<option value="휴가양식">휴가양식</option>
													<option value="사직양식">사직양식</option>
													<option value="파견양식">파견양식</option>
											</select> <script type="text/javascript">
												//카테고리가 변할때마다 선택된 값을 test함수에 파라미터로 넘긴다.
												$("#i_form")
														.change(
																function() {
																	//each문은 for문과 비슷하게 생각하면 된다.
																	//선택된 텍스트 값을 p_zdo에 저장해 보자.
																	$(
																			"#i_form option:selected")
																			.each(
																					function() {
																						var res = $(
																								this)
																								.text();//var값을 집어넣으려면 val에다가 넣어야한다. 
																						//alert("res:" +res);
																						test(res);// ajax

																					});
																});
											</script></td>
											<th style="background: #EAEAEA; text-align: center;">기한</th>
											<td colspan="3"><select>
													<option selected>1일</option>
													<option>3일</option>
													<option>5일</option>
													<option>7일</option>
													<option>15일</option>
													<option>30일</option>
											</select></td>

										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<hr style="border: solid 1px black;">
						<!--***************************양식 뿌려주기  ******************************-->
						<div class="row">
							<div class="col-1"></div>
							<div style="border: 2px solid black; padding-top: 10px;" class="col-9">
								<button style="float: right;"
									type="button" class="btn btn-info">인쇄</button>
								<!-- *****밑에 승인취소버튼 -->
								<div id="test"></div>
								<div class="row">
									<div class="col-5"></div>
									<div class="col-5" style="align-content: center;">
										<button
											type="button" class="btn btn-info btn-lg"
											data-toggle="modal" data-target="#approveModal">승인</button>

										<button type="button" class="btn btn-info btn-lg"
											data-toggle="modal"  data-target="#cancle">취소</button>
										<br> <br>
									</div>
								</div>

							</div>
						</div>
					</div>

					<!--****************************신청 취소**************************************  -->
					<div class="col-1"></div>
					<!-- 	<!-- 이전꺼 보여주는 거 
	<div class="row">
	<div class="col-1"></div>
	<div class="col-10"></div>
	</div>
	<div class="col-1"></div> -->
				</div>
		</div>
		<!-- **********************승인 취소 모달 ********************************** -->
		<!-- ***************************승인 모달********************************* -->
		<div class="modal fade" id="approveModal" role="dialog">
			<div class="modal-dialog">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						받은 결재
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body">
						<br> 승인요청 하시겠습니까? <br> <br>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-info"
							data-dismiss="modal">확인</button>
						<button type="button" class="btn btn-secondary " data-dismiss="modal">닫기</button>
					</div>
				</div>
			</div>
		</div>
		<!-- ***************************승인 모달 끝********************************* -->
		<!-- ***********************************취소모달***************** ******************-->
		<div class="modal fade" id="cancle" role="dialog">
			<div class="modal-dialog">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						결재 신청
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body">
						<br> 취소 하시겠습니까? <br> <br>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-info"
							data-dismiss="modal">확인</button>
						<button type="button" class="btn btn-secondary " data-dismiss="modal">닫기</button>
					</div>
				</div>
			</div>
		</div>
		<!-- ***********************************취소모달 끝***************** ******************-->
		<!-- **********************승인 취소 모달 끝 ********************************** -->

		<script type="text/javascript">
			$(document).ready(function() {
				$.ajax({
					url : "../sanghyun2/upmo.jsp",
					success : function(data) {
						$("#test").html(data);
					}
				});
			});
		</script>
		<!--결재자모달  -->
		<div class="modal fade" id="apporve" role="dialog">
			<div class="modal-dialog modal-lg" style="height: 400px;">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						받은 결재
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body">
						<div id="frame_div" style="border: 1px solid black;">
							<div id="page_title"
								style="border: 1px solid red; margin: 20px 10px;">
								<h2>결재자</h2>
							</div>
							<div id="page_contents"
								style="border: 1px solid yellow; margin: 10px 10px;">
								<div class="toolbar">
									<button id="addrev" class="btn btn-success"
										data-dismiss="modal">확인</button>
									<button id="canclerev" class="btn btn-danger" data-dismiss="modal">취소</button>
								</div>
								<!-- ========================= 휴지통 테이블 ========================== -->
								<table id="table" data-toolbar=".toolbar"
									data-show-columns="true" data-pagination="true"
									data-search="true" data-advanced-search="true"
									data-select-item-name="selectItemName"
									data-url="../sanghyun/member2.json">
									<thead>
										<tr>	
											<th data-field="state" data-checkbox="true"></th>
											<th data-field="app_no" data-sortable="true"
												data-align="center" data-width="10">사 원 번 호</th>
											<th data-field="app_name" data-sortable="true">사 원 이 름</th>
											<th data-field="app_write" data-sortable="true">사 원 부 서</th>
											<th data-field="app_print" data-align="center"
												data-sortable="true">직 급</th>
										</tr>
									</thead>
								</table>
								<!-- ======================== 휴지통 테이블 끝 ====================== -->
							</div>
						</div>
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
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"
		integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
	<script
		src="https://unpkg.com/bootstrap-table@1.16.0/dist/bootstrap-table.min.js"></script>


	<script>
		$(function() {
			$('#table').bootstrapTable()
		})

		/* ========================= 테이블 버튼 영역 =========================== */
		/* 테이블 버튼 생성  */
		function operateFormatter(value, row) {
			return [
					'<a class="button" href="javascript:void(0)" title="button">',
					'<button style="font-size:15px">확인</button>', '</a>  ', ]
					.join('')
		}
		/* 테이블버튼 생성  끝*/

		/* 테이블버튼 이벤트 생성 */
		window.operateEvents = {
			'click .button' : function(e, value, row, index) {
				alert('You click like action, row: ' + JSON.stringify(row))
				alert('You click like action, row: ' + JSON.stringify(index))
			}
		}
		/* 테이블버튼 이벤트 끝 */
		/* ======================= 테이블 버튼 영역 끝 ===================== */

		/* ======================== 취소 버튼 영역 ============================ */
		$(function() {
			$('#canclerev').click(function() {
				var index = []
				$('input[name="selectItemName"]:checked').each(function() {
					index.push($(this).data('index'))
				})
				alert('취소버튼 row index: ' + index.join(', '))
			})
		})
		/* ====================== 삭제 버튼 영역 끝 ============================ */

		/* ======================== 복구버튼 영역 =============================== */
		$(function() {
			$('#addrev').click(function() {
				var index = []
				$('input[name="selectItemName"]:checked').each(function() {
					index.push($(this).data('index'))
				})
				alert('확인버튼  row index: ' + index.join(', '))
			})
		})
		/* ======================= 복구 영역 =================================== */
	</script>


	<!-- 탑메뉴 사용 -->
	<script src="../common/js/topNav.js"></script>
	<!-- 사이드 메뉴 사용 -->
	<script src="../common//js/sideNav.js"></script>

	<script src="../common/scripts.js"></script>
	<!-- 버거 메뉴 활성화 -->
</body>
</html>