package tn.esprit.spring.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class appcontroler {
@ResponseBody	
@RequestMapping("/home")
public String hello(){
	return "welcome to home";
};

}
