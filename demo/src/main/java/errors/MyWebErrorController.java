package errors;

import java.net.URLDecoder;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyWebErrorController implements ErrorController {
	@RequestMapping("/error")
	String handleError(HttpServletRequest request) throws Exception {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		System.out.println("오류코드=" + status);
		System.out.println("오류메시지=" + request.getAttribute(RequestDispatcher.ERROR_MESSAGE));
		System.out.println("오류파일=" + request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI));
		System.out.println("파라미터정보=" + request.getAttribute(RequestDispatcher.FORWARD_QUERY_STRING));
		if(request.getAttribute(RequestDispatcher.FORWARD_QUERY_STRING) != null) {			
			System.out.println("파라미터정보=" + URLDecoder.decode((String)request.getAttribute(RequestDispatcher.FORWARD_QUERY_STRING), "utf-8"));
		}
		System.out.println("오청방식=" + request.getMethod());
		return "errors/" + status.toString();
	}
}
