package com.demo.security.controller.employee;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee/dashboard")
public class DashboardEmployeeController {
    @GetMapping("")
    public String index(Authentication authen) {
        System.out.println(authen.getName());
        return "employee/dashboard/index";
    }
}
