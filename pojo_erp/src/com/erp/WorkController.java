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
		String empno =  (String)session.getAttribute("empno");
		String path = null;
		int result = 0;
		Map<String,Object> pMap = null;
		if(cud.equals("workSelectSearchSign")) {
			//내결제함 조회이벤트 탭 insert here
			logger.info("Controller : 내결제함 조회 호출 성공");
			List<Map<String,Object>> rlist = null;
			pMap = HashMapBuilder.hashMapBuilder(req.getParameterMap());
		    rlist = workLogic.workSelectSearchSign(pMap);
			path = "forward:xxx.jsp";
			
		}else if(cud.equals("workAddDocument")) { 
			//결제양식 작성 insert here
			logger.info("Controller : 결제양식 호출 성공");
			pMap = HashMapBuilder.hashMapBuilder(req.getParameterMap());
		    pMap.put("empno", empno);
			result = workLogic.workAddDocument(pMap);
			path = "redirect:xxx.jsp";
							
		}else if(cud.equals("workAgree")) {
			//결재 승인 insert here
			logger.info("Controller : 결재 승인 호출 성공");
			pMap = HashMapBuilder.hashMapBuilder(req.getParameterMap());
			pMap.put("empno",empno);
			result = workLogic.workAgree(pMap);
			path = "redirect:xxx.jsp";
			
		}else if(cud.equals("workDeny")) {
			//결재 기각 insert here
			logger.info("Controller : 결재 기각 호출 성공");
		    pMap = HashMapBuilder.hashMapBuilder(req.getParameterMap());
		    pMap.put("empno", empno);
			result = workLogic.workDeny(pMap);
			path = "redirect:xxx.jsp";
			
		}else if(cud.equals("workSelectPerson")) {
			//결재신청 수신자 추가 탭 insert here
			logger.info("Controller : 결재 신청 수신자 추가 호출 성공");
			List<Map<String,Object>> rlist = null;
		    pMap = new HashMap<>();
			rlist = workLogic.workSelectPerson(pMap);
			path = "forward:xxx.jsp";
			
		}else if(cud.equals("workAddSendDoc")) {
			//결재 신청 이벤트 탭 insert here
			logger.info("Controller : 결재 신청 호출 성공");
		    pMap = HashMapBuilder.hashMapBuilder(req.getParameterMap());
		    pMap.put("empno", empno);
			result = workLogic.workAddSendDoc(pMap);
			path = "redirect:xxx.jsp";
			
		}else if(cud.equals("workSelectOverView")) {
			//내결재함 오버뷰 insert here
			logger.info("Controller : 내결재함 오버뷰 호출 성공");
			List<Map<String,Object>> rlist = null;
		    pMap = new HashMap();
		    pMap.put("empno", empno);
			rlist = workLogic.workSelectOverView(pMap);
			path = "forward:xxx.jsp";
			
		}else if(cud.equals("workSelectSearchEmp")) {
			//사원조회 이벤트 탭 insert here
			logger.info("Controller : 사원조회 호출 성공");
			List<Map<String,Object>> rlist = null;
			pMap = HashMapBuilder.hashMapBuilder(req.getParameterMap());
			rlist = workLogic.workSelectSearchEmp(pMap);
			path = "forward:xxx.jsp";
			
		}else if(cud.equals("workSelectEmp")) {
			//정보수정 이벤트 탭 insert here
			logger.info("Controller : 정보수정 이벤트 호출 성공");
			List<Map<String,Object>> rlist = null;
			pMap = new HashMap(); 
			pMap.put("empno", empno);
			rlist = workLogic.workSelectEmp(pMap);
			path = "forward:xxx.jsp";
			
		}else if(cud.equals("workAddEmp")) {
			//신규사원 등록 이벤트 탭. insert here
			logger.info("Controller : 신규사원 등록 호출 성공");
		    pMap = HashMapBuilder.hashMapBuilder(req.getParameterMap());
			result = workLogic.workAddEmp(pMap);
			path = "redirect:xxx.jsp";
			
		}else if(cud.equals("workUpdPw")) {
			//재직사원 비밀번호 변경 insert here
			logger.info("Controller : 재직사원 비밀번호 변경 호출 성공");
			pMap = HashMapBuilder.hashMapBuilder(req.getParameterMap());
			pMap.put("empno", empno);
			result = workLogic.workUpdPw(pMap);
			path = "redirect:xxx.jsp";
			
		}else if(cud.equals("workUpdProfile")) {
			//재직사원 정보 변경 insert here
			logger.info("Controller : 재직사원 정보 변경 호출 성공");
			pMap = HashMapBuilder.hashMapBuilder(req.getParameterMap());
			pMap.put("empno", empno);
			result = workLogic.workUpdPw(pMap);
			path = "redirect:xxx.jsp";
		}
		else if(cud.equals("workSelectSearchRetire")) {
			//퇴직사원 조회 insert here
			logger.info("Controller : 퇴직사원 조회 호출 성공");
			List<Map<String,Object>> rlist = null;
			pMap = HashMapBuilder.hashMapBuilder(req.getParameterMap());
			rlist = workLogic.workSelectSearchRetire(pMap);
			path = " forward:xxx.jsp";
			
		}
		
		else if(cud.equals("workSelectSearchDispatcher")) {
			//파견사원 조회 insert here
			logger.info("Controller : 파견사원 조회 호출 성공");
			List<Map<String,Object>> rlist = null;
			pMap = HashMapBuilder.hashMapBuilder(req.getParameterMap());
			rlist = workLogic.workSelectSearchDispatcher(pMap);
			path = " forward:xxx.jsp";
		}
		
		else if(cud.equals("workDelBranch")) {
			//지사 삭제 insert here
			logger.info("Controller : 지사 삭제 호출 성공");
			pMap = HashMapBuilder.hashMapBuilder(req.getParameterMap());
			result = workLogic.workDelBranch(pMap);
			path = " redirect:xxx.jsp";
		}
		
		else if(cud.equals("workAddBranch")) {
			//지사 등록 insert here
			logger.info("Controller : 지사 등록 호출 성공");
			pMap = HashMapBuilder.hashMapBuilder(req.getParameterMap());
			result = workLogic.workAddBranch(pMap);
			path = " redirect:xxx.jsp";
		}
		
		return path;
	}

	@Override
	public ModelAndView process(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		String empno =  (String)session.getAttribute("empno");
		Map<String,Object> pMap = null;
		Map<String,Object> rMap = null;
		ModelAndView mav = new ModelAndView(req,res);
		if(requestName.equals("personManageMent")){
			//인사조직도  insert here
			logger.info("Controller : 인사조직도 호출 성공");
			List<Map<String,Object>> rlist = null;
			pMap = new HashMap();
			rlist = workLogic.personManageMent(pMap);
			mav.addObject("personManageMentList", rlist);
			mav.setViewName("");
		}else if(requestName.equals("mySign")) {
			//전자결재 insert here
			logger.info("Controller : 전자결재 호출 성공");
			List<Map<String,Object>> slist = null;
		    pMap = new HashMap();
		    pMap.put("pname", empno);
		    slist = workLogic.smySign(pMap);
		    mav.addObject("smySignList", slist);
		    
		    List<Map<String,Object>> rlist = null;
		    rMap = new HashMap();
		    rMap.put("empno",empno);
			rlist = workLogic.rmySign(rMap);
			mav.addObject("rmySignList", rlist);
			mav.setViewName("");
		}else if(requestName.equals("signForm")) {
			//결재양식 insert here
			logger.info("Controller : 전자결재 양식 호출 성공");
			List<Map<String,Object>> rlist = null;
		    rlist = workLogic.signForm(pMap); //Map or List 그냥 리스트함.
		    mav.addObject("signFormList",rlist);
		    mav.setViewName("");
		}else if(requestName.equals("signSend")) {
			//결재신청 insert here
			logger.info("Controller : 결재신청 호출 성공");
			List<Map<String,Object>> rlist = null;
			pMap = new HashMap();
			pMap.put("empno", empno);
			rlist = workLogic.signSend(pMap);
			mav.addObject("sigSendList",rlist);
			mav.setViewName("");
		}else if(requestName.equals("empList")) {
			//사원조회 insert here
			logger.info("Controller : 사원조회 호출 성공");
			List<Map<String,Object>> rlist = null;
			rlist = workLogic.empList(pMap);
			mav.addObject("empList", rlist);
			mav.setViewName("");
		}else if(requestName.equals("empRetire")) {
			//퇴직사원조회 insert here
			logger.info("Controller : 퇴직사원관리 호출 성공");
			List<Map<String,Object>> rlist = null;
			rlist = workLogic.empRetire(pMap);
			mav.addObject("empRetireList", rlist);
			mav.setViewName("");
		}else if(requestName.equals("empSend")) {
			//파견사원조회 insert here
			logger.info("Controller : 파견사원관리 호출 성공");
			List<Map<String,Object>> rlist = null;
			rlist = workLogic.empSend(pMap);
			mav.addObject("empSendList", rlist);
			mav.setViewName("");
		}else if(requestName.equals("branchList")) {
			//지사관리 insert here
			logger.info("Controller : 지사관리 호출 성공");
			List<Map<String,Object>> rlist = null;
			rlist = workLogic.branchList(pMap);
			mav.addObject("branchList", rlist);
			mav.setViewName("");
		}
		else if(requestName.equals("deptSchedule")) {
			//부서일정 insert here
			logger.info("Controller : 부서일정 호출 성공");
			List<Map<String,Object>> rlist = null;
			pMap = new HashMap();
			pMap.put("empno",empno);
			rlist = workLogic.deptSchedule(pMap);
			mav.addObject("deptScheduleList", rlist);
			mav.setViewName("");
		}
		else if(requestName.equals("Manager")) {
			//관리자 insert here
			logger.info("Controller : 관리자모드 호출 성공");
			List<Map<String,Object>> rlist = null;
			pMap = new HashMap();
			pMap.put("empno", empno);
			rlist = workLogic.Manager(pMap);
			mav.addObject("ManagerList", rlist);
		}
		return mav;
	}

}
