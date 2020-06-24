package com.erp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;


public class WorkController implements Controller {
	
	String requestName = null; //Mapper에서 requestName을 받아옴.
	WorkLogic workLogic = null;
	Logger logger = Logger.getLogger(WorkController.class);
	public WorkController(String requestName) {
		//requestName을 파라미터로 받아서 전역변수로 넘겨줌.
		this.requestName = requestName;
		workLogic = new WorkLogic();
	}
	@Override
	public String process(String cud, HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String path = null;
		int result = 0;
		Map<String,Object> pMap = null;
		if(cud.equals("workAgree")) {///성공
			//결재 승인 insert here
			logger.info("Controller : 결재 승인 호출 성공");
			/////////////////////// 실제 코드    /////////////////////
			pMap = new HashMap<>();
			pMap.put("emp_no",session.getAttribute("emp_no"));
			pMap.put("ap_no",req.getParameter("ap_no"));
			String result_accept = workLogic.workAgree(pMap);
			if(result_accept.equals("1")) {path="redirect:xxx.jsp";}
			else {path="redirect:errorPage.jsp";}
			///////////////////////  테스트 코드   //////////////////////
			/*
			pMap = new HashMap<>();
			pMap.put("emp_no",10001);
			pMap.put("ap_no",14);
			String result_accept = workLogic.workAgree(pMap);
			System.out.println(result_accept);
			if(result_accept.equals("1")) {path="redirect:xxx.jsp";}
			else {path="redirect:errorPage.jsp";}
			*/
		}else if(cud.equals("workDeny")) { //완료
			//결재 기각 insert here
			logger.info("Controller : 결재 기각 호출 성공");
			/////////////////////// 실제 코드    /////////////////////
		    pMap = HashMapBuilder.hashMapBuilder(req.getParameterMap());
		    pMap.put("emp_no", session.getAttribute("emp_no"));
		    String result_deny = workLogic.workDeny(pMap);
			if(result_deny.equals("1")) {path="redirect:xxx.jsp?result=결재성공";}
			else if(result_deny.equals("결재가 마감된 문서입니다.")) {
				{path="redirect:xxx.jsp?result=결재가 마감된 문서입니다.";}
			}
			else {path="redirect:errorPage.jsp";}
		    ///////////////////////  테스트 코드   //////////////////////
		    /*
		    pMap = new HashMap<>();
			pMap.put("emp_no",10002);
			pMap.put("ap_no","14");
			pMap.put("ap_reason","기각사유입니다.");
			String result_deny = workLogic.workDeny(pMap);
			if(result_deny.equals("1")) {path="redirect:xxx.jsp?result=결재성공";}
			else if(result_deny.equals("결재가 마감된 문서입니다.")) {
				{path="redirect:xxx.jsp?result=결재가 마감된 문서입니다.";}
			}
			else {path="redirect:errorPage.jsp";}
			*/
		}else if(cud.equals("workSelectPerson")) { //성공
			//결재작성 수신자 추가 탭 insert here
			logger.info("Controller : 결재 신청 수신자 추가 호출 성공");
			List<Map<String,Object>> rlist = null;
		    pMap = new HashMap<>();
			rlist = workLogic.empList(pMap); //파라미터 없음
			System.out.println("rlist => "+rlist.size());
			req.setAttribute("empList", rlist);
			path = "forward:xxx.jsp";
		}else if(cud.equals("workAddSendDoc")) {    //성공
			//결재 신청 이벤트 탭 insert here
			logger.info("Controller : 결재 신청 호출 성공");
			/////////////////////// 실제 코드    /////////////////////
		    pMap = HashMapBuilder.hashMapBuilder(req.getParameterMap());
		    result = workLogic.workAddDoc(pMap);
		    if(result == 1) { 		                         //결제테이블에 등록이 성공했으면
		    String[] receiver = ((String)pMap.get("rev_empNo")).split(",");
			int count = 0;								     //성공시 증가
			for(int i=0; i<receiver.length;i++) {            //수신자 인원수만큼 반복
				pMap = new HashMap<>();                      //Map 초기화
				pMap.put("emp_no",receiver[i]);              //수신자 pk담기
				pMap.put("ap_no",req.getParameter("ap_no")); //수신될 문서번호 담기
				pMap.put("count",receiver.length);           //수신자수 담기
				String str_count = workLogic.workAddSendDoc(pMap);
				if(str_count.equals("1")) {count++;}
			}//end of for문
			if(count == receiver.length) {//만약 수신자수만큼 성공을했으면
				path="redirect:xxx.jsp";
			}
			else {path="redirect:errorPage.jsp";}
			}else {
				path="redirect:errorPage.jsp";
			}
			
			///////////////////////  테스트 코드   //////////////////////
			/*
			 			//결재테이블에 등록하기
			pMap.put("fr_no", 1);
		    pMap.put("ap_title", "[휴가]연차휴가 나갑니다.");
		    pMap.put("ap_state", "결재대기");
		    pMap.put("ap_reporter", "10001");
		    pMap.put("ap_appdate", "2020-06-20");
		    pMap.put("ap_closedate", "2020-06-21");
		    pMap.put("ap_content", "문서내용입니다");
		    pMap.put("ap_dname", "개발부");
		    pMap.put("ap_hiredate", "2011-06-05");
		    pMap.put("ap_phone", "010-1234-5678");
		    pMap.put("ap_prosessingdate", "2020-06-01 ~ 2020-06-05");
		    pMap.put("ap_instructions", "지시사항 내용입니다.");
		    pMap.put("ap_bego", "비고 내용입니다.");
		    pMap.put("ap_sign", "기각.png");
		    result = workLogic.workAddDoc(pMap);
		    System.out.println(result);
			 
			              //등록된 결제문서 수신자에게 뿌려주기
			String[] receiver = "10001,10002,20003".split(",");
			int count = 0;
			for(int i=0; i<receiver.length;i++) {
				pMap = new HashMap<>();
				pMap.put("emp_no",receiver[i]); //수신자 pk담기
				pMap.put("ap_no",14); //수신될 문서번호 담기
				pMap.put("count",receiver.length); //수신자수 담기
				String str_count = workLogic.workAddSendDoc(pMap);
				if(str_count.equals("1")) {
					count++;
				}
			}
			if(count == receiver.length) {//만약 수신자수만큼 성공을했으면
				path="redirect:xxx.jsp";
			}
			else {path="redirect:errorPage.jsp";}
			*/
			
		}else if(cud.equals("workSelectOverView")) {/////////////////////////쿼리문 없음
			//내결재함 오버뷰 insert here
			logger.info("Controller : 내결재함 오버뷰 호출 성공");
			List<Map<String,Object>> rlist = null;
		    pMap = new HashMap<>();
			pMap.put("empno",10001);
			rlist = workLogic.workSelectOverView(pMap);
			req.setAttribute("workSelectOverViewList", rlist);
			path = "forward:xxx.jsp";
			
		}else if(cud.equals("workSelectEmp")) { ////성공
			//정보수정 이벤트 탭 insert here
			logger.info("Controller : 인사 정보수정 이벤트 호출 성공");
			List<Map<String,Object>> rList = null;
			pMap = new HashMap<>(); 
			//pMap.put("emp_no", 10001); //테스트코드
			pMap.put("emp_no",session.getAttribute("emp_no")); //실제코드
			rList = workLogic.workSelectEmp(pMap);
			System.out.println("사원에 대한 정보 => "+rList.size());
			req.setAttribute("workEmpList", rList);
			path = "forward:xxx.jsp";
		}
		else if(cud.equals("workUpdEmp")) { //성공
			//정보수정 저장버튼 눌렀을 경우
			logger.info("Controller의 수정 저장버튼 눌렀을 경우");
			result = 0;
			/////////////////////// 실제 코드    /////////////////////
			pMap = HashMapBuilder.hashMapBuilder(req.getParameterMap());
			result = workLogic.workUpdEmp(pMap); 
			if(result==1) {path="redirect:xxx.jsp";}
			else {path="redirect:errorPage.jsp";}
			///////////////////////  테스트 코드   /////////////////////
			/*
			pMap = new HashMap<>(); 
			pMap.put("emp_no", 10008);
			pMap.put("emp_name", "사원명");
			pMap.put("emp_resnum", "960121-1023312");
			pMap.put("emp_photo", "test12.png");
			pMap.put("emp_pw", "1234");
			pMap.put("emp_phone", "010-1234-5678");
			pMap.put("emp_email", "test13@naver.com");
			pMap.put("emp_gender", "남");
			pMap.put("dept_no", 10);
			pMap.put("emp_extend", "466-4516");
			pMap.put("emp_position", "인사사원");
			pMap.put("emp_salary", 2900);
			pMap.put("emp_hiredate", "2020-01-01");
			pMap.put("emp_retiredate", "");
			pMap.put("emp_state", "재직");
			pMap.put("emp_address", "경기도 안양시 만안구 박달로121");
			pMap.put("emp_zipcode", "13525");
			pMap.put("emp_detailaddress", "떙떙이 아파트 100동 100호");
			pMap.put("emp_bank", "신한은행");
			pMap.put("emp_account", "110-45672-23544");
			result = workLogic.workUpdEmp(pMap); 
			if(result==1) {path="redirect:xxx.jsp";}
			else {path="redirect:errorPage.jsp";}
			*/
		}else if(cud.equals("workAddEmp")) {  ///성공
			//신규사원 등록 이벤트 탭. insert here - 
			logger.info("Controller : 신규사원 등록 호출 성공");
			/////////////////////// 실제 코드    /////////////////////
			 pMap = HashMapBuilder.hashMapBuilder(req.getParameterMap());
			 pMap.put("emp_no", session.getAttribute("emp_no"));
			 result =workLogic.workAddEmp(pMap);
			 if(result==1) {path="redirect:xxx.jsp";} 
			 else{path="redirect:errorPage.jsp";}
			///////////////////////  테스트 코드   /////////////////////
			/*
			pMap = new HashMap<>(); 
			pMap.put("emp_no", 10009);
			pMap.put("emp_name", "사원명");
			pMap.put("emp_resnum", "960121-1023312");
			pMap.put("emp_photo", "test12.png");
			pMap.put("emp_pw", "1234");
			pMap.put("emp_phone", "010-1234-5678");
			pMap.put("emp_email", "test13@naver.com");
			pMap.put("emp_gender", "남");
			pMap.put("dept_no", 10);
			pMap.put("emp_extend", "466-4516");
			pMap.put("emp_position", "인사사원");
			pMap.put("emp_salary", 2800);
			pMap.put("emp_hiredate", "2020-01-01");
			pMap.put("emp_retiredate", "");
			pMap.put("emp_state", "재직");
			pMap.put("emp_address", "경기도 안양시 만");
			pMap.put("emp_zipcode", "13525");
			pMap.put("emp_detailaddress", "떙떙이 아파트 100동");
			pMap.put("emp_bank", "신한은행");
			pMap.put("emp_account", "110-45672-23544");
			result = workLogic.workAddEmp(pMap);
			if(result==1) {path="redirect:xxx.jsp";}
			else {path="redirect:errorPage.jsp";}
			*/
		}else if(cud.equals("workUpdPw")) {    ///성공
			//인사탭 사원비밀번호 변경 insert here 
			String results = null;
			logger.info("Controller : 재직사원 비밀번호 변경 호출 성공");
			/////////////////////// 실제 코드    /////////////////////
			pMap = HashMapBuilder.hashMapBuilder(req.getParameterMap());
			results = workLogic.workUpdPw(pMap);
			if(result==1) {path="redirect:xxx.jsp";}
			else {path="redirect:errorPage.jsp";}
			
			///////////////////////  테스트 코드   /////////////////////
			/*
			pMap = new HashMap<>(); 
			pMap.put("U_IN_PW", "1234");
			pMap.put("U_IN_RPW", "123");
			results = workLogic.workUpdPw(pMap);
			if(result==1) {path="redirect:xxx.jsp";}
			else {path="redirect:errorPage.jsp";}
			*/
		}else if(cud.equals("workDelBranch")) {      ///성공
			//지사 삭제 insert here
			logger.info("Controller : 지사 삭제 호출 성공");
			String results = null;
			pMap = HashMapBuilder.hashMapBuilder(req.getParameterMap());
			pMap.put("U_INPUT","예");
			pMap.put("U_NUM","9");
			results = workLogic.workDelBranch(pMap);
			if(result==1) {path="redirect:xxx.jsp";}
			else {path="redirect:errorPage.jsp";}
			
		}else if(cud.equals("workAddBranch")) {     ///성공
			//지사 등록 insert here
			logger.info("Controller : 지사 등록 호출 성공");
			
			/////////////////////// 실제 코드    /////////////////////
			pMap = HashMapBuilder.hashMapBuilder(req.getParameterMap());
			result = workLogic.workAddBranch(pMap);
			if(result==1) {path="redirect:xxx.jsp";}
			else {path="redirect:errorPage.jsp";}
			
			///////////////////////  테스트 코드   /////////////////////
			/*
		    pMap = new HashMap<>(); 
			pMap.put("DL_LATITUDE", 37.4031039459546);
			pMap.put("DL_LONGITUDE", 126.783059388399);
			pMap.put("DL_NAME", "현대자동차");
			pMap.put("DL_TEL", "02-456-1234");
			pMap.put("DL_ADDRESS", "경기도 안양시 동안구");
			result = workLogic.workAddBranch(pMap);
			if(result==1) {path="redirect:xxx.jsp";}
			else {path="redirect:errorPage.jsp";}
			*/
		}else if(cud.equals("MapView")) {  ///성공
			//파견지역 맵 뷰 insert here
			logger.info("Controller : 맵 호출");
			/////////////////////// 실제 코드    /////////////////////		
			pMap = new HashMap<>();
			pMap.put("dl_no", req.getParameter("dl_no"));
			List<Map<String,Object>> rlist = null;
			rlist = workLogic.workSelMapView(pMap);
			req.setAttribute("MapViewList", rlist);
			path = " forward:xxx.jsp"; 
			
			///////////////////////  테스트 코드   /////////////////////
			/*
			List<Map<String,Object>> rlist = null;
			pMap = new HashMap<>(); 
			pMap.put("dl_no", 1);
			rlist = workLogic.workSelMapView(pMap);
			path = " forward:xxx.jsp"; 
			*/
		}else if("addDeptSch".equals(cud)) {  //성공 
			//부서일정 추가하기
			logger.info("부서일정 추가버튼 호출");
			/////////////////////// 실제 코드    /////////////////////	
			pMap = HashMapBuilder.hashMapBuilder(req.getParameterMap());
			pMap.put("emp_no", session.getAttribute("emp_no"));
			String add_result = workLogic.deptAddSchedule(pMap);
			System.out.println("일정등록 성공 여부=>"+add_result);
			if(add_result.equals("1")) {path="redirect:xxx.jsp";}
			else {path="redirect:errorPage.jsp";}
			
			///////////////////////  테스트 코드   /////////////////////
			/*
			pMap = new HashMap<>();
			pMap.put("emp_no", 10001);
			pMap.put("ds_title", "일정 제목");
			pMap.put("ds_memo", "메모 내용");
			pMap.put("ds_sdate", "2020-06-22 18:00");
			pMap.put("ds_edate", "2020-06-22 19:00");
			pMap.put("ds_type", "인사부");
			pMap.put("ds_allday", "false");
			pMap.put("ds_bgcolor", "#ffdd33");
			String add_result = workLogic.deptAddSchedule(pMap);
			System.out.println("부서일정 등록 성공 여부=>"+add_result);
			if(add_result.equals("1")) {path="redirect:xxx.jsp";}
			else {path="redirect:errorPage.jsp";}
			*/
		}else if("updDeptSch".equals(cud)) {   ///성공
			//부서일정 변경하기
			logger.info("부서일정 수정버튼 호출");
			/////////////////////// 실제 코드    /////////////////////	
			pMap = HashMapBuilder.hashMapBuilder(req.getParameterMap());
			pMap.put("emp_no", session.getAttribute("emp_no"));
			String upd_result=workLogic.deptUpdSchedule(pMap);
			if(upd_result.equals("1")) {path="redirect:xxx.jsp";}
			else {path="redirect:errorPage.jsp";}
			
			///////////////////////  테스트 코드   /////////////////////
			/*
			pMap = new HashMap<>();
			pMap.put("emp_no", 10001);
			pMap.put("ds_title", "일정 제목");
			pMap.put("ds_memo", "메모 내용");
			pMap.put("ds_sdate", "2020-06-22 18:00");
			pMap.put("ds_edate", "2020-06-22 19:00");
			pMap.put("ds_type", "인사부");
			pMap.put("ds_allday", "false");
			pMap.put("ds_bgcolor", "#ffdd33");
			pMap.put("ds_no", 4);
			String upd_result=workLogic.deptUpdSchedule(pMap);
			System.out.println("부서일정 수정 성공 여부=>"+upd_result);
			if(upd_result.equals("1")) {path="redirect:xxx.jsp";}
			else {path="redirect:errorPage.jsp";}
			*/
		}else if("delDeptSch".equals(cud)) {  //성공
			//부서일정 삭제하기
			logger.info("부서일정 삭제버튼 호출");
			/////////////////////// 실제 코드    /////////////////////	
			pMap = new HashMap<>();
			pMap.put("emp_no", session.getAttribute("emp_no"));
			pMap.put("ds_no", req.getParameter("ds_no"));
			int del_result = workLogic.deptDelSchedule(pMap);
			if(del_result==1) {path="redirect:xxx.jsp";}
			else {path="redirect:errorPage.jsp";}
			
			///////////////////////  테스트 코드   /////////////////////
			/*
			pMap = new HashMap<>();
			pMap.put("emp_no", 10001);
			pMap.put("ds_no",4); 
			int del_result = 0;
			del_result = workLogic.deptDelSchedule(pMap);
			System.out.println("개인 일정 삭제 처리 결과 : "+del_result);
			if(del_result==1) {path="redirect:xxx.jsp";}
			else {path="redirect:errorPage.jsp";}
			*/
		}
		return path;
	}

	@Override
	public ModelAndView process(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		Map<String,Object> pMap = null;
		Map<String,Object> rMap = null;
		ModelAndView mav = new ModelAndView(req,res);
		
		if(requestName.equals("personManageMent")){ ////////////////////////////////////// 쿼리문 없음
			//인사조직도  insert here
			logger.info("Controller : 인사조직도 호출 성공");
			List<Map<String,Object>> rlist = null;
			pMap = new HashMap<>();
			rlist = workLogic.personManageMent(pMap);
			mav.addObject("personManageMentList", rlist);
			mav.setViewName("");
		}
		
		else if(requestName.equals("mySign")) { ////완료
			//전자결재 insert here
			logger.info("Controller : 전자결재 호출 성공");
			/////////////////////// 실제 코드    /////////////////////
			List<Map<String,Object>> slist = new ArrayList<>();
			pMap = new HashMap<>();
			pMap.put("emp_no",session.getAttribute("emp_no"));
			slist = workLogic.smySign(pMap);
		    mav.addObject("smySignList", slist);
			
		    List<Map<String,Object>> rlist = new ArrayList<>();
		    rMap = new HashMap<>();
			pMap.put("emp_no",session.getAttribute("emp_no"));
			rlist = workLogic.rmySign(rMap);
			mav.addObject("rmySignList", rlist);
			mav.setViewName("");
			
			///////////////////////  테스트 코드   /////////////////////
			/*
			List<Map<String,Object>> slist = new ArrayList<>();
		    pMap = new HashMap();
		    pMap.put("emp_no",10001);
		    slist = workLogic.smySign(pMap);
		    mav.addObject("smySignList", slist);
		
		    List<Map<String,Object>> rlist = null;
		    rMap = new HashMap();
		    pMap.put("emp_no",10001);
			rlist = workLogic.rmySign(rMap);
			mav.addObject("rmySignList", rlist);
			mav.setViewName("");
			*/
		}
		 else if(requestName.equals("signForm")) {  //완료
			//결재양식 insert here
			logger.info("Controller : 전자결재 양식 호출 성공");
			/////////////////////// 실제 코드    /////////////////////
			List<Map<String,Object>> rlist = new ArrayList<>();
			pMap = new HashMap<>();
		    rlist = workLogic.signForm(pMap); //파라미터 없음
		    mav.addObject("signFormList",rlist);
		    mav.setViewName("");
		}else if(requestName.equals("empList")) { //완료
			//사원조회 insert here
			logger.info("Controller : 사원관리 호출 성공");
			List<Map<String,Object>> rlist =  new ArrayList<>();
			pMap = new HashMap<>();
			rlist = workLogic.empList(pMap); //파라미터 없음
			mav.addObject("empList", rlist);
			mav.setViewName("");
		}
		else if(requestName.equals("empRetire")) { //완료
			//퇴직사원조회 insert here
			logger.info("Controller : 퇴직사원관리 호출 성공");
			List<Map<String,Object>> rlist =  new ArrayList<>();
			pMap = new HashMap();
			rlist = workLogic.empRetire(pMap);//파라미터 없음
			mav.addObject("empRetireList", rlist);
			mav.setViewName("");
		}
		else if(requestName.equals("empSend")) { //완료
			//파견사원조회 insert here
			logger.info("Controller : 파견사원관리 호출 성공");
			List<Map<String,Object>> rlist = null;
			pMap = new HashMap<>();
			rlist = workLogic.empSend(pMap);//파라미터 없음
			System.out.println("파견사원 리스트 => "+rlist.size());
			mav.addObject("empSendList", rlist);
			mav.setViewName("");
		}
		else if(requestName.equals("branchList")) { //완료
			//지사관리 insert here
			logger.info("Controller : 지사관리 호출 성공");
			List<Map<String,Object>> rlist = null;
			pMap = new HashMap<>();
			rlist = workLogic.branchList(pMap);//파라미터 없음
			mav.addObject("branchList", rlist);
			mav.setViewName("");
		}
		else if(requestName.equals("deptSchedule")) { //완료
			//부서일정 insert here
			logger.info("Controller : 부서일정 호출 성공");
			/////////////////////// 실제 코드    /////////////////////
			List<Map<String,Object>> rlist =  new ArrayList<>();
			pMap = new HashMap<>();
			pMap.put("emp_no", session.getAttribute("emp_no"));
			pMap.put("dept_day",req.getParameter("dept_day"));
			rlist = workLogic.deptSchedule(pMap);
			mav.addObject("deptScheduleList", rlist);
			mav.setViewName("");
			
			///////////////////////  테스트 코드   /////////////////////
			/*
			List<Map<String,Object>> rlist = new ArrayList<>();
			pMap = new HashMap();
			pMap.put("emp_no",10001);
			pMap.put("dept_day","2020-06-01");
			rlist = workLogic.deptSchedule(pMap);
			System.out.println("부서일정 리스트 =>"+rlist.size());
			mav.addObject("deptScheduleList", rlist);
			mav.setViewName("");
			*/
		}
		return mav;
	}

}
