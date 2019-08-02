package com.bawie.controller;

import com.bawie.entity.Clazz;
import com.bawie.entity.Distinction;
import com.bawie.entity.Management;
import com.bawie.service.ManagementService;
import com.bawie.utils.ExcelUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ManagementController {
    @Autowired
    ManagementService service;
    @RequestMapping("list")
    public ModelAndView list(@RequestParam(defaultValue = "1")Integer pageNum,String mohu,String distinction,String clazz){
        mohu=mohu==null ? "":mohu;
        distinction=distinction==null ? "":distinction;
        clazz=clazz==null ? "":clazz;
        ModelAndView modelAndView = new ModelAndView();
        PageHelper.startPage(pageNum,2,true);
        List<Management> list = service.list(mohu);
        PageInfo<Management> pageInfo = new PageInfo<Management>(list);

        modelAndView.addObject("clazz",clazz);
        modelAndView.addObject("distinction",distinction);
        modelAndView.addObject("list",list);
        modelAndView.addObject("mohu",mohu);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("list");
        return modelAndView;
    }
    @RequestMapping("export")
    public void export(HttpServletResponse response){
        List<Management> list=service.list1();
        String[] columnNames={"ID","届别","班级名称","学号","姓名","出生日期","性别","状态","民族","电话","入学日期","备注"};
        ExcelUtils.exportExcel(response,list,columnNames,"学籍","学籍");
    }

    @RequestMapping("deleteall")
    public void deleteall(String ids,HttpServletResponse response) throws IOException {
        int i=service.deleteall(ids);
        if (i>0){
            response.getWriter().print("ok");
            response.getWriter().close();
        }
    }

    @RequestMapping("toupdate")
    public ModelAndView toupdate(Integer id){
        ModelAndView modelAndView = new ModelAndView();
        Management management=service.toupdate(id);
        modelAndView.setViewName("update");
        modelAndView.addObject("management",management);
        return modelAndView;
    }
    @RequestMapping("updateManagement")
    public void updateManagement(Management management,HttpServletResponse response) throws IOException {
        int i=service.updateManagement(management);
        if (i>0){
            response.getWriter().print("ok");
            response.getWriter().close();
        }
    }

    @RequestMapping("distinction")
    @ResponseBody
    public List<Distinction> distinction(){
        List<Distinction> distinctions=service.distinction();
        return distinctions;
    }

    @RequestMapping("clazz")
    @ResponseBody
    public List<Clazz> clazz(String dname){
        List<Clazz> clazz=service.clazz(dname);
        return clazz;
    }
    @RequestMapping("times")
    public ModelAndView times(){
        ModelAndView modelAndView = new ModelAndView();
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String s = format.format(date);
        System.out.println(s);
        modelAndView.setViewName("redirect:list");
        return modelAndView;
    }
}
