package innovation.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import innovation.utils.UserFormValidator;
import innovation.model.User;
import innovation.service.UserService;

@Controller
@SessionAttributes("currentUser")
public class UserController {

	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserFormValidator validator;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	}
	@ModelAttribute("currentUser")
	public User getUser() {
		User user = new User();
		return user;
	}
	/*@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginForm(@ModelAttribute("login") User user) {
		System.out.println("login");
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", user);
		return mav;
	}*/
	/*为了减少前端麻烦，全部使用html以及json*/
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> login(
			@RequestParam(required = true, defaultValue = "") String name,
			@RequestParam(required = true, defaultValue = "") String password,
			@ModelAttribute("currentUser") User user, BindingResult result,
			SessionStatus status,HttpServletResponse response) { 
		validator.loginValidate(user, result);
		HashMap<String,String> hm = new HashMap<String,String>();
		if (result.hasErrors()) {

			hm.put("status", "1");
			hm.put("code", result.getFieldError().getCode());
			hm.put("message",result.getFieldError().getDefaultMessage());
		} else {
			if (userService.ValidateName(name)) {
				user = userService.login(name, password);
				if (user.getUid()!=0) {
					logger.debug("{} login sucesss!",user.getUid());
					JSONObject json_user = JSONObject.fromObject(user);
					hm.put("status", "0");
					hm.put("message", "login sucess");
					hm.put("data", json_user.toString());
					response.addCookie(new Cookie("username",user.getName()));
					response.addCookie(new Cookie("user",json_user.toString()));
				} else {
					hm.put("status", "2");
					hm.put("message", "Password is Error!");
				}
			} else {
				hm.put("status", "3");
				hm.put("message", "Name Does not exist.");
			}
		}
		return hm;
	}
	
	
	
}

