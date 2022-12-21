package jpapractice.jpaboard.service;

import jpapractice.jpaboard.domain.Member;
import jpapractice.jpaboard.repository.MemberRepository;
import org.aspectj.lang.annotation.RequiredTypes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    EntityManager em;

    @Test
    @Transactional
    public void sameNameCheck() throws Exception {
        //given
        Member member1 = new Member();
        member1.setMemberId("liljay");
        Member member2 = new Member();
        member2.setMemberId("liljay");

        //when

        try {
            memberService.join(member1);
            memberService.join(member2);
        } catch (IllegalStateException e) {
            return;
        }
        fail();
    }
}