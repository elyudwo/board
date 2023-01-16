package jpapractice.jpaboard.controller;

import jpapractice.jpaboard.domain.Member;
import jpapractice.jpaboard.repository.MemberRepository;
import jpapractice.jpaboard.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    @GetMapping("/members/new")
    public String createForm(Model model) {
        model.addAttribute("memberForm",new MemberForm());
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(@Valid MemberForm form, BindingResult result) {

        if(result.hasErrors()) {
            return "members/createMemberForm";
        }

        Member member = new Member();
        member.setMemberId(form.getMemberId());
        member.setMemberPasswd(form.getMemberPassWd());
        member.setCollege(form.getCollege());
        member.setName(form.getName());

        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberRepository.findAll();
        model.addAttribute("members",members);

        return "members/memberList";
    }

    @GetMapping("/members/login")
    public String loginForm(Model model) {
        model.addAttribute("memberForm",new MemberForm());
        return "members/login";
    }

    @PostMapping("/members/login")
    public String login(@Valid MemberForm form) {
        if(memberService.login(form.getMemberId(),form.getMemberPassWd())) {
            return "home";
        }
        return "members/login";
    }

    @GetMapping("/member/{userId}/edit")
    public String user(@PathVariable("userId") Long userId, Model model) {
        Member member = memberRepository.findOne(userId);
        model.addAttribute("member",member);
        return "members/updateMemberForm";
    }

    @PostMapping("/member/{userId}/edit")
    public String editUser(@PathVariable("userId") Long userId,
                           @RequestParam String id,
                           @RequestParam String passWd,
                           @RequestParam String name,
                           @RequestParam String college
                           ) {
        System.out.println(id);
        System.out.println(passWd);
        System.out.println(name);
        System.out.println(college);

        memberRepository.updateMember(userId, id, passWd, name, college);
        return "redirect:/members";
    }
}