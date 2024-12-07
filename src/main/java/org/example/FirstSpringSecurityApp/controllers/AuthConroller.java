package org.example.FirstSpringSecurityApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthConroller {

    @RequestMapping("/login")
    public String loginPage() {
        return "auth/login";
    }
}
