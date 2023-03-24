package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

//@Repository
public class MemoryMemberRepository implements MemberRepository{
    // save 할 때 저장해둘 곳, List와는 달리 Hash에서는 바로탐색이 가능하기에 Hashmap 사용
    private static Map<Long, Member> store = new HashMap<>();
    // 0.1.2 등 키값을 생성해 줌
    private static long sequence = 0L; // Long 형이란 걸 알려주기 위한 0L

    @Override
    public Member save(Member member) {
        //시스템에서 키 값을 생성해서 id 에 저장 -> 기존 ID를 ++sequence로 바꿈
        member.setId(++sequence);
        // 수정한 ID를 store (여기선 DB) 에 저장시킴
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        // id 가 null 이어도 Optional로 둘러싸여있어 감쌀 수 있음.
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream() // 나열된 배열을 stream으로 정리, stram 은 for문을 쉽게 적을 수 잇음.
                .filter(member -> member.getName().equals(name))
                .findAny();
        // 각각의 배열을 member라고 칭했을 때, 각 배열의 name 즉, member.getName() 과 들어온 매개변수 name 이 같은지 판단
        // 이후 스트림 api 중 하나인 findAny() 사용해 하나라도 찾으면 반환, 없으면 optianl의 nullable 이용
    }

    @Override
    public List<Member> findAll() {
        // map 에서 value 값인 name만 반환하기 위해 new로 리스트 생성
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }

}
