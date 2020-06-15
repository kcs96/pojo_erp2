package com.erp;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class EmpController implements Controller {

	String requestName = null;
	EmpLogic empLogic = null;
	Logger logger = Logger.getLogger(EmpController.class);
	public EmpController(String requestName) {
		logger.info("EmpController 생성 성공");
		this.requestName=requestName;
		empLogic = new EmpLogic();
	}

	@Override
	public String process(String cud, HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String path = null;
		int result = 0;
		if("login".equals(cud)) {
			logger.info("EmpController => 로그인 호출");
			Map<String,String[]> pMap = (Map<String,String[]>)req.getParameterMap();
			Map<String,Object> loginMap= HashMapBuilder.hashMapBuilder(pMap);
			Map<String,Object> rMap = new HashMap<>();
			rMap =empLogic.login(loginMap);
			String empno =rMap.get("EMPNO").toString();
			String ename =rMap.get("E_NAME").toString();
			HttpSession session = req.getSession();
			session.setAttribute("emp_no",empno);
			session.setAttribute("emp_name",ename);
			path="redirect:/main/indexMain.erp";
		}else if("myUpdImformation".equals(cud)) {
			logger.info("EmpController => 내 정보 수정 호출");
			HttpSession session = req.getSession();
			Map<String,Object> pMap = new HashMap<>();
			pMap.put("emp_no", session.getAttribute("emp_no"));
			result =empLogic.myUpdImformation(pMap);
			if(result == 1) path="redirect:xxx.jsp"; 
			else if(result == 0) path="redirect:error.jsp"; 
		}
		return path;
	}

	@Override
	public ModelAndView process(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		Map<String,Object> rMap = new HashMap<>();
		Map<String,Object> pMap = new HashMap<>();
		pMap.put("emp_no", session.getAttribute("emp_no"));
		ModelAndView mav = new ModelAndView(req,res);
		
		if(requestName.equals("indexMain")) {
			//메인페이지 insert here
			logger.info("메인페이지 호출");
			List<Map<String,Object>> inoutList = empLogic.inoutList(pMap);
			mav.addObject("inOutList", inoutList);
			List<Map<String,Object>> todayList = empLogic.todayList(pMap);
			mav.addObject("todayList", todayList);
			List<Map<String,Object>> roomList = empLogic.roomList(pMap);
			mav.addObject("roomList", roomList);
			mav.setViewName("");
		}else if("empEdit".equals(requestName)) {
			logger.info("내정보 수정 호출");
			Map<String,Object> myInfoMap = empLogic.myInfoMap(pMap);
			mav.addObject("myInfoMap", myInfoMap);
			mav.setViewName("");
		}
		return mav;
	}

}
