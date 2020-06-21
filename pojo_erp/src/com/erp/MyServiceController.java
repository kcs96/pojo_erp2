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

import org.apache.catalina.Session;
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
	public String process(String cud, HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String path = null;
		Map<String, Object> pMap = new HashMap<>();
		HttpSession session = req.getSession();
		String empno = (String)session.getAttribute("empno");
		
		int result = 0;
		if(cud.equals("myGoWork")) { //insert 출근테이블에 오늘 출근 row추가
			//출근버튼 눌렀을때
			logger.info("MyService => 출근버튼 실행");
			//pMap.put("empno",empno);
			pMap.put("empno",10001);
			result = myServiceLogic.myGoWork(pMap);
			if(result == 1) {
				path="redirect:xxx.jsp";
			}else {
				path="errorPage.jsp";
			}
		}else if(cud.equals("myGoHome")) { //update 오늘 출근row에 퇴근값 추가
			//퇴근버튼 눌렀을때
			logger.info("MyService => 퇴근버튼 실행");
			pMap.put("empno",empno);
			result=myServiceLogic.myGoHome(pMap);
			if(result == 1) {
				path="redirect:xxx.jsp";
			}else {
				path="errorPage.jsp";
			}
		}else if(cud.equals("myGoOut")) { //update 상태컬럼 : 정상 -> 외출
			//외출버튼 눌렀을 때
			logger.info("MyService => 외출버튼 실행");
			pMap.put("empno",empno);
			result = myServiceLogic.myGoOut(pMap);
			if(result == 1) {
				path="redirect:xxx.jsp";
			}else {
				path="errorPage.jsp";
			}
		}else if(cud.equals("myAddSchedule")) { //insert 일정 추가
			//내 일정 내용 추가
			logger.info("MyService => 내 일정 추가 실행");
			pMap = HashMapBuilder.hashMapBuilder(req.getParameterMap());
			result = myServiceLogic.myAddSchedule(pMap);
			if(result == 1) {
				path="redirect:xxx.jsp";
			}else {
				path="errorPage.jsp";
			}
		}else if(cud.equals("myUpdSchedule")) { //update 일정 수정
			//내 일정 내용 수정
			logger.info("MyService => 내 일정 변경 실행");
			pMap = HashMapBuilder.hashMapBuilder(req.getParameterMap());
			pMap.put("empno",empno);
			result=myServiceLogic.myUpdSchedule(pMap);
			if(result == 1) {
				path="redirect:xxx.jsp";
			}else {
				path="errorPage.jsp";
			}
		}else if(cud.equals("myDelSchedule")) { //delete 일정 삭제
			//내 일정 삭제
			logger.info("MyService => 내 일정 삭제 실행");
			pMap = HashMapBuilder.hashMapBuilder(req.getParameterMap());
			pMap.put("emp_no", 10001);
			pMap.put("my_no",1); 
			result = myServiceLogic.myDelSchedule(pMap);
			System.out.println("개인 일정 삭제 처리 결과 : "+result);
			if(result == 1) {
				path="redirect:xxx.jsp";
			}else {
				path="errorPage.jsp";
			}
		}
		return path;
	}

	@Override
	public ModelAndView process(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		ModelAndView mav = new ModelAndView(req,res);
		HttpSession session = req.getSession();
		Map<String,Object> rMap = new HashMap<>();
		Map<String,Object> pMap = new HashMap<>();
		//pMap.put("emp_no", session.getAttribute("emp_no"));
		pMap.put("emp_no",10001);
		if(requestName.equals("inOutManager")) {
			//출퇴관리 insert here
			logger.info("MAV => 출퇴관리 실행");
			List<Map<String,Object>> todayInOutList = new ArrayList<>();
			todayInOutList = myServiceLogic.inOutManager(pMap);
			System.out.println("오늘 출퇴관리탭 리스트"+todayInOutList.size());
			mav.addObject("todayInOutList", todayInOutList);
			
			List<Map<String,Object>> weekInOutList = new ArrayList<>();
			weekInOutList = myServiceLogic.weekInOutInfo(pMap);
			System.out.println("오늘 출퇴관리탭 리스트"+weekInOutList.size());
			mav.addObject("weekInOutList", weekInOutList);
			mav.setViewName("");
			
		}else if(requestName.equals("monthPay")) {
			//당월급여 insert here
			logger.info("MAV => 당월급여 실행");
			pMap.put("btn_type", "당월");
			pMap.put("sal_payday", "2020/06/14");
			List<Map<String,Object>> monthPayList = myServiceLogic.monthPay(pMap);
			System.out.println("당월급여 조회  => "+monthPayList.size());
			mav.addObject("monthPayList", monthPayList);
			mav.setViewName("");
			
		}else if(requestName.equals("allPay")) {
			//전체급여 insert here
			logger.info("MAV => 전체급여 실행");
			pMap.put("btn_type", "전체");
			pMap.put("sal_payday", "2020/06/14");
			List<Map<String,Object>> allPayList = myServiceLogic.allPay(pMap);
			System.out.println("전체급여 조회  => "+allPayList.size());
			mav.addObject("allPayList", allPayList);
			mav.setViewName("");
		}else if(requestName.equals("mySchedule")) {
			//개인일정 insert here
			logger.info("MAV => 개인일정 실행");
			pMap.put("my_day", "2020-06-01");
			List<Map<String,Object>> rList = myServiceLogic.mySchedule(pMap);
			System.out.println("개인일정 리스트 => "+rList.size());
			mav.addObject("myScheduleList", rList);
			mav.setViewName("");
		}
		return mav;
	}
}
