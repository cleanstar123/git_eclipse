package test.service;

import test.dao.TestDao;
import test.domain.RequestJoinDTO;
import test.domain.RequestTestDTO;
import test.domain.ResponseDTO;

public class TestService {
	
	
	//////////////////////////////////////spring framework - 의존관계성 주입(Dependency Injection)
	private TestDao dao;
	
	public TestService() {
		dao = new TestDao();
	}
	
	public ResponseDTO login(RequestTestDTO params) {
		System.out.println("debug >>> service login params");
		return dao.loginRow(params);
	}
}
