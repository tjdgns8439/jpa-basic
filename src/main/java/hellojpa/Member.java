package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity //JPA를 사용하는 객체라는 것을 인식
public class Member {
    public Member() {

    }
    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

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

    @Id //pk설정
    private Long id;
    private String name;
}
