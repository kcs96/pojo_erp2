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
		sqlSec = sqlMapper.openSession(true);
	}
	
	public Map<String, Object> login(Map<String, Object> loginMap) {
		//로그인 이벤트
		logger.info("EmpDao() => 로그인"); 
		Map<String, Object> rMap = new HashMap<>();
		rMap=sqlSec.selectOne("monthPay",loginMap);
		return rMap;
	}

	public List<Map<String, Object>> inoutList(Map<String, Object> pMap) {
		//오늘 출근정보 담기
		logger.info("EmpDao() => 메인페이지 오늘 출근 정보 담기"); 
		List<Map<String, Object>> inoutList = new ArrayList<>();
		inoutList=sqlSec.selectList("inoutList",pMap);
		return inoutList;
	}

	public List<Map<String, Object>> todayList(Map<String, Object> pMap) {
		//오늘 일정 얻어오기
		logger.info("EmpDao() => 메인페이지 오늘 일정 정보 담기"); 
		List<Map<String, Object>> todayList = new ArrayList<>();
		todayList=sqlSec.selectList("todayList",pMap);
		return todayList;
	}

	public List<Map<String, Object>> roomList(Map<String, Object> pMap) {
		//오늘 회의실 예약일정 얻어오기
		logger.info("EmpDao() => 메인페이지 회의실 예약 정보 담기"); 
		List<Map<String, Object>> roomList = new ArrayList<>();
		roomList=sqlSec.selectList("roomList",pMap);
		return roomList;
	}

	public int myUpdImformation(Map<String, Object> pMap) {
		//내 정보 수정 저장
		logger.info("EmpDao() => 내 정보 수정 저장버튼"); 
		result=sqlSec.update("myUpdImformation",pMap);
		return result;
	}

	public Map<String, Object> myInfoMap(Map<String, Object> pMap) {
		//내 정보 리스트 가져오기
		logger.info("EmpDao() => 내 정보 설정 리스트 가져오기"); 
		Map<String, Object> myInfoMap = new HashMap<>();
		myInfoMap=sqlSec.selectOne("myInfoMap",pMap);
		return myInfoMap;
	}
	
}
