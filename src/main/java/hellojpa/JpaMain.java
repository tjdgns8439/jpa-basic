package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        //hello는 persistence.xml에서 설정한 persistecneUnitName
        //entityManagerFactory생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Movie movie = new Movie();
            movie.setDirector("훈");
            movie.setActor("jamie");
            movie.setName("바람과함꼐 사라지다");
            movie.setPrice(10000);
            em.persist(movie);

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
//EntityManagerFactory는 애플리케이션 로딩할 때 맨 처음 하나만 만들어야 한다.
//이는 비용이 매우 크기 때문이다.
//하나의 트랜잭션 단위에는 EntityManager를 하나씩 만들어야 하는데 이는 비용이 크게 들지 않는다.
//EntityManager를 만들었으면 트랜잭션도 만들고 이를 시작해주어야 한다.
//코드 수행이 끝나면 트랜잭션을 commit해준다.