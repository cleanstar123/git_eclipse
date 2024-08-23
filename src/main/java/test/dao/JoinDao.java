package test.dao;

import test.domain.RequestJoinDTO;

public class JoinDao {
	
	private RequestJoinDTO response;
	
	public JoinDao() {
		response = new RequestJoinDTO();
	}
	
	public String joinRow(RequestJoinDTO params) {
		String okMsg = "회원가입이 완료되었습니다.";
		String errorMsg = "다시 작성해주세요.";
		
		if(params.getName() != null && params.getId() != null && params.getPassword() != null && params.getGender() != null) {
			return okMsg;
		}else {
			return errorMsg;
		}
	}
}
