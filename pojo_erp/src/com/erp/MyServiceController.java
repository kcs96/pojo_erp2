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

public class MyServiceController implements Controller {
	Logger logger = Logger.getLogger(MyServiceController.class);
	String requestName = null;
	MyServiceLogic myServiceLogic = null;
	
	public MyServiceController(String requestName) {
		logger.info("MyServiceController 호출 성공");
		this.requestName = requestName;
		myServiceLogic = new MyServiceLogic();
	}
	
	@Override  
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String path = null;
		HttpSession session = req.getSession();
		Map<String, Object> pMap = null;
		if(requestName.equals("myGoWork")) { //insert 출근테이블에 오늘 출근 row추가
			//출근버튼 눌렀을때
			logger.info("MyService => 출근버튼 실행");
			/////////////////////// 실제 코드    /////////////////////
			pMap = new HashMap<>();
			pMap.put("emp_no", session.getAttribute("emp_no"));
			pMap.put("btn_type","출근");
			String result = myServiceLogic.myGoWork(pMap);
			System.out.println("출근 버튼 성공 여부 :"+result);
			if(result.equals("1")) {
				path="redirect:empCommute.jsp";
				System.out.println(path);
			}else {
				path="errorPage.jsp";
			}
			///////////////////////  테스트 코드   /////////////////////
			/*
			pMap = new HashMap<>();
			pMap.put("emp_no",10006);
			pMap.put("btn_type","출근");
			String result = myServiceLogic.myGoWork(pMap);
			System.out.println("출근 버튼 성공 여부 :"+result);
			if(result.equals("1")) {
				path="redirect:xxx.jsp";
				System.out.println(path);
			}else {
				path="errorPage.jsp";
			}
			*/
		}else if(requestName.equals("myGoHome")) { //update 오늘 출근row에 퇴근값 추가
			//퇴근버튼 눌렀을때
			logger.info("MyService => 퇴근버튼 실행");
			/////////////////////// 실제 코드    /////////////////////
			pMap = new HashMap<>();
			pMap.put("emp_no", session.getAttribute("emp_no"));
			pMap.put("btn_type","퇴근");
			String result=myServiceLogic.myGoHome(pMap);
			if(result.equals("1")) {path="redirect:empCommute.jsp";}
			else {path="redirect:errorPage.jsp";}
			///////////////////////  테스트 코드   /////////////////////
			/*
			pMap = new HashMap<>();
			pMap.put("emp_no",10006);
			pMap.put("btn_type","퇴근");
			String result=myServiceLogic.myGoHome(pMap);
			System.out.println("퇴근버튼 성공 여부 :"+result);
			if(result.equals("1")) {
				path="redirect:xxx.jsp";
				System.out.println(path);
			}else {
				path="errorPage.jsp";
			}
			*/
		}else if(requestName.equals("myGoOut")) { //update 상태컬럼 : 정상 -> 외출
			//외출버튼 눌렀을 때
			logger.info("MyService => 외출버튼 실행");
			/////////////////////// 실제 코드    /////////////////////
			pMap = new HashMap<>();
			pMap.put("emp_no", session.getAttribute("emp_no"));
			pMap.put("btn_type","외출");
			String result = myServiceLogic.myGoOut(pMap);
			if(result.equals("1")) {path="redirect:empCommute.jsp";}
			else {path="redirect:dfd.erp?cud=";}
			
			///////////////////////  테스트 코드   /////////////////////
			/*
			pMap = new HashMap<>();
			pMap.put("emp_no",10006);
			pMap.put("btn_type","외출");
			String result = myServiceLogic.myGoOut(pMap);
			System.out.println("외출버튼 성공 여부 :"+result);
			if(result.equals("1")) {
				path="redirect:xxx.jsp";
				System.out.println(path);
			}else {
				path="errorPage.jsp";
			}
			*/
		}else if(requestName.equals("myComBack")) { //update 상태컬럼 : 정상 -> 외출
			//외출복귀버튼 눌렀을 때
			logger.info("MyService => 외출복귀버튼 실행");
			/////////////////////// 실제 코드    /////////////////////
			pMap = new HashMap<>();
			pMap.put("emp_no", session.getAttribute("emp_no"));
			pMap.put("btn_type","외출복귀");
			String result = myServiceLogic.myComBack(pMap);
			if(result.equals("1")) {path="redirect:empCommute.jsp";}
			else {path="redirect:errorPage.jsp";}
			///////////////////////  테스트 코드   /////////////////////
			/*
			pMap = new HashMap<>();
			pMap.put("emp_no",10006);
			pMap.put("btn_type","외출복귀");
			String result = myServiceLogic.myComBack(pMap);
			System.out.println("외출복귀버튼 성공 여부 :"+result);
			if(result.equals("1")) {
				path="redirect:xxx.jsp";
				System.out.println(path);
			}else {
				path="errorPage.jsp";
			}
			*/
		}
		else if(requestName.equals("myAddSchedule")) { //insert 일정 추가
			//내 일정 내용 추가
			logger.info("MyService => 내 일정 추가 실행");
			/////////////////////// 실제 코드    /////////////////////
			pMap= HashMapBuilder.hashMapBuilder(req.getParameterMap());
			pMap.put("emp_no", session.getAttribute("emp_no"));
			String result = myServiceLogic.myAddSchedule(pMap);
			if(result.equals("1")) {path="redirect:xxx.jsp";}
			else {path="redirect:errorPage.jsp";}
			///////////////////////  테스트 코드   /////////////////////
			/*
			Map<String, Object> pMap = new HashMap<>();
			pMap.put("emp_no", 10001);
			pMap.put("my_title", "일정 제목");
			pMap.put("my_memo", "메모 내용");
			pMap.put("my_sdate", "2020-06-22 18:00");
			pMap.put("my_edate", "2020-06-22 19:00");
			pMap.put("my_type", "개인일정");
			pMap.put("my_allday", "false");
			pMap.put("my_bgcolor", "#ffdd33");
			String result = myServiceLogic.myAddSchedule(pMap);
			System.out.println("일정등록 성공 여부=>"+result);
			if(result.equals("1")) {
				path="redirect:xxx.jsp";
				System.out.println(path);
			}else {
				path="errorPage.jsp";
			}
			*/
		}
		else if(requestName.equals("myUpdSchedule")) { //update 일정 수정
			//내 일정 내용 수정
			logger.info("MyService => 내 일정 변경 실행");
			/////////////////////// 실제 코드    /////////////////////	
			pMap= HashMapBuilder.hashMapBuilder(req.getParameterMap());
			pMap.put("emp_no", session.getAttribute("emp_no"));
			String result=myServiceLogic.myUpdSchedule(pMap);
			if(result.equals("1")) {path="redirect:xxx.jsp";}
			else {path="redirect:errorPage.jsp";}
			
			///////////////////////  테스트 코드   /////////////////////
			/*
			Map<String, Object> pMap = new HashMap<>();
			pMap.put("emp_no", 10002);
			pMap.put("my_title", "일정 제목1");
			pMap.put("my_memo", "메모 내용1");
			pMap.put("my_sdate", "2020-06-22 13:00");
			pMap.put("my_edate", "2020-06-22 14:00");
			pMap.put("my_type", "개인일정");
			pMap.put("my_allday", "false");
			pMap.put("my_bgcolor", "#ffdd33");
			pMap.put("my_no", "2");
			String result=myServiceLogic.myUpdSchedule(pMap);
			System.out.println("일정수정 성공 여부=>"+result);
			if(result.equals("1")) {
				path="redirect:xxx.jsp";
				System.out.println(path);
			}else {
				path="redirect:errorPage.jsp";
			}
			*/
		}
		else if(requestName.equals("myDelSchedule")) { //delete 일정 삭제
			//내 일정 삭제
			logger.info("MyService => 내 일정 삭제 실행");
			/////////////////////// 실제 코드    /////////////////////
			pMap = new HashMap<>();
			pMap.put("emp_no", session.getAttribute("emp_no"));
			pMap.put("my_no", req.getParameter("my_no"));
			int del_result = myServiceLogic.myDelSchedule(pMap);
			if(del_result==1) {path="redirect:xxx.jsp";}
			else {path="redirect:errorPage.jsp";}
			
			///////////////////////  테스트 코드   /////////////////////
			/*
			Map<String, Object> pMap = new HashMap<>();
			pMap = HashMapBuilder.hashMapBuilder(req.getParameterMap());
			pMap.put("emp_no", 10002);
			pMap.put("my_no",2); 
			int del_result = 0;
			del_result = myServiceLogic.myDelSchedule(pMap);
			System.out.println("개인 일정 삭제 처리 결과 : "+del_result);
			if(del_result==1) {
				path="redirect:xxx.jsp";
				System.out.println(path);
			}else {
				path="redirect:errorPage.jsp";
			}
			*/
		}
		
		//////////////////////////////////////////////////////// forward 지역 /////////////////////////////////////////////////////////////////////
		else if(requestName.equals("inOutManager")) {
			//출퇴관리 insert here
			logger.info("MAV => 출퇴관리 실행");
			pMap = HashMapBuilder.hashMapBuilder(req.getParameterMap());
			pMap.put("emp_no", session.getAttribute("emp_no")); 
			//pMap.put("emp_no", 10002);
			List<Map<String,Object>> todayInOutList = new ArrayList<>();
			todayInOutList = myServiceLogic.inOutManager(pMap);
			System.out.println("오늘 출퇴관리탭 리스트"+todayInOutList.size());
			req.setAttribute("todayInOutList", todayInOutList);
			path="forward:./empCommute.jsp";
		}
		//////////////주간 근무시간 chart json 수정 ///////
		else if("weekChart".equals(requestName)) {
		logger.info("MAV => 출퇴관리 실행");
		pMap = HashMapBuilder.hashMapBuilder(req.getParameterMap());
		pMap.put("emp_no", session.getAttribute("emp_no")); 
			//이건 뭐지..? 주간 차트를 말하는 건가..?
			List<Map<String,Object>> weekInOutList = new ArrayList<>();
			weekInOutList = myServiceLogic.weekInOutInfo(pMap);
			System.out.println("주간 출퇴관리탭 리스트"+weekInOutList.size());
			req.setAttribute("weekInOutList", weekInOutList);
			path="forward:jsonWeekChart.jsp";
		}
		//개인일정 json 파일//
		else if("myScheduleChart".equals(requestName)) {
			//개인일정 insert here
			logger.info("MAV => 개인일정 실행");
			pMap = new HashMap<>();
			pMap.put("emp_no", session.getAttribute("emp_no")); 
			//pMap.put("my_day", "2020-06-01");//테스트
			pMap.put("sal_payday", req.getParameter("sal_payday")); //실제
			List<Map<String,Object>> rList = myServiceLogic.mySchedule(pMap);
			System.out.println("개인일정 리스트 => "+rList.size());
			req.setAttribute("myScheduleChart", rList);
			path="forward:jsonScheduleChart.jsp";
		}
		else if("monthPay".equals(requestName)) {
			//당월급여 insert here
			logger.info("MAV => 당월급여 실행");
			pMap = new HashMap<>();
			pMap.put("emp_no", session.getAttribute("emp_no")); 
			pMap.put("btn_type", "당월");
			pMap.put("sal_payday", "2020/06/14");//테스트
			//pMap.put("sal_payday", req.getParameter("sal_payday")); //실제
			List<Map<String,Object>> monthPayList = myServiceLogic.monthPay(pMap);
			System.out.println("당월급여 조회  => "+monthPayList.size());
			req.setAttribute("monthPayList", monthPayList);
			path="forward:xxx.jsp";
		}
		else if("allPay".equals(requestName)) {
			//전체급여 insert here
			logger.info("MAV => 전체급여 실행");
			pMap = new HashMap<>();
			pMap.put("emp_no", session.getAttribute("emp_no")); 
			pMap.put("btn_type", "전체");
			pMap.put("sal_payday", "2020/06/14");//테스트
			//pMap.put("sal_payday", req.getParameter("sal_payday")); //실제
			List<Map<String,Object>> allPayList = myServiceLogic.allPay(pMap);
			System.out.println("전체급여 조회  => "+allPayList.size());
			req.setAttribute("allPayList", allPayList);
			path="forward:xxx.jsp";
		}
		else if("mySchedule".equals(requestName)) {
			//개인일정 insert here
			logger.info("MAV => 개인일정 실행");
			pMap = new HashMap<>();
			pMap.put("emp_no", session.getAttribute("emp_no")); 
			//pMap.put("my_day", "2020-06-01");//테스트
			pMap.put("my_day", req.getParameter("my_day")); //실제
			List<Map<String,Object>> rList = myServiceLogic.mySchedule(pMap);
			System.out.println("개인일정 리스트 => "+rList.size());
			req.setAttribute("myScheduleList", rList);
			path="forward:jsonMySchedule.jsp";
		}
		return path;
	}

	@Override
	public ModelAndView process(String cud, HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		ModelAndView mav = new ModelAndView(req,res);
		return mav;
		
	}
}
