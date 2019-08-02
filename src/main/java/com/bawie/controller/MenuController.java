package com.bawie.controller;

import com.bawie.entity.Menu;
import com.bawie.entity.User;
import com.bawie.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MenuController {
    @Autowired
    MenuService service;

    @RequestMapping("menulist")
    @ResponseBody
    public List<Menu> menulist(HttpSession session){
        User user= (User) session.getAttribute("user");
        List<Menu> menus = service.menulist(user.getUsername());
        System.out.println(menus);
        return menus;
    }
}
