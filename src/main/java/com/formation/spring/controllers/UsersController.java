package com.formation.spring.controllers;

import com.formation.spring.business.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: Guillaume Corré
 * Date: 16/05/13
 * Time: 17:17
 */
@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @RequestMapping()
    public String index(ModelMap model) {
        model.addAttribute("users", userService.findAll());

        return "users/list";
    }

    @RequestMapping("/user")
    public String show(ModelMap model) {
        model.addAttribute("user", userService.findByName("Guillaume"));

        return "users/show";
    }
}
