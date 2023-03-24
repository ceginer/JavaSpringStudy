package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    /* 회원 서비스를 위해 멤버레포지토리를 가져옴*/
    private final MemberRepository memberRepository;

    @Autowired
    // 멤버 서비스를 외부에서 넣어지도록 바꾸기
    public MemberService (MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    // 회원가입
    public Long join(Member member){
        // 회원 이름 중복 검사
        validateDuplicateMember(member);
        // Id 저장
        memberRepository.save(member);

        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        // 멤버 레포지토리에서 이름 찾아서 가져오기, 만약 가져온다면 그 m을 ifPresent를 통해 에러 일으키기
        memberRepository.findByName(member.getName())
                .ifPresent(m-> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    //전체 회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberID){
        return memberRepository.findById(memberID);
    }
}
