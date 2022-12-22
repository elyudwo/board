package jpapractice.jpaboard.repository;


import jpapractice.jpaboard.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional
    public void testMember() {
        Member member = new Member();
        member.setName("memberA");

        Long savedId = memberRepository.save(member);

        Assertions.assertThat(savedId).isEqualTo(member.getId());
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void testPrintAll() {
        Member member1 = new Member();
        member1.setName("member1");

        Member member2 = new Member();
        member2.setName("member2");

        Member member3 = new Member();
        member3.setName("member3");

        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);


        List<Member> memberList = memberRepository.findAll();
        Assertions.assertThat(memberList.size()).isEqualTo(3);
    }
}