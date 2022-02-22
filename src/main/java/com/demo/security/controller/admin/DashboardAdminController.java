package com.demo.security.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/dashboard")
public class DashboardAdminController {
    @GetMapping("")
    public String index(){
        return "admin/dashboard/index";
    }
}
