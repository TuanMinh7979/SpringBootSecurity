package com.demo.security.controller.user;

import com.demo.security.models.Account;
import com.demo.security.models.Role;
import com.demo.security.service.AccountService;
import com.demo.security.service.RoleService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private RoleService roleService;

    @GetMapping("/login")
    public String showLogin(Model model, @RequestParam(value = "err", required = false) String err,
                            @RequestParam(value = "logout", required = false) String logout) {

        if (err != null) model.addAttribute("msg", "Dang nhap that bai");
        if (logout != null) {
            model.addAttribute("msg", "logout success");
        }
        return "account/login";
    }

    @GetMapping("/register")
    public String showRegister(ModelMap map) {
        Account acc = new Account();
        map.put("account", acc);
        map.put("roles", roleService.findAll());


        return "account/register";
    }

    @PostMapping("/register")
    //co the dung mapper de convert tu id sang doi tuong

    public String register(@ModelAttribute("account") Account acc, @RequestParam("role") int[] roles) {
        String hash = new BCryptPasswordEncoder().encode(acc.getPassword());
        acc.setPassword(hash);
        Set<Role> roleSet = new HashSet<>();
        if (roles != null && roles.length > 0) {
            for (int roleId : roles) {
                roleSet.add(roleService.findById(roleId));


            }
            acc.setRole(roleSet);
        }
        System.out.println(acc);
        accountService.save(acc);
        return "redirect:/account/login";
    }

    @GetMapping("/welcome")
    public String welcome(Authentication authen) {

        return "account/welcome";
    }


}


