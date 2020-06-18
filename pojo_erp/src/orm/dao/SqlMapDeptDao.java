package orm.dao;

import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

public class SqlMapDeptDao {
	Logger logger = Logger.getLogger(SqlMapDeptDao.class);
	SqlSession SqlSes = null;
	String resource="orm/mybatis/Configuration.xml";
	SqlSessionFactory sqlMapper = null;
	
	public List<Map<String,Object>> proc_empLogin(Map<String,Object> pMap){
		List<Map<String,Object>> plist = new ArrayList<Map<String,Object>>();
		SqlSes.selectOne("proc_empLogin",pMap);
		plist = (List<Map<String,Object>>)pMap.get("key");    
		logger.info("plist.size() : " + plist.size());
		for(int i=0; i<plist.size(); i++) {
			Map<String,Object> rMap = plist.get(i);
			logger.info(rMap.get("emp_no").toString());
			logger.info(rMap.get("emp_pw").toString());
		}
		return plist;
	}

	

	public static void main(String[] args) {
		SqlMapDeptDao md = new SqlMapDeptDao();
		Map<String, Object> pMap = new HashMap();
		pMap.put("emp_no", "1001");
		pMap.put("emp_pw", "1234");
		md.proc_empLogin(pMap);
		
	}
	
}
