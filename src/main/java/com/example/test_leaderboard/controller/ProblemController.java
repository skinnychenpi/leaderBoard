package com.example.test_leaderboard.controller;

import java.util.List;

import com.example.test_leaderboard.Session.UserInfo;
import com.example.test_leaderboard.entity.Problem;
import com.example.test_leaderboard.entity.User;
import com.example.test_leaderboard.service.ProblemService;
import com.example.test_leaderboard.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping
public class ProblemController {

    @Autowired
    private ProblemService problemService;
    @Autowired
    private  UserService userService;

    @GetMapping(path = "/answer")
    private String answer() {
        return "description";
    }

    @RequestMapping(value = "/problem",method = RequestMethod.GET)
    public Problem selectStudent(@Param("problemNumber") Integer problemNumber){
        return problemService.selectProblem(problemNumber).get(0);
    }

    @RequestMapping(value = "/allProblem",method = RequestMethod.GET)
    public String showAllProblem(Model model){
        List<Problem> problems = problemService.showAllProblem();
        model.addAttribute("problems",problems);
        HttpSession session = getRequest().getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute("current_user");
        User user = userService.findUserById(userInfo.getUserId()).get(0);
        model.addAttribute("user",user);
        return "problem";
    }

    @GetMapping(path="/submitAnswer/{problem_id}")
    public String submitAnswer(Model model, @PathVariable(name="problem_id") int problem_id){
        Problem problem = problemService.selectProblem(problem_id).get(0);
        model.addAttribute("problem",problem);
        HttpSession session = getRequest().getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute("current_user");
        User user = userService.findUserById(userInfo.getUserId()).get(0);
        model.addAttribute("user",user);
        return "description";
    }
    private HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    }
}
