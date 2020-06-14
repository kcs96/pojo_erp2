package com.erp;

import java.io.IOException;
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
		Map<String, Object> pMap = null;
		HttpSession session = req.getSession();
		String empno = (String)session.getAttribute("empno");
		int result = 0;
		if(cud.equals("myGoWork")) { //insert 출근테이블에 오늘 출근 row추가
			//출근버튼 눌렀을때
			logger.info("myGoWork 실행");
			pMap.put("empno",empno);
			result = myServiceLogic.myGoWork(pMap);
			if(result == 1) {
				path="redirect:xxx.jsp";
			}else {
				path="errorPage.jsp";
			}
		}else if(cud.equals("myGoHome")) { //update 오늘 출근row에 퇴근값 추가
			//퇴근버튼 눌렀을때
			logger.info("myGoHome 실행");
			pMap.put("empno",empno);
			result=myServiceLogic.myGoHome(pMap);
			if(result == 1) {
				path="redirect:xxx.jsp";
			}else {
				path="errorPage.jsp";
			}
		}else if(cud.equals("myGoOut")) { //update 상태컬럼 : 정상 -> 외출
			//외출버튼 눌렀을 때
			logger.info("myGoOut 실행");
			pMap.put("empno",empno);
			result = myServiceLogic.myGoOut(pMap);
			if(result == 1) {
				path="redirect:xxx.jsp";
			}else {
				path="errorPage.jsp";
			}
		}else if(cud.equals("myAddSchedule")) { //insert 일정 추가
			//내 일정 내용 추가
			logger.info("myAddSchedule 실행");
			pMap = HashMapBuilder.hashMapBuilder(req.getParameterMap());
			pMap.put("empno",empno);
			result = myServiceLogic.myAddSchedule(pMap);
			if(result == 1) {
				path="redirect:xxx.jsp";
			}else {
				path="errorPage.jsp";
			}
		}else if(cud.equals("myUpdSchedule")) { //update 일정 수정
			//내 일정 내용 수정
			logger.info("myUpdSchedule 실행");
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
			logger.info("myDelSchedule 실행");
			pMap = HashMapBuilder.hashMapBuilder(req.getParameterMap());
			pMap.put("empno",empno); 
			result = myServiceLogic.myDelSchedule(pMap);
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
		pMap.put("emp_no", session.getAttribute("emp_no"));
		if(requestName.equals("inOutManager")) {
			//출퇴관리 insert here
			logger.info("출퇴관리 실행");
			rMap = myServiceLogic.inOutManager(pMap);
			mav.addObject("inOutMap", rMap);
			mav.setViewName("");
		}else if(requestName.equals("monthPay")) {
			//당월급여 insert here
			logger.info("당월급여 실행");
			rMap = myServiceLogic.monthPay(pMap);
			mav.addObject("monthPayMap", rMap);
			mav.setViewName("");
		}else if(requestName.equals("allPay")) {
			//전체급여 insert here
			logger.info("전체급여 실행");
			List<Map<String,Object>> rList = myServiceLogic.allPay(pMap);
			mav.addObject("allPayList", rList);
			mav.setViewName("");
		}else if(requestName.equals("mySchedule")) {
			//개인일정 insert here
			logger.info("개인일정 실행");
			List<Map<String,Object>> rList = myServiceLogic.mySchedule(pMap);
			mav.addObject("myScheduleList", rList);
			mav.setViewName("");
		}
		return mav;
	}

}
