package com.controller;

import com.bean.Employee;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/*
处理员工CRUD请求
* */
@Controller
public class EmployeeController {
    /*
     * 查询员工数据（分页）
     * */
   @Autowired
    EmployeeService employeeService;

    @RequestMapping("/emps")

    public String getEmps(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        //引入PageHelper分页插件
        //传入页码，每页大小，pageHelper后紧跟着的查询就是分页查询
        PageHelper.startPage(pn, 5);
        List<Employee> emps = employeeService.getAll();
        //连续展示的页数
        PageInfo page = new PageInfo(emps, 5);
        //pageInfo封装查询结果，返回给页面
        model.addAttribute("pageInfo", page);
        return "list";
    }
}
