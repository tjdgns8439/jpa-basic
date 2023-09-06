package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "ORDERS")//order가 예약어로 걸려있기 때문에 orders라는 이름으로 테이블을 생성해주어야 한다.
public class Order {
    @Id
    @Column(name = "ORDER_ID")
    private Long id;

    @OneToOne
    @JoinColumn(name = "DELEVERY_ID")
    private Delivery delivery;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    @Column
    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

}
