package com.erp;

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
		sqlSes = sqlMapper.openSession(true);
	}
	public List<Map<String, Object>> personManageMent(Map<String, Object> pMap) {
		//인사 관리 탭 insert here
		logger.info("Controller : 인사조직도 호출 성공");
		List<Map<String,Object>> rlist = null;
		rlist = sqlSes.selectList("personManageMent",pMap);
		return rlist;
	}
	public List<Map<String, Object>> smySign(Map<String, Object> pMap) {
		//내결재함(보낸 결재) insert here
		logger.info("Controller : 전자결재 호출 성공");
		List<Map<String,Object>> rlist = null;
		rlist = sqlSes.selectList("smySign",pMap);
		return rlist;
	}
	public List<Map<String, Object>> rmySign(Map<String, Object> rMap) {
		//내결재함(받은 결재) insert here
		logger.info("Controller : 전자결재 호출 성공");
		List<Map<String,Object>> rlist = null;
		rlist = sqlSes.selectList("rmySign",rMap);
		return rlist;
	}
	public List<Map<String, Object>> signForm(Map<String, Object> pMap) {
		//결재양식 이벤트 탭
		logger.info("Controller : 전자결재 양식 호출 성공");
		List<Map<String,Object>> rlist = null;
		rlist = sqlSes.selectList("signForm",pMap);
		return rlist;
	}
	public List<Map<String, Object>> signSend(Map<String, Object> pMap) {
		//결재신청 이벤트 탭
		logger.info("Controller : 결재신청 호출 성공");
		List<Map<String,Object>> rlist = null;
		rlist = sqlSes.selectList("signSend",pMap);
		return rlist;
	}
	public List<Map<String, Object>> empList(Map<String, Object> pMap) {
		//사원조회 이벤트 탭
		logger.info("Controller : 사원조회 호출 성공");
		List<Map<String,Object>> rlist = null;
		rlist = sqlSes.selectList("empList",pMap);
		return rlist;
	}
	public List<Map<String, Object>> empRetire(Map<String, Object> pMap) {
		//퇴직사원 이벤트 탭
		logger.info("Controller : 퇴직사원관리 호출 성공");
		List<Map<String,Object>> rlist = null;
		rlist = sqlSes.selectList("empRetireList",pMap);
		return rlist;
	}
	public List<Map<String, Object>> empSend(Map<String, Object> pMap) {
		//파견사원 이벤트 탭
		logger.info("Controller : 파견사원관리 호출 성공");
		List<Map<String,Object>> rlist = null;
		rlist = sqlSes.selectList("empSendList",pMap);
		return rlist;
	}
	public List<Map<String, Object>> branchList(Map<String, Object> pMap) {
		//지사 관리 이벤트 탭
		logger.info("Controller : 지사관리 호출 성공");
		List<Map<String,Object>> rlist = null;
		rlist = sqlSes.selectList("branchList",pMap);
		return rlist;
	}
	public List<Map<String, Object>> deptSchedule(Map<String, Object> pMap) {
		//부서일정 이벤트 탭
		logger.info("Controller : 부서일정 호출 성공");
		List<Map<String,Object>> rlist = null;
		rlist = sqlSes.selectList("deptScheduleList",pMap);
		return rlist;
	}
	public List<Map<String, Object>> Manager(Map<String, Object> pMap) {
		//관리자 모드 이벤트 탭
		logger.info("Controller : 관리자모드 호출 성공");
		List<Map<String,Object>> rlist = null;
		rlist = sqlSes.selectList("ManagerList",pMap);
		return rlist;
	}
//////////////////////////////////cud작업//////////////////////////////////
	public List<Map<String, Object>> workSelectSearchSign(Map<String, Object> pMap) {
		//내결재함 조회 이벤트 탭 insert here
		logger.info("Controller : 내결제함 조회 호출 성공");
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
	public int workAgree(Map<String, Object> pMap) {
		//결재 승인 이벤트 insert here
		logger.info("Dao : 결재 승인 호출 성공");
		int result = 0;
		result = sqlSes.update("workAgree",pMap);
		return result;
	}
	public int workDeny(Map<String, Object> pMap) {
		//결재 기각 이벤트 insert here
		logger.info("Dao : 결재 기각 호출 성공");
		int result = 0;
		result = sqlSes.update("workDeny",pMap);
		return result;
	}
	public List<Map<String, Object>> workSelectPerson(Map<String, Object> pMap) {
		//결재신청 수신자 추가 탭 insert here
		logger.info("Dao : 결재 신청 수신자 추가 호출 성공");
		List<Map<String,Object>> rlist = null;
		rlist = sqlSes.selectList("workSelectPerson",pMap);
		return rlist;
	}
	public int workAddSendDoc(Map<String, Object> pMap) {
		//결재 신청 이벤트 탭 insert here
		logger.info("Dao : 결재 신청 호출 성공");
		int result = 0;
		result = sqlSes.insert("workAddSendDoc",pMap);
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
		rlist = sqlSes.selectList("workSelectEmp",pMap);
		return rlist;
	}
	public int workAddEmp(Map<String, Object> pMap) {
		//신규사원등록 이벤트 탭 insert here
		logger.info("Dao : 신규사원 등록 호출 성공");
		int result = 0;
		result = sqlSes.update("workUpdSchedule",pMap);
		return result;
	}
	public int workUpdPw(Map<String, Object> pMap) {
		//재직사원 비밀번호 변경 insert here
		logger.info("Dao : 재직사원 비밀번호 변경 호출 성공");
		int result = 0;
		result = sqlSes.update("workUpdPw",pMap);
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
	public int workDelBranch(Map<String, Object> pMap) {
		//지사 삭제 insert here
		logger.info("Dao : 지사 삭제 호출 성공");
		int result = 0;
		result = sqlSes.delete("workDelBranch",pMap);
		return result;
	}
	public int workAddBranch(Map<String, Object> pMap) {
		//지사 등록 insert here
		logger.info("Dao : 지사 등록 호출 성공");
		int result = 0;
		result = sqlSes.insert("workAddBranch",pMap);
		return result;
	}
	
}
