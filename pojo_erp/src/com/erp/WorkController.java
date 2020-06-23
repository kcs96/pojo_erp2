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
		//String empno =  (String)session.getAttribute("empno");
		String path = null;
		int result = 0;
		Map<String,Object> pMap = null;
		if(cud.equals("workAgree")) {/////////////////////////쿼리문 없음
			//결재 승인 insert here
			logger.info("Controller : 결재 승인 호출 성공");
			pMap = HashMapBuilder.hashMapBuilder(req.getParameterMap());
			pMap.put("emp_no",10001);
			result = workLogic.workAgree(pMap);
			path = "redirect:xxx.jsp";
			
		}else if(cud.equals("workDeny")) {
			//결재 기각 insert here
			logger.info("Controller : 결재 기각 호출 성공");
		    pMap = HashMapBuilder.hashMapBuilder(req.getParameterMap());
			pMap.put("emp_no",10001);
			result = workLogic.workDeny(pMap);
			path = "redirect:xxx.jsp";
			
		}else if(cud.equals("workSelectPerson")) {/////////////////////////쿼리문 없음
			//결재신청 수신자 추가 탭 insert here
			logger.info("Controller : 결재 신청 수신자 추가 호출 성공");
			List<Map<String,Object>> rlist = null;
		    pMap = new HashMap<>();
			rlist = workLogic.workSelectPerson(pMap);
			req.setAttribute("workSelectPersonList", rlist);
			path = "forward:xxx.jsp";
			
		}else if(cud.equals("workAddSendDoc")) {/////////////////////////쿼리문 없음
			//결재 신청 이벤트 탭 insert here
			logger.info("Controller : 결재 신청 호출 성공");
		    pMap = HashMapBuilder.hashMapBuilder(req.getParameterMap());
			pMap.put("emp_no",10001);
			result = workLogic.workAddSendDoc(pMap);
			path = "redirect:xxx.jsp";
			
		}else if(cud.equals("workSelectOverView")) {/////////////////////////쿼리문 없음
			//내결재함 오버뷰 insert here
			logger.info("Controller : 내결재함 오버뷰 호출 성공");
			List<Map<String,Object>> rlist = null;
		    pMap = new HashMap();
			pMap.put("empno",10001);
			rlist = workLogic.workSelectOverView(pMap);
			req.setAttribute("workSelectOverViewList", rlist);
			path = "forward:xxx.jsp";
			
		}else if(cud.equals("workSelectEmp")) {//// 완료
			//정보수정 이벤트 탭 insert here
			logger.info("Controller : 인사 정보수정 이벤트 호출 성공");
			List<Map<String,Object>> rList = null;
			pMap = new HashMap<>(); 
			//pMap.put("emp_no", 10001); //테스트코드
			pMap.put("emp_no",session.getAttribute("emp_no")); //실제코드
			rList = workLogic.workSelectEmp(pMap);
			System.out.println("사원에 대한 정보 => "+rList.size());
			req.setAttribute("workSelectEmp", rList);
			path = "forward:xxx.jsp";
		}
		
		else if(cud.equals("workUpdEmp")) { /////////////////못하겠다.
			//정보수정 저장버튼 눌렀을 경우
			logger.info("Controller의 수정 저장버튼 눌렀을 경우");
			result = 0;
			//pMap = HashMapBuilder.hashMapBuilder(req.getParameterMap());
			pMap = new HashMap<>(); 
			pMap.put("emp_no", 10007);
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
			pMap.put("emp_address", "경기도 안양시 만안구 박달로121");
			pMap.put("emp_zipcode", "13525");
			pMap.put("emp_detailaddress", "떙떙이 아파트 100동 100호");
			
			result = workLogic.workUpdEmp(pMap); 
			path = "redirect:xxx.jsp";
			
		}else if(cud.equals("workAddEmp")) { //////////////////////////////////   에러뜨고있음
			//신규사원 등록 이벤트 탭. insert here - 
			logger.info("Controller : 신규사원 등록 호출 성공");
		   // pMap = HashMapBuilder.hashMapBuilder(req.getParameterMap());
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
			pMap.put("emp_salary", 2800);
			pMap.put("emp_hiredate", "2020-01-01");
			pMap.put("emp_retiredate", "");
			pMap.put("emp_state", "재직");
			pMap.put("emp_address", "경기도 안양시 만");
			pMap.put("emp_zipcode", "13525");
			pMap.put("emp_detailaddress", "떙떙이 아파트 100동");
			
			result = workLogic.workAddEmp(pMap);
			path = "redirect:xxx.jsp";
			
		}else if(cud.equals("workUpdPw")) {  /////////////
			//인사탭 사원비밀번호 변경 insert here -o
			String results = null;
			logger.info("Controller : 재직사원 비밀번호 변경 호출 성공");
			pMap = HashMapBuilder.hashMapBuilder(req.getParameterMap());
			results = workLogic.workUpdPw(pMap);
			path = "redirect:xxx.jsp";
			
		}else if(cud.equals("workDelBranch")) {      ///성공
			//지사 삭제 insert here
			logger.info("Controller : 지사 삭제 호출 성공");
			String results = null;
			pMap = HashMapBuilder.hashMapBuilder(req.getParameterMap());
			pMap.put("U_INPUT","예");
			pMap.put("U_NUM","9");
			results = workLogic.workDelBranch(pMap);
			path = " redirect:xxx.jsp";
			
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
			path = " redirect:xxx.jsp";
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
		}else if(cud.equals("totempList")) {
			//총 사원관리 insert here
			logger.info("Controller : 총 사원관리");
			
			
			List<Map<String,Object>> rlist = null;
			pMap = HashMapBuilder.hashMapBuilder(req.getParameterMap());
			rlist = workLogic.tot_empList(pMap);
			path = "forward:xxx.jsp";
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
			pMap = new HashMap();
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
			
		}else if(requestName.equals("signSend")) {////////////////////////////////////// 쿼리문 없음
			//결재신청 insert here
			logger.info("Controller : 결재신청 호출 성공");
			/////////////////////// 실제 코드    /////////////////////
			List<Map<String,Object>> rlist =  new ArrayList<>();
			pMap = new HashMap<>();
			pMap.put("emp_no", session.getAttribute("emp_no"));
			rlist = workLogic.signSend(pMap);
			mav.addObject("sigSendList",rlist);
			mav.setViewName("");
			
			///////////////////////  테스트 코드   /////////////////////
			/*
			List<Map<String,Object>> rlist =  new ArrayList<>();
			pMap = new HashMap<>();
			pMap.put("empno", 10001);
			rlist = workLogic.signSend(pMap);
			mav.addObject("sigSendList",rlist);
			mav.setViewName("");
			*/
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
