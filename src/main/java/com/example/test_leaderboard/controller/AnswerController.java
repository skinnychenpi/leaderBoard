package com.example.test_leaderboard.controller;

import com.example.test_leaderboard.Session.UserInfo;
import com.example.test_leaderboard.entity.User;
import com.example.test_leaderboard.service.AnswerService;
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
import java.util.List;

@Controller
@RequestMapping
public class AnswerController {
    @Autowired
    private AnswerService answerService;
    @Autowired
    private UserService userService;

    @PostMapping(path="/answerSubmit/{problemNumber}")
    public String Answer(Model model,
                         @Param("sql") String sql,
                         @PathVariable(name="problemNumber") int problemNumber){
        String template="";
        HttpSession session = getRequest().getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute("current_user");
        User user = userService.findUserById(userInfo.getUserId()).get(0);
        model.addAttribute("user",user);
        List<Object> answers = answerService.answer(sql,userInfo.getUsername(),problemNumber);
        if (answers.size()==3) {
            Object results = answers.get(0);
            Object timeCost = answers.get(1);
            Object rank = answers.get(2);
            model.addAttribute("timeCost",timeCost);
            model.addAttribute("results",results);
            model.addAttribute("rank",rank);
            model.addAttribute("sql",sql);
            model.addAttribute("problemNumber",problemNumber);
            template =  "result";
        }
        else if (answers.size()==2) {
            Object results = answers.get(0);
            model.addAttribute("results",results);
            model.addAttribute("problemNumber",problemNumber);
            model.addAttribute("sql",sql);
            template =  "result_wrong";

        }
        return template;

    }

    @RequestMapping(path="/answerTest")
    public List<Object> answerTest(@Param("sql") String sql,
                                   @Param("userName") String userName,
                                   @Param("problemNumber") int problemNumber){

        List<Object> answers = answerService.answer(sql,userName, problemNumber);
        return answers;


    }

    private HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    }
}
