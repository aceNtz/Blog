package blog.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {

	
	@RequestMapping("login")
	public String getLoginPage() {
		return "login-page";
	}
	
}
