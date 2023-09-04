package hellojpa;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class MemberProduct {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;


    //중간테이블을 만들면 매핑 정보 외의 정보들을 넣을 수 있음.
    private int count;
    private int price;
    private LocalDateTime orderDateTime;

}
