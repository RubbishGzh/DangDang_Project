package com.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.alibaba.fastjson.JSON;
import com.entity.*;
import com.google.code.kaptcha.Producer;
import com.service.ClientService;

@Controller
@RequestMapping("ClientController")
public class ClientController {

	@Autowired
	private ClientService clientService;

	@Autowired
	private Producer producer;

	// 用户注册
	@RequestMapping("/regist")
	public String register(dangdang_user du, HttpSession session, String code) throws Exception {
		// boolean i =clientService.ins_DdUser(du);
		dangdang_user d_u = du;
		session.setAttribute("regist_data", d_u);
		String kaptcha = (String) session.getAttribute("kaptcha");
		if (!(kaptcha.equals(code)) && !(code.equals(""))) {
			session.setAttribute("kaptchaerror", "验证码不匹配");
			return "forward:/user/register.jsp";
		}
		return "redirect:/user/verify_form.jsp";
	}

	//登录
	@RequestMapping("/login")   
	@ResponseBody
	public String login(String dd_user_email,String dd_user_password,HttpSession session) throws Exception {
		dangdang_user dux = clientService.selUser_ById(dd_user_email,dd_user_password);
		if(dux!=null) {
			session.setAttribute("users",dux);
			session.setAttribute("nickname",dux.getDd_user_nickname());//在session中放入用户的真实姓名,用于在jsp中显示
			return "true";
		}
		return "false";
		}
	
	//退出登录
	@RequestMapping("/remove_login")   
	public String remove_login(HttpSession session) throws Exception {
		String nickname = (String)session.getAttribute("nickname");
		System.out.println(nickname);
		session.removeAttribute("nickname");
		return "redirect:/main/main.jsp";
		}
	
	// 图片验证
	@RequestMapping("/validateCode")
	public void getKaptcha(HttpSession session, HttpServletResponse response) {
		// 获取验证码字符
		String kaptcha = producer.createText();
		session.setAttribute("kaptcha", kaptcha);
		BufferedImage image = producer.createImage(kaptcha);
		try {
			ImageIO.write(image, "jpg", response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//模拟验证码(123456)
	@RequestMapping("/EmailVerification")
	public String EmailVerification(String randomcode, Model model, HttpSession session) {
		if (randomcode.equals("123456")) {
			dangdang_user dduser = new dangdang_user();
			dduser = (dangdang_user) session.getAttribute("regist_data");
			clientService.ins_DdUser(dduser);
			return "redirect:/user/register_ok.jsp";
		}

		else {
			model.addAttribute("email_error", "邮箱验证码输入错误");
			return "forward:/user/verify_form.jsp";
		}
	}
}
