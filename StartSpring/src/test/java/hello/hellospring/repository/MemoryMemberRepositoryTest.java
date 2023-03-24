package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 매번 반복 때마다 clear
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }


    @Test
    public void save(){
        // given (~했다고 치자 -> name이 spring 이라고 치자)
        Member member = new Member();
        member.setName("spring");

        //when (그럼 뭐할건데? -> 일단 DB 에 save 해야지)
        repository.save(member);

        //then(검증해야지 -> DB에 잘 저장됬나를 확인해야지)
        // ---> 현재 DB 에서 save 했던 객체 member의 ID를 통해 Member 객체를 찾았을 때 그 객체를 result라 하자 )
        Member result = repository.findById(member.getId()).get();
        // ---> 그럼 result 와 저장했던 객체 member 가 같은가? )
        Assertions.assertEquals(member, result);

    }


    // 테스트 코드
//    @Test
//    public void save(){
//        // given, when ,then 형식대로 적기
//        // given
//        Member member = new Member();
//        member.setName("spring");
//        // when
//        repository.save(member);
//        //then (검증 단계)
//        Member result = repository.findById(member.getId()).get();
//        //방법 1. 원시적인 것 (추천 x)
//        System.out.println("result = " + (result == member));
//        //방법 2. Assertions 이용, 문제 없으면 그냥 초록색으로 뜸
//        Assertions.assertEquals(member, result);
//        // 방법 3. 그냥 좀 더 직관적인거
//        assertThat(result).isEqualTo(member);
//
//    }

    @Test
    public void findByName() {

        //given
        //정교한 멤버 확인을 위한 멤버 객체 2개 생성
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        //when
        //spring1 찾기
        Member result = repository.findByName("spring1").get();

        //then
        assertThat(result).isEqualTo(member2);

    }

    @Test
    public void findAll(){
        //given
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        //when
        List<Member> result = repository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
    }

}