package firstappdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wcz
 * @date 2019-07-26 20:06
 **/
@RestController
public class HelloController {

	@GetMapping("/login/hello")
	public String hello() {
		return "hello";
	}
}

