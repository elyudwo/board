package jpapractice.jpaboard.controller;


import jpapractice.jpaboard.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class HomeController {

    @RequestMapping("/")
    public String home(HttpServletRequest request, Model model) {

        HttpSession session = request.getSession(false);

        // 세션이 없으면 home
        if(session == null) {
            return "home";
        }

        Member loginMember = (Member)session.getAttribute("loginMember");
        if(loginMember == null) {
            return "home";
        }

        model.addAttribute("member",loginMember);
        return "members/loginHome";
    }

}
