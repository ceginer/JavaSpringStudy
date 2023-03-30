package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
 */
public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;
    // 외부에서 생성자 쓰기 위한 private 한 필드
    private static final MemberRepository instance = new MemberRepository();
    // private 한 생성자 대신 밖에서 생성할 수 있도록 하는 메서드( getInstance() )
    public static MemberRepository getInstance() {
        return instance;
    }
    // 외부에서 생성자를 사용하지 못하게 하기 위해 따로 private한 생성자 사용
    private MemberRepository() {
    }

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }

}
