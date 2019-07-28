package firstappdemo.controller;

import firstappdemo.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wcz
 * @date 2019-07-13 20:58
 **/
@Controller
@RequestMapping("/User2Json")
public class User2JsonController {

	@RequestMapping("/getUser")
	@ResponseBody
	public User getUser(){
		User user = new User();
		user.setId(999999999);
		user.setName("张三");
		user.setPassword("123456");
		user.setRemark("");

		return user;
	}
}
