package com.erp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

public class MyServiceDao {
	Logger logger = Logger.getLogger(MyServiceDao.class);
	public SqlSessionFactory sqlMapper = null;
	public SqlSession sqlSec = null;
	private int result=0;
	
	public MyServiceDao() {
		logger.info("MyServiceDao() 호출 성공"); 
		sqlMapper= MyBatisCommonFactory.getSqlSessionFactory();
		sqlSec = sqlMapper.openSession(true);
	}
	
	public Map<String, Object> myInOutInfo(Map<String, Object> pMap) {
		//출퇴관리 탭 이벤트
		logger.info("MyServiceDao => 출퇴관리 호출"); 
		Map<String, Object> rMap = new HashMap<>();
		rMap=sqlSec.selectOne("monthPay",pMap);
		return rMap;
	}

	public List<Map<String, Object>> weekInOutInfo(Map<String, Object> pMap) {
		//주 단위 내 출퇴관리 정보
		logger.info("MyServiceDao => 주 단위 출퇴 리스트"); 
		List<Map<String, Object>> rList = new ArrayList<>();
		rList=sqlSec.selectList("weekInOutInfo",pMap);
		return rList;
	}


	public Map<String, Object> monthPay(Map<String, Object> pMap) {
		//당월급여 조회  이벤트
		logger.info("MyServiceDao => 당월급여 호출"); 
		Map<String, Object> rMap = new HashMap<>();
		rMap=sqlSec.selectOne("monthPay",pMap);
		return rMap;
	}

	public List<Map<String, Object>> allPay(Map<String, Object> pMap) {
		//전체 급여 조회 이벤트
		logger.info("MyServiceDao => 출퇴관리 호출"); 
		List<Map<String, Object>> rList = new ArrayList<>();
		rList=sqlSec.selectList("allPay",pMap);
		return rList;
	}

	public List<Map<String, Object>> mySchedule(Map<String, Object> pMap) {
		//내 일정 관리  이벤트
		logger.info("MyServiceDao => 내 일정 관리 호출"); 
		List<Map<String, Object>> rList = new ArrayList<>();
		rList=sqlSec.selectList("mySchedule",pMap);
		return rList;
	}
	public int myGoWork(Map<String, Object> pMap) {
		//출근 버튼 이벤트
		logger.info("MyServiceDao => 출근 버튼 호출"); 
		result=sqlSec.insert("myGoWork",pMap);
		return result;
	}

	public int myGoOut(Map<String, Object> pMap) {
		//외출 버튼 이벤트
		logger.info("MyServiceDao => 외출 버튼 호출"); 
		result=sqlSec.update("myGoOut",pMap);
		return result;
	}

	public int myGoHome(Map<String, Object> pMap) {
		//퇴근 버튼 이벤트 탭 이벤트
		logger.info("MyServiceDao => 퇴근 버튼 호출"); 
		result=sqlSec.update("myGoOut",pMap);
		return result;
	}
	
	public int myAddSchedule(Map<String, Object> pMap) {
		//일정추가 버튼 이벤트
		logger.info("MyServiceDao => 개인 일정 추가 호출"); 
		result=sqlSec.insert("myAddSchedule",pMap);
		return result;
	}

	public int myUpdSchedule(Map<String, Object> pMap) {
		//일정수정 버튼 이벤트
		logger.info("MyServiceDao => 개인 일정 수정 호출"); 
		result=sqlSec.update("myUpdSchedule",pMap);
		return result;
	}

	public int myDelSchedule(Map<String, Object> pMap) {
		//일정삭제 버튼 이벤트
		logger.info("MyServiceDao => 개인 일정 삭제 호출"); 
		result=sqlSec.update("myDelSchedule",pMap);
		return result;
	}

}
