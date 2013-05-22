package com.formation.spring.controllers;

import com.formation.spring.business.beans.User;
import com.formation.spring.business.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.security.Principal;

/**
 * Created with IntelliJ IDEA.
 * User: Guillaume Corré
 * Date: 16/05/13
 * Time: 14:29
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Principal principal, HttpSession session) {
        User user = userService.findByName(principal.getName());
        session.setAttribute("user", user);

        return "index";
    }
}
