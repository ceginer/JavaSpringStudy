package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    //    JPQL select m from Member m where m.name =?  -> m.name에서 name은 파라미터;
    //    MemberRepository 의 인터페이스 이름만으로 규칙에 따라 자동으로 쿼리를 생성
    //    (인터페이스 이름 예: findByID, findAll 등은 이미 상속한 JpaRepository 에 설정되어 있어 바로 실행 가능,
    //    findByNameAndID, findByNameOrID 같은 것들도 추가로 사용가능)

    // finByName 만 유독 JpaRository 에 그럼 메소드가 없음
    @Override
    Optional<Member> findByName(String name);
}