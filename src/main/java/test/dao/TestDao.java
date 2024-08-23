package test.dao;

import test.domain.RequestTestDTO;
import test.domain.ResponseDTO;

public class TestDao {
	
	private ResponseDTO response;
	public TestDao() {
		response = new ResponseDTO();
	}
	
	public ResponseDTO loginRow(RequestTestDTO params) {
		System.out.println("debug >>> dao loginRow params : " +  params);
		if(params.getId().equals("jslim") && params.getPwd().equals("jslim")) {
			response.setName(params.getId());
			return response;
		}else {
			response.setName("입력값을 확인하세요");
			return null;
		}
	}
}
