package com.bawie.controller;

import com.bawie.entity.User;
import com.bawie.service.UserService;
import com.bawie.utils.ValidateCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class UserController {
    @Autowired
    UserService service;
    //登陆页面
    @RequestMapping("tologin")
    public ModelAndView tologin(HttpServletResponse response, HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
    //登陆
    @RequestMapping("login")
    public ModelAndView login(String yanz,String username,String password,String auto, HttpServletResponse response, HttpSession session) throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        String yan= (String) session.getAttribute("rand");
        User login = service.login(username);
        if (yanz.equals(yan)){
        if (login!=null&&login.getPassword().equals(password)){
            if ("1".equals(auto)){
                Cookie usercookie = new Cookie("token",login.getUsername()+"_"+System.currentTimeMillis());
                usercookie.setMaxAge(60*60*24*7);
                response.addCookie(usercookie);
            }else {
                Cookie usercookie = new Cookie("token",null);
                response.addCookie(usercookie);
            }
            session.setAttribute("user",login);
            session.setAttribute("error","");
            response.getWriter().print("ok");
            response.getWriter().close();
        }else{
            session.setAttribute("error","账号或密码错误");
        }
        }else{
            response.getWriter().print("ri");
            response.getWriter().close();
        }
        return modelAndView;
    }
    @RequestMapping("LoginByToken")
    public ModelAndView loginByToken(String token,HttpSession session,HttpServletResponse response){
        String[] tokens=token.split("_");
        if(tokens.length!=2){
            throw new IllegalArgumentException("token 不合法");
        }
        String name = tokens[0];
        User user = service.login(name);
        Long time = Long.valueOf(tokens[1]);
        String ViewName ="redirect:/login";
        if(user!=null){
            session.setAttribute("user",user);
            session.setAttribute("error","");
            ViewName="redirect:/main";
        }
        else{
            Cookie userCookie = new Cookie("token",null);
            response.addCookie(userCookie);
            session.setAttribute("error","用户名不存在");
        }
        return new ModelAndView(ViewName);
    }

    @RequestMapping("outlogin")
    public ModelAndView outlogin(HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView();
        Cookie token = new Cookie("token", null);
        response.addCookie(token);
        modelAndView.setViewName("redirect:tologin");
        return modelAndView;
    }

    @RequestMapping("main")
    public ModelAndView main(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main");

        return modelAndView;
    }
    @RequestMapping("top")
    public ModelAndView top(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("top");

        return modelAndView;
    }
    @RequestMapping("left")
    public ModelAndView left(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("left");

        return modelAndView;
    }
    @RequestMapping("right")
    public ModelAndView right(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("right");

        return modelAndView;
    }

    @RequestMapping("yanz")
        public void yanz(HttpServletRequest request,HttpServletResponse response){
         new ValidateCodeUtil().createImage(request,response);
    }
}
