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

public class ConferenceController implements Controller {
	String requestName = null;
	ConferenceLogic conLogic = null;
	public ConferenceController(String requestName) {
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
			// TODO Auto-generated method stub
			ModelAndView mav = new ModelAndView();
			if(requestName.equals("allRes")) {
				//회의실예약 insert here
				List<Map<String,Object>> rList = new ArrayList<>();
				rList = conLogic.allRes();
				mav.addObject("allResList", rList);
				mav.setViewName("");
			}
			return mav;
		}
}
