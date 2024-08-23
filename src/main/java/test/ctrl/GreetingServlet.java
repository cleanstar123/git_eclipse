package test.ctrl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test.domain.RequestTestDTO;
import test.domain.ResponseDTO;
import test.service.TestService;

// https:// server ip : port / context / greeting
@WebServlet("/greeting")
public class GreetingServlet extends HttpServlet {

	private TestService service;
	
	public void init() {
		System.out.println("인스턴스 생성시 딱 한번 호출되는 콜백함수입니다.");
		service = new TestService();
	}
	
	public void destroy() {
		System.out.println("메모리상에서 allocation될 때 딱 한번 호출되는 콜백함수입니다.");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		String uri = request.getRequestURI();
		System.out.println("debug >>> client path : " + uri);
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		RequestTestDTO params = new RequestTestDTO();
		params.setId(id);
		params.setPwd(pwd);
		
		ResponseDTO result = service.login(params);
		if(result != null) {
			// 데이터를 쉐어하기 위해 세션 객체를 만들고 데이터를 심는다.
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", result);
			
			response.sendRedirect("ok.jsp");
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("errMsg", "입력데이터 확인 부탁드립니다.");
			response.sendRedirect("error.jsp");
		}
	}

}
