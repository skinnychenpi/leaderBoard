package com.example.test_leaderboard.controller;

import com.example.test_leaderboard.Session.UserInfo;
import com.example.test_leaderboard.entity.User;
import com.example.test_leaderboard.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;

@Controller
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/login")
    private String login() {
        return "login";
    }

    @GetMapping(path = "/register")
    private String register() {
        return "register";
    }

    @PostMapping(path="/afterLogin")
    public String Login(@RequestParam("username") String user_name,
                        @RequestParam("password") String password){
        List<User> users = userService.verifyUsernameAndPassword(user_name, password);

        if(users.size()>0) {
            UserInfo userInfo = new UserInfo(users.get(0).getUserId(), users.get(0).getUsername());
            HttpSession session = getRequest().getSession();
            session.setAttribute("current_user", userInfo);
            return "index";

        }
        else {
            return "redirect:/login";
        }


    }

    @PostMapping(path = "/registerStore")
    public String add(@RequestParam("usernamesignup") String user_name,
                      @RequestParam("passwordsignup") String password_first,
                      @RequestParam("passwordsignup_confirm") String password_second)
    {
        if (!password_first.equals(password_second))
            return "redirect:/register";
        else {
            List<User> users = userService.verifyUserExistence(user_name);
            if (users.size()>0) {
                return "redirect:/register";
            }
            else {
                userService.register(user_name, password_first);
                return "redirect:/login";
            }
        }
    }


    private HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    }



}
