package com.example.bufsroom;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@GetMapping("/sbb")
	@ResponseBody
	public String index() {
		return "로그인을 하세요.";
	}

	@GetMapping("/")
	public String root() {
		return "redirect:/user/login";
	}

}
