package com.erp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

public class WorkDao {
	SqlSessionFactory sqlMapper = null;
	SqlSession sqlSes = null;
	Logger logger = Logger.getLogger(WorkDao.class);
	public WorkDao() {
		sqlMapper = MyBatisCommonFactory.getSqlSessionFactory();
		sqlSes = sqlMapper.openSession();
	}
	public List<Map<String, Object>> personManageMent(Map<String, Object> pMap) {
		//인사 관리 탭 insert here
		logger.info("Dao : 인사조직도 호출 성공");
		List<Map<String,Object>> rlist = null;
		rlist = sqlSes.selectList("personManageMent",pMap);
		return rlist;
	}
	public List<Map<String, Object>> smySign(Map<String, Object> pMap) {
		//내결재함(보낸 결재) insert here
		logger.info("Dao : 전자결재 호출 성공");
		List<Map<String,Object>> rlist = null;
		sqlSes.selectOne("proc_s_SignList",pMap);
		rlist = (List<Map<String,Object>>)pMap.get("key");
		logger.info("Dao에 smySign rlist.size() : " + rlist.size());
		return rlist;
	}
	public List<Map<String, Object>> rmySign(Map<String, Object> rMap) {
		//내결재함(받은 결재) insert here
		logger.info("Dao : 전자결재 호출 성공");
		List<Map<String,Object>> rlist = null;
	    sqlSes.selectOne("proc_r_SignList",rMap);
	    rlist = (List<Map<String,Object>>)rMap.get("key");
		logger.info("Dao에 rmySign rlist.size() : " + rlist.size());
		return rlist;
	}
	public List<Map<String, Object>> signForm(Map<String, Object> pMap) {
		//결재양식 이벤트 탭
		logger.info("WorkDao : 전자결재 양식 호출 성공");
		List<Map<String,Object>> rlist = null;
		sqlSes.selectOne("proc_SignForm",pMap);
		rlist = (List<Map<String,Object>>)pMap.get("key");
		logger.info("rlist : " + rlist.size());
		return rlist;
	}
	public List<Map<String, Object>> empList(Map<String, Object> pMap) {
		//사원조회 이벤트 탭
		logger.info("Dao : 사원관리 호출 성공");
		List<Map<String,Object>> rlist = null;
		sqlSes.selectOne("proc_empList",pMap);
		rlist = (List<Map<String,Object>>)pMap.get("key");
		logger.info("Dao empList rlist.size() : " + rlist.size()); 
		return rlist;
	}
	public List<Map<String, Object>> empRetire(Map<String, Object> pMap) {
		//퇴직사원 이벤트 탭
		logger.info("Dao : 퇴직사원관리 호출 성공");
		List<Map<String,Object>> rlist = null;
		sqlSes.selectOne("PROC_RETIREMENT",pMap);
		rlist = (List<Map<String,Object>>)pMap.get("key");
		logger.info("Dao empRetire rlist.size() : " + rlist.size());
		return rlist;
	}
	public List<Map<String, Object>> empSend(Map<String, Object> pMap) {
		//파견사원 이벤트 탭
		logger.info("Dao : 파견사원관리 호출 성공");
		List<Map<String,Object>> rlist = new ArrayList<>();
		sqlSes.selectOne("proc_dispatch",pMap);
		rlist = (List<Map<String,Object>>)pMap.get("key");
		return rlist;
	}
	public List<Map<String, Object>> branchList(Map<String, Object> pMap) {
		//지사 관리 이벤트 탭
		logger.info("Dao : 지사관리 호출 성공");
		List<Map<String,Object>> rlist = null;
		sqlSes.selectOne("PROC_BRANCHLIST",pMap);
		rlist = (List<Map<String,Object>>)pMap.get("key");
		logger.info("Dao branchList : " + rlist.size());
		return rlist;
	}
	public List<Map<String, Object>> deptSchedule(Map<String, Object> pMap) {
		//부서일정 이벤트 탭
		logger.info("Dao : 부서일정 호출 성공");
		List<Map<String,Object>> rlist = null;
		sqlSes.selectOne("proc_deptSchList",pMap);
		rlist=(List<Map<String,Object>>)pMap.get("key");
		return rlist;
	}
	public List<Map<String, Object>> Manager(Map<String, Object> pMap) {
		//관리자 모드 이벤트 탭
		logger.info("Dao : 관리자모드 호출 성공");
		List<Map<String,Object>> rlist = null;
		rlist = sqlSes.selectList("ManagerList",pMap);
		return rlist;
	}
//////////////////////////////////cud작업//////////////////////////////////
	public List<Map<String, Object>> workSelectSearchSign(Map<String, Object> pMap) {
		//내결재함 조회 이벤트 탭 insert here
		logger.info("Dao : 내결제함 조회 호출 성공");
		List<Map<String,Object>> rlist = null;
		rlist = sqlSes.selectList("workSelectSearchSignList",pMap);
		return rlist;
	}
	public int workAddDocument(Map<String, Object> pMap) {
		//결재양식 작성 이벤트 탭 insert here
		logger.info("Dao : 결제양식 호출 성공");
		int result = 0;
		result = sqlSes.insert("workAddDocument",pMap);
		return result;
	}
	public String workAgree(Map<String, Object> pMap) {
		//결재 승인 이벤트 insert here
		logger.info("Dao : 결재 승인 호출 성공");
		sqlSes.selectOne("proc_accept",pMap);
		String result = pMap.get("msg").toString();
		return result;
	}
	public String workDeny(Map<String, Object> pMap) {
		//결재 기각 이벤트 insert here
		logger.info("Dao : 결재 기각 호출 성공");
		sqlSes.selectOne("proc_reason",pMap);
		String result = pMap.get("msg").toString();
		return result;
	}
	public String workAddSendDoc(Map<String, Object> pMap) {
		//결재 신청 이벤트 탭 insert here
		logger.info("Dao : 결재 신청 호출 성공");
		sqlSes.selectOne("proc_addRev",pMap);
		String result = pMap.get("msg").toString();
		return result;
	}
	public List<Map<String, Object>> SelectOverView(Map<String, Object> pMap) {
		//내결재함 오버뷰 insert here
		logger.info("Dao : 내결재함 오버뷰 호출 성공");
		List<Map<String,Object>> rlist = null;
		rlist = sqlSes.selectList("SelectOverView",pMap);
		return rlist;
	}
	public List<Map<String, Object>> workSelectSearchEmp(Map<String, Object> pMap) {
		//사원조회 이벤트 탭 insert here
		logger.info("Dao : 사원조회 호출 성공");
		List<Map<String,Object>> rlist = null;
		rlist = sqlSes.selectList("workSelectSearchEmp",pMap);
		return rlist;
	}
	public List<Map<String, Object>> workSelectEmp(Map<String, Object> pMap) {
		//정보수정 이벤트 탭 insert here
		logger.info("Dao : 정보수정 이벤트 호출 성공");
		List<Map<String,Object>> rlist = null;
	    	sqlSes.selectOne("PROC_EMPLIST_INSA",pMap);
	    	rlist = (List<Map<String,Object>>)pMap.get("key");
	    	logger.info("Dao workSelEmp : " + rlist.size());
		return rlist;
	}
	public int workUpdEmp(Map<String, Object> pMap) {
		int result = 0;
		result = sqlSes.update("workUpdEmp",pMap);
		logger.info("result : " + result);
		return result;
	}
	public int workAddEmp(Map<String, Object> pMap) {
		//신규사원등록 이벤트 탭 insert here
		logger.info("Dao : 신규사원 등록 호출 성공");
		int result = 0;
		result = sqlSes.insert("workAddEmp",pMap);
		sqlSes.commit();
		logger.info("result : " + result);
		return result;
	}
	public String workUpdPw(Map<String, Object> pMap) {
		//재직사원 비밀번호 변경 insert here
		logger.info("Dao : 재직사원 비밀번호 변경 호출 성공");
		String result = null;
		sqlSes.selectOne("PROC_CHANGEPW",pMap);
		result = pMap.get("MSG").toString();
		logger.info("result : " + result );
		return result;
	}
	public int workUpdProfile(Map<String, Object> pMap) {
		//재직사원 정보 변경 insert here
		logger.info("Dao : 재직사원 정보 변경 호출 성공");
		int result = 0;
		result = sqlSes.update("workUpdProfile",pMap);
		return result;
	}
	public List<Map<String, Object>> workSelectSearchRetire(Map<String, Object> pMap) {
		//퇴직사원 조회 insert here
		logger.info("Dao : 퇴직사원 조회 호출 성공");
		List<Map<String,Object>> rlist = null;
		rlist = sqlSes.selectList("workSelectRetire",pMap);
		return rlist;
	}
	public List<Map<String, Object>> workSelectSearchDispatcher(Map<String, Object> pMap) {
		//파견사원 조회 insert here
		logger.info("Dao : 파견사원 조회 호출 성공");
		List<Map<String,Object>> rlist = null;
		rlist = sqlSes.selectList("workSelectSearchDispatcher",pMap);
		return rlist;
	}
	public String workDelBranch(Map<String, Object> pMap) {
		//지사 삭제 insert here
		logger.info("Dao : 지사 삭제 호출 성공");
		String result = null;
		sqlSes.selectOne("PROC_DELBRANCH",pMap);
		result = pMap.get("MSG").toString();
		logger.info("result : " + result);
		return result;
	}
	public int workAddBranch(Map<String, Object> pMap) {
		//지사 등록 insert here
		logger.info("Dao : 지사 등록 호출 성공");
		int result = 0;
		result = sqlSes.insert("addBranch",pMap);
		sqlSes.commit();
		return result;
	}
	public List<Map<String, Object>> workSelMapView(Map<String, Object> pMap) {
		logger.info("Dao : 파견맵뷰 호출 성공 ");
		List<Map<String,Object>> rlist = null;
		sqlSes.selectOne("PROC_MapView",pMap);
		rlist = (List<Map<String,Object>>)pMap.get("key");
		logger.info("Dao workSelMapView 호출 성공 : " + rlist.size());
		return rlist;
	}
	public String deptAddSchedule(Map<String, Object> pMap) {
		//부서일정추가 버튼 이벤트
		logger.info("workDao => 부서 일정 추가 호출"); 
		String result ="";
		sqlSes.selectOne("proc_deptSchAdd",pMap);
		result=pMap.get("msg").toString();
		return result;
	}
	public String deptUpdSchedule(Map<String, Object> pMap) {
		//부서일정추가 버튼 이벤트
		logger.info("workDao => 부서 일정 수정 호출"); 
		String result ="";
		sqlSes.selectOne("proc_deptSchUpd",pMap);
		result=pMap.get("msg").toString();
		return result;
	}
	public int deptDelSchedule(Map<String, Object> pMap) {
		logger.info("workDao => 개인 일정 삭제 호출"); 
		int result=sqlSes.delete("work_deptSchDel",pMap);
		return result;
	}
	public int workAddDoc(Map<String, Object> pMap) {
		logger.info("workDao => 결제 신청버튼 호출 (결제입력)"); 
		int result=sqlSes.insert("workAddDoc",pMap);
		return result;
	}
}
