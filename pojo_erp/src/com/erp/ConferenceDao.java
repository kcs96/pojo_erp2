package com.erp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

public class ConferenceDao {
	Logger logger = Logger.getLogger(ConferenceDao.class);
	public SqlSessionFactory sqlMapper = null;
	public SqlSession sqlSec = null;
	
	public ConferenceDao() {
		logger.info("ConferenceDao() 호출 성공"); 
		sqlMapper= MyBatisCommonFactory.getSqlSessionFactory();
		sqlSec = sqlMapper.openSession();
	}

	public int conAddRoom(Map<String, Object> pMap) {
		//회의실예약 버튼 이벤트
		logger.info("ConferenceDao() => 회의실 예약"); 
		int result = 0;
		result = sqlSec.insert("conAddRoom",pMap);
		return result;
	}

	public int conDelRoom(Map<String, Object> pMap) {
		//회의실 삭제 이벤트
		logger.info("ConferenceDao() => 회의실 삭제"); 
		int result = 0;
		result = sqlSec.delete("conDelRoom",pMap);
		return result;
	}

	public List<Map<String, Object>> allRes(Map<String, Object> pMap) {
		//전체 회의실 예약 정보 가져오기
		logger.info("ConferenceDao() => 회의실 전체예약정보"); 
		List<Map<String, Object>> rList = new ArrayList<>();
		sqlSec.selectOne("proc_conResList",pMap);
		rList = (List<Map<String, Object>>)pMap.get("key");
		return rList;
	}
}
