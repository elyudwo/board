package jpapractice.jpaboard.service;


import jpapractice.jpaboard.domain.Member;
import jpapractice.jpaboard.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        if(memberRepository.findByName(member.getMemberId()).size() != 0) {
            throw new IllegalStateException("동일한 아이디가 있습니다.");
        }
    }

}
