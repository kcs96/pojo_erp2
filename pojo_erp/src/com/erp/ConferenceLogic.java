package com.erp;

import java.util.List;
import java.util.Map;

public class ConferenceLogic {
	ConferenceDao cdao = null;
	public ConferenceLogic() {
		cdao = new ConferenceDao();
	}
	
	public int conAddRoom(Map<String, Object> pMap) {
		//회의실예약 버튼 이벤트
		int result = 0;
		result = cdao.conAddRoom(pMap);
		return result;
	}

	public int conDelRoom(Map<String, Object> pMap) {
		//회의실 삭제 이벤트
		int result = 0;
		result = cdao.conDelRoom(pMap);
		return result;
	}

	public List<Map<String, Object>> allRes() {
		//전체 회의실 예약 정보 가져오기
		List<Map<String, Object>> rList = null;
		rList = cdao.allRes();
		return rList;
	}

}
