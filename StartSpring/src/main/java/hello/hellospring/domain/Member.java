package hello.hellospring.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Member {
    // strategy(전략) 에서의 IDENTITY: DB에서 아이디를 자동 생성해주는 것
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 큰 정수값은 Long을 사용
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
