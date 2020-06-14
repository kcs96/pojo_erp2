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
	
	public EmpDao() {
		logger.info("EmpDao() 호출 성공"); 
		sqlMapper= MyBatisCommonFactory.getSqlSessionFactory();
		sqlSec = sqlMapper.openSession(true);
	}
	
	public Map<String, Object> login(Map<String, Object> loginMap) {
		//로그인 이벤트
		Map<String, Object> rMap = new HashMap<>();
		rMap=sqlSec.selectOne("monthPay",loginMap);
		return rMap;
	}

	public List<Map<String, Object>> inoutList(Map<String, Object> pMap) {
		//오늘 출근정보 담기
		List<Map<String, Object>> inoutList = new ArrayList<>();
		inoutList=sqlSec.selectList("inoutList",pMap);
		return inoutList;
	}

	public List<Map<String, Object>> todayList(Map<String, Object> pMap) {
		//오늘 일정 얻어오기
		List<Map<String, Object>> todayList = new ArrayList<>();
		todayList=sqlSec.selectList("todayList",pMap);
		return todayList;
	}

	public List<Map<String, Object>> roomList(Map<String, Object> pMap) {
		//오늘 회의실 예약일정 얻어오기
		List<Map<String, Object>> roomList = new ArrayList<>();
		roomList=sqlSec.selectList("roomList",pMap);
		return roomList;
	}
	
}
