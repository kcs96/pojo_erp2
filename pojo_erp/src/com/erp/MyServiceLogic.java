package com.erp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class MyServiceLogic {
	
	Logger logger = Logger.getLogger(MyServiceLogic.class);
	MyServiceDao myServiceDao = null;
	public MyServiceLogic() {
		logger.info("MyServiceLogic 호출 성공");
		this.myServiceDao=new MyServiceDao();
	}
 
	public Map<String,Object> inOutManager(Map<String,Object> pMap) {
		//출퇴관리 탭 이벤트
		logger.info("MyServiceLogic => 출퇴관리 호출");
		Map<String,Object> rMap = new HashMap<>();
		rMap= myServiceDao.myInOutInfo(pMap); //today에 대한 내 정보
		List<Map<String,Object>> rList = new ArrayList<>();
		rList = myServiceDao.weekInOutInfo(pMap);
		return rMap;
	}

	public Map<String, Object> monthPay(Map<String, Object> pMap) {
		//당월급여 조회 탭 이벤트
		logger.info("MyServiceLogic => 당월 급여 호출");
		Map<String,Object> rMap = new HashMap<>();
		rMap = myServiceDao.monthPay(pMap);		
		return rMap;
	}

	public List<Map<String, Object>> allPay(Map<String, Object> pMap) {
		//전체 급여 조회 탭 이벤트
		logger.info("MyServiceLogic => 전체급여 호출");
		List<Map<String, Object>> rList = null;
		rList = myServiceDao.allPay(pMap);		
		return rList;
	}

	public List<Map<String, Object>> mySchedule(Map<String, Object> pMap) {
		//내 일정 관리 탭 이벤트
		logger.info("MyServiceLogic => 개인 일정  호출");
		List<Map<String, Object>> rList = null;
		rList = myServiceDao.mySchedule(pMap);
		return rList;
	}
	public int myGoWork(Map<String, Object> pMap) {
		//출근 버튼 이벤트 탭 이벤트
		logger.info("MyServiceLogic => 출근 버튼  호출");
		int result = 0;
		result = myServiceDao.myGoWork(pMap);
		return result;
		
	}
	public int myGoHome(Map<String, Object> pMap) {
		//퇴근 버튼 이벤트 탭 이벤트
		logger.info("MyServiceLogic => 퇴근 버튼  호출");
		int result = 0;
		result = myServiceDao.myGoHome(pMap);
		return result;
		
	}
	public int myGoOut(Map<String, Object> pMap) {
		//외출 버튼 이벤트
		logger.info("MyServiceLogic => 외출 버튼 호출");
		int result = 0;
		result = myServiceDao.myGoOut(pMap);
		return result;
	}

	public int myAddSchedule(Map<String, Object> pMap) {
		//일정추가 버튼 이벤트
		logger.info("MyServiceLogic => 개인 일정 추가  호출");
		int result = 0;
		result = myServiceDao.myAddSchedule(pMap);
		return result;
	}

	public int myUpdSchedule(Map<String, Object> pMap) {
		//일정수정 버튼 이벤트
		logger.info("MyServiceLogic => 개인 일정 수정  호출");
		int result = 0;
		result = myServiceDao.myUpdSchedule(pMap);
		return result;
	}

	public int myDelSchedule(Map<String, Object> pMap) {
		//일정삭제 버튼 이벤트
		logger.info("MyServiceLogic => 개인 일정 삭제  호출");
		int result = 0;
		result = myServiceDao.myDelSchedule(pMap);
		return result;
		
	}

}
