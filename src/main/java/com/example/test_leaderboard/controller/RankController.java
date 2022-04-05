package com.example.test_leaderboard.controller;

import com.example.test_leaderboard.Session.UserInfo;
import com.example.test_leaderboard.entity.Rank;
import com.example.test_leaderboard.entity.User;
import com.example.test_leaderboard.service.RankService;
import com.example.test_leaderboard.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.util.List;

@Controller
@RequestMapping
public class RankController {
    @Autowired
    private RankService rankService;
    @Autowired
    private UserService userService;

    @RequestMapping("allRankTest")
    public List<Rank> showAllRank(@Param("problemNumber") int problemNumber){
        return rankService.showAllRank(problemNumber);
    }

    @RequestMapping("userRank")
    public BigInteger showUserRank(@Param("problemNumber") int problemNumber,
                                   @Param("userName") String userName){
        return rankService.showUserRank(problemNumber,userName);
    }

    @RequestMapping(path="/allRank/{problemNumber}")
    public String RankById(@PathVariable Integer problemNumber, Model model){
        List<Rank> ranks = rankService.showAllRank(problemNumber);
        model.addAttribute("rankList", ranks);
        HttpSession session = getRequest().getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute("current_user");
        User user = userService.findUserById(userInfo.getUserId()).get(0);
        model.addAttribute("user",user);
        return "leaderboard";
    }

//    @RequestMapping(path="/allRank/1")
//    public String RankByIdTest(Model model){
//        List<Rank> ranks = rankService.showAllRank(1);
//        model.addAttribute("rankList", ranks);
//        User user = userService.findUserById(1).get(0);
//        model.addAttribute("user",user);
//        return "leaderboard";
//    }

    private HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    }
}
