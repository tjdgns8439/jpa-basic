package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        //hello는 persistence.xml에서 설정한 persistecneUnitName
        //entityManagerFactory생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        //EntityManager 생성 -> 트랜잭션마다 생성
        EntityManager em = emf.createEntityManager();
        //트랜잭션 생성
        EntityTransaction tx = em.getTransaction();
        //트랜잭션 시작
        tx.begin();

        //실제 코드
        Member member = new Member();
        member.setId(1L);
        member.setName("HelloA");
        em.persist(member);

        //트랜잭션 commit
        tx.commit();

        em.close();
        emf.close();
    }
}
//EntityManagerFactory는 애플리케이션 로딩할 때 맨 처음 하나만 만들어야 한다.
//이는 비용이 매우 크기 때문이다.
//하나의 트랜잭션 단위에는 EntityManager를 하나씩 만들어야 하는데 이는 비용이 크게 들지 않는다.
//EntityManager를 만들었으면 트랜잭션도 만들고 이를 시작해주어야 한다.
//코드 수행이 끝나면 트랜잭션을 commit해준다.