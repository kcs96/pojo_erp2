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

public class ConferenceController implements Controller {
	String requestName = null;
	ConferenceLogic conLogic = null;
	Logger logger = Logger.getLogger(ConferenceController.class);
	public ConferenceController(String requestName) {
		logger.info("ConferenceController 호출 성공");
		this.requestName = requestName;
		conLogic = new ConferenceLogic();
	}

	@Override
	public String process(String cud,HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map<String, Object> pMap = null;
		String path =null;
		HttpSession session = req.getSession();
		String empno = (String)session.getAttribute("empno");
		if(cud.equals("conAddRoom")) {//insert
			//회의실예약 insert here
			logger.info("ConferenceController[String] => 회의실예약 호출");
			int result = 0;
			pMap = HashMapBuilder.hashMapBuilder(req.getParameterMap());
			pMap.put("empno",empno);
			result=conLogic.conAddRoom(pMap);
			if(result==1) {
				path="redirect:xxx.jsp";
			}else {
				path="errorPage.jsp";
			}
		}else if(cud.equals("conDelRoom")) {//delete
			//회의실예약취소 insert here
			logger.info("ConferenceController[String] => 회의실예약취소 호출");
			int result = 0;
			pMap = HashMapBuilder.hashMapBuilder(req.getParameterMap());
			pMap.put("empno",empno);
			result=conLogic.conDelRoom(pMap);
			if(result==1) {
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
			ModelAndView mav = new ModelAndView();
			Map<String,Object> pMap = new HashMap<>();
			pMap.put("cfr_day", "2020-06-01");
			if(requestName.equals("allRes")) {
				//회의실예약 insert here
				logger.info("ConferenceController[String] => 회의실예약탭  호출");
				List<Map<String,Object>> allResList = new ArrayList<>();
				allResList = conLogic.allRes(pMap);
				System.out.println("회의실예약 리스트 => "+allResList.size());
				mav.addObject("allResList", allResList);
				mav.setViewName("");
			}
			return mav;
		}
}
