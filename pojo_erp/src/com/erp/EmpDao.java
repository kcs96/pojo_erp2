package com.erp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

public class EmpDao {
	
	Logger logger = Logger.getLogger(EmpDao.class);
	public SqlSessionFactory sqlMapper = null;
	public SqlSession sqlSec = null;
	private int result = 0;
	public EmpDao() {
		logger.info("EmpDao() 호출 성공"); 
		sqlMapper= MyBatisCommonFactory.getSqlSessionFactory();
		System.out.println(sqlMapper);
		sqlSec = sqlMapper.openSession();
	}
	
	public Map<String, Object> login(Map<String, Object> loginMap) {
		//로그인 이벤트
		logger.info("EmpDao() => 로그인"); 
		Map<String, Object> rMap = new HashMap<>();
		System.out.println(loginMap.get("emp_no"));
		System.out.println(loginMap.get("emp_pw"));
		sqlSec.selectOne("proc_empLogin",loginMap);
		List<Map<String,Object>> pMap=(List<Map<String,Object>>)loginMap.get("key");
		System.out.println(pMap.get(0).get("EMP_NO"));
		System.out.println(pMap.get(0).get("EMP_NAME"));
		return rMap;
	}
   
	public List<Map<String, Object>> inoutList(Map<String, Object> pMap) {
		//오늘 출근정보 담기
		logger.info("EmpDao() => 메인페이지 오늘 출근 정보 담기"); 
		List<Map<String, Object>> inoutList = new ArrayList<>();
		sqlSec.selectList("proc_commute",pMap);
		inoutList=(List<Map<String,Object>>)pMap.get("key");
		return inoutList;
	}

	public List<Map<String, Object>> todayList(Map<String, Object> pMap) {
		//오늘 일정 얻어오기
		logger.info("EmpDao() => 메인페이지 오늘 일정 정보 담기"); 
		List<Map<String, Object>> todayList = new ArrayList<>();
		sqlSec.selectList("proc_myschedule",pMap);
		todayList=(List<Map<String,Object>>)pMap.get("key");
		return todayList;
	}
	
	public List<Map<String, Object>> taskTime(Map<String, Object> pMap) {
		//오늘 일정 얻어오기
		logger.info("EmpDao() => 메인페이지 오늘 일정 정보 담기"); 
		List<Map<String, Object>> todayTaskList = new ArrayList<>();
		sqlSec.selectList("proc_taskTime",pMap);
		todayTaskList=(List<Map<String,Object>>)pMap.get("key");
		return todayTaskList;
	}

	public List<Map<String, Object>> roomList(Map<String, Object> pMap) {
		//오늘 회의실 예약일정 얻어오기
		logger.info("EmpDao() => 메인페이지 회의실 예약 정보 담기"); 
		List<Map<String, Object>> roomList = new ArrayList<>();
		sqlSec.selectList("proc_todaycfr",pMap);
		roomList=(List<Map<String,Object>>)pMap.get("key");

		return roomList;
	}

	public int myUpdImformation(Map<String, Object> pMap) {
		//내 정보 수정 저장
		logger.info("EmpDao() => 내 정보 수정 저장버튼"); 
		result=sqlSec.update("myUpdImformation",pMap);
		return result;
	}

	public List<Map<String, Object>> myInfoMap(Map<String, Object> pMap) {
		//내 정보 리스트 가져오기
		logger.info("EmpDao() => 내 정보 설정 리스트 가져오기"); 
		List<Map<String, Object>> myInfoList = new ArrayList<Map<String,Object>>();
		sqlSec.selectOne("PROC_NEMPLIST",pMap);
		myInfoList=(List<Map<String, Object>>)pMap.get("key");
		return myInfoList;
	}

	public Map<String,Object> newPassword(Map<String, Object> pMap) {
		logger.info("EmpLogic => 내 정보 리스트 => password 설정");
		Map<String,Object> rMap = new HashMap<String, Object>();
		sqlSec.selectOne("proc_newPassword",pMap);
		rMap =(Map<String, Object>) pMap.get("key");
		
		System.out.println(rMap.size());
		return rMap;
	}
	
}
