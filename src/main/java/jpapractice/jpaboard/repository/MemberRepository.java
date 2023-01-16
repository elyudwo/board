package jpapractice.jpaboard.repository;

import jpapractice.jpaboard.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    @PersistenceContext
    private final EntityManager em;

    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    public Member findOne(Long id) {
        return em.find(Member.class,id);
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m",Member.class)
                .getResultList();
    }

    public List<Member> findById(String memberId) {
        return em.createQuery("select m from Member m where m.memberId = :memberId",
                        Member.class)
                .setParameter("memberId", memberId)
                .getResultList();
    }

    @Transactional
    public void updateMember(Long userId, String memberId, String memberPassWd, String name, String college) {
        Member member1 = findOne(userId);
        member1.setMemberId(memberId);
        member1.setMemberPasswd(memberPassWd);
        member1.setName(name);
        member1.setCollege(college);
    }
}