package org.example.FirstSpringSecurityApp.controllers;

import jakarta.validation.Valid;
import org.example.FirstSpringSecurityApp.models.Person;
import org.example.FirstSpringSecurityApp.services.RegistrationService;
import org.example.FirstSpringSecurityApp.util.PersonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthConroller {

    private final PersonValidator personValidator;
    private final RegistrationService registrationService;

    @Autowired
    public AuthConroller(PersonValidator personValidator, RegistrationService registrationService) {
        this.personValidator = personValidator;
        this.registrationService = registrationService;
    }

    @RequestMapping("/login")
    public String loginPage() {
        return "auth/login";
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("person") Person person) {

        return "auth/registration";
    }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("person") @Valid Person person,
                                      BindingResult bindingResult) {
        personValidator.validate(person, bindingResult);

        if (bindingResult.hasErrors())
            return "auth/registration";

        registrationService.register(person);

        return "redirect:/auth/login";
    }
}
