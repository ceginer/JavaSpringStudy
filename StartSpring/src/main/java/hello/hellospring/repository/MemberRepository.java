package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // 회원저장
    // Optional 을 통해서 null 값이면 저장 안하도록
    Optional<Member> findById(Long id); //Id 로 찾기
    Optional<Member> findByName(String name); // 이름으로 찾기
    List<Member> findAll(); // 모든 회원


}
