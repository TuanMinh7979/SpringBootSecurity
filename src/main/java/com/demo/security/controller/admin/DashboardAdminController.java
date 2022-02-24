package com.demo.security.controller.admin;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/dashboard")
public class DashboardAdminController {
    @GetMapping("")
    public String index(Authentication authen){
        System.out.println(authen.getName());
        return "admin/dashboard/index";
    }
}
