package jpabook.jpashop;

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

        //try-catch구문 적용
        //이름 변경
        try{

            em.flush();
            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
