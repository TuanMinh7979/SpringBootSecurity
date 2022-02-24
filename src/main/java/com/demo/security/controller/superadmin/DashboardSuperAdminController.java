package com.demo.security.controller.superadmin;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/superadmin/dashboard")
public class DashboardSuperAdminController {
    @GetMapping("")
    public String index(Authentication authen)
    {
        System.out.println(authen.getName());
        return "superadmin/dashboard/index";
    }
}
