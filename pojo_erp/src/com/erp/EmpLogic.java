package com.erp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmpLogic {
		
	EmpDao empDao = null;
	
	public EmpLogic() {
		this.empDao = new EmpDao();
	}
	
	public Map<String, Object> login(Map<String, Object> loginMap) {
		//로그인 이벤트 시작
		Map<String, Object> rMap = new HashMap<>();
		rMap = empDao.login(loginMap);
		return  rMap;
	}

	public List<Map<String, Object>> inoutList(Map<String, Object> pMap) {
		//메인페이지 오늘 출근 정보
		List<Map<String, Object>> rList = new ArrayList<>();
		rList = empDao.inoutList(pMap);
		return rList;
	}

	public List<Map<String, Object>> todayList(Map<String, Object> pMap) {
		//메인페이지 오늘 나의 일정 정보
		List<Map<String, Object>> rList = new ArrayList<>();
		rList = empDao.todayList(pMap);
		return rList;
	}

	public List<Map<String, Object>> roomList(Map<String, Object> pMap) {
		//메인페이지 오늘 회의실예약 정보
		List<Map<String, Object>> rList = new ArrayList<>();
		rList = empDao.roomList(pMap);
		return rList;
	}

}
